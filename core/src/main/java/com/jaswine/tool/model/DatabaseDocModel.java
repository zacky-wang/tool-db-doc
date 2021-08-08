package com.jaswine.tool.model;

import java.util.List;

/**
 * @author Jaswine
 * @date 2021-06-08 20:50:57
 */
public class DatabaseDocModel {


    private String databaseName;

    private String charSet;

    private List<BaseTableModel> tableList;


    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public List<BaseTableModel> getTableList() {
        return tableList;
    }

    public void setTableList(List<BaseTableModel> tableList) {
        this.tableList = tableList;
    }
}
