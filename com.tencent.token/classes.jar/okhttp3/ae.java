package okhttp3;

import com.tencent.token.gn;
import java.util.ArrayList;
import java.util.List;

public final class ae
{
  final List a = new ArrayList(20);
  
  private void d(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException("name == null");
    }
    if (paramString1.isEmpty()) {
      throw new IllegalArgumentException("name is empty");
    }
    int j = paramString1.length();
    int i = 0;
    int k;
    while (i < j)
    {
      k = paramString1.charAt(i);
      if ((k <= 32) || (k >= 127)) {
        throw new IllegalArgumentException(gn.a("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
      }
      i += 1;
    }
    if (paramString2 == null) {
      throw new NullPointerException("value for name " + paramString1 + " == null");
    }
    j = paramString2.length();
    i = 0;
    while (i < j)
    {
      k = paramString2.charAt(i);
      if (((k <= 31) && (k != 9)) || (k >= 127)) {
        throw new IllegalArgumentException(gn.a("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
      }
      i += 1;
    }
  }
  
  public ad a()
  {
    return new ad(this);
  }
  
  ae a(String paramString)
  {
    int i = paramString.indexOf(":", 1);
    if (i != -1) {
      return b(paramString.substring(0, i), paramString.substring(i + 1));
    }
    if (paramString.startsWith(":")) {
      return b("", paramString.substring(1));
    }
    return b("", paramString);
  }
  
  public ae a(String paramString1, String paramString2)
  {
    d(paramString1, paramString2);
    return b(paramString1, paramString2);
  }
  
  public ae b(String paramString)
  {
    int j;
    for (int i = 0; i < this.a.size(); i = j + 2)
    {
      j = i;
      if (paramString.equalsIgnoreCase((String)this.a.get(i)))
      {
        this.a.remove(i);
        this.a.remove(i);
        j = i - 2;
      }
    }
    return this;
  }
  
  ae b(String paramString1, String paramString2)
  {
    this.a.add(paramString1);
    this.a.add(paramString2.trim());
    return this;
  }
  
  public ae c(String paramString1, String paramString2)
  {
    d(paramString1, paramString2);
    b(paramString1);
    b(paramString1, paramString2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ae
 * JD-Core Version:    0.7.0.1
 */