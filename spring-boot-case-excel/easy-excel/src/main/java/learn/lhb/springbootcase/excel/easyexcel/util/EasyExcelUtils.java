package learn.lhb.springbootcase.excel.easyexcel.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import learn.lhb.springbootcase.domain.constant.EasyExcelConstant;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

/**
 * @Author lianghongbin
 * @Date 17:33 2022/2/8
 * @Description 
 */
@Slf4j
public class EasyExcelUtils {

    public static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception{
        try{
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8") + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e){
            log.error("导出文件失败");
            throw new Exception("导出文件失败!");
        }
    }
    
    public static Boolean checkFileName(String fileName) {
        Objects.requireNonNull(fileName, "导入失败，文件名不能为空!");
        return fileName.endsWith(EasyExcelConstant.XLS) && fileName.endsWith(EasyExcelConstant.XLSX);
    }

    /**
     * @Description  通用 excel 导出模板
     * 针对没有复杂的合并单元格的导出
     * 使用EasyExcel的流会自动关闭，无需手动关闭
     * @Date 16:21 2022/2/9
     * @Param response
     * @param list
     * @param fileName
     * @param sheetName
     * @param clazz
     * @Return 
     * @Author lianghongbin
     */
    public static <T> void commonWrite(HttpServletResponse response, List<T> list, String fileName, String sheetName, Class<T> clazz) throws Exception{
        try {
            EasyExcel.write(getOutputStream(fileName, response), clazz)
                    .excelType(ExcelTypeEnum.XLSX)
                    .autoCloseStream(Boolean.TRUE)
                    .sheet(sheetName)
                    .doWrite(list);
        } catch (Exception e) {
            throw new Exception(String.format("【%s】文件导出失败", fileName));
        }
    }
        
}
