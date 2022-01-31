package com.tencent.mobileqq.pic;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CircleCounter
{
  public static long a(int paramInt)
  {
    long l = 0L;
    if (paramInt == 0)
    {
      l = PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559172), 0L) + 1L;
      PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559173), l);
    }
    while (paramInt != 1) {
      return l;
    }
    l = PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559172), 0L) + 1L;
    PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559173), l);
    return l;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = "";
    String str2 = "";
    String str3;
    if (paramInt1 == 0)
    {
      str3 = "WIFI";
      if (paramInt2 != 3) {
        break label74;
      }
      str1 = "C2C";
      label23:
      if (paramInt3 != 0) {
        break label124;
      }
      str2 = BaseApplicationImpl.getContext().getString(2131559177);
    }
    for (;;)
    {
      return str3 + "_" + str1 + str2;
      str3 = "XG";
      break;
      label74:
      if (paramInt2 == 2)
      {
        str1 = BaseApplicationImpl.getContext().getString(2131559174);
        break label23;
      }
      if (paramInt2 == 0)
      {
        str1 = BaseApplicationImpl.getContext().getString(2131559175);
        break label23;
      }
      if (paramInt2 != 1) {
        break label23;
      }
      str1 = BaseApplicationImpl.getContext().getString(2131559176);
      break label23;
      label124:
      if (paramInt3 == 1) {
        str2 = BaseApplicationImpl.getContext().getString(2131559178);
      }
    }
  }
  
  public static ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    label37:
    String str1;
    while (i < 2)
    {
      int j = 0;
      while (j < 4) {
        if (j == 1)
        {
          j += 1;
        }
        else
        {
          int k = 0;
          if (k < 2)
          {
            str1 = a(i, j, k);
            l1 = PicPreDownloadUtils.a(str1, 0L);
            localArrayList.add("2_" + str1 + ":" + l1);
            if (k == 1)
            {
              l2 = PicPreDownloadUtils.a(a(i, j, 0), 0L);
              if (l1 + l2 <= 0L) {
                break label199;
              }
            }
          }
          label199:
          for (f = (float)l1 / (float)(l1 + l2);; f = 0.0F)
          {
            str1 = new DecimalFormat("##%").format(f);
            String str2 = a(i, j, -1);
            localArrayList.add("1_" + str2 + "菊花比：" + str1);
            k += 1;
            break label37;
            break;
          }
        }
      }
      i += 1;
    }
    long l1 = PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559172), 0L);
    long l2 = PicPreDownloadUtils.a(BaseApplicationImpl.getContext().getString(2131559173), 0L);
    if (l1 + l2 > 0L) {}
    for (float f = (float)l2 / (float)(l1 + l2);; f = 0.0F)
    {
      str1 = new DecimalFormat("##%").format(f);
      localArrayList.add("0_总菊花比：" + str1);
      return localArrayList;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = a(paramInt1, paramInt2, paramInt3);
    PicPreDownloadUtils.a(str, PicPreDownloadUtils.a(str, 0L) + 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CircleCounter
 * JD-Core Version:    0.7.0.1
 */