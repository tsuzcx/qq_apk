package com.tencent.mobileqq.streamtransfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamFileInfo
{
  public static final int a = 0;
  public static final int b = 1;
  private long jdField_a_of_type_Long;
  private File jdField_a_of_type_JavaIoFile = null;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream = null;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private short jdField_a_of_type_Short = 0;
  boolean jdField_a_of_type_Boolean = false;
  private short b = 0;
  private int jdField_c_of_type_Int;
  private short jdField_c_of_type_Short = 1;
  private int d;
  
  public StreamFileInfo(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaIoFile = new File(paramString);
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
    }
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (FileNotFoundException paramString)
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      paramString.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public File a()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public FileOutputStream a()
  {
    return this.jdField_a_of_type_JavaIoFileOutputStream;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public short a()
  {
    return this.b;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(short paramShort)
  {
    this.b = paramShort;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public short b()
  {
    return this.jdField_c_of_type_Short;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Short = 0;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(short paramShort)
  {
    this.jdField_c_of_type_Short = paramShort;
  }
  
  public short c()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void c(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamFileInfo
 * JD-Core Version:    0.7.0.1
 */