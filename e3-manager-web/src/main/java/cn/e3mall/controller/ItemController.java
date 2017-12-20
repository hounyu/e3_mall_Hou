package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;



@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable long itemId){
		TbItem itemById = itemService.getItemById(itemId);
		return itemById;
	} 
	@RequestMapping("/")
	public String indexShow(){
		return "index";
	} 
	/**
	 * 页面跳转
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	} 
	
	/**
	 * 查询所有商品(分页)
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult findAllItem(int page,int rows){
		DataGridResult dataGridResult  = itemService.findAllItem(page,rows);
		return dataGridResult;
	}
	
	
}
