package com.tencent.token;

public final class fo
{
  public static boolean a(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE")) || (paramString.equals("MOVE"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("PROPPATCH")) || (paramString.equals("REPORT"));
  }
  
  public static boolean c(String paramString)
  {
    return (!paramString.equals("GET")) && (!paramString.equals("HEAD"));
  }
  
  public static boolean d(String paramString)
  {
    return paramString.equals("PROPFIND");
  }
  
  public static boolean e(String paramString)
  {
    return paramString.equals("PROPFIND") ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fo
 * JD-Core Version:    0.7.0.1
 */