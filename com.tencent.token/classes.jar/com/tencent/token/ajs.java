package com.tencent.token;

public final class ajs
{
  public static String a(aij paramaij)
  {
    String str = paramaij.e();
    paramaij = paramaij.g();
    if (paramaij != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append('?');
      localStringBuilder.append(paramaij);
      return localStringBuilder.toString();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajs
 * JD-Core Version:    0.7.0.1
 */