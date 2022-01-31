package com.tencent.mobileqq.shortvideo;

public class ShortVideoUploadInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoUploadInfo.RetryInfo a;
  public Object a;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String g;
  public String h;
  public String i;
  
  public boolean a()
  {
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.g);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.h);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.c);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.d);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.f);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.i);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo
 * JD-Core Version:    0.7.0.1
 */