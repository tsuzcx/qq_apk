package com.tencent.token;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class aip
{
  public final aij a;
  public final String b;
  public final aii c;
  @Nullable
  public final aiq d;
  final Map<Class<?>, Object> e;
  private volatile ahv f;
  
  aip(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = aix.a(parama.e);
  }
  
  public final a a()
  {
    return new a(this);
  }
  
  @Nullable
  public final String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public final ahv b()
  {
    ahv localahv = this.f;
    if (localahv != null) {
      return localahv;
    }
    localahv = ahv.a(this.c);
    this.f = localahv;
    return localahv;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tags=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    aij a;
    String b;
    public aii.a c;
    aiq d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new aii.a();
    }
    
    a(aip paramaip)
    {
      this.a = paramaip.a;
      this.b = paramaip.b;
      this.d = paramaip.d;
      Object localObject;
      if (paramaip.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramaip.e);
      }
      this.e = ((Map)localObject);
      this.c = paramaip.c.a();
    }
    
    public final a a(aij paramaij)
    {
      if (paramaij != null)
      {
        this.a = paramaij;
        return this;
      }
      throw new NullPointerException("url == null");
    }
    
    public final a a(String paramString)
    {
      if (paramString != null)
      {
        Object localObject;
        if (paramString.regionMatches(true, 0, "ws:", 0, 3))
        {
          localObject = new StringBuilder("http:");
          ((StringBuilder)localObject).append(paramString.substring(3));
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = paramString;
          if (paramString.regionMatches(true, 0, "wss:", 0, 4))
          {
            localObject = new StringBuilder("https:");
            ((StringBuilder)localObject).append(paramString.substring(4));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        return a(aij.d((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public final a a(String paramString, @Nullable aiq paramaiq)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramaiq != null) && (!ajp.a(paramString)))
          {
            paramaiq = new StringBuilder("method ");
            paramaiq.append(paramString);
            paramaiq.append(" must not have a request body.");
            throw new IllegalArgumentException(paramaiq.toString());
          }
          if (paramaiq == null)
          {
            int i;
            if ((!paramString.equals("POST")) && (!paramString.equals("PUT")) && (!paramString.equals("PATCH")) && (!paramString.equals("PROPPATCH")) && (!paramString.equals("REPORT"))) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0)
            {
              paramaiq = new StringBuilder("method ");
              paramaiq.append(paramString);
              paramaiq.append(" must have a request body.");
              throw new IllegalArgumentException(paramaiq.toString());
            }
          }
          this.b = paramString;
          this.d = paramaiq;
          return this;
        }
        throw new IllegalArgumentException("method.length() == 0");
      }
      throw new NullPointerException("method == null");
    }
    
    public final a a(String paramString1, String paramString2)
    {
      this.c.b(paramString1, paramString2);
      return this;
    }
    
    public final aip a()
    {
      if (this.a != null) {
        return new aip(this);
      }
      throw new IllegalStateException("url == null");
    }
    
    public final a b(String paramString)
    {
      this.c.a(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aip
 * JD-Core Version:    0.7.0.1
 */