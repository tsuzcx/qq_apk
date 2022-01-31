package com.tencent.mobileqq.activity.photo;

import java.net.URL;

public class LocalPhotoInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public long a;
  public String a;
  public long b;
  public long c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public static LocalPhotoInfo a(URL paramURL)
  {
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      LocalPhotoInfo localLocalPhotoInfo = new LocalPhotoInfo();
      localLocalPhotoInfo.a = paramURL[0];
      localLocalPhotoInfo.f = Integer.parseInt(paramURL[1]);
      localLocalPhotoInfo.g = Integer.parseInt(paramURL[2]);
      localLocalPhotoInfo.b = Long.parseLong(paramURL[3]);
      if (paramURL.length > 6) {
        localLocalPhotoInfo.h = Integer.parseInt(paramURL[6]);
      }
      return localLocalPhotoInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public static String a(LocalPhotoInfo paramLocalPhotoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocalPhotoInfo.a);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalPhotoInfo.f);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalPhotoInfo.g);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalPhotoInfo.b);
    localStringBuilder.append("|");
    localStringBuilder.append(0);
    localStringBuilder.append("|");
    localStringBuilder.append("201403010");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalPhotoInfo
 * JD-Core Version:    0.7.0.1
 */