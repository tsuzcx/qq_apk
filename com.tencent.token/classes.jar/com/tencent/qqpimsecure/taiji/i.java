package com.tencent.qqpimsecure.taiji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class i
{
  @SuppressLint({"StaticFieldLeak"})
  private static i a;
  private Context b;
  private int c = 0;
  
  private i(Context paramContext)
  {
    this.b = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.c = 4;
    }
  }
  
  public static i a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new i(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a()
  {
    return c.a().a(this.b, "tjs", this.c).getString("g1", "");
  }
  
  public void a(int paramInt)
  {
    c.a().a(this.b, "tjs", this.c).putInt("k_t_a_v", paramInt);
  }
  
  public void a(long paramLong)
  {
    c.a().a(this.b, "tjs", this.c).putLong("pull_all_time", paramLong);
  }
  
  public void a(String paramString)
  {
    c.a().a(this.b, "tjs", this.c).putString("g1", paramString);
  }
  
  public void a(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1)
  {
    ITaijiPreferenceManager localITaijiPreferenceManager = c.a().a(this.b, "tjs", this.c);
    localITaijiPreferenceManager.beginTransaction();
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      localITaijiPreferenceManager.putString(String.valueOf(i), (String)paramHashMap.get(Integer.valueOf(i)));
    }
    paramHashMap = paramHashMap1.keySet().iterator();
    while (paramHashMap.hasNext())
    {
      i = ((Integer)paramHashMap.next()).intValue();
      localITaijiPreferenceManager.putInt(String.valueOf(i), ((Integer)paramHashMap1.get(Integer.valueOf(i))).intValue());
    }
    localITaijiPreferenceManager.endTransaction();
  }
  
  public void a(boolean paramBoolean)
  {
    c.a().a(this.b, "tjs", this.c).putBoolean("cloud", paramBoolean);
  }
  
  public String b()
  {
    return c.a().a(this.b, "tjs", this.c).getString("g2", "");
  }
  
  public void b(long paramLong)
  {
    c.a().a(this.b, "tjs", this.c).putLong("kv_time", paramLong);
  }
  
  public void b(String paramString)
  {
    c.a().a(this.b, "tjs", this.c).putString("g2", paramString);
  }
  
  public void b(HashMap<Integer, String> paramHashMap, HashMap<Integer, Integer> paramHashMap1)
  {
    bn.b("TaijiShareDao", "selectChangedProfile");
    ITaijiPreferenceManager localITaijiPreferenceManager = c.a().a(this.b, "tjs", this.c);
    Object localObject1 = paramHashMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (localITaijiPreferenceManager.getString(String.valueOf(((Map.Entry)localObject2).getKey()), "").equals(paramHashMap.get(((Map.Entry)localObject2).getKey())))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("kvStringProfile remove:");
        localStringBuilder.append(((Map.Entry)localObject2).getKey());
        bn.b("TaijiShareDao", localStringBuilder.toString());
        ((Iterator)localObject1).remove();
      }
    }
    paramHashMap = paramHashMap1.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      localObject1 = (Map.Entry)paramHashMap.next();
      localObject2 = (Integer)paramHashMap1.get(((Map.Entry)localObject1).getKey());
      if ((localObject2 == null) || (localITaijiPreferenceManager.getInt(String.valueOf(((Map.Entry)localObject1).getKey()), -1) == ((Integer)localObject2).intValue()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("kvIntProfile remove:");
        ((StringBuilder)localObject2).append(((Map.Entry)localObject1).getKey());
        bn.b("TaijiShareDao", ((StringBuilder)localObject2).toString());
        paramHashMap.remove();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    c.a().a(this.b, "tjs", this.c).putBoolean("none", paramBoolean);
  }
  
  public long c()
  {
    return c.a().a(this.b, "tjs", this.c).getLong("pull_all_time", 0L);
  }
  
  public void c(long paramLong)
  {
    c.a().a(this.b, "tjs", this.c).putLong("lst_cloud_time", paramLong);
  }
  
  public void c(String paramString)
  {
    c.a().a(this.b, "tjs", this.c).putString("md5", paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    c.a().a(this.b, "tjs", this.c).putBoolean("k_l_l_s_s", paramBoolean);
  }
  
  public long d()
  {
    return c.a().a(this.b, "tjs", this.c).getLong("kv_time", 0L);
  }
  
  public String e()
  {
    return c.a().a(this.b, "tjs", this.c).getString("md5", "");
  }
  
  public boolean f()
  {
    return c.a().a(this.b, "tjs", this.c).getBoolean("cloud", false);
  }
  
  public boolean g()
  {
    return c.a().a(this.b, "tjs", this.c).getBoolean("none", false);
  }
  
  public boolean h()
  {
    return c.a().a(this.b, "tjs", this.c).getBoolean("k_l_l_s_s", true);
  }
  
  public int i()
  {
    return c.a().a(this.b, "tjs", this.c).getInt("k_t_a_v", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.i
 * JD-Core Version:    0.7.0.1
 */