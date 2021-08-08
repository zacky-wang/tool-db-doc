package com.jaswine.tool.service;



import com.jaswine.tool.model.BaseTableModel;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * 数据库操作interface
 *
 * @author jaswine
 */
public interface IDatabaseInfoService {

    <T extends BaseTableModel> List<T> getTableInfo();

    InputStream getTableFile(String type);

}
