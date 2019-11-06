package com.example.demo.Controller;

import com.example.demo.Bean.ResultBean;
import com.example.demo.Domain.Tbresult;
import com.example.demo.service.AddStudentResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddStudentResultController {
    @Autowired
   private AddStudentResultService addStudentResultService;
    @RequestMapping("/addResult")
    @ResponseBody
    public ResultBean addResult(Tbresult result, String name)  {
        ResultBean resultBean = addStudentResultService.studentResult(result, name);
        return resultBean;
    }


}
