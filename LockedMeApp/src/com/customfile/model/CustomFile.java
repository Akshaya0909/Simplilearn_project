package com.customfile.model;

import java.util.Comparator;

import com.customfile.exception.CustomFileException;

public class CustomFile {
	private String file_name;
	private String format;
	private int day_of_creation;
	private int month_of_creation;
	private int year_of_creation;
	private String size;
	

	public String getFile_name() {
		return file_name;
	}
	

	public void setFile_name(String file_name) {
		
		this.file_name = file_name;
	
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	
	@Override
	public String toString() {
		return "CustomFile [file_name=" + file_name + ", format=" + format + ", day_of_creation=" + day_of_creation
				+ ", month_of_creation=" + month_of_creation + ", year_of_creation=" + year_of_creation + ", size="
				+ size + "]";
	}


	public int getDay_of_creation() {
		return day_of_creation;
	}


	public void setDay_of_creation(int day_of_creation) {
		this.day_of_creation = day_of_creation;
	}


	public int getMonth_of_creation() {
		return month_of_creation;
	}

	public void setMonth_of_creation(int month_of_creation) {
		this.month_of_creation = month_of_creation;
	}

	public int getYear_of_creation() {
		return year_of_creation;
	}

	public void setYear_of_creation(int year_of_creation) {
		this.year_of_creation = year_of_creation;
	}


	public static Comparator<CustomFile> FileNameComparator = new Comparator<CustomFile>() {

		public int compare(CustomFile s1, CustomFile s2) {
		   String FileName1 = s1.getFile_name().toUpperCase();
		   String FileName2 = s2.getFile_name().toUpperCase();

		   //ascending order
		   return FileName1.compareTo(FileName2);

		   //descending order
		   //return FileName2.compareTo(FileName1);
	    }};


	
}
