package com.tencent.token;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class aio
{
  public final aii a;
  public final String b;
  public final aih c;
  @Nullable
  public final aip d;
  final Map<Class<?>, Object> e;
  private volatile ahu f;
  
  aio(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = aiw.a(parama.e);
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
  
  public final ahu b()
  {
    ahu localahu = this.f;
    if (localahu != null) {
      return localahu;
    }
    localahu = ahu.a(this.c);
    this.f = localahu;
    return localahu;
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
    aii a;
    String b;
    public aih.a c;
    aip d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new aih.a();
    }
    
    a(aio paramaio)
    {
      this.a = paramaio.a;
      this.b = paramaio.b;
      this.d = paramaio.d;
      Object localObject;
      if (paramaio.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramaio.e);
      }
      this.e = ((Map)localObject);
      this.c = paramaio.c.a();
    }
    
    public final a a(aii paramaii)
    {
      if (paramaii != null)
      {
        this.a = paramaii;
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
        return a(aii.d((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public final a a(String paramString, @Nullable aip paramaip)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramaip != null) && (!ajo.a(paramString)))
          {
            paramaip = new StringBuilder("method ");
            paramaip.append(paramString);
            paramaip.append(" must not have a request body.");
            throw new IllegalArgumentException(paramaip.toString());
          }
          if (paramaip == null)
          {
            int i;
            if ((!paramString.equals("POST")) && (!paramString.equals("PUT")) && (!paramString.equals("PATCH")) && (!paramString.equals("PROPPATCH")) && (!paramString.equals("REPORT"))) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0)
            {
              paramaip = new StringBuilder("method ");
              paramaip.append(paramString);
              paramaip.append(" must have a request body.");
              throw new IllegalArgumentException(paramaip.toString());
            }
          }
          this.b = paramString;
          this.d = paramaip;
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
    
    public final aio a()
    {
      if (this.a != null) {
        return new aio(this);
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
 * Qualified Name:     com.tencent.token.aio
 * JD-Core Version:    0.7.0.1
 */