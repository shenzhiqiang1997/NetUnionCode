package priv.shen.daily.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.shen.daily.dao.MessageDao;
import priv.shen.daily.entity.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class TestDao {
	@Autowired
	private MessageDao messageDao;
	
	@Test
	public void testAdd() {
		Message message=new Message("123", "123");
		messageDao.add(message);
	}
	@Test
	public void testGet() {
		Message message=messageDao.get(1L);
		System.out.println(message);
	}
	@Test
	public void testList() {
		List<Message> messages=messageDao.list();
		System.out.println(messages);
	}
	@Test
	public void testSearch() {
		Message message=new Message("123", "123",new Date());
		List<Message> messages=messageDao.search(message);
		System.out.println(messages);
	}
	@Test 
	public void testUpdate() {
		Message message=new Message(1L,"1234","1234",new Date());
		messageDao.update(message);
	}
	@Test
	public void testDelete() {
		messageDao.delete(1L);
	}
	
}
