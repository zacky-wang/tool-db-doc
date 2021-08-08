package com.jaswine.tool.service.impl.export;

import com.jaswine.tool.model.mysql.MySQLTableLineModel;
import com.jaswine.tool.model.mysql.MySqlTableModel;
import com.jaswine.tool.service.IFileExport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Jaswine
 * @date 2021-08-05 15:13:24
 */
@Service(value = "MarkdownFileExport")
@Slf4j
public class MarkdownFileExport implements IFileExport {

    private final String COLUMN_NAME =  "|字段|类型|字符集|是否为Null|键|默认值|注释|\n|:--|:--|:--|:--|:--|:--|:--|\n";

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年 MM月dd日 HH:mm");

    @Override
    public InputStream generateFile(List<MySqlTableModel> tableModels) {


        String header = buildHeader();
        String body = buildTable(tableModels);

        String content = header.concat(body);

        return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
    }


    private String buildHeader(){
        StringBuilder header = new StringBuilder();
        header.append("数据库生成\n")
                .append("生成时间:")
                .append(LocalDateTime.now().format(dateTimeFormatter))
                .append("\n");
        return header.toString();
    }

    private String buildTable(List<MySqlTableModel> tableModels){
        StringBuilder  body = new StringBuilder();
        for (MySqlTableModel tableModel: tableModels){
            body.append("表名:").append(tableModel.getTableName()).append("\n")
                .append(COLUMN_NAME);
            for (MySQLTableLineModel line : tableModel.getLines()){
                body.append("|").append(line.getField() == null ? "/" : line.getField()).append("|")
                    .append(line.getType() == null ? "/" : line.getType()).append("|")
                    .append(line.getCollation() == null ? "/" : line.getCollation()).append("|")
                    .append(line.getIsNull() == null ? "/" : line.getIsNull()).append("|")
                    .append(line.getKey() == null ? "/" : line.getKey()).append("|")
                    .append(line.getDefaultValue() == null ? "/" : line.getDefaultValue()).append("|")
                    .append(line.getComment() == null ? "/" : line.getComment()).append("|\n");
            }
        }

        return body.toString();
    }










}
