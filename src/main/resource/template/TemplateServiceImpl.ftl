package PACKAGES;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.meina.page.PageParam;
import com.meina.page.PageUtils;
import com.meina.service.BaseService;
import com.meina.session.SessionUtils;
import com.meina.util.response.ResultData;

/**
 * CLASSNAME模块
 * @author julong
 * @date 2023年11月20日 下午10:28:54
 * @desc 
 */
@Service
public class DATAINDEXServiceImpl extends BaseService implements DATAINDEXService {

	private static final Logger logger = LoggerFactory.getLogger(DATAINDEXServiceImpl.class);
	
	@Autowired
	private DATAINDEXDao dataindexDaoImpl;
	
	/**
     * 根据主键删除CLASSNAME信息
     * @param dataid
     * @author julong
     * @date 2023年11月20日 下午10:28:54
     */
	@Override
	public int deleteByDATAID(Long dataid) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-删除CLASSNAME输入参数-dataid: {}", dataid);
		int result = this.dataindexDaoImpl.deleteByPrimaryKey(dataid);
		logger.debug("【CLASSNAME模块】-删除CLASSNAME执行结果-result: {}", result);
		return result;
	}

	/**
     * 新增CLASSNAME信息
     * @param dataindexForm
     * @author julong
     * @date 2023年11月20日 下午10:28:54
     */
	@Override
	public int saveDATAINDEX(DATAINDEXForm dataindexForm) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-新增CLASSNAME输入参数-dataindexForm: {}", dataindexForm);
		DATAINDEX entity = DATAINDEXConverter.INSTANCE.formConverterEntity(dataindexForm);
		entity.setDATAID(SequenceUtils.createSqeuenceToNumber());
		entity.setCreateFieldEntity(SessionUtils.getUser());
		int result = this.dataindexDaoImpl.insertSelective(entity);
		logger.debug("【CLASSNAME模块】-新增CLASSNAME执行结果-result: {}", result);
		return result;
	}

	/**
     * 根据主键查询CLASSNAME信息
     * @param dataid
     * @author julong
     * @date 2023年11月20日 下午10:28:54
     */
	@Override
	public DATAINDEXVO getByDATAID(Long dataid) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-根据编号查询CLASSNAME信息输入参数-dataid：{}", dataid);
		DATAINDEX entity = this.dataindexDaoImpl.selectByPrimaryKey(dataid);
		DATAINDEXVO dataindexVO = DATAINDEXConverter.INSTANCE.entityConverterVO(entity);
		return dataindexVO;
	}

	/**
     * 查询CLASSNAME信息
     * @param dataindex
     * @author julong
     * @date 2023年11月20日 下午10:28:54
     */
	@Override
	public List<DATAINDEXVO> selectDATAINDEXList(DATAINDEXQuery dataindexQuery) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-查询CLASSNAME信息列表输入参数-dataindexQuery: {}", dataindexQuery);
		//查询数据的方法
		List<DATAINDEX> dataList =  this.dataindexDaoImpl.selectBySelective(dataindexQuery);
		//分页获取的方法
		List<DATAINDEXVO> resultData = DATAINDEXConverter.INSTANCE.entityListConverterVOList(dataList);
		return resultData;
	}

	/**
     * 分页查询CLASSNAME信息
     * @param dataindexQuery
     * @return
     * @author julong
     * @date 2023年11月16日 下午4:37:24
     * @desc
     */
	@Override
	public ResultData<DATAINDEXVO> selectDATAINDEXListPage(DATAINDEXQuery dataindexQuery) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-分页查询CLASSNAME信息输入参数-dataindexQuery: {}", dataindexQuery);
		PageParam<DATAINDEX> pageParam = new PageParam<DATAINDEX>(dataindexQuery.getPageSize(), dataindexQuery.getPageIndex());
		if(pageParam.getPageSize() <= 0){
			pageParam.setPageSize(super.pageProperties.getPageSize());
		}
		if(pageParam.getPageIndex() <= 0){
			pageParam.setPageIndex(super.pageProperties.getPageIndex());
		}
		PageInfo<DATAINDEX> pages = PageUtils.getPageHelper(pageParam);
		//查询数据的方法
		PageMethod.startPage(pages.getPageNum(),pages.getPageSize());
		List<DATAINDEX> dataList =  this.dataindexDaoImpl.selectBySelective(dataindexQuery);
		//分页获取的方法
		pages = new PageInfo<DATAINDEX>(dataList);
		PageInfo<DATAINDEXVO> pageList = DATAINDEXConverter.INSTANCE.entityPageConverterVOPage(pages);
		//格式化返回结果
		ResultData<DATAINDEXVO> resultData = PageUtils.formatPage(pageList);
		return resultData;
	}

	 
    /**
     * 根据主键修改CLASSNAME信息
     * @param dataindexForm
     * @author julong
     * @date 2023年11月20日 下午10:28:54
     */
	@Override
	public int updateDATAINDEX(DATAINDEXForm dataindexForm) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-修改CLASSNAME输入参数-dataindexForm: {}", dataindexForm);
		DATAINDEX entity = DATAINDEXConverter.INSTANCE.formConverterEntity(dataindexForm);
		entity.setUpdateFieldEntity(SessionUtils.getUser());
		int result = this.dataindexDaoImpl.updateByPrimaryKeySelective(entity);
		logger.debug("【CLASSNAME模块】-修改CLASSNAME执行结果-result: {}", result);
		return result;
	}

	/**
     * 根据主键更新CLASSNAME数据删除标识
     * @param dataid
     * @return
     * @author julong
     * @date 2023年11月16日 下午4:40:29
     * @desc
     */
	@Override
	public int updateDeleteStatus(Long dataid) {
		// TODO Auto-generated method stub
		logger.debug("【CLASSNAME模块】-修改CLASSNAME删除状态输入参数-dataid: {}", dataid);
		DATAINDEX entity = new DATAINDEX();
		entity.setDATAID(dataid);
		entity.setDeleteFieldEntity(SessionUtils.getUser());
		int result = this.dataindexDaoImpl.updateByPrimaryKeySelective(entity);
		logger.debug("【CLASSNAME模块】-修改CLASSNAME删除状态执行结果-result: {}", result);
		return result;
	}

}
