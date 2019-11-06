package com.example.demo.Controller;
import com.example.demo.Bean.ResultBean;
import com.example.demo.Bean.StudentInformationBean;
import com.example.demo.Domain.TbAdmin;
import com.example.demo.UItl.Md5Utils;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;


@Controller
public class AdminController {
    @RequestMapping("/index")
    public Object index(){

        return "index";
    }
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(TbAdmin admin) throws SQLException {
        String md5Password = Md5Utils.md5Utils(admin.getPassword());
        admin.setPassword(md5Password);
        ResultBean resultBean = adminService.login(admin);

        return resultBean;
    }
    @RequestMapping("/register")
    @ResponseBody
    public ResultBean register(TbAdmin admin) throws SQLException {
        admin.setPassword(Md5Utils.md5Utils(admin.getPassword()));
        ResultBean register = adminService.register(admin);

        return register;
    }
    @RequestMapping("/loginPage")
    public String login(){

        return "login";
    }


}
