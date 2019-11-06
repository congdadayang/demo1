package com.example.demo.Controller;

import com.example.demo.Bean.Excle;
import com.example.demo.Bean.QueryStudentBean;
import com.example.demo.Bean.ResultBean;
import com.example.demo.service.GetStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class GetStudentController {
    @Autowired
    GetStudentService getStudentService;

    @RequestMapping("/query")
    @ResponseBody
    public ResultBean getListStudent(QueryStudentBean studentBean, String page, String limit) {
        System.out.println("页数" + page + "一页多少条数据" + limit);
        System.out.println("姓名" + studentBean.getName() + "年级" + studentBean.getGrade());
        ResultBean resultBean = getStudentService.GetLIStStudent(studentBean, page, limit);
        int size = getStudentService.getSize();
        resultBean.setCount(size);
        return resultBean;
    }

    @RequestMapping("/QueryStudent")
    public String Query() {
        return "Query";
    }

    @RequestMapping("/page")
    @ResponseBody
    public int page() {

        return 1;
    }

    @RequestMapping("/toExcel")
    @ResponseBody
    public ResultBean ex(QueryStudentBean studentBean) throws IOException, IllegalAccessException {
        ResultBean ex = getStudentService.ex(studentBean);

        return ex;
    }

}
