package com.tencent.mobileqq.service.profile;

import QQService.TagInfo;
import java.util.ArrayList;
import java.util.Calendar;

public class ProfileUtil
{
  public static final int a = 0;
  public static final int b = 1;
  
  public static int a(int paramInt)
  {
    int i = 0;
    if (paramInt > 0) {
      i = Calendar.getInstance().get(1) - ((0xFFFF0000 & paramInt) >> 16);
    }
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 << 16) + (paramInt2 << 8) + paramInt3;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    if (paramInt > 0) {
      localStringBuilder.append((0xFFFF0000 & paramInt) >> 16).append("-").append((0xFF00 & paramInt) >> 8).append("-").append(paramInt & 0xFF);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("0-0-0");
    }
  }
  
  public static String a(ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    int j;
    int k;
    label22:
    TagInfo localTagInfo;
    if (paramArrayList != null)
    {
      j = paramArrayList.size();
      k = 0;
      if (k >= j) {
        break label109;
      }
      localTagInfo = (TagInfo)paramArrayList.get(k);
      if ((localTagInfo == null) || (localTagInfo.strContent == null) || (localTagInfo.strContent.length() <= 0)) {
        break label106;
      }
      if (i == 0) {
        break label90;
      }
      localStringBuilder.append(localTagInfo.strContent);
      i = 0;
    }
    label90:
    label106:
    for (;;)
    {
      k += 1;
      break label22;
      j = 0;
      break;
      localStringBuilder.append("、").append(localTagInfo.strContent);
    }
    label109:
    return localStringBuilder.toString();
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (0xFFFF0000 & paramInt) >> 16;
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2, paramInt3);
    paramInt2 = localCalendar.getActualMaximum(5);
    if (paramInt3 >= localCalendar.getActualMinimum(5))
    {
      paramInt1 = paramInt3;
      if (paramInt3 <= paramInt2) {}
    }
    else
    {
      paramInt1 = localCalendar.get(5);
    }
    return paramInt1;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 1) {
      return "IT";
    }
    return "";
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (0xFF00 & paramInt) >> 8;
  }
  
  public static int d(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramInt & 0xFF;
  }
  
  public static int e(int paramInt)
  {
    return 2130838084;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.ProfileUtil
 * JD-Core Version:    0.7.0.1
 */