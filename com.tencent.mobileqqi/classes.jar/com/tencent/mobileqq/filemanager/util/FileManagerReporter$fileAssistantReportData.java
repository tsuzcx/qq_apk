package com.tencent.mobileqq.filemanager.util;

import com.tencent.qphone.base.util.QLog;

public class FileManagerReporter$fileAssistantReportData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public String c;
  private String d = "share_file";
  private String e;
  
  public FileManagerReporter$fileAssistantReportData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public FileManagerReporter$fileAssistantReportData(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.e = FileManagerUtil.a(paramLong1);
    this.c = paramString3;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public static fileAssistantReportData a(String paramString, int paramInt)
  {
    boolean bool = true;
    fileAssistantReportData localfileAssistantReportData = new fileAssistantReportData();
    try
    {
      String[] arrayOfString = paramString.split("/");
      localfileAssistantReportData.d = arrayOfString[0];
      localfileAssistantReportData.jdField_a_of_type_JavaLangString = arrayOfString[1];
      localfileAssistantReportData.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[2]);
      localfileAssistantReportData.jdField_b_of_type_JavaLangString = arrayOfString[3];
      localfileAssistantReportData.e = arrayOfString[4];
      localfileAssistantReportData.c = arrayOfString[5];
      localfileAssistantReportData.jdField_b_of_type_Long = Long.parseLong(arrayOfString[6]);
      if (Integer.parseInt(arrayOfString[7]) == 0) {}
      for (;;)
      {
        localfileAssistantReportData.jdField_a_of_type_Boolean = bool;
        localfileAssistantReportData.jdField_b_of_type_Int = paramInt;
        return localfileAssistantReportData;
        bool = false;
      }
      return null;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("<FileAssistant>FileManagerReporter", 2, "loadAssistantReportData error[" + paramString + "]");
      }
    }
  }
  
  public String a()
  {
    this.e = FileManagerUtil.a(this.jdField_a_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.d));
    localStringBuilder.append("/");
    localStringBuilder.append(a(this.jdField_a_of_type_JavaLangString));
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("/");
    localStringBuilder.append(a(this.jdField_b_of_type_JavaLangString));
    localStringBuilder.append("/");
    localStringBuilder.append(a(this.e));
    localStringBuilder.append("/");
    localStringBuilder.append(a(this.c));
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("/");
    if (this.jdField_a_of_type_Boolean) {
      localStringBuilder.append(0);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(1);
    }
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData
 * JD-Core Version:    0.7.0.1
 */