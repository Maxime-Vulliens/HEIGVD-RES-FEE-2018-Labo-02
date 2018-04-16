package ch.heigvd.res.labs.roulette.net.protocol;

import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import java.util.List;

/**
 * Created by Maxime on 16.04.18.
 */
public class ListCommandResponse {

    private String status;
    private List<Student> students;

    public ListCommandResponse() {
    }

    public ListCommandResponse(String status, List<Student> students) {
        this.status = status;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
