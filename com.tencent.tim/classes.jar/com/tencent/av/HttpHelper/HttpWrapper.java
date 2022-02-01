package com.tencent.av.HttpHelper;

import android.util.Log;

public class HttpWrapper
{
  public static String tag;
  
  public static void send(byte[] paramArrayOfByte, String paramString)
  {
    Log.e(tag, "send called with Buffer" + paramString + "end");
    new Thread(new HttpWrapper.1(paramString, paramArrayOfByte)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpWrapper
 * JD-Core Version:    0.7.0.1
 */