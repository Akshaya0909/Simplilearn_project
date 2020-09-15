package com.customfile.dao.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.customfile.dao.CustomFileDAO;
import com.customfile.exception.CustomFileException;
import com.customfile.model.CustomFile;

public class CustomFileDAOImplementation implements CustomFileDAO {
	private static Map<String,CustomFile> customfilemap = new HashMap<String,CustomFile>();

	@Override
	public CustomFile createCustomFile(CustomFile customfile, String name) throws CustomFileException {
		customfile.setFile_name(name);
		customfilemap.put(customfile.getFile_name(), customfile);
		return customfile;
	}

	@Override
	public void deleteCustomFile(String name) throws CustomFileException {
		if (customfilemap.containsKey(name)) {
			customfilemap.remove(name);
		}else {
			throw new CustomFileException("Entered name " + name + " doesnt exist");
		}


	}

	@Override
	public CustomFile getCustomFileByName(String name) throws CustomFileException {
		if (customfilemap.containsKey(name)) {
			return customfilemap.get(name);
		} else {
			throw new CustomFileException("Entered name " + name + " doesnt exist");
		}

	}


	

	@Override
	public List<CustomFile> getAllCustomFilesByFormat(String format) throws CustomFileException {
		List<CustomFile> customfileList = customfilemap.values().stream().filter(s -> s.getFormat() == format)
				.collect(Collectors.toList());
		if(customfileList.size()==0) {
			throw new CustomFileException("No file found with the given format "+format);
		}
		return customfileList;
	}

	@Override
	public List<CustomFile> getAllCustomFilesByName() throws CustomFileException {
		if (customfilemap.size() == 0) {
			throw new CustomFileException("No files as of now.. Please create one");
		}
		List<CustomFile> filelist = new ArrayList<CustomFile>(customfilemap.values());
		Collections.sort(filelist,CustomFile.FileNameComparator);

		   //for(Student str: arraylist){
				//System.out.println(str);
		return filelist;
		
	}
	
	
}
