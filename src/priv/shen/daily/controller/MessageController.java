package priv.shen.daily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import priv.shen.daily.dao.MessageDao;
import priv.shen.daily.entity.Message;
import priv.shen.daily.excepetion.NullException;
import priv.shen.daily.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageDao messageDao;
	
	@RequestMapping(path="/message/messages",method=RequestMethod.GET)
	public String list(Model model) {
		List<Message> messages=messageDao.list();
		model.addAttribute("messages", messages);
		
		return "list";
	}
	
	@RequestMapping(path="/message/messages",method=RequestMethod.POST)
	public String search(Message message,Model model) {
		List<Message> messages=messageDao.search(message);
		model.addAttribute("messages", messages);
		
		return "list";
	}
	
	@RequestMapping(path="/message/{id}",method=RequestMethod.GET)
	public String get(@PathVariable("id") Long id,Model model) {
		Message message=messageDao.get(id);
		model.addAttribute("message", message);
		
		return "detail";
	}
	
	@RequestMapping(path="/message",method=RequestMethod.POST)
	public String add(Message message,Model model) {
		
		try {
			
			messageService.add(message);
		} catch (NullException e) {
			model.addAttribute("message", e.getMessage());
		}
		
		return "redirect:/message/messages";
	}
	
	@RequestMapping(path="/message/put")
	public String update(Message message) {
		messageDao.update(message);
		return "redirect:/message/messages";
	}
	
	@RequestMapping(path="/message/delete/{messageId}")
	public String delete(@PathVariable("messageId") Long messageId) {
		messageDao.delete(messageId);
		return "redirect:/message/messages";
	}
	
}
