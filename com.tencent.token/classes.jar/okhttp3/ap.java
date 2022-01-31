package okhttp3;

import com.tencent.token.gn;
import java.util.Map;
import javax.annotation.Nullable;

public final class ap
{
  final af a;
  final String b;
  final ad c;
  @Nullable
  final ar d;
  final Map e;
  private volatile e f;
  
  ap(aq paramaq)
  {
    this.a = paramaq.a;
    this.b = paramaq.b;
    this.c = paramaq.c.a();
    this.d = paramaq.d;
    this.e = gn.a(paramaq.e);
  }
  
  @Nullable
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public af a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public ad c()
  {
    return this.c;
  }
  
  @Nullable
  public ar d()
  {
    return this.d;
  }
  
  public aq e()
  {
    return new aq(this);
  }
  
  public e f()
  {
    e locale = this.f;
    if (locale != null) {
      return locale;
    }
    locale = e.a(this.c);
    this.f = locale;
    return locale;
  }
  
  public boolean g()
  {
    return this.a.c();
  }
  
  public String toString()
  {
    return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ap
 * JD-Core Version:    0.7.0.1
 */