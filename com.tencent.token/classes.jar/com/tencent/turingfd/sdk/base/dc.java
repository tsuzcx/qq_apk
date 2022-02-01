package com.tencent.turingfd.sdk.base;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dc
{
  public static String[] a = { ct.a(ct.o), ct.a(ct.p), ct.a(ct.q), ct.a(ct.r), ct.a(ct.s), ct.a(ct.t), ct.a(ct.u), ct.a(ct.v), ct.a(ct.w), ct.a(ct.x), ct.a(ct.y), ct.a(ct.z), ct.a(ct.A), ct.a(ct.B), ct.a(ct.C), ct.a(ct.D), ct.a(ct.E), ct.a(ct.F), ct.a(ct.G), ct.a(ct.H), ct.a(ct.I) };
  
  public static Set<String> a(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = a;
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.dc
 * JD-Core Version:    0.7.0.1
 */