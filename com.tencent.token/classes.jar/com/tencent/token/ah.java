package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.j;

public final class ah
{
  private long a;
  private int b;
  private String c;
  
  public ah(long paramLong, int paramInt, String paramString)
  {
    this.a = paramLong;
    this.b = paramInt;
    if (TextUtils.isEmpty(paramString))
    {
      this.c = "";
      return;
    }
    this.c = j.b(paramString);
  }
  
  public final String a()
  {
    return this.a + "," + this.b + "," + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ah
 * JD-Core Version:    0.7.0.1
 */