package com.tencent.superplayer.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

public class HashBucketUtils
{
  private static final int BUCKET_MAX_COUNT = 100;
  private static final int TAB_GUID_MAX_LEN = 28;
  private static final int TAB_HASH_MASK = 2147483647;
  
  private int aldHash(String paramString1, String paramString2)
  {
    l = 0L;
    try
    {
      paramString1 = paramString1 + '-' + paramString2;
      paramString1 = MessageDigest.getInstance("MD5").digest(paramString1.getBytes("UTF-8"));
      paramString1[7] = ((byte)(paramString1[7] & 0xFFFFFFF0));
      int i = 0;
      while (i < 8)
      {
        int j = paramString1[i];
        l = l << 8 | j & 0xFF;
        i += 1;
      }
      l >>>= 4;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        l = 0L;
        paramString1.printStackTrace();
      }
    }
    return (int)(l % 100L);
  }
  
  public static int getBucket(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return 0;
    }
    return (int)(tabHash(paramString.substring(0, 28), paramInt) % 100L + 1L);
  }
  
  private static long getValue(long paramLong, int paramInt, char paramChar)
  {
    if ((paramInt & 0x1) == 0) {
      return paramLong << 7 ^ paramChar ^ paramLong >>> 3 ^ paramLong;
    }
    return paramLong << 11 ^ paramChar ^ paramLong >>> 5 ^ 0xFFFFFFFF ^ paramLong;
  }
  
  public static long tabHash(String paramString, int paramInt)
  {
    int i = 0;
    long l1 = 0L;
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    while (j < paramString.length())
    {
      long l2 = paramInt;
      int k = j + 1;
      l2 = l1 * l2 + arrayOfChar[j];
      l1 = l2;
      if (k < paramString.length()) {
        l1 = getValue(l2, i, arrayOfChar[k]);
      }
      j = k + 1;
      i += 1;
    }
    return 0x7FFFFFFF & l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.HashBucketUtils
 * JD-Core Version:    0.7.0.1
 */