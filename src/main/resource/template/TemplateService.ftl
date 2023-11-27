package PACKAGES;

import java.util.List;

import com.meina.util.response.ResultData;


/**
 * CLASSNAME的信息模块
 * @author julong
 * @date 2023年11月16日 下午4:37:45
 * @desc 
 */
public interface DATAINDEXService {
	
    /**
     * 根据主键删除CLASSNAME的信息
     * @param dataid
     * @author julong
     * @date 2023-11-15 03:51:06
     */
    public abstract int deleteByDATAID(Long dataid);

    /**
     * 新增CLASSNAME的信息
     * @param dataindexForm
     * @author julong
     * @date 2023-11-15 03:51:06
     */
    public abstract int saveDATAINDEX(DATAINDEXForm dataindexForm);
 
    /**
     * 根据主键查询CLASSNAME的信息
     * @param dataid
     * @author julong
     * @date 2023-11-15 03:51:06
     */
    public abstract DATAINDEXVO getByDATAID(Long dataid);

    /**
     * 查询CLASSNAME的信息
     * @param dataindexQuery
     * @author julong
     * @date 2023-11-15 03:51:06
     */
    public abstract List<DATAINDEXVO> selectDATAINDEXList(DATAINDEXQuery dataindexQuery);

    /**
     * 分页查询CLASSNAME的信息
     * @param dataindexQuery
     * @return
     * @author julong
     * @date 2023年11月16日 下午4:37:24
     * @desc
     */
    public abstract ResultData<DATAINDEXVO> selectDATAINDEXListPage(DATAINDEXQuery dataindexQuery);
    
    /**
     * 根据主键修改CLASSNAME的信息
     * @param dataindexForm
     * @author julong
     * @date 2023-11-15 03:51:06
     */
    public abstract int updateDATAINDEX(DATAINDEXForm dataindexForm);
    
    /**
     * 根据主键更新CLASSNAME数据删除标识
     * @param dataid
     * @return
     * @author julong
     * @date 2023年11月16日 下午4:40:29
     * @desc
     */
    public abstract int updateDeleteStatus(Long dataid);


}