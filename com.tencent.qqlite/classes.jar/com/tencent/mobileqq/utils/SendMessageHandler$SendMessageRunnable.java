package com.tencent.mobileqq.utils;

public class SendMessageHandler$SendMessageRunnable
  implements Runnable
{
  public int a;
  public String a;
  public String[] a;
  public long c;
  public boolean c;
  public long d = 9223372036854775807L;
  public long e = 9223372036854775807L;
  public long f = -1L;
  public long g = -1L;
  public long h = -1L;
  
  public SendMessageHandler$SendMessageRunnable()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public void run() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("index:");
    localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Int));
    localStringBuilder.append(",reason:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",startTime:");
    localStringBuilder.append(String.valueOf(this.g - this.f));
    localStringBuilder.append(",timeOut:");
    localStringBuilder.append(String.valueOf(this.g - this.f + this.jdField_c_of_type_Long));
    if (this.jdField_c_of_type_Boolean)
    {
      localStringBuilder.append(",duration:");
      localStringBuilder.append(String.valueOf(this.h - this.g));
      localStringBuilder.append(",error:");
      localStringBuilder.append(String.valueOf(this.d));
      if (this.e != 9223372036854775807L)
      {
        localStringBuilder.append(",serverReply:");
        localStringBuilder.append(String.valueOf(this.e));
      }
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(",status:RUNNING");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable
 * JD-Core Version:    0.7.0.1
 */