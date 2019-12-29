package com.gaurav.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gaurav.demo.dao.AlienRepo;
import com.gaurav.demo.model.Alien;

import java.util.List;


@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	
	@RequestMapping("/")
	public String home(){
		System.out.println("in home ");
		return "home.jsp";
	}
	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien =repo.findById(aid).orElse(new Alien());
////		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByTechSorted("java"));
//		mv.addObject(alien);
//		return mv;
//	}

	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "Deleted";			
	}

	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	


	

}
