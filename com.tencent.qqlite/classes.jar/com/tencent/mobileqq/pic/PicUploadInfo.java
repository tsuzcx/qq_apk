package com.tencent.mobileqq.pic;

import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.net.URL;

public class PicUploadInfo
  extends PicBaseInfo
{
  public PicUploadInfo.RetryInfo a;
  public long b;
  public boolean b;
  public long c;
  public int f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j = 0;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public PicUploadInfo()
  {
    this.jdField_h_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int a()
  {
    if (this.jdField_h_of_type_Int != -1) {
      return this.jdField_h_of_type_Int;
    }
    if (this.jdField_g_of_type_JavaLangString != null)
    {
      if (GifDrawable.isGifFile(new File(this.jdField_g_of_type_JavaLangString)))
      {
        this.jdField_h_of_type_Int = 0;
        return this.jdField_h_of_type_Int;
      }
    }
    else {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.i == 2) {}
    for (this.jdField_h_of_type_Int = 1;; this.jdField_h_of_type_Int = 0) {
      return this.jdField_h_of_type_Int;
    }
  }
  
  String a()
  {
    int i1 = 65537;
    if (this.e == null)
    {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    if ("chatthumb".equals(this.e)) {}
    for (;;)
    {
      URL localURL = URLDrawableHelper.a(this, i1, null);
      if (localURL == null) {
        break;
      }
      return localURL.toString();
      if ("chatimg".equals(this.e)) {
        i1 = 1;
      } else if ("chatraw".equals(this.e)) {
        i1 = 131075;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    if (!FileUtils.b(this.jdField_g_of_type_JavaLangString))
    {
      a("checkPicInfo", "path invalid,localPath:" + this.jdField_g_of_type_JavaLangString);
      return false;
    }
    if (((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1020) || (this.jdField_b_of_type_Int == 1004)) && (this.d == null))
    {
      a("checkPicInfo", "secondId invalid,uinType:" + this.jdField_b_of_type_Int + ",secondId:" + this.d);
      return false;
    }
    if (a() == -1)
    {
      a("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.jdField_h_of_type_Int);
      return false;
    }
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("protocolType:").append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.i);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n |-").append("source_image_width:").append(this.k);
    localStringBuilder.append("\n |-").append("source_image_height:").append(this.l);
    localStringBuilder.append("\n |-").append("source_image_filesize:").append(this.c);
    localStringBuilder.append("\n |-").append("source_image_filesizeflag:").append(this.m);
    localStringBuilder.append("\n |-").append("source_image_type:").append(this.n);
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
 * Qualified Name:     com.tencent.mobileqq.pic.PicUploadInfo
 * JD-Core Version:    0.7.0.1
 */