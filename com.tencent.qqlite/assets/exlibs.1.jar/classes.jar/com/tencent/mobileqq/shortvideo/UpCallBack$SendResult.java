package com.tencent.mobileqq.shortvideo;

public class UpCallBack$SendResult
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSendResult");
    localStringBuilder.append("\n |-").append("result:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("errCode:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-").append("errStr:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("path:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("size:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-").append("uuid:").append(this.c);
    localStringBuilder.append("\n |-").append("md5:").append(this.d);
    localStringBuilder.append("\n |-").append("groupFileID:").append(this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.UpCallBack.SendResult
 * JD-Core Version:    0.7.0.1
 */