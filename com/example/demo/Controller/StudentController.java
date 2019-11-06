package com.example.demo.Controller;

import com.example.demo.Bean.QueryStudentBean;
import com.example.demo.Bean.ResultBean;
import com.example.demo.Bean.StudentInformationBean;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/Student information")
    @ResponseBody
    public ResultBean StudentInformation(StudentInformationBean student) {
        System.out.println(student.getName() + student.getSexual() + student.getAge() + student.getGrade());
        ResultBean student1 = studentService.student(student);
        return student1;
    }

    @RequestMapping("/StudentResultInput")
    public String studentInput() {

        return "ResultInput";
    }

    @RequestMapping("/StudentName")
    @ResponseBody
    public ResultBean StudentName(String name) {
        System.out.println(name);
        ResultBean resultBean = studentService.studentName(name);
        return resultBean;
    }

    @RequestMapping("/delStudent")
    @ResponseBody
    public ResultBean delStudent(int id) {
        System.out.println(id);
        ResultBean student = studentService.Student(id);
        return  student;
    }
    @RequestMapping("/upData")
    @ResponseBody
    public ResultBean delStudent(QueryStudentBean studentBean) {

        ResultBean resultBean = studentService.upDataStudent(studentBean);
        return  resultBean;
    }


}
