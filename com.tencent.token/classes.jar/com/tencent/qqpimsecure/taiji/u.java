package com.tencent.qqpimsecure.taiji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class u
{
  @SuppressLint({"StaticFieldLeak"})
  private static u a;
  private Context b;
  private int c = 0;
  
  private u(Context paramContext)
  {
    this.b = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.c = 4;
    }
  }
  
  public static u a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new u(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public String a()
  {
    return f.a().a(this.b, "tjs", this.c).getString("g1", "");
  }
  
  public void a(int paramInt)
  {
    f.a().a(this.b, "tjs", this.c).putInt("k_t_a_v", paramInt);
  }
  
  public void a(long paramLong)
  {
    f.a().a(this.b, "tjs", this.c).putLong("pull_all_time", paramLong);
  }
  
  public void a(String paramString)
  {
    f.a().a(this.b, "tjs", this.c).putString("g1", paramString);
  }
  
  public void a(HashMap paramHashMap1, HashMap paramHashMap2)
  {
    ITaijiPreferenceManager localITaijiPreferenceManager = f.a().a(this.b, "tjs", this.c);
    localITaijiPreferenceManager.beginTransaction();
    Iterator localIterator = paramHashMap1.keySet().iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localITaijiPreferenceManager.putString(String.valueOf(i), (String)paramHashMap1.get(Integer.valueOf(i)));
    }
    paramHashMap1 = paramHashMap2.keySet().iterator();
    while (paramHashMap1.hasNext())
    {
      i = ((Integer)paramHashMap1.next()).intValue();
      localITaijiPreferenceManager.putInt(String.valueOf(i), ((Integer)paramHashMap2.get(Integer.valueOf(i))).intValue());
    }
    localITaijiPreferenceManager.endTransaction();
  }
  
  public void a(boolean paramBoolean)
  {
    f.a().a(this.b, "tjs", this.c).putBoolean("cloud", paramBoolean);
  }
  
  public String b()
  {
    return f.a().a(this.b, "tjs", this.c).getString("g2", "");
  }
  
  public void b(long paramLong)
  {
    f.a().a(this.b, "tjs", this.c).putLong("kv_time", paramLong);
  }
  
  public void b(String paramString)
  {
    f.a().a(this.b, "tjs", this.c).putString("g2", paramString);
  }
  
  public void b(HashMap paramHashMap1, HashMap paramHashMap2)
  {
    cl.b("TaijiShareDao", "selectChangedProfile");
    ITaijiPreferenceManager localITaijiPreferenceManager = f.a().a(this.b, "tjs", this.c);
    Object localObject1 = paramHashMap1.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localITaijiPreferenceManager.getString(String.valueOf(((Map.Entry)localObject2).getKey()), "").equals(paramHashMap1.get(((Map.Entry)localObject2).getKey())))
      {
        cl.b("TaijiShareDao", "kvStringProfile remove:" + ((Map.Entry)localObject2).getKey());
        ((Iterator)localObject1).remove();
      }
    }
    paramHashMap1 = paramHashMap2.entrySet().iterator();
    while (paramHashMap1.hasNext())
    {
      localObject1 = (Map.Entry)paramHashMap1.next();
      localObject2 = (Integer)paramHashMap2.get(((Map.Entry)localObject1).getKey());
      if ((localObject2 == null) || (localITaijiPreferenceManager.getInt(String.valueOf(((Map.Entry)localObject1).getKey()), -1) == ((Integer)localObject2).intValue()))
      {
        cl.b("TaijiShareDao", "kvIntProfile remove:" + ((Map.Entry)localObject1).getKey());
        paramHashMap1.remove();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    f.a().a(this.b, "tjs", this.c).putBoolean("none", paramBoolean);
  }
  
  public long c()
  {
    return f.a().a(this.b, "tjs", this.c).getLong("pull_all_time", 0L);
  }
  
  public void c(long paramLong)
  {
    f.a().a(this.b, "tjs", this.c).putLong("lst_cloud_time", paramLong);
  }
  
  public void c(String paramString)
  {
    f.a().a(this.b, "tjs", this.c).putString("md5", paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    f.a().a(this.b, "tjs", this.c).putBoolean("k_l_l_s_s", paramBoolean);
  }
  
  public long d()
  {
    return f.a().a(this.b, "tjs", this.c).getLong("kv_time", 0L);
  }
  
  public String e()
  {
    return f.a().a(this.b, "tjs", this.c).getString("md5", "");
  }
  
  public boolean f()
  {
    return f.a().a(this.b, "tjs", this.c).getBoolean("cloud", false);
  }
  
  public boolean g()
  {
    return f.a().a(this.b, "tjs", this.c).getBoolean("none", false);
  }
  
  public boolean h()
  {
    return f.a().a(this.b, "tjs", this.c).getBoolean("k_l_l_s_s", true);
  }
  
  public int i()
  {
    return f.a().a(this.b, "tjs", this.c).getInt("k_t_a_v", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.u
 * JD-Core Version:    0.7.0.1
 */