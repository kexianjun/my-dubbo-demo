package marshalling;

import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class MainTest implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentTest studentTest = new StudentTest();
        studentTest.setAge("hello");
        studentTest.setName("world");

        MarshallingSerialization serialization = new MarshallingSerialization();
        ObjectOutput output = serialization.serialize(null, new FileOutputStream("test"));
        output.writeObject("hello");
        output.writeObject("world");
        output.writeObject(studentTest);
        output.writeObject(studentTest);
        output.writeBytes("heloo".getBytes());
        output.flushBuffer();

        ObjectInput objectInput = serialization.deserialize(null, new FileInputStream("test"));
        System.out.println(objectInput.readObject());
        System.out.println(objectInput.readObject());
        System.out.println(objectInput.readObject(StudentTest.class));
        System.out.println(objectInput.readObject(StudentTest.class));
        System.out.println(Arrays.toString(objectInput.readBytes()));

    }

    @Override
    public String toString() {
        return "hello how are you";
    }

    public static class StudentTest implements Serializable{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "StudentTest{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
