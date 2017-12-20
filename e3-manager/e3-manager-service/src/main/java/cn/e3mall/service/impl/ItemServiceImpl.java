package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private 	TbItemMapper tbItemMapper;
	
	@Override
	public TbItem getItemById(long id) {
		TbItem selectByPrimaryKey = tbItemMapper.selectByPrimaryKey(id);
		 
		return selectByPrimaryKey;
	}

	@Override
	public DataGridResult findAllItem(int page, int rows) {
		PageHelper.startPage(page, rows);
		DataGridResult dataGrIdResult = new DataGridResult();
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> info = new PageInfo<>(list);
		long total = info.getTotal();
		dataGrIdResult.setRows(list);
		dataGrIdResult.setTotal(total);
		return dataGrIdResult;
	}

}
