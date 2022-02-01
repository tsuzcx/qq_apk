package okhttp3;

import com.tencent.token.fc;
import com.tencent.token.fo;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class x
{
  final s a;
  final String b;
  final r c;
  @Nullable
  final y d;
  final Map<Class<?>, Object> e;
  private volatile d f;
  
  x(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = fc.a(parama.e);
  }
  
  @Nullable
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public s a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public r c()
  {
    return this.c;
  }
  
  @Nullable
  public y d()
  {
    return this.d;
  }
  
  public a e()
  {
    return new a(this);
  }
  
  public d f()
  {
    d locald = this.f;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.c);
    this.f = locald;
    return locald;
  }
  
  public boolean g()
  {
    return this.a.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request{method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tags=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    s a;
    String b;
    r.a c;
    y d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new r.a();
    }
    
    a(x paramx)
    {
      this.a = paramx.a;
      this.b = paramx.b;
      this.d = paramx.d;
      Object localObject;
      if (paramx.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramx.e);
      }
      this.e = ((Map)localObject);
      this.c = paramx.c.b();
    }
    
    public a a(String paramString)
    {
      if (paramString != null)
      {
        Object localObject;
        if (paramString.regionMatches(true, 0, "ws:", 0, 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("http:");
          ((StringBuilder)localObject).append(paramString.substring(3));
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = paramString;
          if (paramString.regionMatches(true, 0, "wss:", 0, 4))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https:");
            ((StringBuilder)localObject).append(paramString.substring(4));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        return a(s.e((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public a a(String paramString, @Nullable y paramy)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramy != null) && (!fo.c(paramString)))
          {
            paramy = new StringBuilder();
            paramy.append("method ");
            paramy.append(paramString);
            paramy.append(" must not have a request body.");
            throw new IllegalArgumentException(paramy.toString());
          }
          if ((paramy == null) && (fo.b(paramString)))
          {
            paramy = new StringBuilder();
            paramy.append("method ");
            paramy.append(paramString);
            paramy.append(" must have a request body.");
            throw new IllegalArgumentException(paramy.toString());
          }
          this.b = paramString;
          this.d = paramy;
          return this;
        }
        throw new IllegalArgumentException("method.length() == 0");
      }
      throw new NullPointerException("method == null");
    }
    
    public a a(r paramr)
    {
      this.c = paramr.b();
      return this;
    }
    
    public a a(s params)
    {
      if (params != null)
      {
        this.a = params;
        return this;
      }
      throw new NullPointerException("url == null");
    }
    
    public x a()
    {
      if (this.a != null) {
        return new x(this);
      }
      throw new IllegalStateException("url == null");
    }
    
    public a b(String paramString)
    {
      this.c.b(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.x
 * JD-Core Version:    0.7.0.1
 */