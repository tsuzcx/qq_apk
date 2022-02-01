package com.tencent.token;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class acr
{
  public static String[] a;
  
  static
  {
    int[] arrayOfInt1 = afz.o;
    String str1 = afz.a(arrayOfInt1);
    int[] arrayOfInt2 = afz.p;
    String str2 = afz.a(arrayOfInt2);
    int[] arrayOfInt3 = afz.q;
    String str3 = afz.a(arrayOfInt3);
    int[] arrayOfInt4 = afz.r;
    String str4 = afz.a(arrayOfInt4);
    int[] arrayOfInt5 = afz.s;
    String str5 = afz.a(arrayOfInt5);
    int[] arrayOfInt6 = afz.t;
    String str6 = afz.a(arrayOfInt6);
    int[] arrayOfInt7 = afz.u;
    String str7 = afz.a(arrayOfInt7);
    int[] arrayOfInt8 = afz.v;
    String str8 = afz.a(arrayOfInt8);
    String str9 = afz.a(afz.w);
    int[] arrayOfInt9 = afz.x;
    String str10 = afz.a(arrayOfInt9);
    String str11 = afz.a(afz.y);
    String str12 = afz.a(afz.z);
    String str13 = afz.a(afz.A);
    String str14 = afz.a(afz.B);
    String str15 = afz.a(afz.C);
    String str16 = afz.a(afz.D);
    int[] arrayOfInt10 = afz.E;
    String str17 = afz.a(arrayOfInt10);
    int[] arrayOfInt11 = afz.F;
    String str18 = afz.a(arrayOfInt11);
    int[] arrayOfInt12 = afz.G;
    String str19 = afz.a(arrayOfInt12);
    int[] arrayOfInt13 = afz.H;
    String str20 = afz.a(arrayOfInt13);
    int[] arrayOfInt14 = afz.I;
    a = new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, afz.a(arrayOfInt14) };
    afz.a(arrayOfInt1);
    afz.a(arrayOfInt2);
    afz.a(arrayOfInt3);
    afz.a(arrayOfInt4);
    afz.a(arrayOfInt5);
    afz.a(arrayOfInt6);
    afz.a(arrayOfInt7);
    afz.a(arrayOfInt8);
    afz.a(arrayOfInt9);
    afz.a(arrayOfInt10);
    afz.a(arrayOfInt11);
    afz.a(arrayOfInt12);
    afz.a(arrayOfInt13);
    afz.a(arrayOfInt14);
  }
  
  public static Set<String> a(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    String[] arrayOfString = a;
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (Pattern.compile(arrayOfString[i]).matcher(str).find()) {
          localHashSet.add(str);
        }
        i += 1;
      }
    }
    paramSet.removeAll(localHashSet);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acr
 * JD-Core Version:    0.7.0.1
 */