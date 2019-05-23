package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Book;
import com.uca.capas.service.BookService;
import com.uca.capas.dao.BookDAO;

@Controller
public class MainController {

	static Logger log = Logger.getLogger(MainController.class.getName());

	@Autowired
	private BookService bookService;

	//private String[] criteria = {"Título", "Autor", "ISBN", "Género"};
	Map<Integer, String> criteria;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Iniciando funcion main - " + log.getName());
			
		ModelAndView mav = new ModelAndView();
		
		criteria = new HashMap<>();
		criteria.put(0, "Título");
		criteria.put(1, "Autor");
		criteria.put(2, "ISBN");
		criteria.put(3, "Género");
		
		mav.addObject("criteria", criteria);
		mav.setViewName("main");
		return mav;
	
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value = "term") String term, @RequestParam(value="criteria") int criterion) {
		ModelAndView mav = new ModelAndView();
		if(criterion < 0 || criterion > 3) criterion = 0;
		List<Book> books = bookService.findbyCriteria(criterion, term);
		
		mav.addObject("all", 0);
		mav.addObject("books", books);
		mav.addObject("quantity",books.size());
		mav.addObject("term", term);
		mav.addObject("criteria", criteria.get(criterion));
		mav.setViewName("result");
		return mav;
	}

	@RequestMapping("/showAll")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<Book> books = bookService.findAll();
		int nAuthors = bookService.countAuthors();
		int sBooks = bookService.sumStock();
		
		mav.addObject("all", 1);
		mav.addObject("books", books);
		mav.addObject("quantity",sBooks);
		mav.addObject("qauthors", nAuthors);
		mav.setViewName("result");
		return mav;
	}

}
