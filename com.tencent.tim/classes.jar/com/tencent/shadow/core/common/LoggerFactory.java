package com.tencent.shadow.core.common;

public final class LoggerFactory
{
  private static volatile ILoggerFactory sILoggerFactory;
  
  public static ILoggerFactory getILoggerFactory()
  {
    if (sILoggerFactory == null) {
      throw new RuntimeException("没有找到 ILoggerFactory 实现，请先调用setILoggerFactory");
    }
    return sILoggerFactory;
  }
  
  public static final Logger getLogger(Class paramClass)
  {
    return getILoggerFactory().getLogger(paramClass.getName());
  }
  
  public static void setILoggerFactory(ILoggerFactory paramILoggerFactory)
  {
    if (sILoggerFactory != null) {
      throw new RuntimeException("不能重复初始化");
    }
    sILoggerFactory = paramILoggerFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.core.common.LoggerFactory
 * JD-Core Version:    0.7.0.1
 */