import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;

    public Student() {
    } // important to have a default constructor (one that does not take any
      // parameters) or Serializable may not work

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
