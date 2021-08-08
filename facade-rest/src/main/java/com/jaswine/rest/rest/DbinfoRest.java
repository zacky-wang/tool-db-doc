package com.jaswine.rest.rest;

import com.jaswine.tool.model.BaseTableModel;
import com.jaswine.tool.service.IDatabaseInfoService;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Jaswine
 * @date 2021-07-22 09:10:37
 */
@RestController
@RequestMapping(value = "/db")
public class DbinfoRest {

    @Resource
    private IDatabaseInfoService databaseInfoService;

    @GetMapping(value = "/json")
    public List<BaseTableModel> getDbJsonInfo(){
        return databaseInfoService.getTableInfo();
    }

    @GetMapping(value = "/file/{type}")
    public void getDbFileInfo(HttpServletResponse response, @PathVariable String type) throws IOException {

        InputStream md = databaseInfoService.getTableFile(type);

        response.setHeader("Content-Disposition", String.format("inline; filename= demo.md"));
        response.setContentType("application/octet-stream");

        IOUtils.copy(md,response.getOutputStream());
    }

}
