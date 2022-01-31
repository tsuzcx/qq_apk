package okhttp3;

import com.tencent.token.gn;
import com.tencent.token.he;
import com.tencent.token.ii;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class s
{
  private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private final String e;
  private final String f;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  private s(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      int n = paramInt2;
      if (paramInt1 < paramInt2)
      {
        n = paramString.charAt(paramInt1);
        if (((n >= 32) || (n == 9)) && (n < 127) && ((n < 48) || (n > 57)) && ((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 58)) {
          break label108;
        }
        n = 1;
        if (paramBoolean) {
          break label114;
        }
      }
      label108:
      label114:
      for (int i1 = 1;; i1 = 0)
      {
        if (n != i1) {
          break label120;
        }
        n = paramInt1;
        return n;
        n = 0;
        break;
      }
      label120:
      paramInt1 += 1;
    }
  }
  
  private static long a(String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      if (l1 > 0L) {
        break label15;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label15:
      while (paramString.matches("-?\\d+")) {
        if (!paramString.startsWith("-")) {
          return 9223372036854775807L;
        }
      }
      throw localNumberFormatException;
    }
    return -9223372036854775808L;
    return l1;
  }
  
  private static long a(String paramString, int paramInt1, int paramInt2)
  {
    int i5 = a(paramString, paramInt1, paramInt2, false);
    int n = -1;
    int i2 = -1;
    int i4 = -1;
    int i1 = -1;
    int i3 = -1;
    paramInt1 = -1;
    Matcher localMatcher = d.matcher(paramString);
    if (i5 < paramInt2)
    {
      int i11 = a(paramString, i5 + 1, paramInt2, true);
      localMatcher.region(i5, i11);
      int i6;
      int i8;
      int i10;
      int i9;
      int i7;
      if ((n == -1) && (localMatcher.usePattern(d).matches()))
      {
        i6 = Integer.parseInt(localMatcher.group(1));
        i8 = Integer.parseInt(localMatcher.group(2));
        i10 = Integer.parseInt(localMatcher.group(3));
        i9 = i1;
        i7 = i3;
        i5 = paramInt1;
      }
      for (;;)
      {
        i11 = a(paramString, i11 + 1, paramInt2, false);
        paramInt1 = i5;
        i3 = i7;
        i1 = i9;
        i4 = i10;
        i2 = i8;
        n = i6;
        i5 = i11;
        break;
        if ((i1 == -1) && (localMatcher.usePattern(c).matches()))
        {
          i9 = Integer.parseInt(localMatcher.group(1));
          i5 = paramInt1;
          i7 = i3;
          i10 = i4;
          i8 = i2;
          i6 = n;
        }
        else if ((i3 == -1) && (localMatcher.usePattern(b).matches()))
        {
          String str = localMatcher.group(1).toLowerCase(Locale.US);
          i7 = b.pattern().indexOf(str) / 4;
          i5 = paramInt1;
          i9 = i1;
          i10 = i4;
          i8 = i2;
          i6 = n;
        }
        else
        {
          i5 = paramInt1;
          i7 = i3;
          i9 = i1;
          i10 = i4;
          i8 = i2;
          i6 = n;
          if (paramInt1 == -1)
          {
            i5 = paramInt1;
            i7 = i3;
            i9 = i1;
            i10 = i4;
            i8 = i2;
            i6 = n;
            if (localMatcher.usePattern(a).matches())
            {
              i5 = Integer.parseInt(localMatcher.group(1));
              i7 = i3;
              i9 = i1;
              i10 = i4;
              i8 = i2;
              i6 = n;
            }
          }
        }
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 < 1601) {
      throw new IllegalArgumentException();
    }
    if (i3 == -1) {
      throw new IllegalArgumentException();
    }
    if ((i1 < 1) || (i1 > 31)) {
      throw new IllegalArgumentException();
    }
    if ((n < 0) || (n > 23)) {
      throw new IllegalArgumentException();
    }
    if ((i2 < 0) || (i2 > 59)) {
      throw new IllegalArgumentException();
    }
    if ((i4 < 0) || (i4 > 59)) {
      throw new IllegalArgumentException();
    }
    paramString = new GregorianCalendar(gn.g);
    paramString.setLenient(false);
    paramString.set(1, paramInt1);
    paramString.set(2, i3 - 1);
    paramString.set(5, i1);
    paramString.set(11, n);
    paramString.set(12, i2);
    paramString.set(13, i4);
    paramString.set(14, 0);
    return paramString.getTimeInMillis();
  }
  
  public static List a(af paramaf, ad paramad)
  {
    List localList = paramad.b("Set-Cookie");
    paramad = null;
    int i1 = localList.size();
    int n = 0;
    s locals;
    while (n < i1)
    {
      locals = a(paramaf, (String)localList.get(n));
      if (locals == null)
      {
        n += 1;
      }
      else
      {
        if (paramad != null) {
          break label91;
        }
        paramad = new ArrayList();
      }
    }
    label91:
    for (;;)
    {
      paramad.add(locals);
      break;
      if (paramad != null) {
        return Collections.unmodifiableList(paramad);
      }
      return Collections.emptyList();
    }
  }
  
  @Nullable
  static s a(long paramLong, af paramaf, String paramString)
  {
    int i1 = paramString.length();
    int n = gn.a(paramString, 0, i1, ';');
    int i2 = gn.a(paramString, 0, n, '=');
    if (i2 == n) {
      return null;
    }
    String str4 = gn.c(paramString, 0, i2);
    if ((str4.isEmpty()) || (gn.b(str4) != -1)) {
      return null;
    }
    String str5 = gn.c(paramString, i2 + 1, n);
    if (gn.b(str5) != -1) {
      return null;
    }
    long l1 = 253402300799999L;
    long l2 = -1L;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = true;
    boolean bool1 = false;
    n += 1;
    String str6;
    String str1;
    if (n < i1)
    {
      i2 = gn.a(paramString, n, i1, ';');
      int i3 = gn.a(paramString, n, i2, '=');
      str6 = gn.c(paramString, n, i3);
      if (i3 < i2)
      {
        str1 = gn.c(paramString, i3 + 1, i2);
        label182:
        if (!str6.equalsIgnoreCase("expires")) {
          break label233;
        }
      }
    }
    label556:
    for (;;)
    {
      long l3;
      try
      {
        l3 = a(str1, 0, str1.length());
        bool1 = true;
        l1 = l3;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        continue;
      }
      n = i2 + 1;
      break;
      str1 = "";
      break label182;
      label233:
      if (str6.equalsIgnoreCase("max-age"))
      {
        try
        {
          l3 = a(localIllegalArgumentException1);
          l2 = l3;
          bool1 = true;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
      else if (str6.equalsIgnoreCase("domain"))
      {
        try
        {
          String str2 = b(localNumberFormatException);
          localObject1 = str2;
          bool2 = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException2) {}
      }
      else if (str6.equalsIgnoreCase("path"))
      {
        localObject2 = localIllegalArgumentException2;
      }
      else if (str6.equalsIgnoreCase("secure"))
      {
        bool4 = true;
      }
      else if (str6.equalsIgnoreCase("httponly"))
      {
        bool3 = true;
        continue;
        if (l2 == -9223372036854775808L) {
          paramLong = -9223372036854775808L;
        }
        for (;;)
        {
          String str3 = paramaf.f();
          if (localObject1 == null) {
            paramString = str3;
          }
          for (;;)
          {
            if ((str3.length() != paramString.length()) && (ii.a().a(paramString) == null))
            {
              return null;
              if (l2 == -1L) {
                break label556;
              }
              if (l2 <= 9223372036854775L) {}
              for (l1 = l2 * 1000L;; l1 = 9223372036854775807L)
              {
                l1 += paramLong;
                if (l1 >= paramLong)
                {
                  paramLong = l1;
                  if (l1 <= 253402300799999L) {
                    break;
                  }
                }
                paramLong = 253402300799999L;
                break;
              }
              paramString = localObject1;
              if (!a(str3, localObject1)) {
                return null;
              }
            }
          }
          if ((localObject2 == null) || (!localObject2.startsWith("/")))
          {
            paramaf = paramaf.h();
            n = paramaf.lastIndexOf('/');
            if (n != 0) {
              paramaf = paramaf.substring(0, n);
            }
          }
          for (;;)
          {
            return new s(str4, str5, paramLong, paramString, paramaf, bool4, bool3, bool2, bool1);
            paramaf = "/";
            continue;
            paramaf = localObject2;
          }
          paramLong = l1;
        }
      }
    }
  }
  
  @Nullable
  public static s a(af paramaf, String paramString)
  {
    return a(System.currentTimeMillis(), paramaf, paramString);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {}
    while ((paramString1.endsWith(paramString2)) && (paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.') && (!gn.c(paramString1))) {
      return true;
    }
    return false;
  }
  
  private static String b(String paramString)
  {
    if (paramString.endsWith(".")) {
      throw new IllegalArgumentException();
    }
    String str = paramString;
    if (paramString.startsWith(".")) {
      str = paramString.substring(1);
    }
    paramString = gn.a(str);
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    return paramString;
  }
  
  public String a()
  {
    return this.e;
  }
  
  String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('=');
    localStringBuilder.append(this.f);
    if (this.l)
    {
      if (this.g != -9223372036854775808L) {
        break label145;
      }
      localStringBuilder.append("; max-age=0");
    }
    for (;;)
    {
      if (!this.m)
      {
        localStringBuilder.append("; domain=");
        if (paramBoolean) {
          localStringBuilder.append(".");
        }
        localStringBuilder.append(this.h);
      }
      localStringBuilder.append("; path=").append(this.i);
      if (this.j) {
        localStringBuilder.append("; secure");
      }
      if (this.k) {
        localStringBuilder.append("; httponly");
      }
      return localStringBuilder.toString();
      label145:
      localStringBuilder.append("; expires=").append(he.a(new Date(this.g)));
    }
  }
  
  public String b()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof s)) {}
    do
    {
      return false;
      paramObject = (s)paramObject;
    } while ((!paramObject.e.equals(this.e)) || (!paramObject.f.equals(this.f)) || (!paramObject.h.equals(this.h)) || (!paramObject.i.equals(this.i)) || (paramObject.g != this.g) || (paramObject.j != this.j) || (paramObject.k != this.k) || (paramObject.l != this.l) || (paramObject.m != this.m));
    return true;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = this.e.hashCode();
    int i5 = this.f.hashCode();
    int i6 = this.h.hashCode();
    int i7 = this.i.hashCode();
    int i8 = (int)(this.g ^ this.g >>> 32);
    int n;
    int i1;
    label72:
    int i2;
    if (this.j)
    {
      n = 0;
      if (!this.k) {
        break label145;
      }
      i1 = 0;
      if (!this.l) {
        break label150;
      }
      i2 = 0;
      label81:
      if (!this.m) {
        break label155;
      }
    }
    for (;;)
    {
      return (i2 + (i1 + (n + (((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i3;
      n = 1;
      break;
      label145:
      i1 = 1;
      break label72;
      label150:
      i2 = 1;
      break label81;
      label155:
      i3 = 1;
    }
  }
  
  public String toString()
  {
    return a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.s
 * JD-Core Version:    0.7.0.1
 */