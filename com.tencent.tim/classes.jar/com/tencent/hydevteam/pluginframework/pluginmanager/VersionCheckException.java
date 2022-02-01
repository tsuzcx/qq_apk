package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;

@API
public class VersionCheckException
  extends Exception
{
  public VersionCheckException(String paramString)
  {
    super(paramString);
  }
  
  public VersionCheckException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException
 * JD-Core Version:    0.7.0.1
 */