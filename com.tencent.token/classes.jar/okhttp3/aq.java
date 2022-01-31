package okhttp3;

import com.tencent.token.hh;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class aq
{
  af a;
  String b;
  ae c;
  ar d;
  Map e = Collections.emptyMap();
  
  public aq()
  {
    this.b = "GET";
    this.c = new ae();
  }
  
  aq(ap paramap)
  {
    this.a = paramap.a;
    this.b = paramap.b;
    this.d = paramap.d;
    if (paramap.e.isEmpty()) {}
    for (Object localObject = Collections.emptyMap();; localObject = new LinkedHashMap(paramap.e))
    {
      this.e = ((Map)localObject);
      this.c = paramap.c.b();
      return;
    }
  }
  
  public ap a()
  {
    if (this.a == null) {
      throw new IllegalStateException("url == null");
    }
    return new ap(this);
  }
  
  public aq a(String paramString)
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
      return a(af.e(str));
      str = paramString;
      if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
        str = "https:" + paramString.substring(4);
      }
    }
  }
  
  public aq a(String paramString1, String paramString2)
  {
    this.c.c(paramString1, paramString2);
    return this;
  }
  
  public aq a(String paramString, @Nullable ar paramar)
  {
    if (paramString == null) {
      throw new NullPointerException("method == null");
    }
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("method.length() == 0");
    }
    if ((paramar != null) && (!hh.c(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
    }
    if ((paramar == null) && (hh.b(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must have a request body.");
    }
    this.b = paramString;
    this.d = paramar;
    return this;
  }
  
  public aq a(ad paramad)
  {
    this.c = paramad.b();
    return this;
  }
  
  public aq a(af paramaf)
  {
    if (paramaf == null) {
      throw new NullPointerException("url == null");
    }
    this.a = paramaf;
    return this;
  }
  
  public aq b(String paramString)
  {
    this.c.b(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.aq
 * JD-Core Version:    0.7.0.1
 */