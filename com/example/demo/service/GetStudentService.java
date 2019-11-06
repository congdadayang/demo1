package com.example.demo.service;

import com.example.demo.Bean.ExcelBean;
import com.example.demo.Bean.Excle;
import com.example.demo.Bean.QueryStudentBean;
import com.example.demo.Bean.ResultBean;
import com.example.demo.UItl.DBUtils;
import com.example.demo.UItl.ExcelUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GetStudentService extends BaseService {
    public List listStudent(QueryStudentBean studentBean, int page, String limit) {
        System.out.println("SELECT tbstudent.id ,`name`,sexual,age,grade,Chinese,Math,English FROM tbstudent RIGHT JOIN tbgrade ON tbgradeid=tbgrade.id LEFT JOIN tbresult ON tbresultid=tbresult.id WHERE name like'%" + studentBean.getName() + "%' AND tbgrade.grade like'%" + studentBean.getQueryGrade() + "%'limit " + page + "," + limit + " ");
        List<Map<String, Object>> list = DBUtils.getList("SELECT tbstudent.id ,`name`,sexual,age,grade,Chinese,Math,English FROM tbstudent RIGHT JOIN tbgrade ON tbgradeid=tbgrade.id LEFT JOIN tbresult ON tbresultid=tbresult.id WHERE name like'%" + studentBean.getName() + "%' AND tbgrade.grade like'%" + studentBean.getQueryGrade() + "%'limit " + page + "," + limit + " ");
        List<QueryStudentBean> listQuery = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            Map<String, Object> map = list.get(i);
            QueryStudentBean listStudentBean = new QueryStudentBean();
            for (Map.Entry<String, Object> ma : map.entrySet()) {
                if (ma.getKey().equals("id")) {
                    listStudentBean.setId((Integer) ma.getValue());
                }
                if (ma.getKey().equals("name")) {
                    listStudentBean.setName((String) ma.getValue());
                }
                if (ma.getKey().equals("sexual")) {
                    listStudentBean.setSexual((String) ma.getValue());
                }
                if (ma.getKey().equals("age")) {
                    listStudentBean.setAge((Integer) ma.getValue());
                }
                if (ma.getKey().equals("grade")) {
                    listStudentBean.setGrade((Integer) ma.getValue());
                }
                if (ma.getKey().equals("Chinese")) {
                    if (ma.getValue() == null) {
                        listStudentBean.setChinese(0);
                    } else {
                        listStudentBean.setChinese((Integer) ma.getValue());
                    }
                }
                if (ma.getKey().equals("Math")) {
                    if (ma.getValue() == null) {
                        listStudentBean.setMath(0);
                    } else {
                        listStudentBean.setMath((Integer) ma.getValue());
                    }
                }
                if (ma.getKey().equals("English")) {
                    if (ma.getValue() == null) {
                        listStudentBean.setEnglish(0);
                    } else {
                        listStudentBean.setEnglish((Integer) ma.getValue());
                    }

                }
            }
            listQuery.add(listStudentBean);
        }
        return listQuery;
    }

    public ResultBean GetLIStStudent(QueryStudentBean studentBean, String page, String limit) {

        if (studentBean.getName() == null) {
            studentBean.setName("");
        }
        if (studentBean.getGrade() == 0) {
            studentBean.setQueryGrade("");
        } else {
            studentBean.setQueryGrade(String.valueOf(studentBean.getGrade()));
        }
        int i = Integer.parseInt(page);
        i = (i - 1) * 10;
        List list = listStudent(studentBean, i, limit);
        return success(list);
    }

    public int getSize() {
        int studentSize = getStudentSize();
        return studentSize;
    }

    public int getStudentSize() {
        int count = DBUtils.getCount("SELECT COUNT(*) FROM tbstudent");
        return count;
    }

    public ResultBean ex(QueryStudentBean studentBean) throws IllegalAccessException {
        studentBean.setQueryGrade("");
        studentBean.setName("");
        List list = listStudent(studentBean, 0, "5555");
        ExcelBean excel=new ExcelBean();
        excel.setList(list);
        excel.setExcelName("导出表");
        excel.setSheetName("学生表");
        excel.setPath("D:\\IDEA workbase\\demo1\\src\\main\\resources\\static\\ex");
        String[] str = new String[]{"序号", "姓名", "性别", "年龄", "年级", "语文", "数学", "英语"};
        String [] kye=new String[]{"id","name","sexual","age","grade","chinese","math","english"};
        excel.setKeys(kye);
        excel.setTitle(str);
        ExcelUtils.createExcel(excel);
        String path="/ex/导出表.xlsx";
        return success(path);
    }
}
