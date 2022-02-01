package com.tencent.moai.mailsdk.util.log;

public abstract interface LoggerDelegate
{
  public abstract void log(int paramInt, String paramString1, String paramString2);
  
  public abstract void ossLog(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.log.LoggerDelegate
 * JD-Core Version:    0.7.0.1
 */