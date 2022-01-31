package com.tencent.turingfd.sdk.base;

import android.util.Log;
import java.util.Locale;

public class er
{
  public static boolean a;
  public static boolean b;
  
  static
  {
    Log.d("TuringFdSDK", a());
  }
  
  public static String a()
  {
    return String.format(Locale.getDefault(), "TuringFD v%d (c%d, l%s, t%d, %s, %s, %d, compiled %s)", new Object[] { Integer.valueOf(32), Integer.valueOf(105678), "21916EDD69455490", Integer.valueOf(1), "baseFull", "taf", Integer.valueOf(1), "2019_10_29_16_12_45" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.er
 * JD-Core Version:    0.7.0.1
 */