package com.customfile.service.implementation;

import java.util.List;

import com.customfile.dao.CustomFileDAO;
import com.customfile.dao.implementation.CustomFileDAOImplementation;
import com.customfile.exception.CustomFileException;
import com.customfile.model.CustomFile;
import com.customfile.service.CustomFileService;

public class CustomFileServiceImplementation implements CustomFileService {

	private CustomFileDAO dao=new CustomFileDAOImplementation();

	
	@Override
	public CustomFile createCustomFile(CustomFile customfile, String name) throws CustomFileException {
		if(!isValidName(customfile.getFile_name())) {
			throw new CustomFileException("Entered name "+customfile.getFile_name()+" is invalid");
		}else if(!isValidFormat(customfile.getFormat())) {
			throw new CustomFileException("Entered format "+customfile.getFormat()+" is invalid");
		}else if(!isValidSize(customfile.getSize())) {
			throw new CustomFileException("Entered size "+customfile.getSize()+" is invalid");
		}else if(!isValidDay(customfile.getDay_of_creation())) {
			throw new CustomFileException("Entered day "+customfile.getDay_of_creation()+" is invalid");
		}else if(!isValidMonth(customfile.getMonth_of_creation())) {
			throw new CustomFileException("Entered month "+customfile.getMonth_of_creation()+" is invalid");
		}else if(!isValidYear(customfile.getYear_of_creation())) {
			throw new CustomFileException("Entered year "+customfile.getYear_of_creation()+" is invalid");
		}
		return dao.createCustomFile(customfile,name);
		
	}

	@Override
	public List<CustomFile> getAllCustomFilesByFormat(String format) throws CustomFileException {
		if(!isValidFormat(format)) {
			throw new CustomFileException("Invalid format -> "+format);
		}else {
			return dao.getAllCustomFilesByFormat(format);
		}
	}

	@Override
	public List<CustomFile> getAllCustomFilesByName() throws CustomFileException {
		return dao.getAllCustomFilesByName();
	}

	@Override
	public void deleteCustomFile(String name) throws CustomFileException {
		if(!isValidName(name)) {
			throw new CustomFileException("Invalid file name -> "+name);
		}else {
			dao.deleteCustomFile(name);
		}
		
	}

	
	public static boolean isValidName(String str) {
	    if (str == null) return false;
	        // In case you allow other special characters regex expressions can be changed accordingly
	    if (str.matches("[a-zA-Z0-9_]+")) return true;
	    return false;
	}
	public static boolean isValidFormat (String str) {
	    if (str == null) return false;
	        // In case we specify the particular formats we need,regex expressions can be changed accordingly
	    if (str.matches("[a-zA-Z]+")) return true;
	    return false;
	}
	public static boolean isValidSize(String str) {
	    if (str == null) return false;
	    if (str.matches("[0-9a-zA-Z]+")) return true;
	    return false;
	}
	public static boolean isValidDay(int str) {
	    if (str<1 || str>31) return false;
	    else return true;
	        
	}
	public static boolean isValidMonth(int str) {
	    if (str<1 || str>12) return false;
	       
	    else return true;
	}
	
	// We could initialise a static variable called present year & use it in our condition to make it omore generic
	public static boolean isValidYear(int str) {
	    if (str<1 || str>2020) return false;
	    else return true;   
	}

	@Override
	public CustomFile getCustomFileByName(String name) throws CustomFileException {
	
		if(!isValidName(name)) {
			throw new CustomFileException("Invalid filename -> "+name);
		}else {
			return dao.getCustomFileByName(name);
		}
	}


}
