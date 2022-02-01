package okhttp3;

import com.tencent.token.fb;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okio.c;

public final class s
{
  private static final char[] d = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  final String a;
  final String b;
  final int c;
  private final String e;
  private final String f;
  private final List<String> g;
  @Nullable
  private final List<String> h;
  @Nullable
  private final String i;
  private final String j;
  
  s(a parama)
  {
    this.a = parama.a;
    this.e = a(parama.b, false);
    this.f = a(parama.c, false);
    this.b = parama.d;
    this.c = parama.a();
    this.g = a(parama.f, false);
    if (parama.g != null) {}
    for (Object localObject1 = a(parama.g, true);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.h != null) {
        localObject1 = a(parama.h, false);
      }
      this.i = ((String)localObject1);
      this.j = parama.toString();
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
        c localc = new c();
        localc.a(paramString1, paramInt1, k);
        a(localc, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localc.o();
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
        c localc = new c();
        localc.a(paramString, paramInt1, k);
        a(localc, paramString, k, paramInt2, paramBoolean);
        return localc.o();
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
  
  private List<String> a(List<String> paramList, boolean paramBoolean)
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
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList)
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
  
  static void a(c paramc, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
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
            paramc.a((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((k < 32) || (k == 127) || ((k >= 128) && (paramBoolean4)) || (paramString2.indexOf(k) != -1) || ((k == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, paramInt1, paramInt2))))))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new c();
          }
          if ((paramCharset == null) || (paramCharset.equals(fb.e))) {
            ((c)localObject2).a(k);
          }
          for (;;)
          {
            localObject3 = localObject2;
            if (((c)localObject2).e()) {
              break;
            }
            int m = ((c)localObject2).h() & 0xFF;
            paramc.b(37);
            paramc.b(d[(m >> 4 & 0xF)]);
            paramc.b(d[(m & 0xF)]);
            continue;
            ((c)localObject2).a(paramString1, paramInt1, Character.charCount(k) + paramInt1, paramCharset);
          }
        }
        paramc.a(k);
        localObject3 = localObject1;
      }
    }
  }
  
  static void a(c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < paramInt2)
    {
      int k = paramString.codePointAt(paramInt1);
      if ((k == 37) && (paramInt1 + 2 < paramInt2))
      {
        int m = fb.a(paramString.charAt(paramInt1 + 1));
        int n = fb.a(paramString.charAt(paramInt1 + 2));
        if ((m == -1) || (n == -1)) {
          break label111;
        }
        paramc.b((m << 4) + n);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        break;
        if ((k == 43) && (paramBoolean)) {
          paramc.b(32);
        } else {
          label111:
          paramc.a(k);
        }
      }
    }
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (fb.a(paramString.charAt(paramInt1 + 1)) != -1) && (fb.a(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List<String> b(String paramString)
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
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList)
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
  
  public static s e(String paramString)
  {
    return new a().a(null, paramString).c();
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
  public s c(String paramString)
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
    int m = fb.a(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  @Nullable
  public a d(String paramString)
  {
    try
    {
      paramString = new a().a(this, paramString);
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
    return ((paramObject instanceof s)) && (((s)paramObject).j.equals(this.j));
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
    int m = fb.a(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public List<String> i()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = fb.a(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = fb.a(this.j, n, m, '/');
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
    int m = fb.a(this.j, k, this.j.length(), '#');
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
  
  public a n()
  {
    a locala = new a();
    locala.a = this.a;
    locala.b = d();
    locala.c = e();
    locala.d = this.b;
    if (this.c != a(this.a)) {}
    for (int k = this.c;; k = -1)
    {
      locala.e = k;
      locala.f.clear();
      locala.f.addAll(i());
      locala.e(j());
      locala.h = l();
      return locala;
    }
  }
  
  public String toString()
  {
    return this.j;
  }
  
  public static final class a
  {
    @Nullable
    String a;
    String b = "";
    String c = "";
    @Nullable
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    @Nullable
    List<String> g;
    @Nullable
    String h;
    
    public a()
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
        i = fb.a(paramString, paramInt1, paramInt2, "/\\");
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
      paramString = s.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
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
      return fb.a(s.a(paramString, paramInt1, paramInt2, false));
    }
    
    private static int f(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(s.a(paramString, paramInt1, paramInt2, "", false, false, false, true, null));
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
      return s.a(this.a);
    }
    
    public a a(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > 65535)) {
        throw new IllegalArgumentException("unexpected port: " + paramInt);
      }
      this.e = paramInt;
      return this;
    }
    
    public a a(String paramString)
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
    
    a a(@Nullable s params, String paramString)
    {
      int i = fb.a(paramString, 0, paramString.length());
      int i1 = fb.b(paramString, i, paramString.length());
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
          if ((m < 2) && (params != null) && (params.a.equals(this.a))) {
            break label765;
          }
          k = 0;
          j = 0;
          m = i + m;
          i = k;
          k = m;
          n = fb.a(paramString, k, i1, "@/\\?#");
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
          if (params != null)
          {
            this.a = params.a;
            break label64;
          }
          throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        }
      }
      if (i == 0)
      {
        m = fb.a(paramString, k, n, ':');
        String str = s.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        params = str;
        if (j != 0) {
          params = this.b + "%40" + str;
        }
        this.b = params;
        if (m != n)
        {
          i = 1;
          this.c = s.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        }
        j = 1;
      }
      for (;;)
      {
        m = n + 1;
        k = i;
        i = m;
        break;
        this.c = (this.c + "%40" + s.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
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
        this.e = s.a(this.a);
      }
      if (this.d == null) {
        throw new IllegalArgumentException("Invalid URL host: \"" + paramString.substring(k, i) + '"');
      }
      j = n;
      i = fb.a(paramString, j, i1, "?#");
      a(paramString, j, i);
      if ((i < i1) && (paramString.charAt(i) == '?'))
      {
        j = fb.a(paramString, i, i1, '#');
        this.g = s.b(s.a(paramString, i + 1, j, " \"'<>#", true, false, true, true, null));
        i = j;
      }
      for (;;)
      {
        if ((i < i1) && (paramString.charAt(i) == '#')) {
          this.h = s.a(paramString, i + 1, i1, "", true, false, false, false, null);
        }
        return this;
        label765:
        this.b = params.d();
        this.c = params.e();
        this.d = params.b;
        this.e = params.c;
        this.f.clear();
        this.f.addAll(params.i());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {
            break;
          }
        }
        e(params.j());
        j = i;
        break;
      }
    }
    
    a b()
    {
      int j = this.f.size();
      int i = 0;
      String str;
      while (i < j)
      {
        str = (String)this.f.get(i);
        this.f.set(i, s.a(str, "[]", true, true, false, true));
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
            this.g.set(i, s.a(str, "\\^`{|}", true, true, true, true));
          }
          i += 1;
        }
      }
      if (this.h != null) {
        this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
      }
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("username == null");
      }
      this.b = s.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    
    public a c(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("password == null");
      }
      this.c = s.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }
    
    public s c()
    {
      if (this.a == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.d == null) {
        throw new IllegalStateException("host == null");
      }
      return new s(this);
    }
    
    public a d(String paramString)
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
    
    public a e(@Nullable String paramString)
    {
      if (paramString != null) {}
      for (paramString = s.b(s.a(paramString, " \"'<>#", true, false, true, true));; paramString = null)
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
        if (i != s.a(this.a))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        s.a(localStringBuilder, this.f);
        if (this.g != null)
        {
          localStringBuilder.append('?');
          s.b(localStringBuilder, this.g);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.s
 * JD-Core Version:    0.7.0.1
 */