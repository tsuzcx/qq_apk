package com.tencent.tencentmap.mapsdk.map;

import android.graphics.BitmapFactory;

final class d
{
  e a = null;
  protected final int b;
  long c = 0L;
  private boolean d = false;
  
  public d(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.b = paramInt;
    this.d = paramBoolean;
    this.c = (1000000L * paramLong);
    if (this.b > 0)
    {
      this.a = new e(this.b);
      return;
    }
    this.a = null;
  }
  
  protected final e.a a(String paramString)
  {
    Object localObject;
    if (paramString.equals("")) {
      localObject = null;
    }
    e.a locala;
    do
    {
      do
      {
        return localObject;
        locala = this.a.a(paramString);
        localObject = locala;
      } while (!this.d);
      if (locala == null) {
        return null;
      }
      localObject = locala;
    } while (System.nanoTime() - locala.b <= this.c);
    this.a.b(paramString);
    return null;
  }
  
  protected final boolean a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    e.a locala = new e.a();
    try
    {
      locala.a = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (locala.a == null)
      {
        locala.a = null;
        return false;
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        this.a.a();
      }
      if (this.d == true) {
        locala.b = System.nanoTime();
      }
      this.a.a(paramString, locala);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.d
 * JD-Core Version:    0.7.0.1
 */