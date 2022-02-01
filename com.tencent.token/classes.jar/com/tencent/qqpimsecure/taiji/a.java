package com.tencent.qqpimsecure.taiji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiPreferenceManager;

public class a
{
  private static a a;
  private ITaijiPreferenceManager b;
  private Context c;
  private int d = 0;
  
  private a(Context paramContext)
  {
    this.c = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.d = 4;
    }
    this.b = c.a().a(this.c, "tj", this.d);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("act_got_ads");
    paramContext.registerReceiver(new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        bn.b("TaijiDao", "on receive ACTION_ON_GOT_ADS");
        if ("act_got_ads".equals(paramAnonymousIntent.getAction())) {
          a.a(a.this, c.a().a(a.a(a.this), "tj", a.b(a.this)));
        }
      }
    }, localIntentFilter);
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  public String a(int paramInt)
  {
    ITaijiPreferenceManager localITaijiPreferenceManager = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad_");
    localStringBuilder.append(paramInt);
    return localITaijiPreferenceManager.getString(localStringBuilder.toString(), "");
  }
  
  public List<String> a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = ((Integer)paramList.next()).intValue();
        Object localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ad_");
        localStringBuilder.append(i);
        localObject = ((ITaijiPreferenceManager)localObject).getString(localStringBuilder.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(HashMap<Integer, String> paramHashMap)
  {
    a(paramHashMap, true);
  }
  
  public void a(HashMap<Integer, String> paramHashMap, boolean paramBoolean)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.b.beginTransaction();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ITaijiPreferenceManager localITaijiPreferenceManager;
        StringBuilder localStringBuilder;
        if (!paramBoolean)
        {
          localITaijiPreferenceManager = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ad_");
          localStringBuilder.append(i);
          if (!TextUtils.isEmpty(localITaijiPreferenceManager.getString(localStringBuilder.toString(), ""))) {}
        }
        else
        {
          localITaijiPreferenceManager = this.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ad_");
          localStringBuilder.append(i);
          localITaijiPreferenceManager.putString(localStringBuilder.toString(), (String)paramHashMap.get(Integer.valueOf(i)));
        }
      }
      this.b.endTransaction();
    }
  }
  
  public void b(int paramInt)
  {
    ITaijiPreferenceManager localITaijiPreferenceManager = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ad_");
    localStringBuilder.append(paramInt);
    localITaijiPreferenceManager.remove(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.a
 * JD-Core Version:    0.7.0.1
 */