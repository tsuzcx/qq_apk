package okhttp3;

import com.tencent.token.fb;
import com.tencent.token.fn;
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
    this.e = fb.a(parama.e);
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
    return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
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
      if (paramx.e.isEmpty()) {}
      for (Object localObject = Collections.emptyMap();; localObject = new LinkedHashMap(paramx.e))
      {
        this.e = ((Map)localObject);
        this.c = paramx.c.b();
        return;
      }
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        return a(s.e(str));
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public a a(String paramString, @Nullable y paramy)
    {
      if (paramString == null) {
        throw new NullPointerException("method == null");
      }
      if (paramString.length() == 0) {
        throw new IllegalArgumentException("method.length() == 0");
      }
      if ((paramy != null) && (!fn.c(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramy == null) && (fn.b(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.b = paramString;
      this.d = paramy;
      return this;
    }
    
    public a a(r paramr)
    {
      this.c = paramr.b();
      return this;
    }
    
    public a a(s params)
    {
      if (params == null) {
        throw new NullPointerException("url == null");
      }
      this.a = params;
      return this;
    }
    
    public x a()
    {
      if (this.a == null) {
        throw new IllegalStateException("url == null");
      }
      return new x(this);
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