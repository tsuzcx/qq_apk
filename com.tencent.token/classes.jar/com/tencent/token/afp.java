package com.tencent.token;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class afp
{
  public static String[] a = { afg.a(afg.o), afg.a(afg.p), afg.a(afg.q), afg.a(afg.r), afg.a(afg.s), afg.a(afg.t), afg.a(afg.u), afg.a(afg.v), afg.a(afg.w), afg.a(afg.x), afg.a(afg.y), afg.a(afg.z), afg.a(afg.A), afg.a(afg.B), afg.a(afg.C), afg.a(afg.D), afg.a(afg.E), afg.a(afg.F), afg.a(afg.G), afg.a(afg.H), afg.a(afg.I) };
  
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
 * Qualified Name:     com.tencent.token.afp
 * JD-Core Version:    0.7.0.1
 */