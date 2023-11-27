package PACKAGES;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.pagehelper.PageInfo;


@Mapper(componentModel="spring")
public interface DATAINDEXConverter {

	public static final DATAINDEXConverter INSTANCE = Mappers.getMapper(DATAINDEXConverter.class);
	
	/**
	 * info 转 vo
	 * @param dataindexPage
	 * @return
	 * @author julong
	 * @date 2023年9月12日 上午11:50:39
	 * @desc
	 */
	public abstract PageInfo<DATAINDEXVO> entityPageConverterVOPage(PageInfo<DATAINDEX> dataindexPage);

	
	/**
     * info list 转 vo list
     *
     * @param dataindexList
     * @return
     * @author julong
     * @date 2023年9月12日 上午11:50:52
     * @desc
     */
	public abstract List<DATAINDEXVO> entityListConverterVOList(List<DATAINDEX> dataindexList);

	
	/**
	 * info 转 vo
	 * @param dataindex
	 * @return
	 * @author julong
	 * @date 2023年9月12日 上午11:51:06
	 * @desc
	 */
	@Mapping(source="dataid",target="dataId")
	public abstract DATAINDEXVO entityConverterVO(DATAINDEX dataindex);

	
	/**
	 * form 转 info
	 * @param dataindexForm
	 * @return
	 * @author julong
	 * @date 2023年9月12日 上午11:51:15
	 * @desc
	 */
	public abstract DATAINDEX formConverterEntity(DATAINDEXForm dataindexForm);
	

}
