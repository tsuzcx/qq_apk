package com.tencent.turingfd.sdk.base;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  public static String[] a = { db.a(db.n), db.a(db.o), db.a(db.p), db.a(db.q), db.a(db.r), db.a(db.s), db.a(db.t), db.a(db.u), db.a(db.v), db.a(db.w), db.a(db.x), db.a(db.y), db.a(db.z), db.a(db.A), db.a(db.B), db.a(db.C), db.a(db.D), db.a(db.E) };
  
  public static Set a(Set paramSet)
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.m
 * JD-Core Version:    0.7.0.1
 */