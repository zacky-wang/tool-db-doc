package com.jaswine.tool.service.impl;

import com.jaswine.tool.mapper.MySQLDatabaseInfoMapper;
import com.jaswine.tool.model.mysql.MySQLTableLineModel;
import com.jaswine.tool.model.mysql.MySqlTableModel;
import com.jaswine.tool.service.IDatabaseInfoService;
import com.jaswine.tool.service.IFileExport;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaswine
 * @date 2021-06-11 17:50:00
 */
@Service
public class MySQLDatabaseInfoServiceImpl implements IDatabaseInfoService , ApplicationContextAware {

    private ApplicationContext context;

    @Resource
    private MySQLDatabaseInfoMapper databaseInfoMapper;
    @Resource
    private IFileExport fileExport;

    @Override
    public List<MySqlTableModel> getTableInfo() {
        List<MySqlTableModel> tableInfo = new ArrayList<>();
        for (String tableName : databaseInfoMapper.getAllTableName()) {
            List<MySQLTableLineModel> lines = databaseInfoMapper.getMySQLTableInfo(tableName);
            MySqlTableModel tableModel = new MySqlTableModel(tableName, lines);
            tableInfo.add(tableModel);
        }
        return tableInfo;
    }

    @Override
    public InputStream getTableFile(String type) {
        List<MySqlTableModel> tableInfo = getTableInfo();
        fileExport = context.getBean("MarkdownFileExport",IFileExport.class);
        return fileExport.generateFile(tableInfo);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
