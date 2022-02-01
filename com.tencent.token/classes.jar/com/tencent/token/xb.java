package com.tencent.token;

public final class xb
{
  private static String a()
  {
    String str = "";
    Object localObject = new Throwable().getStackTrace();
    if (localObject.length > 2)
    {
      str = localObject[2];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(str.getFileName());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str.getLineNumber());
      ((StringBuilder)localObject).append("|");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str.getMethodName());
      localStringBuilder.append("()] ");
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    abk.a().a(paramInt, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (abk.a().d)
    {
      str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    boolean bool = abk.a().c;
    a(2, "TokenLog", str);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (abk.a().d)
    {
      str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString2);
      str = localStringBuilder.toString();
    }
    boolean bool = abk.a().c;
    a(2, paramString1, str);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str;
      if (abk.a().d)
      {
        str = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("assert failed");
        str = localStringBuilder.toString();
      }
      else
      {
        str = "assert failed";
      }
      paramBoolean = abk.a().c;
      a(16, "TokenLog", str);
    }
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (abk.a().d)
    {
      str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    boolean bool = abk.a().c;
    a(4, "TokenLog", str);
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (abk.a().d)
    {
      str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    boolean bool = abk.a().c;
    a(16, "TokenLog", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xb
 * JD-Core Version:    0.7.0.1
 */