package com.customfile.dao;

import java.util.List;

import com.customfile.exception.CustomFileException;
import com.customfile.model.CustomFile;

public interface CustomFileDAO {

	public CustomFile createCustomFile(CustomFile customfile,String name) throws CustomFileException;
	public void deleteCustomFile(String name) throws CustomFileException;
	public CustomFile getCustomFileByName(String name) throws CustomFileException;
	public List<CustomFile> getAllCustomFilesByFormat(String format) throws CustomFileException;
	
	public List<CustomFile> getAllCustomFilesByName() throws CustomFileException;
	

	
}
