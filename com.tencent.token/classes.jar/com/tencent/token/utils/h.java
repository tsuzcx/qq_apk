package com.tencent.token.utils;

import com.tencent.token.ui.base.LockPatternView.a;
import java.util.List;

public class h
{
  public static String a(List<LockPatternView.a> paramList)
  {
    if (paramList == null) {
      return "";
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      LockPatternView.a locala = (LockPatternView.a)paramList.get(i);
      int k = locala.a();
      arrayOfByte[i] = ((byte)(locala.b() + k * 3));
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
 * Qualified Name:     com.tencent.token.utils.h
 * JD-Core Version:    0.7.0.1
 */