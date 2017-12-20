import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void pageHelperTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 10);
		List<TbItem> list = itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(list.size());
	}
	
}
