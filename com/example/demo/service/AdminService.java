package com.example.demo.service;

import com.example.demo.Bean.LoginBean;
import com.example.demo.Bean.ResultBean;
import com.example.demo.Domain.TbAdmin;
import com.example.demo.UItl.DBUtils;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Service
public class AdminService extends BaseService {
    public ResultBean login(TbAdmin admin) throws SQLException {
        LoginBean listLoginBean = listLogin(admin);
        if (listLoginBean==null) {
            return failure("用户名或密码不正确");
        }else if (listLoginBean.getPassword().equals(admin.getPassword())){
            return success();
        }else {
            return failure("用户名或密码不正确");
        }
    }
    public LoginBean listLogin(TbAdmin admin) throws SQLException {
        List<Map<String,Object>> list = DBUtils.getList("SELECT * FROM tbadmin WHERE name='" + admin.getName() + "'");
        LoginBean loginData = null;
        if (list.size()!=0){
            Map<String, Object> map = list.get(0);
            for (Map.Entry<String, Object> ma:map.entrySet()){
                loginData =new LoginBean();
                if (admin.getPassword().equals(ma.getValue())){
                    loginData.setPassword((String) ma.getValue());
                    return loginData;
                }
            }
        }else {
            return null;
        }
        return loginData;
    }
    public ResultBean register(TbAdmin admin) throws SQLException {//注册
        LoginBean listLoginBean = listLogin(admin);
        if (listLoginBean==null){
            int i = addRegister(admin);
                return success("注册成功");//返回成功
        }else {
            return failure("用户名已被注册");//返回失败
        }
    }
    public int addRegister(TbAdmin admin) {//注册
        int update = DBUtils.update("INSERT INTO tbadmin(name,PASSWORD)VALUES('" + admin.getName() + "','" + admin.getPassword() + "')");
        return update;
    }
}