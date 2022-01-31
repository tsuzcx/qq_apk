package com.tencent.mobileqq.emoticon;

import java.io.File;

public class DownloadInfo
{
  public final int a;
  public final File a;
  public final String a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b;
  public int c = -1;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public DownloadInfo(String paramString, File paramFile, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + ".tmp";
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.e = "";
    this.jdField_a_of_type_ArrayOfByte = null;
    this.c = -1;
    this.jdField_d_of_type_Int = 0;
    this.h = null;
    this.i = null;
    this.g = null;
  }
  
  public void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (paramProgressHandler == null) {
      return;
    }
    paramProgressHandler.a("param_ipUrl", Boolean.toString(this.jdField_a_of_type_Boolean));
    if (this.jdField_b_of_type_Int == 13) {
      this.e = ("url:" + this.jdField_b_of_type_JavaLangString + ",detail:" + this.e);
    }
    paramProgressHandler.a("param_error", this.e);
    if (this.c != -1) {
      paramProgressHandler.a("param_respcode", this.c);
    }
    paramProgressHandler.a("param_resp_content_read", this.g);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.h != null)
    {
      localObject1 = localObject2;
      if (this.h.length() > 0) {
        localObject1 = this.h;
      }
    }
    if ((this.i != null) && (this.i.length() > 0)) {
      localObject2 = (String)localObject1 + "#" + this.i;
    }
    for (;;)
    {
      paramProgressHandler.a("param_resp_content", (String)localObject2);
      return;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {
          localObject2 = (String)localObject1 + "#null";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */