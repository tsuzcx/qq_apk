package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.ptt.PttBuffer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StreamFileInfo
{
  public static final int a = 0;
  public static final int b = 1;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private short jdField_a_of_type_Short = 0;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  private short b = 0;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private short jdField_c_of_type_Short = 1;
  private int d;
  
  public StreamFileInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    PttBuffer.a(paramString);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public File a()
  {
    return new File(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Short = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(short paramShort)
  {
    this.b = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PttBuffer.b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    PttBuffer.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    PttBuffer.a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public short b()
  {
    return this.jdField_c_of_type_Short;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamFileInfo
 * JD-Core Version:    0.7.0.1
 */