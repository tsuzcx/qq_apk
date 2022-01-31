package com.tencent.mobileqq.config;

import android.content.Context;
import android.os.Bundle;

public abstract class ConfigDialog
{
  public static int a;
  public static String a;
  public static int b;
  public static String b;
  public Bundle a;
  protected CommandListener a;
  public String c;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TITLE";
    jdField_b_of_type_JavaLangString = "CONTENT";
    jdField_a_of_type_Int = 10001;
    jdField_b_of_type_Int = 10002;
  }
  
  public ConfigDialog(Context paramContext) {}
  
  public abstract Bundle a();
  
  public abstract String a();
  
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigDialog
 * JD-Core Version:    0.7.0.1
 */