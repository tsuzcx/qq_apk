package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;

public class a
{
  private static final byte[] d = { 6, 98, -78, 83, 38, 11, 101, -14, 22, 96 };
  private String a;
  private long b;
  private boolean c;
  
  public a(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = QmspSDK.getContext().getSharedPreferences(b.a + a(d), 0);
    this.c = true;
    try
    {
      long l3 = ((SharedPreferences)localObject).getLong(this.a, 0L);
      l1 = System.currentTimeMillis();
      long l2 = l1 - l3;
      if (l3 != 0L)
      {
        l3 = this.b;
        if ((l2 >= l3) || (l2 <= 0L)) {}
      }
    }
    catch (Exception localException1)
    {
      long l1;
      bool = false;
    }
    try
    {
      this.c = false;
      return true;
    }
    catch (Exception localException2)
    {
      break label137;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(this.a, l1);
    ((SharedPreferences.Editor)localObject).commit();
    return false;
    label137:
    localException1.printStackTrace();
    return bool;
  }
  
  private void b()
  {
    if (!this.c) {
      return;
    }
    Object localObject = QmspSDK.getContext().getSharedPreferences(b.a + a(d), 0);
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.a);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  public void a(a parama)
  {
    if (parama != null)
    {
      if (a()) {
        break label22;
      }
      parama.run();
    }
    for (;;)
    {
      b();
      return;
      label22:
      parama.a();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */