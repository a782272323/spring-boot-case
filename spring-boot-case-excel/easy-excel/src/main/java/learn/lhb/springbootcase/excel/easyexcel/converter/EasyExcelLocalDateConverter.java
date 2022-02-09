package learn.lhb.springbootcase.excel.easyexcel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author lianghongbin
 * @Date 16:27 2022/2/9
 * @Description 自定义日期转换器 LocalDate
 */
public class EasyExcelLocalDateConverter implements Converter<LocalDate> {
    @Override
    public Class supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public CellData convertToExcelData(LocalDate localDate, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new  CellData<>(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
