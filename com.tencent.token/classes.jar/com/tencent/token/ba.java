package com.tencent.token;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ba
{
  private String a;
  private Map b;
  
  public ba(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final a a(String paramString)
  {
    return (a)this.b.get(paramString);
  }
  
  public final Map a()
  {
    return this.b;
  }
  
  public final void a(a parama)
  {
    this.b.put(a.a(parama), parama);
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public static final class a
  {
    private String a;
    private String b;
    private List c;
    private long d;
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      this.a = paramString1;
      this.d = paramLong;
      this.b = paramString2;
      this.c = new ArrayList();
    }
    
    public a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.d = paramLong;
      this.b = paramString3;
      this.c = a(paramString2);
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = paramString4.split(":");
        if ((paramString1 != null) && (paramString1.length > 0)) {
          new az(paramString1[0], Integer.parseInt(paramString1[1]));
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
              localArrayList.add(new az(arrayOfString[0], Integer.parseInt(arrayOfString[1])));
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
    
    public final void a(az paramaz)
    {
      this.c.add(paramaz);
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
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append(((az)((Iterator)localObject).next()).c());
          localStringBuilder.append(",");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        return localStringBuilder.toString();
      }
      return "";
    }
    
    public final String e()
    {
      return this.b;
    }
    
    public final boolean f()
    {
      return System.currentTimeMillis() - this.d > be.a().b.e * 60 * 1000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ba
 * JD-Core Version:    0.7.0.1
 */