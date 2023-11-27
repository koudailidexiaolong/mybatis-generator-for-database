package PACKAGES;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meina.util.response.ResponseResult;
import com.meina.util.response.ResultData;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="CLASSNAME模块")
@RestController
@RequestMapping("/api/v2/dataindex")
public class DATAINDEXAction {

	@Autowired
	private DATAINDEXService dataindexServiceImpl;
	

    /**
     * 查询CLASSNAME列表
     * @param dataindexQuery
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:16:21
     * @desc
     */
    @ApiOperation(value = "查询CLASSNAME列表")
    @PostMapping("/list")
    public ResponseResult<List<DATAINDEXVO>> selectDATAINDEXList(@RequestBody DATAINDEXQuery dataindexQuery) {
        //查询结果
        List<DATAINDEXVO> listData = this.dataindexServiceImpl.selectDATAINDEXList(dataindexQuery);
        return ResponseResult.getResult(listData);
    }
  
    /**
     * 分页查询CLASSNAME列表
     * @param dataindexQuery
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:18:42
     * @desc
     */
    @ApiOperation(value = "分页查询CLASSNAME列表")
    @PostMapping("/pages")
    public ResponseResult<ResultData<DATAINDEXVO>> selectDATAINDEXListPage(@RequestBody DATAINDEXQuery dataindexQuery) {
        //分页查询
        ResultData<DATAINDEXVO> pageData = this.dataindexServiceImpl.selectDATAINDEXListPage(dataindexQuery);
        return ResponseResult.getResult(pageData);
    }
   
    /**
     * 新增CLASSNAME信息
     * @param dataindexForm
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:19:07
     * @desc
     */
    @ApiOperation(value = "新增CLASSNAME信息")
    @PostMapping("/save")
    public ResponseResult<Integer> saveDATAINDEX(@Valid @RequestBody DATAINDEXForm dataindexForm) {
        int result =  this.dataindexServiceImpl.saveDATAINDEX(dataindexForm);
        return ResponseResult.getResult(result);
    }
   
    /**
     * 修改CLASSNAME信息
     * @param DATAINDEXForm
     * @param dataid
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:19:20
     * @desc
     */
    @ApiOperation(value = "修改CLASSNAME信息")
    @PostMapping("/update/{dataid}")
    public ResponseResult<Integer> updateDATAINDEX(@ApiParam(name = "dataid", value = "CLASSNAME编号", required = true)@Valid @RequestBody  DATAINDEXForm dataindexForm,@PathVariable(name = "dataid", required = true) Long dataid) {
        dataindexForm.setDATAID(dataid);
        int result = this.dataindexServiceImpl.updateDATAINDEX(dataindexForm);
        return ResponseResult.getResult(result);
    }
    
    /**
     * 根据编号查询CLASSNAME信息
     * @param dataid 主键
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:20:11
     * @desc
     */
    @ApiOperation(value = "根据编号查询CLASSNAME信息")
    @GetMapping("/{dataid}")
    public ResponseResult<DATAINDEXVO> getDATAINDEXById(@ApiParam(name = "dataid", value = "CLASSNAME编号", required = true) @PathVariable(name = "dataid", required = true) Long dataid) {
    	DATAINDEXVO dataVO =  this.dataindexServiceImpl.getByDATAID(dataid);
        return ResponseResult.getResult(dataVO);
    }
  
    /**
     * 根据主键物理删除CLASSNAME信息
     * @param dataid 主键
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:29:32
     * @desc
     */
    @ApiOperation(value = "物理删除CLASSNAME信息")
    @GetMapping(value = "/delete/{dataid}")
    public ResponseResult<Integer> deleteDATAINDEX(@ApiParam(name = "dataid", value = "CLASSNAME编号", required = true) @PathVariable(name = "dataid", required = true) Long dataid) {
    	int result = this.dataindexServiceImpl.deleteByDATAID(dataid);
        return ResponseResult.getResult(result);
    }
   
    /**
     * 根据主键逻辑删除CLASSNAME信息
     * @param dataid
     * @return
     * @author julong
     * @date 2023年11月20日 下午8:27:20
     * @desc
     */
    @ApiOperation(value = "逻辑删除CLASSNAME信息")
    @GetMapping(value = "/update/deleteStatus/{dataid}")
    public ResponseResult<Integer> updateDATAINDEXDeleteStatus(@ApiParam(name = "dataid", value = "CLASSNAME编号", required = true) @PathVariable(name = "dataid", required = true) Long dataid) {
    	int result = this.dataindexServiceImpl.updateDeleteStatus(dataid);
    	return ResponseResult.getResult(result);
    }

}
