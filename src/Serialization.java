import java.io.*;
import java.util.*;

public class Serialization {

    List<Student> students = new ArrayList<Student>();

    public Serialization() {
        students.add(new Student(1, "John"));
        students.add(new Student(2, "Mary"));
        students.add(new Student(3, "Mike"));
        students.add(new Student(4, "Steve"));
    }

    public void Serialize() {
        System.out.println("Serialize");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.ser"));) {
            out.writeObject(students);
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Deserialize() throws IOException {
        System.out.println("Deserialize");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"));) {
            List<Student> inStudents = (List<Student>) in.readObject(); // Warning due to not type checking raw data
            for (Student student : inStudents) {
                System.out.println(student.id + " " + student.name);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
