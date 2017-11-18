package priv.shen.daily.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.shen.daily.dao.MessageDao;
import priv.shen.daily.entity.Message;
import priv.shen.daily.excepetion.NullException;

@Service
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	
	public void add(Message message) {
		if(message.getName()==null||message.getName()=="") {
			throw new NullException("��������Ϊ��");
		}
		if(message.getMessage()==null||message.getMessage()=="") {
			throw new NullException("���Բ���Ϊ��");
		}
		messageDao.add(message);
	}
}
