package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;

public class c
{
  public static boolean a()
  {
    String str = Build.MANUFACTURER;
    if (!TextUtils.isEmpty(str)) {
      return "xiaomi".equals(str.trim().toLowerCase());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.c
 * JD-Core Version:    0.7.0.1
 */