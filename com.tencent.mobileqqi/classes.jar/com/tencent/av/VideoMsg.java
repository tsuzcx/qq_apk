package com.tencent.av;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VideoMsg
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int f = 1000;
  public static final int g = 1001;
  public static final int h = 1002;
  public static final int i = 1003;
  public static final int j = 1004;
  public static final int k = 1005;
  public static final int l = 2000;
  public static final int m = 2001;
  public static final int n = 2002;
  public static final int o = 2003;
  public static final int p = 2004;
  public static final int q = 2005;
  public long a;
  public HttpMsg a;
  private File a;
  public InputStream a;
  public OutputStream a;
  protected String a;
  public byte[] a;
  public long b;
  protected String b;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public int r;
  public int s;
  
  public VideoMsg(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    try
    {
      this.g = paramString1;
      this.jdField_d_of_type_Int = paramInt;
      if (paramInt == 0)
      {
        this.jdField_d_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_d_of_type_JavaLangString);
        if ((this.jdField_a_of_type_JavaIoFile.exists()) && (paramInt == 0))
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
          this.c = paramString2.substring(paramString2.lastIndexOf(".")).toLowerCase();
        }
        this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString2);
        return;
      }
      this.jdField_e_of_type_JavaLangString = paramString2;
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public InputStream a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_d_of_type_JavaLangString);
      return this.jdField_a_of_type_JavaIoInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
      }
    }
  }
  
  public OutputStream a()
  {
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString);
      label22:
      return this.jdField_a_of_type_JavaIoOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label22;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_d_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString);
      }
      return;
    }
    catch (FileNotFoundException paramString) {}
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.VideoMsg
 * JD-Core Version:    0.7.0.1
 */