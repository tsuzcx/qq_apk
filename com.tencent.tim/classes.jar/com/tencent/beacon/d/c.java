package com.tencent.beacon.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

public class c
{
  protected final Context a;
  private final boolean b;
  private boolean c = false;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
    this.b = com.tencent.beacon.a.c.b.e(this.a);
  }
  
  private Map<String, String> b()
  {
    this.c = com.tencent.beacon.a.c.b.d;
    HashMap localHashMap = new HashMap(8);
    Object localObject = e.l();
    f localf = f.e();
    localHashMap.put("A19", ((e)localObject).q());
    if (com.tencent.beacon.a.c.b.e(this.a))
    {
      localObject = "F";
      localHashMap.put("A66", localObject);
      localHashMap.put("A68", "" + com.tencent.beacon.a.c.b.b(this.a));
      if (!this.c) {
        break label149;
      }
    }
    label149:
    for (localObject = "Y";; localObject = "N")
    {
      localHashMap.put("A85", localObject);
      localHashMap.put("A20", localf.j());
      localHashMap.put("A69", localf.k());
      return localHashMap;
      localObject = "B";
      break;
    }
  }
  
  private boolean c()
  {
    return ((StatModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).c(b());
  }
  
  public void a()
  {
    Object localObject = com.tencent.beacon.a.d.a.a();
    String str = ((com.tencent.beacon.a.d.a)localObject).getString("active_user_date", "");
    if (!com.tencent.beacon.base.util.b.d().equals(str))
    {
      com.tencent.beacon.base.util.c.a("[event] recover a heart beat for active user.", new Object[0]);
      if (c())
      {
        com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success", new Object[0]);
        localObject = ((com.tencent.beacon.a.d.a)localObject).edit();
        if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor)localObject)) {
          ((SharedPreferences.Editor)localObject).putString("active_user_date", com.tencent.beacon.base.util.b.d()).apply();
        }
      }
      return;
    }
    com.tencent.beacon.base.util.c.e("[event] active user event had upload.", new Object[0]);
  }
  
  public void a(com.tencent.beacon.e.b paramb)
  {
    String str1 = com.tencent.beacon.base.util.b.d();
    com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
    String str2 = locala.getString("HEART_DENGTA", "");
    String str3 = locala.getString("active_user_date", "");
    if ((str1.equals(str2)) || (str3.equals(str1)))
    {
      com.tencent.beacon.base.util.c.e("[event] heartbeat had upload!", new Object[0]);
      return;
    }
    if (paramb.a("rqd_heartbeat"))
    {
      com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
      return;
    }
    if (!paramb.b("rqd_heartbeat"))
    {
      com.tencent.beacon.base.util.c.e("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    com.tencent.beacon.a.b.a.a().a(new b(this, str1, locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.d.c
 * JD-Core Version:    0.7.0.1
 */