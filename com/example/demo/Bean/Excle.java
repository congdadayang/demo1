package com.example.demo.Bean;

import java.util.List;

public class Excle<T> {
    private List<T> list;// 数据所在的集合
    private String[] title;//sheet表的标题
    private String SheetName; //sheet表的名称
    private String excelName; //excel的名称
    private String path;//excel表格保存的路径
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public String[] getTitle() {
        return title;
    }
    public void setTitle(String[] title) {
        this.title = title;
    }
    public String getSheetName() {
        return SheetName;
    }
    public void setSheetName(String sheetName) {
        SheetName = sheetName;
    }
    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

