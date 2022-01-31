package com.tencent.biz.common.download;

public class DownloadInfo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  
  public DownloadInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String toString()
  {
    return "DownloadInfo [threadId=" + this.jdField_a_of_type_Int + ", startPos=" + this.b + ", endPos=" + this.c + ", compeleteSize=" + this.d + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.download.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */