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
  public int f;
  public int g;
  public String g;
  public int h = -1;
  public String h;
  public int i;
  
  public PicUploadInfo()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int a()
  {
    if (this.h != -1) {
      return this.h;
    }
    if (this.g != null)
    {
      if (GifDrawable.isGifFile(new File(this.g)))
      {
        this.h = 0;
        return this.h;
      }
    }
    else {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getProtocolType", "localPath == null");
    }
    if (this.i == 1) {}
    for (this.h = 1;; this.h = 0) {
      return this.h;
    }
  }
  
  String a()
  {
    int j = 65537;
    if (this.e == null)
    {
      Logger.b("PIC_TAG_ERROR", "PicUploadInfo.getUrlString", "protocol == null");
      return null;
    }
    if ("chatthumb".equals(this.e)) {}
    for (;;)
    {
      URL localURL = URLDrawableHelper.a(this, j, null);
      if (localURL == null) {
        break;
      }
      return localURL.toString();
      if ("chatimg".equals(this.e)) {
        j = 1;
      } else if ("chatraw".equals(this.e)) {
        j = 131075;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    if (!FileUtils.b(this.g))
    {
      a("checkPicInfo", "path invalid,localPath:" + this.g);
      return false;
    }
    if (((this.jdField_b_of_type_Int == 1000) || (this.jdField_b_of_type_Int == 1020) || (this.jdField_b_of_type_Int == 1004)) && (this.d == null))
    {
      a("checkPicInfo", "secondId invalid,uinType:" + this.jdField_b_of_type_Int + ",secondId:" + this.d);
      return false;
    }
    if (a() == -1)
    {
      a("PicBaseInfo.check", "protocolType invalid,protocolType:" + this.h);
      return false;
    }
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.g);
    localStringBuilder.append("\n |-").append("protocolType:").append(this.h);
    localStringBuilder.append("\n |-").append("md5:").append(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicUploadInfo
 * JD-Core Version:    0.7.0.1
 */