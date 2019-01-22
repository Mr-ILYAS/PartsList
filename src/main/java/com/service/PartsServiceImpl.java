package com.service;

import com.dao.PartsDao;
import com.model.Part;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {
	private PartsDao partsDao;
	private List<Part> currentList = new ArrayList();
	List<Part> editList = new ArrayList();
	private int limit = 10;
	private int from = 0;
	
	public void setPartsDao(PartsDao partsDao) {
		this.partsDao = partsDao;
	}
	
	@Override
	@Transactional
	public void addPart(Part part) {
		this.partsDao.addPart(part);
		from = 0;
	}
	
	@Override
	@Transactional
	public void updatePart(Part part) {
		this.partsDao.updatePart(part);
		from = 0;
	}
	
	@Override
	@Transactional
	public void removePart(int id) {
		this.partsDao.removePart(id);
		from = 0;
	}
	
	@Override
	@Transactional
	public Part getPartById(int id) {
		return this.partsDao.getPartById(id);
	}
	
	@Override
	@Transactional
	public List<Part> list() {
		currentList = this.partsDao.listParts();
		return currentList;
	}
	
	@Override
	@Transactional
	public List<Part> listParts() {
		if(from >= currentList.size()) return editList;
		editList.clear();
		for(int i = from; i < (from + limit); i++) {
			if(i < currentList.size()) editList.add(currentList.get(i));
		}
		from += limit;
		return editList;
	}
	
	@Override
	@Transactional
	public List<Part> currentList() {
		return currentList;
	}
	
	@Override
	@Transactional
	public List<Part> listNext() {
		return listParts();
	}
	
	@Override
	@Transactional
	public void listPrevious() {
		int x = from - 2*limit;
		if(x < 0) from = 0;
		else from = x;
	}
	
	@Override
	@Transactional
	public List<Part> selectNeeded(){
		currentList.clear();
		List<Part> list = this.partsDao.listParts();
		for(Part part : list) {
			if(part.getNeeded() == 1) currentList.add(part);
		}
		from = 0;
		return currentList;
	}
	
	@Override
	@Transactional
	public List<Part> selectNotNeeded(){
		currentList.clear();
		List<Part> list = this.partsDao.listParts();
		for(Part part : list) {
			if(part.getNeeded() == 0) currentList.add(part);
		}
		from = 0;
		return currentList;
	}
	
	@Override
	@Transactional
	public int countOfComputer() {
		List<Part> list = this.partsDao.listParts();
		List<Part> neededList = new ArrayList();
		for(Part part : list) {
			if(part.getNeeded() == 1) neededList.add(part);
		}
		int res = neededList.get(0).getQuantity();
		for(Part part : neededList) {
			if(res > part.getQuantity()) res = part.getQuantity();
		}
		return res;
	}
	@Transactional
	public Part getPartByName(String name) {
		List<Part> list = this.partsDao.listParts();
		for(Part part : list) {
			if(part.getName().equals(name)) return part;
		}
		Part part = new Part();
		part.setName("Неверное наименование");
		from = 0;
		return  part;
	}
	
	@Override
	@Transactional
	public List<Part> getFullList() {
		return partsDao.listParts();
	}
	
	@Override
	public void redirectFrom() {
		from = 0;
	}
}
