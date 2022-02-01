package com.tencent.turingfd.sdk.qps;

import com.tencent.token.ahl;
import java.lang.reflect.Field;
import java.util.Locale;

public enum for
  implements ahl
{
  public static String a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while ((!Character.isLetter(paramString.charAt(i))) && (i < j - 1)) {
      i += 1;
    }
    char c1 = paramString.charAt(i);
    if (Character.isUpperCase(c1)) {
      return paramString;
    }
    c1 = Character.toUpperCase(c1);
    if (i == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c1);
      localStringBuilder.append(paramString.substring(1));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i));
    localStringBuilder.append(c1);
    localStringBuilder.append(paramString.substring(i + 1));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length();
    int i = 0;
    while (i < j)
    {
      char c1 = paramString1.charAt(i);
      if ((Character.isUpperCase(c1)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public enum case
  {
    public case()
    {
      super(5, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return for.a(paramField.getName(), ".").toLowerCase(Locale.ENGLISH);
    }
  }
  
  public enum do
  {
    public do()
    {
      super(0, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return paramField.getName();
    }
  }
  
  public enum for
  {
    public for()
    {
      super(2, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return for.a(for.a(paramField.getName(), " "));
    }
  }
  
  public enum if
  {
    public if()
    {
      super(1, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return for.a(paramField.getName());
    }
  }
  
  public enum new
  {
    public new()
    {
      super(3, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return for.a(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
  }
  
  public enum try
  {
    public try()
    {
      super(4, (byte)0);
    }
    
    public final String a(Field paramField)
    {
      return for.a(paramField.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.for
 * JD-Core Version:    0.7.0.1
 */