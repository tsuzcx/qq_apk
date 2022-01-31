package com.tencent.mobileqq.activity.photo;

import java.net.URL;

public class LocalMediaInfo
{
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public long d;
  public long e;
  public int f;
  public int g;
  public int h;
  
  public static LocalMediaInfo a(URL paramURL)
  {
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.a = paramURL[0];
      localLocalMediaInfo.f = Integer.parseInt(paramURL[1]);
      localLocalMediaInfo.g = Integer.parseInt(paramURL[2]);
      localLocalMediaInfo.d = Long.parseLong(paramURL[3]);
      if (paramURL.length > 6) {
        localLocalMediaInfo.h = Integer.parseInt(paramURL[6]);
      }
      return localLocalMediaInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public static String a(LocalMediaInfo paramLocalMediaInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocalMediaInfo.a);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.f);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.g);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.d);
    localStringBuilder.append("|");
    localStringBuilder.append(0);
    localStringBuilder.append("|");
    localStringBuilder.append("201403010");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.LocalMediaInfo
 * JD-Core Version:    0.7.0.1
 */