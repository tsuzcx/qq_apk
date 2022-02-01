package com.tencent.token;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class ald
{
  private static final char[] e = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public final String a;
  public final String b;
  public final int c;
  @Nullable
  public final List<String> d;
  private final String f;
  private final String g;
  private final List<String> h;
  @Nullable
  private final String i;
  private final String j;
  
  ald(a parama)
  {
    this.a = parama.a;
    this.f = a(parama.b, false);
    this.g = a(parama.c, false);
    this.b = parama.d;
    this.c = parama.a();
    this.h = a(parama.f, false);
    Object localObject1 = parama.g;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = a(parama.g, true);
    } else {
      localObject1 = null;
    }
    this.d = ((List)localObject1);
    localObject1 = localObject2;
    if (parama.h != null) {
      localObject1 = a(parama.h, false);
    }
    this.i = ((String)localObject1);
    this.j = parama.toString();
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
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m >= 32) && (m != 127) && ((m < 128) || (!paramBoolean4)) && (paramString2.indexOf(m) == -1) && ((m != 37) || ((paramBoolean1) && ((!paramBoolean2) || (a(paramString1, k, paramInt2))))) && ((m != 43) || (!paramBoolean3)))
      {
        k += Character.charCount(m);
      }
      else
      {
        ant localant = new ant();
        localant.a(paramString1, paramInt1, k);
        Object localObject3;
        for (Object localObject1 = null; k < paramInt2; localObject1 = localObject3)
        {
          paramInt1 = paramString1.codePointAt(k);
          if (paramBoolean1)
          {
            localObject3 = localObject1;
            if (paramInt1 != 9)
            {
              localObject3 = localObject1;
              if (paramInt1 != 10)
              {
                localObject3 = localObject1;
                if (paramInt1 != 12)
                {
                  localObject3 = localObject1;
                  if (paramInt1 == 13) {}
                }
              }
            }
          }
          else
          {
            Object localObject2;
            if ((paramInt1 == 43) && (paramBoolean3))
            {
              if (paramBoolean1) {
                localObject2 = "+";
              } else {
                localObject2 = "%2B";
              }
              localant.a((String)localObject2);
              localObject3 = localObject1;
            }
            else if ((paramInt1 >= 32) && (paramInt1 != 127) && ((paramInt1 < 128) || (!paramBoolean4)) && (paramString2.indexOf(paramInt1) == -1) && ((paramInt1 != 37) || ((paramBoolean1) && ((!paramBoolean2) || (a(paramString1, k, paramInt2))))))
            {
              localant.a(paramInt1);
              localObject3 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ant();
              }
              ((ant)localObject2).a(paramInt1);
              for (;;)
              {
                localObject3 = localObject2;
                if (((ant)localObject2).c()) {
                  break;
                }
                m = ((ant)localObject2).f() & 0xFF;
                localant.b(37);
                localant.b(e[(m >> 4 & 0xF)]);
                localant.b(e[(m & 0xF)]);
              }
            }
          }
          k += Character.charCount(paramInt1);
        }
        return localant.m();
      }
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m != 37) && ((m != 43) || (!paramBoolean)))
      {
        k += 1;
      }
      else
      {
        ant localant = new ant();
        localant.a(paramString, paramInt1, k);
        a(localant, paramString, k, paramInt2, paramBoolean);
        return localant.m();
      }
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private static List<String> a(List<String> paramList, boolean paramBoolean)
  {
    int m = paramList.size();
    ArrayList localArrayList = new ArrayList(m);
    int k = 0;
    while (k < m)
    {
      String str = (String)paramList.get(k);
      if (str != null) {
        str = a(str, paramBoolean);
      } else {
        str = null;
      }
      localArrayList.add(str);
      k += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  private static void a(ant paramant, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int m = paramString.codePointAt(paramInt1);
      if (m == 37)
      {
        int k = paramInt1 + 2;
        if (k < paramInt2)
        {
          int n = alr.a(paramString.charAt(paramInt1 + 1));
          int i1 = alr.a(paramString.charAt(k));
          if ((n == -1) || (i1 == -1)) {
            break label105;
          }
          paramant.b((n << 4) + i1);
          paramInt1 = k;
          break label112;
        }
      }
      if ((m == 43) && (paramBoolean)) {
        paramant.b(32);
      } else {
        label105:
        paramant.a(m);
      }
      label112:
      paramInt1 += Character.charCount(m);
    }
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
  
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    int k = paramInt1 + 2;
    return (k < paramInt2) && (paramString.charAt(paramInt1) == '%') && (alr.a(paramString.charAt(paramInt1 + 1)) != -1) && (alr.a(paramString.charAt(k)) != -1);
  }
  
  static List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m;
    for (int k = 0; k <= paramString.length(); k = m + 1)
    {
      int n = paramString.indexOf('&', k);
      m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n != -1) && (n <= m))
      {
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
      else
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  public static void b(StringBuilder paramStringBuilder, List<String> paramList)
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
  
  public static ald d(String paramString)
  {
    return new a().a(null, paramString).b();
  }
  
  public final URI a()
  {
    Object localObject2 = new a();
    ((a)localObject2).a = this.a;
    ((a)localObject2).b = c();
    ((a)localObject2).c = d();
    ((a)localObject2).d = this.b;
    if (this.c != a(this.a)) {
      k = this.c;
    } else {
      k = -1;
    }
    ((a)localObject2).e = k;
    ((a)localObject2).f.clear();
    ((a)localObject2).f.addAll(f());
    ((a)localObject2).a(g());
    Object localObject1;
    if (this.i == null)
    {
      localObject1 = null;
    }
    else
    {
      k = this.j.indexOf('#');
      localObject1 = this.j.substring(k + 1);
    }
    ((a)localObject2).h = ((String)localObject1);
    int n = ((a)localObject2).f.size();
    int m = 0;
    int k = 0;
    while (k < n)
    {
      localObject1 = (String)((a)localObject2).f.get(k);
      ((a)localObject2).f.set(k, a((String)localObject1, "[]", true, true, false, true));
      k += 1;
    }
    if (((a)localObject2).g != null)
    {
      n = ((a)localObject2).g.size();
      k = m;
      while (k < n)
      {
        localObject1 = (String)((a)localObject2).g.get(k);
        if (localObject1 != null) {
          ((a)localObject2).g.set(k, a((String)localObject1, "\\^`{|}", true, true, true, true));
        }
        k += 1;
      }
    }
    if (((a)localObject2).h != null) {
      ((a)localObject2).h = a(((a)localObject2).h, " \"#<>\\^`{|}", true, true, false, false);
    }
    localObject2 = ((a)localObject2).toString();
    try
    {
      localObject1 = new URI((String)localObject2);
      return localObject1;
    }
    catch (URISyntaxException localURISyntaxException) {}
    try
    {
      localObject2 = URI.create(((String)localObject2).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
      return localObject2;
    }
    catch (Exception localException)
    {
      label366:
      break label366;
    }
    throw new RuntimeException(localURISyntaxException);
  }
  
  public final boolean b()
  {
    return this.a.equals("https");
  }
  
  @Nullable
  public final a c(String paramString)
  {
    try
    {
      paramString = new a().a(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public final String c()
  {
    if (this.f.isEmpty()) {
      return "";
    }
    int k = this.a.length() + 3;
    String str = this.j;
    int m = alr.a(str, k, str.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public final String d()
  {
    if (this.g.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.a.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public final String e()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    String str = this.j;
    int m = alr.a(str, k, str.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ald)) && (((ald)paramObject).j.equals(this.j));
  }
  
  public final List<String> f()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    Object localObject = this.j;
    int m = alr.a((String)localObject, k, ((String)localObject).length(), "?#");
    localObject = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = alr.a(this.j, n, m, '/');
      ((List)localObject).add(this.j.substring(n, k));
    }
    return localObject;
  }
  
  @Nullable
  public final String g()
  {
    if (this.d == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    String str = this.j;
    int m = alr.a(str, k, str.length(), '#');
    return this.j.substring(k, m);
  }
  
  public final int hashCode()
  {
    return this.j.hashCode();
  }
  
  public final String toString()
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
    
    static String a(String paramString, int paramInt1, int paramInt2)
    {
      return alr.a(ald.a(paramString, paramInt1, paramInt2, false));
    }
    
    private void b(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      Object localObject;
      if ((i != 47) && (i != 92))
      {
        localObject = this.f;
        ((List)localObject).set(((List)localObject).size() - 1, "");
      }
      else
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
      }
      while (paramInt1 < paramInt2)
      {
        int j = alr.a(paramString, paramInt1, paramInt2, "/\\");
        int k = 0;
        if (j < paramInt2) {
          i = 1;
        } else {
          i = 0;
        }
        localObject = ald.a(paramString, paramInt1, j, " \"<>^`{}|/\\?#", true, false, false, true);
        if ((!((String)localObject).equals(".")) && (!((String)localObject).equalsIgnoreCase("%2e"))) {
          paramInt1 = 0;
        } else {
          paramInt1 = 1;
        }
        if (paramInt1 == 0)
        {
          if ((!((String)localObject).equals("..")) && (!((String)localObject).equalsIgnoreCase("%2e.")) && (!((String)localObject).equalsIgnoreCase(".%2e")))
          {
            paramInt1 = k;
            if (!((String)localObject).equalsIgnoreCase("%2e%2e")) {}
          }
          else
          {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            localObject = this.f;
            if ((((String)((List)localObject).remove(((List)localObject).size() - 1)).isEmpty()) && (!this.f.isEmpty()))
            {
              localObject = this.f;
              ((List)localObject).set(((List)localObject).size() - 1, "");
            }
            else
            {
              this.f.add("");
            }
          }
          else
          {
            List localList = this.f;
            if (((String)localList.get(localList.size() - 1)).isEmpty())
            {
              localList = this.f;
              localList.set(localList.size() - 1, localObject);
            }
            else
            {
              this.f.add(localObject);
            }
            if (i != 0) {
              this.f.add("");
            }
          }
        }
        paramInt1 = j;
        if (i != 0) {
          paramInt1 = j + 1;
        }
      }
    }
    
    private static int c(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {
        return -1;
      }
      int j = paramString.charAt(paramInt1);
      int i;
      if (j >= 97)
      {
        i = paramInt1;
        if (j <= 122) {}
      }
      else
      {
        if (j < 65) {
          break label154;
        }
        i = paramInt1;
        if (j > 90) {
          return -1;
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  paramInt1 = i + 1;
                  if (paramInt1 >= paramInt2) {
                    break label152;
                  }
                  j = paramString.charAt(paramInt1);
                  if (j < 97) {
                    break;
                  }
                  i = paramInt1;
                } while (j <= 122);
                if (j < 65) {
                  break;
                }
                i = paramInt1;
              } while (j <= 90);
              if (j < 48) {
                break;
              }
              i = paramInt1;
            } while (j <= 57);
            i = paramInt1;
          } while (j == 43);
          i = paramInt1;
        } while (j == 45);
        i = paramInt1;
      } while (j == 46);
      if (j == 58) {
        return paramInt1;
      }
      return -1;
      label152:
      return -1;
      label154:
      return -1;
    }
    
    private static int d(String paramString, int paramInt1, int paramInt2)
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
    
    private static int e(String paramString, int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if (j != 58)
        {
          int i = paramInt1;
          if (j != 91)
          {
            i = paramInt1;
          }
          else
          {
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
          paramInt1 = i + 1;
        }
        else
        {
          return paramInt1;
        }
      }
      return paramInt2;
    }
    
    private static int f(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(ald.a(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    final int a()
    {
      int i = this.e;
      if (i != -1) {
        return i;
      }
      return ald.a(this.a);
    }
    
    final a a(@Nullable ald paramald, String paramString)
    {
      int i = alr.a(paramString, 0, paramString.length());
      int i1 = alr.b(paramString, i, paramString.length());
      int j = c(paramString, i, i1);
      if (j != -1)
      {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.a = "https";
          i += 6;
        }
        else if (paramString.regionMatches(true, i, "http:", 0, 5))
        {
          this.a = "http";
          i += 5;
        }
        else
        {
          paramald = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
          paramald.append(paramString.substring(0, j));
          paramald.append("'");
          throw new IllegalArgumentException(paramald.toString());
        }
      }
      else
      {
        if (paramald == null) {
          break label829;
        }
        this.a = paramald.a;
      }
      j = d(paramString, i, i1);
      if ((j < 2) && (paramald != null) && (paramald.a.equals(this.a)))
      {
        this.b = paramald.c();
        this.c = paramald.d();
        this.d = paramald.b;
        this.e = paramald.c;
        this.f.clear();
        this.f.addAll(paramald.f());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {}
        }
        else
        {
          a(paramald.g());
          j = i;
        }
      }
      else
      {
        k = i + j;
        i = 0;
        int m = 0;
        for (;;)
        {
          j = alr.a(paramString, k, i1, "@/\\?#");
          int n;
          if (j != i1) {
            n = paramString.charAt(j);
          } else {
            n = -1;
          }
          if ((n == -1) || (n == 35) || (n == 47) || (n == 92)) {
            break;
          }
          switch (n)
          {
          default: 
            break;
          case 64: 
            if (i == 0)
            {
              int i2 = alr.a(paramString, k, j, ':');
              n = j;
              String str = ald.a(paramString, k, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
              paramald = str;
              if (m != 0)
              {
                paramald = new StringBuilder();
                paramald.append(this.b);
                paramald.append("%40");
                paramald.append(str);
                paramald = paramald.toString();
              }
              this.b = paramald;
              if (i2 != n)
              {
                this.c = ald.a(paramString, i2 + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                i = 1;
              }
              m = 1;
            }
            else
            {
              paramald = new StringBuilder();
              paramald.append(this.c);
              paramald.append("%40");
              paramald.append(ald.a(paramString, k, j, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
              this.c = paramald.toString();
            }
            k = j + 1;
          }
        }
        i = e(paramString, k, j);
        m = i + 1;
        if (m < j)
        {
          this.d = a(paramString, k, i);
          this.e = f(paramString, m, j);
          if (this.e == -1)
          {
            paramald = new StringBuilder("Invalid URL port: \"");
            paramald.append(paramString.substring(m, j));
            paramald.append('"');
            throw new IllegalArgumentException(paramald.toString());
          }
        }
        else
        {
          this.d = a(paramString, k, i);
          this.e = ald.a(this.a);
        }
        if (this.d == null) {
          break label788;
        }
      }
      int k = alr.a(paramString, j, i1, "?#");
      b(paramString, j, k);
      i = k;
      if (k < i1)
      {
        i = k;
        if (paramString.charAt(k) == '?')
        {
          i = alr.a(paramString, k, i1, '#');
          this.g = ald.b(ald.a(paramString, k + 1, i, " \"'<>#", true, false, true, true));
        }
      }
      if ((i < i1) && (paramString.charAt(i) == '#')) {
        this.h = ald.a(paramString, 1 + i, i1, "", true, false, false, false);
      }
      return this;
      label788:
      paramald = new StringBuilder("Invalid URL host: \"");
      paramald.append(paramString.substring(k, i));
      paramald.append('"');
      throw new IllegalArgumentException(paramald.toString());
      label829:
      throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    }
    
    public final a a(@Nullable String paramString)
    {
      if (paramString != null) {
        paramString = ald.b(ald.a(paramString, " \"'<>#", true, false, true, true));
      } else {
        paramString = null;
      }
      this.g = paramString;
      return this;
    }
    
    public final ald b()
    {
      if (this.a != null)
      {
        if (this.d != null) {
          return new ald(this);
        }
        throw new IllegalStateException("host == null");
      }
      throw new IllegalStateException("scheme == null");
    }
    
    public final String toString()
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
      else
      {
        localStringBuilder.append(this.d);
      }
      int i = a();
      if (i != ald.a(this.a))
      {
        localStringBuilder.append(':');
        localStringBuilder.append(i);
      }
      ald.a(localStringBuilder, this.f);
      if (this.g != null)
      {
        localStringBuilder.append('?');
        ald.b(localStringBuilder, this.g);
      }
      if (this.h != null)
      {
        localStringBuilder.append('#');
        localStringBuilder.append(this.h);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ald
 * JD-Core Version:    0.7.0.1
 */