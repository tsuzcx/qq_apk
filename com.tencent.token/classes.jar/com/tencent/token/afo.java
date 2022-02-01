package com.tencent.token;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class afo
{
  public static String[] a = { aff.a(aff.o), aff.a(aff.p), aff.a(aff.q), aff.a(aff.r), aff.a(aff.s), aff.a(aff.t), aff.a(aff.u), aff.a(aff.v), aff.a(aff.w), aff.a(aff.x), aff.a(aff.y), aff.a(aff.z), aff.a(aff.A), aff.a(aff.B), aff.a(aff.C), aff.a(aff.D), aff.a(aff.E), aff.a(aff.F), aff.a(aff.G), aff.a(aff.H), aff.a(aff.I) };
  
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
 * Qualified Name:     com.tencent.token.afo
 * JD-Core Version:    0.7.0.1
 */