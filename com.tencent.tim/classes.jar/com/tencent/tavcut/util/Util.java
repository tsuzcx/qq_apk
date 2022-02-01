package com.tencent.tavcut.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.tavcut.bean.Size;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Util
{
  public static Size constrainMaxSize(Size paramSize, int paramInt)
  {
    int i = paramSize.getWidth();
    int j = paramSize.getHeight();
    if (paramSize.getWidth() > paramSize.getHeight())
    {
      if (paramSize.getWidth() <= paramInt) {
        break label100;
      }
      j = (int)(paramInt / (paramSize.getWidth() * 1.0F / paramSize.getHeight()) + 0.5D);
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      return new Size(i, paramInt);
      if (paramSize.getHeight() > paramInt) {
        i = (int)(paramInt * (paramSize.getWidth() * 1.0F / paramSize.getHeight()) + 0.5D);
      } else {
        label100:
        paramInt = j;
      }
    }
  }
  
  public static Size constrainMinSize(Size paramSize, int paramInt)
  {
    int i = paramSize.getWidth();
    int j = paramSize.getHeight();
    if (paramSize.getWidth() < paramSize.getHeight())
    {
      if (paramSize.getWidth() >= paramInt) {
        break label100;
      }
      j = (int)(paramInt / (paramSize.getWidth() * 1.0F / paramSize.getHeight()) + 0.5D);
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      return new Size(i, paramInt);
      if (paramSize.getHeight() < paramInt) {
        i = (int)(paramInt * (paramSize.getWidth() * 1.0F / paramSize.getHeight()) + 0.5D);
      } else {
        label100:
        paramInt = j;
      }
    }
  }
  
  public static float dp2px(Context paramContext, float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static List<String> getDirFilePaths(String paramString1, String paramString2)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString1 = new File(paramString1).listFiles(new Util.1(paramString2));
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString1[i].getAbsolutePath());
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      Logger.e(paramString1);
    }
  }
  
  public static String md5(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        int k = paramString[i];
        if ((k & 0xFF) < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException("NoSuchAlgorithmException", paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UnsupportedEncodingException", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.Util
 * JD-Core Version:    0.7.0.1
 */