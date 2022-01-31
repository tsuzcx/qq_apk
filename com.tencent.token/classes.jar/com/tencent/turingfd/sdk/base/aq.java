package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aq
{
  public static final dj a = new an();
  public Map b = new HashMap();
  public Map c = new HashMap();
  public au d;
  
  public final Guava a(long paramLong1, long paramLong2, List paramList)
  {
    Guava localGuava = new Guava();
    localGuava.duration = ((int)paramLong2);
    localGuava.cd = paramLong1;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      as localas = (as)paramList.next();
      Haw localHaw = new Haw();
      switch (localas.a)
      {
      default: 
        localHaw.ed = 0;
      }
      for (;;)
      {
        localHaw.x = localas.b;
        localHaw.y = localas.c;
        localHaw.gd = localas.d;
        localHaw.radius = localas.e;
        localArrayList.add(localHaw);
        break;
        localHaw.ed = 4;
        continue;
        localHaw.ed = 2;
        continue;
        localHaw.ed = 3;
        continue;
        localHaw.ed = 1;
      }
    }
    localGuava.dd = localArrayList;
    return localGuava;
  }
  
  public final List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() <= 20)
    {
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    as localas1 = (as)paramList.get(0);
    as localas2 = (as)paramList.get(paramList.size() - 1);
    paramList.remove(localas1);
    paramList.remove(localas2);
    int j = (int)Math.ceil(paramList.size() / 18);
    localArrayList.add(localas1);
    int i = 1;
    while (i < paramList.size())
    {
      localArrayList.add(paramList.get(i));
      i += j;
    }
    localArrayList.add(localas2);
    return localArrayList;
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getClass().getName();
    Object localObject = (at)this.b.get(paramActivity);
    ba.c.remove(localObject);
    this.b.remove(paramActivity);
    localObject = (ar)this.c.get(paramActivity);
    ba.d.remove(localObject);
    this.c.remove(paramActivity);
  }
  
  public void a(Activity paramActivity, int paramInt, au paramau)
  {
    paramActivity.getApplicationContext();
    this.d = paramau;
    paramau = paramActivity.getClass().getName();
    paramActivity = new at(this, paramActivity.getClass().getName(), paramInt);
    this.b.put(paramau, paramActivity);
    ba.c.add(paramActivity);
    paramActivity = new ar(this, paramInt);
    this.c.put(paramau, paramActivity);
    ba.d.add(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aq
 * JD-Core Version:    0.7.0.1
 */