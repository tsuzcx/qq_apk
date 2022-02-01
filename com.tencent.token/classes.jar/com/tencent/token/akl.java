package com.tencent.token;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class akl
{
  public final akf a;
  public final String b;
  public final ake c;
  @Nullable
  public final akm d;
  final Map<Class<?>, Object> e;
  private volatile ajr f;
  
  akl(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = akt.a(parama.e);
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
  
  public final ajr b()
  {
    ajr localajr = this.f;
    if (localajr != null) {
      return localajr;
    }
    localajr = ajr.a(this.c);
    this.f = localajr;
    return localajr;
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
    akf a;
    String b;
    public ake.a c;
    akm d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new ake.a();
    }
    
    a(akl paramakl)
    {
      this.a = paramakl.a;
      this.b = paramakl.b;
      this.d = paramakl.d;
      Object localObject;
      if (paramakl.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramakl.e);
      }
      this.e = ((Map)localObject);
      this.c = paramakl.c.a();
    }
    
    public final a a(akf paramakf)
    {
      if (paramakf != null)
      {
        this.a = paramakf;
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
        return a(akf.d((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public final a a(String paramString, @Nullable akm paramakm)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramakm != null) && (!all.a(paramString)))
          {
            paramakm = new StringBuilder("method ");
            paramakm.append(paramString);
            paramakm.append(" must not have a request body.");
            throw new IllegalArgumentException(paramakm.toString());
          }
          if (paramakm == null)
          {
            int i;
            if ((!paramString.equals("POST")) && (!paramString.equals("PUT")) && (!paramString.equals("PATCH")) && (!paramString.equals("PROPPATCH")) && (!paramString.equals("REPORT"))) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0)
            {
              paramakm = new StringBuilder("method ");
              paramakm.append(paramString);
              paramakm.append(" must have a request body.");
              throw new IllegalArgumentException(paramakm.toString());
            }
          }
          this.b = paramString;
          this.d = paramakm;
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
    
    public final akl a()
    {
      if (this.a != null) {
        return new akl(this);
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
 * Qualified Name:     com.tencent.token.akl
 * JD-Core Version:    0.7.0.1
 */