package com.tencent.tissue.v8rt.engine;

import android.annotation.TargetApi;
import android.os.Trace;

public final class TraceUtil
{
  public static void beginSection(String paramString) {}
  
  @TargetApi(18)
  private static void beginSectionV18(String paramString)
  {
    Trace.beginSection(paramString);
  }
  
  public static void endSection() {}
  
  @TargetApi(18)
  private static void endSectionV18() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.TraceUtil
 * JD-Core Version:    0.7.0.1
 */