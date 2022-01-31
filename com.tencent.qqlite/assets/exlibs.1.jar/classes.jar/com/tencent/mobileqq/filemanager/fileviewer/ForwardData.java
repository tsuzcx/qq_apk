package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;

public class ForwardData
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ForwardData a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("srcDiscGroup");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("peerType", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("rootEntrace", true);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("busiType", 0);
    this.c = paramIntent.getIntExtra("enterfrom", 0);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ForwardData
 * JD-Core Version:    0.7.0.1
 */