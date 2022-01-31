package com.tencent.mobileqq.utils;

import etk;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class FileSystemTool
{
  public static final int a = 1;
  public static FileInputStream a;
  public static FileOutputStream a;
  public static final String a = "file:///";
  private static Vector a;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 4;
  private static int e = 0;
  private static int f = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilVector = new Vector(4);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramString2 = a(paramString1, paramString2, paramBoolean);
      File localFile = new File(paramString2);
      if (!localFile.exists())
      {
        if ((paramString1 == null) || ("".equals(paramString1))) {
          localFile.mkdirs();
        }
      }
      else
      {
        if (paramInt != 1) {
          break label106;
        }
        jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(paramString2);
      }
      for (;;)
      {
        e += 1;
        paramString1 = new etk(e, paramString2, jdField_a_of_type_JavaIoFileInputStream, jdField_a_of_type_JavaIoFileOutputStream);
        jdField_a_of_type_JavaUtilVector.addElement(paramString1);
        return e;
        localFile.createNewFile();
        break;
        label106:
        if (paramInt == 2)
        {
          jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramString2);
        }
        else if (paramInt == 4)
        {
          jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(paramString2);
          jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramString2);
        }
      }
      return -1;
    }
    catch (Exception paramString1) {}
  }
  
  public static long a(int paramInt)
  {
    if (paramInt == -1) {
      return -1L;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        try
        {
          int j = localetk.jdField_a_of_type_JavaIoFileInputStream.available();
          return j;
        }
        catch (IOException localIOException) {}
      }
      i += 1;
    }
    return -1L;
  }
  
  public static DataInputStream a(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        return localetk.a();
      }
      i += 1;
    }
    return null;
  }
  
  public static DataOutputStream a(int paramInt)
  {
    return a(paramInt, 0L);
  }
  
  public static DataOutputStream a(int paramInt, long paramLong)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        return localetk.a(paramLong);
      }
      i += 1;
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        return localetk.b();
      }
      i += 1;
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = paramString2 + "/" + paramString1;
    paramString1 = paramString2;
    if (!paramString2.startsWith("file:///"))
    {
      paramString1 = paramString2;
      if (paramBoolean) {
        paramString1 = "file:///" + paramString2;
      }
    }
    return paramString1;
  }
  
  public static void a()
  {
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      ((etk)jdField_a_of_type_JavaUtilVector.elementAt(i)).a();
      jdField_a_of_type_JavaUtilVector.removeElementAt(i);
      i += 1;
    }
  }
  
  public static void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_JavaUtilVector.size())
      {
        etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
        if (localetk.a() == paramInt)
        {
          localetk.a();
          jdField_a_of_type_JavaUtilVector.removeElementAt(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_JavaUtilVector.size())
      {
        etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
        if (localetk.a() == paramInt) {}
        try
        {
          localetk.b();
          jdField_a_of_type_JavaUtilVector.removeElement(localetk);
          return true;
        }
        catch (Exception localException) {}
        i += 1;
      }
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilVector.size() >= 4) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilVector.size()) {
        break label51;
      }
      if (((etk)jdField_a_of_type_JavaUtilVector.elementAt(i)).a().equals(paramString)) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a(paramString1, paramString2, paramBoolean);
    if ((paramString1.length() == 0) && (paramString2.length() == 0)) {
      return false;
    }
    return a(str);
  }
  
  public static int b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramInt, paramBoolean);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        return localetk.c();
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_JavaUtilVector.size())
      {
        if (((etk)jdField_a_of_type_JavaUtilVector.elementAt(i)).a() == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static String c(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilVector.size())
    {
      etk localetk = (etk)jdField_a_of_type_JavaUtilVector.elementAt(i);
      if (localetk.a() == paramInt) {
        return localetk.a();
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileSystemTool
 * JD-Core Version:    0.7.0.1
 */