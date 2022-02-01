package com.tencent.map.sdk.a;

import android.content.Context;

public final class op
{
  static final String[] a = { "txmapengine", "txnavengine" };
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      or.a("loadLibary:" + paramString + "  successful");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = oq.a(paramContext, paramString);
      or.a("loadLibary:" + paramString + " result:" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.op
 * JD-Core Version:    0.7.0.1
 */