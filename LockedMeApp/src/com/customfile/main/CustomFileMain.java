package com.customfile.main;


import java.util.List;
import java.util.Scanner;

import com.customfile.exception.CustomFileException;
import com.customfile.model.CustomFile;
import com.customfile.service.CustomFileService;
import com.customfile.service.implementation.CustomFileServiceImplementation;

public class CustomFileMain {
	public static void main(String[] args) {
		System.out.println("Welcome to LockedMe App V1.0");
		System.out.println("Developed by Akshaya R");
		System.out.println("------------------------------------");
		int ch=0;
		Scanner scanner = new Scanner(System.in);
		CustomFileService service = new CustomFileServiceImplementation();
		do {
			
			System.out.println("\nLockedMe File Operations Menu");
			System.out.println("===================");
			System.out.println("\n1)List All Files in Ascending order");
			System.out.println("===================");
			System.out.println("\nBusiness Level Operations");
			System.out.println("\n2)Create a new file & add it to the directory");
			System.out.println("\n3)Delete a file");
			System.out.println("\n4)Search file By Name");
			System.out.println("\n5)List files of a specified format");
			System.out.println("\n6)Return to Main Menu");
			System.out.println("\n7)EXITTTTTT");
			System.out.println("Please Enter your appropriate choice(1-7)");
			
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			switch(ch) {
			case 1:
				try {
					List<CustomFile> customfileList=service.getAllCustomFilesByName();
					
					if(customfileList!=null && customfileList.size()>0) {
						System.out.println("Printing filenames in ascending order :\n");
						for(CustomFile str: customfileList){
							System.out.println(str);
						}
						System.out.println("Total number of files : "+customfileList.size());
					}
					else {
						System.out.println("No files to display. Please create one.");
						}
					}
					
					catch (CustomFileException e1) {
					System.out.println(e1.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Enter file details mentioned Below.....");
				CustomFile sh=new CustomFile();
				System.out.println("Enter file Name");
				String nameee = scanner.nextLine();
				sh.setFile_name(nameee);
				System.out.println("Enter format");
				sh.setFormat(scanner.nextLine());
				System.out.println("Enter size of the file");
				sh.setSize(scanner.nextLine());
				System.out.println("Enter day of creation of file");
				sh.setDay_of_creation(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter month of creation of file(in numbers)");
				sh.setMonth_of_creation(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter year of creation of file");
				sh.setYear_of_creation(Integer.parseInt(scanner.nextLine()));
				
				try {
					sh = service.createCustomFile(sh,nameee);
					System.out.println("The following file has been added : \n");
					System.out.println(sh);
				} catch (CustomFileException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Please Enter file name to be deleted");
			    String namee = scanner.nextLine();
			    try {
					service.deleteCustomFile(namee);
					System.out.println("File "+namee+" deleted successfully!!");
				} catch (CustomFileException e) {
					
					System.out.println(e.getMessage());
				}
			    break;
			    
			case 4:
				System.out.println("Please enter file name for particular file's details");
				String choice=scanner.nextLine();
				try {
					CustomFile customFileByName = service.getCustomFileByName(choice);
					System.out.println("Printing file details : ");
					System.out.println(customFileByName);
				} catch (CustomFileException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 5:
				System.out.println("Please enter format to retrive all customfiles of that format");
				String forchoice = scanner.nextLine();
				try {
					List<CustomFile> allCustomFilesByFormat = service.getAllCustomFilesByFormat(forchoice);
					if(allCustomFilesByFormat!=null && allCustomFilesByFormat.size()>0) {
						System.out.println("Printing filenames having format  : "+ forchoice);
						for(CustomFile str: allCustomFilesByFormat){
							System.out.println(str);
						}
						System.out.println("Total number of files of given format : "+allCustomFilesByFormat.size());
					}
					else {
						System.out.println("No files to display. Please create one.");
						}
			
						
					}
						
				catch (CustomFileException e) {
					System.out.println(e.getMessage());
				}
				break;
				
				
			case 6:
				System.out.println("Returning to main menu.....");
				break;
				
			case 7: System.out.println("Thanks for using our LockedMe APP V1.0.. Always striving to make file access easier for you.....");
			break;
			
			default:
			System.out.println("Entered choice is invalid. Please enter choice numbers between 1-7 only");
			break;

			
			}
				
		
	}while(ch!=7);

}
 }
