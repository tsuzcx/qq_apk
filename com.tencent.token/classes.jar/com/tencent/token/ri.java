package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ri
{
  private static ri b;
  avb a;
  private Context c;
  private int d = 0;
  
  private ri(Context paramContext)
  {
    this.c = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.d = 4;
    }
    this.a = rk.a.a().a("tj");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("act_got_ads");
    paramContext.registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        
        if ("act_got_ads".equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = ri.this;
          paramAnonymousIntent = rk.a.a();
          ri.a(ri.this);
          ri.b(ri.this);
          ri.a(paramAnonymousContext, paramAnonymousIntent.a("tj"));
        }
      }
    }, localIntentFilter);
  }
  
  public static ri a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ri(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public final String a(int paramInt)
  {
    return this.a.a("ad_".concat(String.valueOf(paramInt)), "");
  }
  
  public final void a(HashMap<Integer, String> paramHashMap)
  {
    a(paramHashMap, true);
  }
  
  public final void a(HashMap<Integer, String> paramHashMap, boolean paramBoolean)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.a.b();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if ((paramBoolean) || (TextUtils.isEmpty(this.a.a("ad_".concat(String.valueOf(i)), "")))) {
          this.a.b("ad_".concat(String.valueOf(i)), (String)paramHashMap.get(Integer.valueOf(i)));
        }
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ri
 * JD-Core Version:    0.7.0.1
 */