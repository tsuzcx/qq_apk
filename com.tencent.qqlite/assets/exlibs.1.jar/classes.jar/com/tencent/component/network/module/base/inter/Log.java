package com.tencent.component.network.module.base.inter;

public abstract interface Log
{
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isErrorEnabled();
  
  public abstract boolean isInfoEnabled();
  
  public abstract boolean isVerboseEnabled();
  
  public abstract boolean isWarnEnabled();
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.inter.Log
 * JD-Core Version:    0.7.0.1
 */