package com.tencent.token;

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
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class aib
{
  private static final Pattern c = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern e = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  public final String a;
  public final String b;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  private aib(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString1;
    this.b = paramString2;
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
    while (paramInt1 < paramInt2)
    {
      int n = paramString.charAt(paramInt1);
      if (((n >= 32) || (n == 9)) && (n < 127) && ((n < 48) || (n > 57)) && ((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 58)) {
        n = 0;
      } else {
        n = 1;
      }
      if (n == (paramBoolean ^ true)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      if (l1 <= 0L) {
        return -9223372036854775808L;
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-")) {
          return -9223372036854775808L;
        }
        return 9223372036854775807L;
      }
      throw localNumberFormatException;
    }
  }
  
  @Nullable
  private static aib a(long paramLong, aii paramaii, String paramString)
  {
    int i7 = paramString.length();
    int n = aiw.a(paramString, 0, i7, ';');
    int i1 = aiw.a(paramString, 0, n, '=');
    localObject4 = null;
    if (i1 == n) {
      return null;
    }
    String str1 = aiw.c(paramString, 0, i1);
    if ((!str1.isEmpty()) && (aiw.b(str1) == -1))
    {
      String str2 = aiw.c(paramString, i1 + 1, n);
      if (aiw.b(str2) != -1) {
        return null;
      }
      n += 1;
      localObject3 = null;
      l2 = -1L;
      bool4 = false;
      l1 = 253402300799999L;
      boolean bool5 = false;
      bool2 = true;
      for (bool3 = false; n < i7; bool3 = bool1)
      {
        int i8 = aiw.a(paramString, n, i7, ';');
        i1 = aiw.a(paramString, n, i8, '=');
        String str3 = aiw.c(paramString, n, i1);
        if (i1 < i8) {
          localObject1 = aiw.c(paramString, i1 + 1, i8);
        } else {
          localObject1 = "";
        }
        if (str3.equalsIgnoreCase("expires"))
        {
          for (;;)
          {
            try
            {
              i9 = ((String)localObject1).length();
              i2 = a((String)localObject1, 0, i9, false);
              localObject5 = f.matcher((CharSequence)localObject1);
              i6 = -1;
              i4 = -1;
              i1 = -1;
              n = -1;
              i5 = -1;
              i3 = -1;
              if (i2 >= i9) {
                continue;
              }
              i10 = a((String)localObject1, i2 + 1, i9, true);
              ((Matcher)localObject5).region(i2, i10);
              if ((i6 == -1) && (((Matcher)localObject5).usePattern(f).matches()))
              {
                i6 = Integer.parseInt(((Matcher)localObject5).group(1));
                i5 = Integer.parseInt(((Matcher)localObject5).group(2));
                i3 = Integer.parseInt(((Matcher)localObject5).group(3));
              }
              else if (n == -1)
              {
                if (!((Matcher)localObject5).usePattern(e).matches()) {
                  continue;
                }
                n = Integer.parseInt(((Matcher)localObject5).group(1));
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException1)
            {
              int i9;
              int i2;
              Object localObject5;
              int i6;
              int i4;
              int i5;
              int i3;
              int i10;
              long l4;
              boolean bool1;
              long l3;
              boolean bool6;
              boolean bool7;
              continue;
              Object localObject2;
              continue;
              continue;
              continue;
              continue;
            }
            if (i4 == -1)
            {
              if (!((Matcher)localObject5).usePattern(d).matches()) {
                continue;
              }
              str3 = ((Matcher)localObject5).group(1).toLowerCase(Locale.US);
              i4 = d.pattern().indexOf(str3) / 4;
            }
            else
            {
              if ((i1 != -1) || (!((Matcher)localObject5).usePattern(c).matches())) {
                continue;
              }
              i1 = Integer.parseInt(((Matcher)localObject5).group(1));
            }
            i2 = a((String)localObject1, i10 + 1, i9, false);
          }
          i2 = i1;
          if (i1 >= 70)
          {
            i2 = i1;
            if (i1 <= 99) {
              i2 = i1 + 1900;
            }
          }
          i1 = i2;
          if (i2 >= 0)
          {
            i1 = i2;
            if (i2 <= 69) {
              i1 = i2 + 2000;
            }
          }
          if (i1 >= 1601) {
            if (i4 != -1) {
              if ((n > 0) && (n <= 31)) {
                if ((i6 >= 0) && (i6 <= 23))
                {
                  if (i5 < 0) {
                    break label1446;
                  }
                  if ((i5 <= 59) && ((i3 < 0) || (i3 > 59))) {}
                }
              }
            }
          }
        }
        try
        {
          localObject1 = new GregorianCalendar(aiw.g);
          ((Calendar)localObject1).setLenient(false);
          ((Calendar)localObject1).set(1, i1);
          ((Calendar)localObject1).set(2, i4 - 1);
          ((Calendar)localObject1).set(5, n);
          ((Calendar)localObject1).set(11, i6);
          ((Calendar)localObject1).set(12, i5);
          ((Calendar)localObject1).set(13, i3);
          ((Calendar)localObject1).set(14, 0);
          l4 = ((Calendar)localObject1).getTimeInMillis();
          bool1 = true;
          localObject1 = localObject4;
          l3 = l2;
          bool6 = bool4;
          localObject5 = localObject3;
          bool7 = bool2;
        }
        catch (IllegalArgumentException|NumberFormatException localIllegalArgumentException2)
        {
          for (;;)
          {
            localObject2 = localObject4;
            l3 = l2;
            bool6 = bool4;
            localObject5 = localObject3;
            l4 = l1;
            bool7 = bool2;
            bool1 = bool3;
          }
        }
        throw new IllegalArgumentException();
        throw new IllegalArgumentException();
        throw new IllegalArgumentException();
        throw new IllegalArgumentException();
        throw new IllegalArgumentException();
        throw new IllegalArgumentException();
        localObject1 = localObject4;
        l3 = l2;
        bool6 = bool4;
        localObject5 = localObject3;
        l4 = l1;
        bool7 = bool2;
        bool1 = bool3;
        break label1070;
        if (str3.equalsIgnoreCase("max-age"))
        {
          l3 = a((String)localObject1);
          bool1 = true;
          localObject1 = localObject4;
          bool6 = bool4;
          localObject5 = localObject3;
          l4 = l1;
          bool7 = bool2;
        }
        else if (str3.equalsIgnoreCase("domain"))
        {
          if (!((String)localObject1).endsWith("."))
          {
            localObject5 = localObject1;
            if (((String)localObject1).startsWith(".")) {
              localObject5 = ((String)localObject1).substring(1);
            }
            localObject1 = aiw.a((String)localObject5);
            if (localObject1 != null)
            {
              bool7 = false;
              l3 = l2;
              bool6 = bool4;
              localObject5 = localObject3;
              l4 = l1;
              bool1 = bool3;
            }
            else
            {
              throw new IllegalArgumentException();
            }
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else if (str3.equalsIgnoreCase("path"))
        {
          localObject5 = localObject1;
          localObject1 = localObject4;
          l3 = l2;
          bool6 = bool4;
          l4 = l1;
          bool7 = bool2;
          bool1 = bool3;
        }
        else if (str3.equalsIgnoreCase("secure"))
        {
          bool6 = true;
          localObject1 = localObject4;
          l3 = l2;
          localObject5 = localObject3;
          l4 = l1;
          bool7 = bool2;
          bool1 = bool3;
        }
        else
        {
          localObject1 = localObject4;
          l3 = l2;
          bool6 = bool4;
          localObject5 = localObject3;
          l4 = l1;
          bool7 = bool2;
          bool1 = bool3;
          if (str3.equalsIgnoreCase("httponly"))
          {
            bool5 = true;
            bool1 = bool3;
            bool7 = bool2;
            l4 = l1;
            localObject5 = localObject3;
            bool6 = bool4;
            l3 = l2;
            localObject1 = localObject4;
          }
        }
        label1070:
        n = i8 + 1;
        localObject4 = localObject1;
        l2 = l3;
        bool4 = bool6;
        localObject3 = localObject5;
        l1 = l4;
        bool2 = bool7;
      }
      if (l2 == -9223372036854775808L)
      {
        paramLong = -9223372036854775808L;
      }
      else if (l2 != -1L)
      {
        if (l2 <= 9223372036854775L) {
          l1 = l2 * 1000L;
        } else {
          l1 = 9223372036854775807L;
        }
        l1 = paramLong + l1;
        if ((l1 >= paramLong) && (l1 <= 253402300799999L)) {
          paramLong = l1;
        } else {
          paramLong = 253402300799999L;
        }
      }
      else
      {
        paramLong = l1;
      }
      Object localObject1 = paramaii.b;
      if (localObject4 == null)
      {
        paramString = (String)localObject1;
      }
      else
      {
        if (((String)localObject1).equals(localObject4)) {
          n = 1;
        } else if ((((String)localObject1).endsWith(localObject4)) && (((String)localObject1).charAt(((String)localObject1).length() - localObject4.length() - 1) == '.') && (!aiw.c((String)localObject1))) {
          n = 1;
        } else {
          n = 0;
        }
        if (n == 0) {
          return null;
        }
        paramString = localObject4;
      }
      if (((String)localObject1).length() != paramString.length()) {
        if (PublicSuffixDatabase.a().a(paramString) == null) {
          return null;
        }
      }
      if ((localObject3 != null) && (localObject3.startsWith("/")))
      {
        paramaii = localObject3;
      }
      else
      {
        paramaii = paramaii.e();
        n = paramaii.lastIndexOf('/');
        if (n != 0) {
          paramaii = paramaii.substring(0, n);
        } else {
          paramaii = "/";
        }
      }
      return new aib(str1, str2, paramLong, paramString, paramaii, bool4, bool5, bool2, bool3);
    }
    else
    {
      return null;
    }
  }
  
  public static List<aib> a(aii paramaii, aih paramaih)
  {
    int i2 = paramaih.a.length / 2;
    int i1 = 0;
    aib localaib = null;
    Object localObject1 = null;
    int n = 0;
    Object localObject2;
    while (n < i2)
    {
      localObject2 = localObject1;
      if ("Set-Cookie".equalsIgnoreCase(paramaih.a(n)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(paramaih.b(n));
      }
      n += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      localObject2 = Collections.unmodifiableList((List)localObject1);
    } else {
      localObject2 = Collections.emptyList();
    }
    i2 = ((List)localObject2).size();
    paramaih = localaib;
    n = i1;
    while (n < i2)
    {
      localObject1 = (String)((List)localObject2).get(n);
      localaib = a(System.currentTimeMillis(), paramaii, (String)localObject1);
      localObject1 = paramaih;
      if (localaib != null)
      {
        localObject1 = paramaih;
        if (paramaih == null) {
          localObject1 = new ArrayList();
        }
        ((List)localObject1).add(localaib);
      }
      n += 1;
      paramaih = (aih)localObject1;
    }
    if (paramaih != null) {
      return Collections.unmodifiableList(paramaih);
    }
    return Collections.emptyList();
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof aib)) {
      return false;
    }
    paramObject = (aib)paramObject;
    return (paramObject.a.equals(this.a)) && (paramObject.b.equals(this.b)) && (paramObject.h.equals(this.h)) && (paramObject.i.equals(this.i)) && (paramObject.g == this.g) && (paramObject.j == this.j) && (paramObject.k == this.k) && (paramObject.l == this.l) && (paramObject.m == this.m);
  }
  
  public final int hashCode()
  {
    int n = this.a.hashCode();
    int i1 = this.b.hashCode();
    int i2 = this.h.hashCode();
    int i3 = this.i.hashCode();
    long l1 = this.g;
    return ((((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + (int)(l1 ^ l1 >>> 32)) * 31 + (this.j ^ true)) * 31 + (this.k ^ true)) * 31 + (this.l ^ true)) * 31 + (this.m ^ true);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append('=');
    localStringBuilder.append(this.b);
    if (this.l) {
      if (this.g == -9223372036854775808L)
      {
        localStringBuilder.append("; max-age=0");
      }
      else
      {
        localStringBuilder.append("; expires=");
        localStringBuilder.append(ajm.a(new Date(this.g)));
      }
    }
    if (!this.m)
    {
      localStringBuilder.append("; domain=");
      localStringBuilder.append(this.h);
    }
    localStringBuilder.append("; path=");
    localStringBuilder.append(this.i);
    if (this.j) {
      localStringBuilder.append("; secure");
    }
    if (this.k) {
      localStringBuilder.append("; httponly");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aib
 * JD-Core Version:    0.7.0.1
 */