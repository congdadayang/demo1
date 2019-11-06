package com.example.demo.service;

import com.example.demo.Bean.ResultBean;
import com.example.demo.Domain.Tbresult;
import com.example.demo.UItl.DBUtils;
import org.springframework.stereotype.Service;

@Service
public class AddStudentResultService extends BaseService {
    public int UpDataStudentResult(Tbresult result, String name) {
        int i = DBUtils.add_returnId("INSERT INTO tbresult (Chinese,Math,English)VALUES('" + result.getChinese() + "','" + result.getMath() + "','" + result.getEnglish() + "')");
        if (i!=0) {
            int update = DBUtils.update("UPDATE tbstudent SET tbresultid='" + i + "' WHERE name='" + name + "'");
            if (update == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    public ResultBean studentResult(Tbresult result, String name) {
        int i = UpDataStudentResult(result, name);
        if (i == 1) {
           return success("录入成功");
        } else {
            return failure("信息录入错误");
        }
    }
}
