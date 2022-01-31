package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;

public class ShortVideoDownloadInfo
  extends ShortVideoBaseInfo
{
  public static final int i = 0;
  public static final int j = -1;
  public static final int k = -2;
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String g;
  public int h;
  public String h;
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.a))
    {
      a("ShortVideoDownloadInfo.check", "uuid invaid:" + this.a);
      return false;
    }
    if (this.b == null)
    {
      a("ShortVideoDownloadInfo", "selfUin invalid,selfUin:" + this.b);
      return false;
    }
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoDownloadInfo");
    localStringBuilder.append("\n |-").append("md5:").append(this.e);
    localStringBuilder.append("\n |-").append("uuid:").append(this.a);
    localStringBuilder.append("\n |-").append("fileType:").append(this.g);
    localStringBuilder.append("\n |-").append("format:").append(this.d);
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
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo
 * JD-Core Version:    0.7.0.1
 */