package com.tencent.thumbplayer.log;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPBaseLogger
  implements ITPLogger
{
  private TPLoggerContext mTPLoggerContext;
  private String mTag;
  
  public TPBaseLogger(@NonNull TPLoggerContext paramTPLoggerContext)
  {
    this.mTPLoggerContext = paramTPLoggerContext;
    this.mTag = this.mTPLoggerContext.getTag();
  }
  
  public TPBaseLogger(TPLoggerContext paramTPLoggerContext, String paramString)
  {
    this.mTPLoggerContext = new TPLoggerContext(paramTPLoggerContext, paramString);
    this.mTag = this.mTPLoggerContext.getTag();
  }
  
  public void debug(String paramString)
  {
    TPLogUtil.d(this.mTPLoggerContext.getTag(), paramString);
  }
  
  public void error(String paramString)
  {
    TPLogUtil.e(this.mTPLoggerContext.getTag(), paramString);
  }
  
  public TPLoggerContext getTPLoggerContext()
  {
    return this.mTPLoggerContext;
  }
  
  public String getTag()
  {
    return this.mTPLoggerContext.getTag();
  }
  
  public void info(String paramString)
  {
    TPLogUtil.i(this.mTPLoggerContext.getTag(), paramString);
  }
  
  public void printException(Exception paramException)
  {
    TPLogUtil.e(this.mTPLoggerContext.getTag(), paramException);
  }
  
  public void updateContext(TPLoggerContext paramTPLoggerContext)
  {
    if (paramTPLoggerContext == null)
    {
      this.mTPLoggerContext = new TPLoggerContext(this.mTag);
      return;
    }
    this.mTPLoggerContext = paramTPLoggerContext;
  }
  
  public void updateTaskId(String paramString)
  {
    this.mTPLoggerContext.setTaskId(paramString);
  }
  
  public void verbose(String paramString)
  {
    TPLogUtil.v(this.mTPLoggerContext.getTag(), paramString);
  }
  
  public void warn(String paramString)
  {
    TPLogUtil.w(this.mTPLoggerContext.getTag(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.log.TPBaseLogger
 * JD-Core Version:    0.7.0.1
 */