package com.tencent.moai.mailsdk.util;

import java.util.concurrent.atomic.AtomicInteger;

public class UinqueUtility
{
  private static AtomicInteger id = new AtomicInteger();
  
  public static String getUniqueBoundaryValue()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l = localStringBuffer.hashCode();
    localStringBuffer.append("----=_Part_").append(id.getAndIncrement()).append("_").append(l).append('.').append(System.currentTimeMillis());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.UinqueUtility
 * JD-Core Version:    0.7.0.1
 */