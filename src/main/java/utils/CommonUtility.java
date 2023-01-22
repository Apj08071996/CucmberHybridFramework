package utils;

import java.util.Date;

public class CommonUtility
{
  public static String generateEmailWithTimeStamp()
   {
	   Date date=new Date();
	   
	 
	   return "ajinkya"+date.toString().replace(" ","_").replaceAll(":","_")+"@gmail.com";
	   
	  
   }
}
