package com.tencent.token;

import android.os.Build.VERSION;
import android.view.Gravity;

public final class fb
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Gravity.getAbsoluteGravity(paramInt1, paramInt2);
    }
    return paramInt1 & 0xFF7FFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fb
 * JD-Core Version:    0.7.0.1
 */