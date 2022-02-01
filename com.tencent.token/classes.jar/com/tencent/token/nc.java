package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.NetworkInfo;

final class nc
{
  private static nc d;
  nf a;
  final BroadcastReceiver b = new nd(this);
  final BroadcastReceiver c = new ne(this);
  
  public static nc a()
  {
    try
    {
      if (d == null) {
        d = new nc();
      }
      nc localnc = d;
      return localnc;
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
        nc localnc = nc.this;
        if (localnc.a != null)
        {
          localnc.a.a();
          return;
        }
        lh.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
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
      nc localnc = nc.this;
      if (localObject != null)
      {
        localObject = nz.b;
        nz.b();
        String str = nz.b;
        if (!((String)localObject).equals(str))
        {
          if ((((String)localObject).equals(nz.a)) && (nz.f()))
          {
            if (localnc.a != null)
            {
              localnc.a.a();
              return;
            }
            lh.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
            return;
          }
          if ((!str.equals(nz.a)) && (nz.f()))
          {
            if (localnc.a != null)
            {
              localnc.a.a();
              return;
            }
            lh.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nc
 * JD-Core Version:    0.7.0.1
 */