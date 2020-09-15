package com.customfile.service;

import java.util.List;

import com.customfile.exception.CustomFileException;
import com.customfile.model.CustomFile;

public interface CustomFileService {
	
	public CustomFile createCustomFile(CustomFile customfile,String name) throws CustomFileException;
	public void deleteCustomFile(String name) throws CustomFileException;
	public CustomFile getCustomFileByName(String name) throws CustomFileException;
	public List<CustomFile> getAllCustomFilesByFormat(String format) throws CustomFileException;
	
	public List<CustomFile> getAllCustomFilesByName() throws CustomFileException;
	//public List<CustomFile> getAllCustomFilesBySize() throws CustomFileException;
	//public List<CustomFile> getAllCustomFilesByName() throws CustomFileException;

}
