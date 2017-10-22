/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HM2D
 */
public class HWone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
		
		Contact[] contacts = new Contact[1000];
		
		String firstline;
                int contactCounter = 0;
		 String fileName = "Contacts.txt";
		 String line = null;
		 String[] splited;
                 String[] splited2;
                
                /////FileReader
                	 
		try {

			 FileReader fileReader = new FileReader(fileName);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 firstline = bufferedReader.readLine();
			 String[] splitStrings = firstline.split(" ");
                         /////////Read From File
			 while((line = bufferedReader.readLine()) != null) {
                             splited = line.split(" ");
                             //System.out.println(splited[1]);
                             //splited2 = splited[0].split(" ");
                             //System.out.println(splited2[4]);
                             splited2 = line.split("\"");
                             //System.out.println(splited[3]);
                             if(splited[3] != null)
                             { if(splited2[1] != null)
                                 contacts[contactCounter++] = new Contact(splited[0] + " " + splited[1],splited[2],splited[3],splited2[1]); 
                             else     contacts[contactCounter++] = new Contact(splited[0] + " " + splited[1],splited[2],splited[3],""); 
                              
                             }else if(splited2[1] != null){
                                     contacts[contactCounter++] = new Contact(splited[0] + " " + splited[1],splited[2],"",splited2[1]); 
                              
                             }else     contacts[contactCounter++] = new Contact(splited[0] + " " + splited[1],splited[2],"",""); 
                             
			 
			 } 

			 bufferedReader.close(); 
			 }
			 catch(FileNotFoundException ex) {
			 System.out.println(
			 "Unable to open file '" + 
			 fileName + "'"); 
			 }
			 catch(IOException ex) {
			 System.out.println(
			 "Error reading file '" 
			 + fileName + "'"); 
			 // Or we could just do this: 
			 // ex.printStackTrace();
			 }
         
                  Scanner in = new Scanner(System.in);
      int theInput;
      while(true){
          
      System.out.println("____________________________________");
      System.out.println("1- Add");
      System.out.println("2- List");
      System.out.println("3- Search");
      System.out.println("4- Sort");
      System.out.println("5- Delete");
      System.out.println("6- Exit");
      System.out.print("Please Enter The Number Of Your Choice:");
      
      theInput = in.nextInt();
          System.out.println("____________________________________");
          System.out.println("____________________________________");
//wrong input
if(theInput > 6 || theInput <1){
    System.out.println("Wrong Input!");
continue;
}

//exit status
      if(theInput == 6){
             File file = new File("Contacts.txt");
                if (!file.exists()) {
				file.createNewFile();
			}
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
         
           String content="\n";
          for (int i = 0; i < contacts.length; i++) {
              if(contacts[i] != null)
              content += contacts[i].name + " " + contacts[i].number + " " + contacts[i].postalCode + " \"" + contacts[i].address+ "\"" +  "\n"; 
          }
         bw.write(content);
          //System.out.println(content);
          bw.close();
          return;
      
      }
      //ADD
      
      if(theInput == 1){
          
          clearConsole();
      String name;    
      String number;
      String postalCode;
      String address;
      System.out.print("Please Enter The Name Of The Recipent:");
          in.nextLine();
          
         name = in.nextLine();
         //in.nextLine();
          System.out.print("Plese Enter The Telephone Number Of The Recipent:");
          number = in.nextLine();
         //in.nextLine();
          System.out.print("Please Enter The Postal Code Of The Recipent:");
           postalCode = in.nextLine();
           System.out.print("Please Enter The Address Of The Recipent:");
           //in.nextLine();
           address = in.nextLine();
           
           
          contacts[contactCounter++] = new Contact(name,number,postalCode,address);
         
      
      /////must write in file
    
      
      
      }
      //List
      if(theInput == 2){
          System.out.println("List Of Contacts:");
          for (int i = 0; i < contacts.length; i++) {
              if(contacts[i] != null){
                  //System.out.println(contacts[i].postalCode);
              
              System.out.println(contacts[i].name + " " + contacts[i].number + " " +  contacts[i].postalCode + " \"" + contacts[i].address + "\"");   
          }}
      
      
      }
      //Search
      if(theInput == 3)
      {
          String name;
          System.out.print("Please Enter The Name Of The Recipent To Search:");
          in.nextLine();
          
         name = in.nextLine();
          //System.out.println(name);
          boolean found = false;
              for (int i = 0; i < contactCounter; i++) {
      //        System.out.println(contacts[i].name + " " + contacts[i].number);   
                if(contacts[i].name.contains(name)){
                found = true;
                    System.out.println("Contact Found:");
                  System.out.println(contacts[i].name + " " + contacts[i].number + contacts[i].postalCode + " " + contacts[i].address);   
          
                }
              
              }
              
              if(found == false){
                  System.out.println("The Contact Was Not Found");
              }
      
      }
      //Sort
      if(theInput == 4){
///          String a = "a";
   //       System.out.println((int)a.charAt(0));
            for(int i =65;i< 90;i++){
            for(int j=0;j<contacts.length;j++){
                if(contacts[j] != null){
                //System.out.println(contacts[j].name);
                    
                if((int)contacts[j].name.charAt(0) == i){
                
                    System.out.println(contacts[j].name + " " + contacts[j].number + contacts[j].postalCode + " " + contacts[j].address);   
          
                
                
                }
                
                if((int)contacts[j].name.charAt(0) == i+32){
                
                    System.out.println(contacts[j].name + " " + contacts[j].number + contacts[j].postalCode + " " + contacts[j].address);   
          
                }
                }
            
            }
            
            
            
            
            
            }
      
      
      }
      
      //delete
      if(theInput == 5){
          boolean found=false;
          String name;
          
          System.out.print("Please Enter The Name Of The Recipent To Delete:");
          in.nextLine();
          
         name = in.nextLine();
          for (int i = 0; i < contactCounter; i++) {
      //        System.out.println(contacts[i].name + " " + contacts[i].number);   
                if(contacts[i].name.contains(name)){
                found = true;
                contactCounter--;
                    System.out.println("Contact was Deleted");
                    for (int j = i; j < contacts.length-1; j++) {
                        contacts[j] = contacts[j+1];
                    }
                    break;
                    
                    
                    
                }
              
              }
              
             if(found == false){
                  System.out.println("The Contact Was Not Found");
              }
      
      }
      
      }
	}
    public final static void clearConsole()
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        //  Handle any exceptions.
    }
}
}
