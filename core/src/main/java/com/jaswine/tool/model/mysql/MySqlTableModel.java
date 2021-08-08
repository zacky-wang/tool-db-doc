package com.jaswine.tool.model.mysql;

import com.jaswine.tool.model.BaseTableModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jaswine
 * @date 2021-08-05 11:56:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MySqlTableModel extends BaseTableModel {

    private String tableName;

    private List<MySQLTableLineModel> lines;

}
