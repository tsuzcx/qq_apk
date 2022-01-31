package com.tencent.mobileqq.utils;

public class SendMessageHandler$SendMessageRunnable
  implements Runnable
{
  public int a;
  public String a;
  public String[] a;
  public boolean c = false;
  public long e = -1L;
  public long f = 9223372036854775807L;
  public long g = 9223372036854775807L;
  public long h = -1L;
  public long i = -1L;
  public long j = -1L;
  
  public SendMessageHandler$SendMessageRunnable()
  {
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
    localStringBuilder.append(String.valueOf(this.i - this.h));
    localStringBuilder.append(",timeOut:");
    localStringBuilder.append(String.valueOf(this.i - this.h + this.e));
    if (this.c)
    {
      localStringBuilder.append(",duration:");
      localStringBuilder.append(String.valueOf(this.j - this.i));
      localStringBuilder.append(",error:");
      localStringBuilder.append(String.valueOf(this.f));
      if (this.g != 9223372036854775807L)
      {
        localStringBuilder.append(",serverReply:");
        localStringBuilder.append(String.valueOf(this.g));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable
 * JD-Core Version:    0.7.0.1
 */