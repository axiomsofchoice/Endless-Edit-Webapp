package com.np_compete.endless_edit;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static String now()
    {
         return "Generated timestamp: " + new Date().toString() ;  
    }

}
