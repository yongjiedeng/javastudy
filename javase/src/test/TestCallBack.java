package test;

import com.dyj.javastudy.Jacky;
import com.dyj.javastudy.Student;
import com.dyj.javastudy.Teacher;
import org.testng.annotations.Test;

/**
 * Created by dengyongjie044 on 2017/5/4.
 */
public class TestCallBack {
    @Test
    public void testCallBack(){
        Student student = new Jacky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();
        //student.resolveQuestion(teacher);
    }
}
