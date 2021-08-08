package com.jaswine.tool.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaswine.tool.model.mysql.MySQLTableLineModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MySQLDatabaseInfoMapper extends BaseMapper<MySQLTableLineModel> {

    List<String> getAllTableName();

    List<MySQLTableLineModel> getMySQLTableInfo(@Param("tableName") String tableName);
}
