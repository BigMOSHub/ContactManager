package net.codejava.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.contact.dao.ContactDAO;
import net.codejava.contact.model.Contact;

@Controller
public class MainController {
	
		
	@Autowired
	private ContactDAO contactDAO;
	 
	@RequestMapping(value = "/") 
		public ModelAndView listContact(ModelAndView model) { 
		System.out.println("MainController linea 27 - inicio -/- listContact");
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact",listContact);
		model.setViewName("index");
		System.out.println("MainController linea 31 - fin -/- listContact");
		return model;
	}
		
	@RequestMapping(value = "/new", method = RequestMethod.GET) 
		public ModelAndView newContact(ModelAndView model) { 
		System.out.println("MainController linea 37 - inicio -/new-");
		Contact newContact = new Contact();
		model.addObject("contact",newContact);
		model.setViewName("contact_form");
		System.out.println("MainController linea 41 - fin -/new-");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public ModelAndView saveContact(@ModelAttribute Contact contact) { 
		System.out.println("MainController linea 47 - inicio -/save-");
		if (contact.getId()== null){
			contactDAO.save(contact);
		}else {
			contactDAO.update(contact);
		}
		System.out.println("MainController linea 53 - fin -/save-");
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET) 
	public ModelAndView editContact(HttpServletRequest request) { 
		System.out.println("MainController linea 58 - inicio -/edit-");
		Integer id	= Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(id);
		ModelAndView model = new ModelAndView("contact_form"); 
		model.addObject("contact",contact);				
		System.out.println("MainController linea 63 - fin -/edit-");
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public ModelAndView deleteContact(@RequestParam Integer id) { 
		System.out.println("MainController linea 69 - inicio -/delete-");
		contactDAO.delete(id);
		System.out.println("MainController linea 71 - fin -/delete-");
		return new ModelAndView("redirect:/");
	}

}
