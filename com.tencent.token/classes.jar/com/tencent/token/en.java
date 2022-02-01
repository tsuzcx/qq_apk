package com.tencent.token;

import com.tencent.token.global.g;

public class en
{
  public static void a(String paramString)
  {
    try
    {
      et.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete database table failed: ");
      localStringBuilder.append(paramString.toString());
      g.c(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.en
 * JD-Core Version:    0.7.0.1
 */