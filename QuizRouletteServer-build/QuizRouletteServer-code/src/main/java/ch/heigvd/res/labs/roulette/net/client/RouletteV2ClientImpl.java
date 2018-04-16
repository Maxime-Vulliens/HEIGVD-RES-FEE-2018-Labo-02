package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import ch.heigvd.res.labs.roulette.net.protocol.ListCommandResponse;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV2Protocol;
import java.io.IOException;
import java.util.List;

/**
 * This class implements the client side of the protocol specification (version 2).
 *
 * @author Olivier Liechti
 */
public class RouletteV2ClientImpl extends RouletteV1ClientImpl implements IRouletteV2Client {

  @Override
  public void clearDataStore() throws IOException {
    if (current_socket != null) {
      os.write("CLEAR\n".getBytes());
      getStringFromInputStream(is);
    }
  }

  @Override
  public List<Student> listStudents() throws IOException {
    String input;

    if (current_socket != null) {
      os.write("LIST\n".getBytes());
      input = getStringFromInputStream(is);
      ListCommandResponse lstResponse = JsonObjectMapper.parseJson(input,ListCommandResponse.class);
      return lstResponse.getStudents();
    }
    return null;

  }


  
}
