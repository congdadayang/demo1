package com.example.demo.service;

import com.example.demo.Bean.LoginBean;
import com.example.demo.Bean.QueryStudentBean;
import com.example.demo.Bean.ResultBean;
import com.example.demo.Bean.StudentInformationBean;
import com.example.demo.Domain.TbStudent;
import com.example.demo.UItl.DBUtils;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.Secmod;

import java.util.List;
import java.util.Map;

@Service
public class StudentService extends BaseService {
    public ResultBean student(StudentInformationBean student) {
        int i = addStudent(student);
        if (i == 1) {
            return BaseService.success("添加成功");
        } else {
            return BaseService.failure("添加失败");
        }
    }

    public int addStudent(StudentInformationBean student) {

        int i = DBUtils.add_returnId("insert into tbgrade (grade)VALUES(" + student.getGrade() + ")");
        System.out.println("insert into tbstudent (name,sexual,age,tbgradeid)VALUES('" + student.getName() + "','" + student.getSexual() + "','" + student.getAge() + "'," + i + "')");
        int update = DBUtils.update("insert into tbstudent (name,sexual,age,tbgradeid)VALUES('" + student.getName() + "','" + student.getSexual() + "','" + student.getAge() + "','" + i + "')");
        return update;
    }

    public ResultBean studentName(String name) {
        int i = getStudentName(name);
        if (i == 1) {
            System.out.println(1);
            return success();
        } else {
            System.out.println(0);
            return failure("姓名不存在");
        }
    }

    public int getStudentName(String name) {
        List<Map<String, Object>> list = DBUtils.getList("SELECT * FROM tbstudent WHERE name='" + name + "'");

        return list.size();
    }

    public int delStudent(int id) {
        List<Map<String, Object>> list = DBUtils.getList("SELECT tbgradeid,tbresultid FROM tbstudent WHERE id='" + id + "'");
        Map<String, Object> map = list.get(0);
        for (Map.Entry<String, Object> ma : map.entrySet()) {
            if (ma.getKey().equals("tbgradeid")) {
                DBUtils.update("DELETE FROM tbgrade WHERE id=" + ma.getValue() + "");
            }
            if (ma.getKey().equals("tbresultid")) {
                if (ma.getValue() == null) {
                } else {
                    DBUtils.update("DELETE FROM tbresult WHERE id=" + ma.getValue() + "");
                }
            }
        }
        int update = DBUtils.update("DELETE FROM tbstudent WHERE id=" + id + "");
        return update;
    }

    public ResultBean Student(int id) {
        int i = delStudent(id);
        if (i == 1) {
            return success();
        } else {
            return failure();
        }

    }

    public int upData(QueryStudentBean studentBean) {
        List<Map<String, Object>> list = DBUtils.getList("SELECT tbgradeid,tbresultid FROM tbstudent WHERE id='" + studentBean.getId() + "'");
        Map<String, Object> map = list.get(0);
        for (Map.Entry<String, Object> ma : map.entrySet()) {
            if (ma.getKey().equals("tbgradeid")) {
                DBUtils.update("UPDATE tbgrade SET grade=" + studentBean.getGrade() + " WHERE id=" + ma.getValue() + "");
            }
            if (ma.getKey().equals("tbresultid")) {
                if (ma.getValue() == null) {
                    int i = DBUtils.add_returnId("INSERT INTO tbresult (Chinese,Math,English)VALUES('" + studentBean.getChinese() + "','" + studentBean.getMath() + "','" + studentBean.getEnglish() + "')");
                    DBUtils.update("UPDATE tbstudent SET tbresultid='" + i + "' WHERE id=" + studentBean.getId() + "");

                } else {
                    DBUtils.update("UPDATE tbresult SET Chinese=" + studentBean.getChinese() + ",Math=" + studentBean.getMath() + ",English=" + studentBean.getEnglish() + " WHERE id=" + ma.getValue() + "");
                }
            }
        }
        int update = DBUtils.update("UPDATE tbstudent SET name='" + studentBean.getName() + "',sexual='" + studentBean.getSexual() + "',age=" + studentBean.getAge() + " WHERE id=" + studentBean.getId() + "");
        return update;
    }

    public ResultBean upDataStudent(QueryStudentBean studentBean) {
        int i = upData(studentBean);
        if (i==1){
            return success();
        }else {
            return failure();
        }
    }
}

