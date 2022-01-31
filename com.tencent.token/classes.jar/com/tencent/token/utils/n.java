package com.tencent.token.utils;

import com.tencent.token.ui.base.bt;
import java.util.List;

public class n
{
  public static String a(List paramList)
  {
    if (paramList == null) {
      return "";
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      bt localbt = (bt)paramList.get(i);
      int k = localbt.a();
      arrayOfByte[i] = ((byte)(localbt.b() + k * 3));
      i += 1;
    }
    return a(arrayOfByte);
  }
  
  public static final String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.n
 * JD-Core Version:    0.7.0.1
 */