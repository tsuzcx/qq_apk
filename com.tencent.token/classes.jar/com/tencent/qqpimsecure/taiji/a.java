package com.tencent.qqpimsecure.taiji;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class a
{
  private static a a = null;
  private ITaijiPreferenceManager b;
  private Context c;
  private int d = 0;
  
  private a(Context paramContext)
  {
    this.c = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.d = 4;
    }
    this.b = f.a().a(this.c, "tj", this.d);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("act_got_ads");
    paramContext.registerReceiver(new b(this), localIntentFilter);
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public String a(int paramInt)
  {
    return this.b.getString("ad_" + paramInt, "");
  }
  
  public List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)paramList.next()).intValue();
      String str = this.b.getString("ad_" + i);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(HashMap paramHashMap)
  {
    a(paramHashMap, true);
  }
  
  public void a(HashMap paramHashMap, boolean paramBoolean)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.b.beginTransaction();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if ((paramBoolean) || (TextUtils.isEmpty(this.b.getString("ad_" + i, "")))) {
          this.b.putString("ad_" + i, (String)paramHashMap.get(Integer.valueOf(i)));
        }
      }
      this.b.endTransaction();
    }
  }
  
  public void b(int paramInt)
  {
    this.b.remove("ad_" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.a
 * JD-Core Version:    0.7.0.1
 */