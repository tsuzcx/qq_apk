package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class o
  extends HandlerThread
{
  private static o a;
  
  public o(String paramString)
  {
    super(paramString);
  }
  
  public static o a()
  {
    try
    {
      if (a == null)
      {
        a = new o("TbsHandlerThread");
        a.start();
      }
      o localo = a;
      return localo;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */