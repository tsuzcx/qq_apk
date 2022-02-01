package com.tencent.token;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class alj
{
  public final ald a;
  public final String b;
  public final alc c;
  @Nullable
  public final alk d;
  final Map<Class<?>, Object> e;
  private volatile akp f;
  
  alj(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = alr.a(parama.e);
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
  
  public final akp b()
  {
    akp localakp = this.f;
    if (localakp != null) {
      return localakp;
    }
    localakp = akp.a(this.c);
    this.f = localakp;
    return localakp;
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
    ald a;
    String b;
    public alc.a c;
    alk d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new alc.a();
    }
    
    a(alj paramalj)
    {
      this.a = paramalj.a;
      this.b = paramalj.b;
      this.d = paramalj.d;
      Object localObject;
      if (paramalj.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramalj.e);
      }
      this.e = ((Map)localObject);
      this.c = paramalj.c.a();
    }
    
    public final a a(ald paramald)
    {
      if (paramald != null)
      {
        this.a = paramald;
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
        return a(ald.d((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public final a a(String paramString, @Nullable alk paramalk)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramalk != null) && (!amj.a(paramString)))
          {
            paramalk = new StringBuilder("method ");
            paramalk.append(paramString);
            paramalk.append(" must not have a request body.");
            throw new IllegalArgumentException(paramalk.toString());
          }
          if (paramalk == null)
          {
            int i;
            if ((!paramString.equals("POST")) && (!paramString.equals("PUT")) && (!paramString.equals("PATCH")) && (!paramString.equals("PROPPATCH")) && (!paramString.equals("REPORT"))) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0)
            {
              paramalk = new StringBuilder("method ");
              paramalk.append(paramString);
              paramalk.append(" must have a request body.");
              throw new IllegalArgumentException(paramalk.toString());
            }
          }
          this.b = paramString;
          this.d = paramalk;
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
    
    public final alj a()
    {
      if (this.a != null) {
        return new alj(this);
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
 * Qualified Name:     com.tencent.token.alj
 * JD-Core Version:    0.7.0.1
 */