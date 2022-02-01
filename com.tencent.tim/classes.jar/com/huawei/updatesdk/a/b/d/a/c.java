package com.huawei.updatesdk.a.b.d.a;

import com.huawei.updatesdk.a.a.c.f;
import com.huawei.updatesdk.a.a.c.g;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c
{
  public static final String CLIENT_API = "clientApi";
  private static final String END_FLAG = "_";
  private static String url;
  private String method_;
  private String ver_ = "1.1";
  
  private String a(Field paramField)
    throws IllegalAccessException, IllegalArgumentException
  {
    paramField = paramField.get(this);
    if ((paramField != null) && ((paramField instanceof b))) {
      return ((b)paramField).toJson();
    }
    if (paramField != null) {
      return String.valueOf(paramField);
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    url = paramString;
  }
  
  public String a()
  {
    return this.method_;
  }
  
  public String b()
    throws IllegalAccessException, IllegalArgumentException, ArrayIndexOutOfBoundsException
  {
    c();
    Map localMap = e();
    String[] arrayOfString = new String[localMap.size()];
    localMap.keySet().toArray(arrayOfString);
    Arrays.sort(arrayOfString);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      String str = a((Field)localMap.get(arrayOfString[i]));
      if (str != null)
      {
        str = g.a(str);
        localStringBuilder.append(arrayOfString[i]).append("=").append(str).append("&");
      }
      i += 1;
      if (i >= arrayOfString.length)
      {
        i = localStringBuilder.length();
        if ((i > 0) && (localStringBuilder.charAt(i - 1) == '&')) {
          localStringBuilder.deleteCharAt(i - 1);
        }
        return localStringBuilder.toString();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.method_ = paramString;
  }
  
  protected void c() {}
  
  public void c(String paramString)
  {
    this.ver_ = paramString;
  }
  
  public String d()
  {
    return url + "clientApi";
  }
  
  protected Map<String, Field> e()
  {
    HashMap localHashMap = new HashMap();
    Field[] arrayOfField = f.a(getClass());
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      localField.setAccessible(true);
      String str = localField.getName();
      if (str.endsWith("_")) {
        localHashMap.put(str.substring(0, str.length() - "_".length()), localField);
      }
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */