package com.tencent.moai.mailsdk.util.log;

public class Logger
{
  private static LoggerDelegate delegate = new Logger.1();
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    delegate.log(paramInt, paramString1, paramString2);
  }
  
  public static void osslog(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      delegate.ossLog(paramVarArgs);
    }
  }
  
  public static void setDelegate(LoggerDelegate paramLoggerDelegate)
  {
    if (paramLoggerDelegate != null) {
      delegate = paramLoggerDelegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.log.Logger
 * JD-Core Version:    0.7.0.1
 */