package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class TbsHandlerThread
  extends HandlerThread
{
  private static final String THREAD_NAME = "TbsHandlerThread";
  private static TbsHandlerThread mHandlerThread;
  
  public TbsHandlerThread(String paramString)
  {
    super(paramString);
  }
  
  public static TbsHandlerThread getInstance()
  {
    try
    {
      if (mHandlerThread == null)
      {
        mHandlerThread = new TbsHandlerThread("TbsHandlerThread");
        mHandlerThread.start();
      }
      TbsHandlerThread localTbsHandlerThread = mHandlerThread;
      return localTbsHandlerThread;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsHandlerThread
 * JD-Core Version:    0.7.0.1
 */