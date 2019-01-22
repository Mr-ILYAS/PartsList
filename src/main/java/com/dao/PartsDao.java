package com.dao;

import com.model.Part;
import java.util.List;

public interface PartsDao {
	public void addPart(Part part);
	public void updatePart(Part part);
	public void removePart(int id);
	public Part getPartById(int id);
	public List<Part> listParts();
}