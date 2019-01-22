package com.service;

import com.model.Part;

import java.util.List;

public interface PartsService {
	public void addPart(Part part);
	
	public void updatePart(Part part);
	
	public void removePart(int id);
	
	public Part getPartById(int id);
	
	public List<Part> listParts();
	
	public List<Part> selectNeeded();
	
	public List<Part> selectNotNeeded();
	
	public int countOfComputer();
	
	public Part getPartByName(String name);
	
	public List<Part> listNext();
	
	public void listPrevious();
	
	public List list();
	
	public List currentList();
	
	public List getFullList();
	
	public void redirectFrom();
	
}
