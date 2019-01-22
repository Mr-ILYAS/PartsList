package com.controller;

import com.model.Part;
import com.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartsController {
	private PartsService partsService;
	
	@Autowired(required = true)
	@Qualifier(value = "partsService")
	public void setPartsService(PartsService partsService) {
		this.partsService = partsService;
	}
	
	@RequestMapping(value = "parts", method = RequestMethod.GET)
	public String listParts(Model model){
		if(this.partsService.currentList().size() == 0) this.partsService.list();
		model.addAttribute("fullList", this.partsService.getFullList());
		model.addAttribute("listAll", this.partsService.currentList());
		model.addAttribute("part", new Part());
		model.addAttribute("listParts", this.partsService.listParts());
		model.addAttribute("countComputers", this.partsService.countOfComputer());
		return "parts";
	}
	
	@RequestMapping("redirect")
	public String initialize() {
		this.partsService.list();
		this.partsService.redirectFrom();
		return "redirect:/parts";
	}
	
	@RequestMapping(value = "/parts/add", method = RequestMethod.POST)
	public String addPart(@ModelAttribute("part") Part part) {
		if(part.getId() == 0){
			if(part.isValid()) this.partsService.addPart(part);
		}else {
			this.partsService.updatePart(part);
		}
		return "redirect:/redirect";
	}
	
	@RequestMapping(value = "/parts/update", method = RequestMethod.POST)
	public String updatePart(@ModelAttribute("part") Part part) {
			this.partsService.updatePart(part);
		return "redirect:/redirect";
	}
	
	@RequestMapping(value = "/parts/search", method = RequestMethod.POST)
	public String getPartByName(@ModelAttribute("part") Part part, Model model) {
		model.addAttribute("part", partsService.getPartByName(part.getName()));
		return "search";
	}
	
	@RequestMapping("/remove/{id}")
	public String removePart(@PathVariable("id") int id){
		this.partsService.removePart(id);
		return "redirect:/redirect";
	}
	
	@RequestMapping("next")
	public String nextList() {
		return "redirect:/parts";
	}
	
	@RequestMapping("previous")
	public String previousList() {
		this.partsService.listPrevious();
		return "redirect:/parts";
	}
	
	@RequestMapping(value = "/parts/selectNeeded", method = RequestMethod.GET)
	public String selectNeeded() {
		this.partsService.selectNeeded();
		return "redirect:/parts";
	}
	@RequestMapping(value = "/parts/selectNotNeeded", method = RequestMethod.GET)
	public String selectNotNeeded() {
		this.partsService.selectNotNeeded();
		return "redirect:/parts";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editPart(@PathVariable("id") int id, Model model) {
	model.addAttribute("part", this.partsService.getPartById(id));
	model.addAttribute("listParts", this.partsService.listParts());
	return "parts";
	}
}