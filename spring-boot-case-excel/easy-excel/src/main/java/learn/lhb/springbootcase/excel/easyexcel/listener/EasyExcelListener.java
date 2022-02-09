package learn.lhb.springbootcase.excel.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.google.common.collect.Lists;
import learn.lhb.springbootcase.domain.constant.EasyExcelConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @Author lianghongbin
 * @Date 16:29 2022/2/9
 * @Description EasyExcel 监听器
 * <p> 不能注册为Bean ，被 Spring 管理</p>
 */
@Slf4j
public class EasyExcelListener<T> extends AnalysisEventListener<T> {
    /**
     * 最大支持的数据量
     */
    private Integer maxExport = EasyExcelConstant.MAX_EXPORT_COUNT;
    private Integer maxImport = EasyExcelConstant.MAX_IMPORT_COUNT;

    /**
     * 业务逻辑层
     */
    private T service;

    /**
     * 真正读取的数据 list
     */
    List<T> lists = Lists.newArrayList();

    public EasyExcelListener(T service) {
        this.service = service;
    }
    
    public EasyExcelListener() {}

    /**
     * 读取每行数据
     * @param t
     * @param analysisContext
     * @param lists
     */
    private void addLists(T t, AnalysisContext analysisContext, List<T> lists) {
        
    }

    /**
     * 解析每行数据
     * @param t
     * @param analysisContext
     */
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        addLists(t, analysisContext, this.lists);
    }

    /**
     * 全部数据解析完成后调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        
    }

//    @Override
//    public boolean hasNext(AnalysisContext context) {
//        
//    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        
    }

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {

    }

    /**
     * 获取表头数据 map
     * @param headMap
     * @param analysisContext
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext analysisContext) {
        
    }
    
    public List<T> getLists() {
        return this.lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
    
    public Integer getMaxExport() {
        return this.maxExport;
    }

    public void setMaxExport(Integer maxExport) {
        this.maxExport = maxExport;
    }
    
    public Integer getMaxImport() {
        return this.maxImport;
    }

    public void setMaxImport(Integer maxImport) {
        this.maxImport = maxImport;
    }
}
