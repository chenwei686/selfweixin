package com.self.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.mapper.TbItemMapper;
import com.self.pojo.TbItem;
import com.self.pojo.TbItemExample;
import com.self.service.TbItemService;

@Service
public class TbItemServiceImpl implements TbItemService{

	@Autowired
	TbItemMapper tbItemMapper;
	
	@Override
	public TbItem loadItem(Long id) {
		// TODO Auto-generated method stub
		System.out.println("-------------serc");
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		System.out.println(tbItem);
		return tbItem;
	}

/*	@Override
	public EasyUiDataGrid ListItems(TbItemExample example, int page, int rows) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(page , rows);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		Long  total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);

		EasyUiDataGrid grid = new EasyUiDataGrid();
		grid.setRows(list);
		
		grid.setTotal(total);
		
		return grid;
	}*/

}
