package okhttp3;

import com.tencent.token.gn;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public final class ag
{
  @Nullable
  String a;
  String b = "";
  String c = "";
  @Nullable
  String d;
  int e = -1;
  final List f = new ArrayList();
  @Nullable
  List g;
  @Nullable
  String h;
  
  public ag()
  {
    this.f.add("");
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramString.charAt(paramInt1);
    if ((i == 47) || (i == 92))
    {
      this.f.clear();
      this.f.add("");
      paramInt1 += 1;
      label52:
      if (paramInt1 >= paramInt2) {
        break label127;
      }
      i = gn.a(paramString, paramInt1, paramInt2, "/\\");
      if (i >= paramInt2) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      a(paramString, paramInt1, i, bool, true);
      paramInt1 = i;
      if (bool) {
        paramInt1 = i + 1;
      }
      break label52;
      this.f.set(this.f.size() - 1, "");
      break label52;
      label127:
      break;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = af.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
    if (f(paramString)) {}
    for (;;)
    {
      return;
      if (g(paramString))
      {
        d();
        return;
      }
      if (((String)this.f.get(this.f.size() - 1)).isEmpty()) {
        this.f.set(this.f.size() - 1, paramString);
      }
      while (paramBoolean1)
      {
        this.f.add("");
        return;
        this.f.add(paramString);
      }
    }
  }
  
  private static int b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 < 2) {}
    int i;
    label115:
    do
    {
      for (;;)
      {
        return -1;
        i = paramString.charAt(paramInt1);
        if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
        {
          paramInt1 += 1;
          while (paramInt1 < paramInt2)
          {
            i = paramString.charAt(paramInt1);
            if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46)) {
              break label115;
            }
            paramInt1 += 1;
          }
        }
      }
    } while (i != 58);
    return paramInt1;
  }
  
  private static int c(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      int j = paramString.charAt(paramInt1);
      if ((j != 92) && (j != 47)) {
        break;
      }
      i += 1;
      paramInt1 += 1;
    }
    return i;
  }
  
  private static int d(String paramString, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt1;
    }
    switch (paramString.charAt(paramInt1))
    {
    default: 
      i = paramInt1;
    case '[': 
      for (;;)
      {
        paramInt1 = i + 1;
        break;
        do
        {
          paramInt1 = i + 1;
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          i = paramInt1;
        } while (paramString.charAt(paramInt1) != ']');
        i = paramInt1;
      }
      j = paramInt2;
    }
    return j;
  }
  
  private void d()
  {
    if ((((String)this.f.remove(this.f.size() - 1)).isEmpty()) && (!this.f.isEmpty()))
    {
      this.f.set(this.f.size() - 1, "");
      return;
    }
    this.f.add("");
  }
  
  private static String e(String paramString, int paramInt1, int paramInt2)
  {
    return gn.a(af.a(paramString, paramInt1, paramInt2, false));
  }
  
  private static int f(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = Integer.parseInt(af.a(paramString, paramInt1, paramInt2, "", false, false, false, true, null));
      if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
        return paramInt1;
      }
      return -1;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  private boolean f(String paramString)
  {
    return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
  }
  
  private boolean g(String paramString)
  {
    return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
  }
  
  int a()
  {
    if (this.e != -1) {
      return this.e;
    }
    return af.a(this.a);
  }
  
  public ag a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("unexpected port: " + paramInt);
    }
    this.e = paramInt;
    return this;
  }
  
  public ag a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("scheme == null");
    }
    if (paramString.equalsIgnoreCase("http"))
    {
      this.a = "http";
      return this;
    }
    if (paramString.equalsIgnoreCase("https"))
    {
      this.a = "https";
      return this;
    }
    throw new IllegalArgumentException("unexpected scheme: " + paramString);
  }
  
  ag a(@Nullable af paramaf, String paramString)
  {
    int i = gn.a(paramString, 0, paramString.length());
    int i1 = gn.b(paramString, i, paramString.length());
    int j = b(paramString, i, i1);
    label64:
    int k;
    label116:
    int n;
    if (j != -1) {
      if (paramString.regionMatches(true, i, "https:", 0, 6))
      {
        this.a = "https";
        i += "https:".length();
        m = c(paramString, i, i1);
        if ((m < 2) && (paramaf != null) && (paramaf.a.equals(this.a))) {
          break label765;
        }
        k = 0;
        j = 0;
        m = i + m;
        i = k;
        k = m;
        n = gn.a(paramString, k, i1, "@/\\?#");
        if (n == i1) {
          break label320;
        }
      }
    }
    label320:
    for (int m = paramString.charAt(n);; m = -1) {
      switch (m)
      {
      default: 
        m = i;
        i = k;
        k = m;
        m = k;
        k = i;
        i = m;
        break label116;
        if (paramString.regionMatches(true, i, "http:", 0, 5))
        {
          this.a = "http";
          i += "http:".length();
          break label64;
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + paramString.substring(0, j) + "'");
        if (paramaf != null)
        {
          this.a = paramaf.a;
          break label64;
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
      }
    }
    if (i == 0)
    {
      m = gn.a(paramString, k, n, ':');
      String str = af.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
      paramaf = str;
      if (j != 0) {
        paramaf = this.b + "%40" + str;
      }
      this.b = paramaf;
      if (m != n)
      {
        i = 1;
        this.c = af.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
      }
      j = 1;
    }
    for (;;)
    {
      m = n + 1;
      k = i;
      i = m;
      break;
      this.c = (this.c + "%40" + af.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
    }
    i = d(paramString, k, n);
    if (i + 1 < n)
    {
      this.d = e(paramString, k, i);
      this.e = f(paramString, i + 1, n);
      if (this.e == -1) {
        throw new IllegalArgumentException("Invalid URL port: \"" + paramString.substring(i + 1, n) + '"');
      }
    }
    else
    {
      this.d = e(paramString, k, i);
      this.e = af.a(this.a);
    }
    if (this.d == null) {
      throw new IllegalArgumentException("Invalid URL host: \"" + paramString.substring(k, i) + '"');
    }
    j = n;
    i = gn.a(paramString, j, i1, "?#");
    a(paramString, j, i);
    if ((i < i1) && (paramString.charAt(i) == '?'))
    {
      j = gn.a(paramString, i, i1, '#');
      this.g = af.b(af.a(paramString, i + 1, j, " \"'<>#", true, false, true, true, null));
      i = j;
    }
    for (;;)
    {
      if ((i < i1) && (paramString.charAt(i) == '#')) {
        this.h = af.a(paramString, i + 1, i1, "", true, false, false, false, null);
      }
      return this;
      label765:
      this.b = paramaf.d();
      this.c = paramaf.e();
      this.d = paramaf.b;
      this.e = paramaf.c;
      this.f.clear();
      this.f.addAll(paramaf.i());
      if (i != i1)
      {
        j = i;
        if (paramString.charAt(i) != '#') {
          break;
        }
      }
      e(paramaf.j());
      j = i;
      break;
    }
  }
  
  ag b()
  {
    int j = this.f.size();
    int i = 0;
    String str;
    while (i < j)
    {
      str = (String)this.f.get(i);
      this.f.set(i, af.a(str, "[]", true, true, false, true));
      i += 1;
    }
    if (this.g != null)
    {
      j = this.g.size();
      i = 0;
      while (i < j)
      {
        str = (String)this.g.get(i);
        if (str != null) {
          this.g.set(i, af.a(str, "\\^`{|}", true, true, true, true));
        }
        i += 1;
      }
    }
    if (this.h != null) {
      this.h = af.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
    }
    return this;
  }
  
  public ag b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("username == null");
    }
    this.b = af.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    return this;
  }
  
  public af c()
  {
    if (this.a == null) {
      throw new IllegalStateException("scheme == null");
    }
    if (this.d == null) {
      throw new IllegalStateException("host == null");
    }
    return new af(this);
  }
  
  public ag c(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("password == null");
    }
    this.c = af.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    return this;
  }
  
  public ag d(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("host == null");
    }
    String str = e(paramString, 0, paramString.length());
    if (str == null) {
      throw new IllegalArgumentException("unexpected host: " + paramString);
    }
    this.d = str;
    return this;
  }
  
  public ag e(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (paramString = af.b(af.a(paramString, " \"'<>#", true, false, true, true));; paramString = null)
    {
      this.g = paramString;
      return this;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("://");
    if ((!this.b.isEmpty()) || (!this.c.isEmpty()))
    {
      localStringBuilder.append(this.b);
      if (!this.c.isEmpty())
      {
        localStringBuilder.append(':');
        localStringBuilder.append(this.c);
      }
      localStringBuilder.append('@');
    }
    if (this.d.indexOf(':') != -1)
    {
      localStringBuilder.append('[');
      localStringBuilder.append(this.d);
      localStringBuilder.append(']');
    }
    for (;;)
    {
      int i = a();
      if (i != af.a(this.a))
      {
        localStringBuilder.append(':');
        localStringBuilder.append(i);
      }
      af.a(localStringBuilder, this.f);
      if (this.g != null)
      {
        localStringBuilder.append('?');
        af.b(localStringBuilder, this.g);
      }
      if (this.h != null)
      {
        localStringBuilder.append('#');
        localStringBuilder.append(this.h);
      }
      return localStringBuilder.toString();
      localStringBuilder.append(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ag
 * JD-Core Version:    0.7.0.1
 */