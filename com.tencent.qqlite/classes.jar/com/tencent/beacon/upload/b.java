package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.e;

public final class b
  extends a
{
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, 0, 100);
  }
  
  public final com.tencent.beacon.c.a.b a()
  {
    Object localObject = e.m();
    byte[] arrayOfByte = "".getBytes();
    try
    {
      localObject = com.tencent.beacon.b.a.a(c(), (e)localObject, arrayOfByte, -1, -1);
      if (localObject != null) {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      com.tencent.beacon.d.a.d("encode2RequestPackage failed", new Object[0]);
    }
    return null;
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.b
 * JD-Core Version:    0.7.0.1
 */