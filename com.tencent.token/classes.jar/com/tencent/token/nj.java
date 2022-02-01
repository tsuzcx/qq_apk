package com.tencent.token;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class nj
{
  String a;
  Map b;
  
  public nj(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final void a(a parama)
  {
    this.b.put(parama.a, parama);
  }
  
  public static final class a
  {
    String a;
    String b;
    public List c;
    long d;
    
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
          new ni(paramString1[0], Integer.parseInt(paramString1[1]));
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
              localArrayList.add(new ni(arrayOfString[0], Integer.parseInt(arrayOfString[1])));
            }
            i += 1;
          }
        }
      }
      return localArrayList;
    }
    
    public final String a()
    {
      Object localObject = this.c;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append(((ni)((Iterator)localObject).next()).a());
          localStringBuilder.append(",");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        return localStringBuilder.toString();
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nj
 * JD-Core Version:    0.7.0.1
 */