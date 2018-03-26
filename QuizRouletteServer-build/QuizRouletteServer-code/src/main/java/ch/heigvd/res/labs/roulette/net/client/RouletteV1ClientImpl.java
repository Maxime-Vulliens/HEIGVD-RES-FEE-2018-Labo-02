package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.EmptyStoreException;
import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.StudentsStoreImpl;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.net.protocol.InfoCommandResponse;
import ch.heigvd.res.labs.roulette.net.protocol.RandomCommandResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements the client side of the protocol specification (version 1).
 * 
 * @author Olivier Liechti
 */
public class RouletteV1ClientImpl implements IRouletteV1Client {

  private static final Logger LOG = Logger.getLogger(RouletteV1ClientImpl.class.getName());
  private Socket current_socket;
  private StudentsStoreImpl studentList = new StudentsStoreImpl();

  @Override
  public void connect(String server, int port) throws IOException {
    try {
      current_socket = new Socket(server,port);
    }
    catch (UnknownHostException e) {

      e.printStackTrace();

    }catch (IOException e) {

      //Si une exception de ce type est levée
      //c'est que le port n'est pas ouvert ou n'est pas autorisé

    }
  }

  @Override
  public void disconnect() throws IOException {
    current_socket.close();
  }

  @Override
  public boolean isConnected() {
    if (current_socket != null){
      return current_socket.isConnected();
    }
    return false;
  }

  @Override
  public void loadStudent(String fullname) throws IOException {
    studentList.addStudent(new Student(fullname));
  }

  @Override
  public void loadStudents(List<Student> students) throws IOException {
    for (Student stu : students) {
      studentList.addStudent(stu);
    }
  }

  @Override
  public Student pickRandomStudent() throws EmptyStoreException, IOException {
    if (studentList != null) {
      return studentList.pickRandomStudent();
    }
    return null;
  }

  @Override
  public int getNumberOfStudents() throws IOException {
    if (studentList != null) {
      return studentList.getNumberOfStudents();
    }
    return 0;
  }

  @Override
  public String getProtocolVersion() throws IOException {
    return RouletteV1Protocol.VERSION;
  }

}
