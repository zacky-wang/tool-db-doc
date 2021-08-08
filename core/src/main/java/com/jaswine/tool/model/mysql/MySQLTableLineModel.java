package com.jaswine.tool.model.mysql;

import com.jaswine.tool.model.BaseTableModel;
import lombok.Data;

/**
 * @author Jaswine
 * @date 2021-06-11 17:48:57
 */
@Data
public class MySQLTableLineModel {

    /** 字段 */
    private String field;

    /** 类型 */
    private String type;

    /** 字符集 */
    private String collation;

    /** 是否可为null */
    private String isNull;

    /** 是否是索引键 */
    private String key;

    /** 默认值 */
    private String defaultValue;

    /** 注释 */
    private String comment;

}
