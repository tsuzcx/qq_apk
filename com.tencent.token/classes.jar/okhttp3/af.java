package okhttp3;

import com.tencent.token.gn;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okio.f;

public final class af
{
  private static final char[] d = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  final String a;
  final String b;
  final int c;
  private final String e;
  private final String f;
  private final List g;
  @Nullable
  private final List h;
  @Nullable
  private final String i;
  private final String j;
  
  af(ag paramag)
  {
    this.a = paramag.a;
    this.e = a(paramag.b, false);
    this.f = a(paramag.c, false);
    this.b = paramag.d;
    this.c = paramag.a();
    this.g = a(paramag.f, false);
    if (paramag.g != null) {}
    for (Object localObject1 = a(paramag.g, true);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (paramag.h != null) {
        localObject1 = a(paramag.h, false);
      }
      this.i = ((String)localObject1);
      this.j = paramag.toString();
      return;
    }
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m < 32) || (m == 127) || ((m >= 128) && (paramBoolean4)) || (paramString2.indexOf(m) != -1) || ((m == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, k, paramInt2))))) || ((m == 43) && (paramBoolean3)))
      {
        f localf = new f();
        localf.a(paramString1, paramInt1, k);
        a(localf, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localf.o();
      }
      k += Character.charCount(m);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m == 37) || ((m == 43) && (paramBoolean)))
      {
        f localf = new f();
        localf.a(paramString, paramInt1, k);
        a(localf, paramString, k, paramInt2, paramBoolean);
        return localf.o();
      }
      k += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List a(List paramList, boolean paramBoolean)
  {
    int m = paramList.size();
    ArrayList localArrayList = new ArrayList(m);
    int k = 0;
    if (k < m)
    {
      String str = (String)paramList.get(k);
      if (str != null) {}
      for (str = a(str, paramBoolean);; str = null)
      {
        localArrayList.add(str);
        k += 1;
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(StringBuilder paramStringBuilder, List paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(k));
      k += 1;
    }
  }
  
  static void a(f paramf, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    Object localObject1 = null;
    if (paramInt1 < paramInt2)
    {
      int k = paramString1.codePointAt(paramInt1);
      Object localObject3;
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (k != 9)
        {
          localObject3 = localObject1;
          if (k != 10)
          {
            localObject3 = localObject1;
            if (k != 12)
            {
              if (k != 13) {
                break label79;
              }
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        localObject1 = localObject3;
        break;
        label79:
        Object localObject2;
        if ((k == 43) && (paramBoolean3))
        {
          if (paramBoolean1) {}
          for (localObject2 = "+";; localObject2 = "%2B")
          {
            paramf.a((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((k < 32) || (k == 127) || ((k >= 128) && (paramBoolean4)) || (paramString2.indexOf(k) != -1) || ((k == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, paramInt1, paramInt2))))))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new f();
          }
          if ((paramCharset == null) || (paramCharset.equals(gn.e))) {
            ((f)localObject2).a(k);
          }
          for (;;)
          {
            localObject3 = localObject2;
            if (((f)localObject2).e()) {
              break;
            }
            int m = ((f)localObject2).h() & 0xFF;
            paramf.b(37);
            paramf.b(d[(m >> 4 & 0xF)]);
            paramf.b(d[(m & 0xF)]);
            continue;
            ((f)localObject2).a(paramString1, paramInt1, Character.charCount(k) + paramInt1, paramCharset);
          }
        }
        paramf.a(k);
        localObject3 = localObject1;
      }
    }
  }
  
  static void a(f paramf, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < paramInt2)
    {
      int k = paramString.codePointAt(paramInt1);
      if ((k == 37) && (paramInt1 + 2 < paramInt2))
      {
        int m = gn.a(paramString.charAt(paramInt1 + 1));
        int n = gn.a(paramString.charAt(paramInt1 + 2));
        if ((m == -1) || (n == -1)) {
          break label111;
        }
        paramf.b((m << 4) + n);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        break;
        if ((k == 43) && (paramBoolean)) {
          paramf.b(32);
        } else {
          label111:
          paramf.a(k);
        }
      }
    }
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (gn.a(paramString.charAt(paramInt1 + 1)) != -1) && (gn.a(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k <= paramString.length())
    {
      int n = paramString.indexOf('&', k);
      int m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n == -1) || (n > m))
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
      for (;;)
      {
        k = m + 1;
        break;
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      String str1 = (String)paramList.get(k);
      String str2 = (String)paramList.get(k + 1);
      if (k > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      k += 2;
    }
  }
  
  public static af e(String paramString)
  {
    return new ag().a(null, paramString).c();
  }
  
  public URI a()
  {
    Object localObject = n().b().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject = URI.create(((String)localObject).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localURISyntaxException);
      }
    }
  }
  
  public String b()
  {
    return this.a;
  }
  
  @Nullable
  public af c(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.c();
    }
    return null;
  }
  
  public boolean c()
  {
    return this.a.equals("https");
  }
  
  public String d()
  {
    if (this.e.isEmpty()) {
      return "";
    }
    int k = this.a.length() + 3;
    int m = gn.a(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  @Nullable
  public ag d(String paramString)
  {
    try
    {
      paramString = new ag().a(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public String e()
  {
    if (this.f.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.a.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof af)) && (((af)paramObject).j.equals(this.j));
  }
  
  public String f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public String h()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = gn.a(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public List i()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = gn.a(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = gn.a(this.j, n, m, '/');
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  @Nullable
  public String j()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = gn.a(this.j, k, this.j.length(), '#');
    return this.j.substring(k, m);
  }
  
  @Nullable
  public String k()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public String l()
  {
    if (this.i == null) {
      return null;
    }
    int k = this.j.indexOf('#');
    return this.j.substring(k + 1);
  }
  
  public String m()
  {
    return d("/...").b("").c("").c().toString();
  }
  
  public ag n()
  {
    ag localag = new ag();
    localag.a = this.a;
    localag.b = d();
    localag.c = e();
    localag.d = this.b;
    if (this.c != a(this.a)) {}
    for (int k = this.c;; k = -1)
    {
      localag.e = k;
      localag.f.clear();
      localag.f.addAll(i());
      localag.e(j());
      localag.h = l();
      return localag;
    }
  }
  
  public String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.af
 * JD-Core Version:    0.7.0.1
 */