package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.NetworkInfo;

final class nx
{
  private static nx d;
  oa a;
  final BroadcastReceiver b = new ny(this);
  final BroadcastReceiver c = new nz(this);
  
  public static nx a()
  {
    try
    {
      if (d == null) {
        d = new nx();
      }
      nx localnx = d;
      return localnx;
    }
    finally {}
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      try
      {
        nx localnx = nx.this;
        if (localnx.a != null)
        {
          localnx.a.a();
          return;
        }
        mc.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private Intent a;
    
    b(Intent paramIntent)
    {
      this.a = paramIntent;
    }
    
    public final void run()
    {
      Object localObject = (NetworkInfo)this.a.getParcelableExtra("networkInfo");
      nx localnx = nx.this;
      if (localObject != null)
      {
        localObject = ou.b;
        ou.b();
        String str = ou.b;
        if (!((String)localObject).equals(str))
        {
          if ((((String)localObject).equals(ou.a)) && (ou.f()))
          {
            if (localnx.a != null)
            {
              localnx.a.a();
              return;
            }
            mc.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
            return;
          }
          if ((!str.equals(ou.a)) && (ou.f()))
          {
            if (localnx.a != null)
            {
              localnx.a.a();
              return;
            }
            mc.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nx
 * JD-Core Version:    0.7.0.1
 */