package com.tencent.youtu.ytcommon.tools;

public class YTException
{
  public static void report(Exception paramException)
  {
    paramException.printStackTrace();
    YTLogger.e("YTException", "[YTException.report] ");
  }
  
  public static void report(Exception paramException, String paramString1, String paramString2)
  {
    paramException.printStackTrace();
    YTLogger.w("YTException" + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTException
 * JD-Core Version:    0.7.0.1
 */