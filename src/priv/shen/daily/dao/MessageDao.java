package priv.shen.daily.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import priv.shen.daily.entity.Message;

public interface MessageDao {
	public List<Message> list();
	public List<Message> search(@Param("message")Message message);
	public Message get(@Param("id")Long id);
	public void add(@Param("message")Message message);
	public void update(@Param("message")Message message);
	public void delete(@Param("id")Long id);
}
