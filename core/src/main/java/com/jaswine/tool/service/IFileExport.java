package com.jaswine.tool.service;


import com.jaswine.tool.model.mysql.MySqlTableModel;

import java.io.InputStream;
import java.util.List;

public interface IFileExport {

    InputStream generateFile(List<MySqlTableModel> tableModels);

}
