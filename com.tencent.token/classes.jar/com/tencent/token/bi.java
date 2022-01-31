package com.tencent.token;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bi
{
  private String a;
  private String b;
  private List c;
  private long d;
  
  public bi(String paramString1, long paramLong, String paramString2)
  {
    this.a = paramString1;
    this.d = paramLong;
    this.b = paramString2;
    this.c = new ArrayList();
  }
  
  public bi(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.d = paramLong;
    this.b = paramString3;
    this.c = a(paramString2);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = paramString4.split(":");
      if ((paramString1 != null) && (paramString1.length > 0)) {
        new bg(paramString1[0], Integer.parseInt(paramString1[1]));
      }
    }
  }
  
  private static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split(":");
          if ((arrayOfString != null) && (arrayOfString.length > 0)) {
            localArrayList.add(new bg(arrayOfString[0], Integer.parseInt(arrayOfString[1])));
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(bg parambg)
  {
    this.c.add(parambg);
  }
  
  public final long b()
  {
    return this.d;
  }
  
  public final List c()
  {
    return this.c;
  }
  
  public final String d()
  {
    Object localObject = this.c;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append(((bg)((Iterator)localObject).next()).c());
      localStringBuilder.append(",");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public final String e()
  {
    return this.b;
  }
  
  public final boolean f()
  {
    return System.currentTimeMillis() - this.d > bm.a().b.e * 60 * 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bi
 * JD-Core Version:    0.7.0.1
 */