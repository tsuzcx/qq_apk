package com.tencent.open.appcommon.js;

import java.util.ArrayList;
import java.util.HashMap;

public class AsyncMethodMap
{
  public static ArrayList a;
  public static HashMap a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilArrayList.add("getQueryDownloadAction");
    jdField_a_of_type_JavaUtilArrayList.add("checkUpdate");
    jdField_a_of_type_JavaUtilArrayList.add("picUpload");
    jdField_a_of_type_JavaUtilArrayList.add("gSetPackageScanSetting");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "javascript:QzoneApp.fire('interface." + paramString1 + "',{'guid':'" + paramString2 + "','r':'" + paramString3 + "','data':'" + paramString4 + "'});void(0);";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AsyncMethodMap
 * JD-Core Version:    0.7.0.1
 */