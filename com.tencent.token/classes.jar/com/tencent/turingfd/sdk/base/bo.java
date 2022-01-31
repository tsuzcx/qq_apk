package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bo
  implements Runnable
{
  public bo(bp parambp, Context paramContext, Map paramMap) {}
  
  public void run()
  {
    Object localObject = bp.a(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
    } while (localObject == null);
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)this.b.get(str1);
      try
      {
        ((SharedPreferences.Editor)localObject).putString(str1, ed.e(ed.a(str2.getBytes(), ed.c())));
      }
      catch (Throwable localThrowable2) {}
    }
    try
    {
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Throwable localThrowable1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bo
 * JD-Core Version:    0.7.0.1
 */