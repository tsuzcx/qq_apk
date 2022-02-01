package com.tencent.qmsp.sdk.base;

import android.text.TextUtils;

public enum d
{
  private String a;
  
  private d(int paramInt, String paramString)
  {
    this.a = paramString;
  }
  
  public static d a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = b;
      return localObject;
    }
    d[] arrayOfd = values();
    int i2 = arrayOfd.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label57;
      }
      d locald = arrayOfd[i1];
      localObject = locald;
      if (locald.a.equalsIgnoreCase(paramString)) {
        break;
      }
      i1 += 1;
    }
    label57:
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.d
 * JD-Core Version:    0.7.0.1
 */