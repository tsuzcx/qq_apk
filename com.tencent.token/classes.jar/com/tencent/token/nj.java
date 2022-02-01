package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.NetworkInfo;

final class nj
{
  private static nj d;
  nm a;
  final BroadcastReceiver b = new nk(this);
  final BroadcastReceiver c = new nl(this);
  
  public static nj a()
  {
    try
    {
      if (d == null) {
        d = new nj();
      }
      nj localnj = d;
      return localnj;
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
        nj localnj = nj.this;
        if (localnj.a != null)
        {
          localnj.a.a();
          return;
        }
        lo.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
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
      nj localnj = nj.this;
      if (localObject != null)
      {
        localObject = og.b;
        og.b();
        String str = og.b;
        if (!((String)localObject).equals(str))
        {
          if ((((String)localObject).equals(og.a)) && (og.f()))
          {
            if (localnj.a != null)
            {
              localnj.a.a();
              return;
            }
            lo.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
            return;
          }
          if ((!str.equals(og.a)) && (og.f()))
          {
            if (localnj.a != null)
            {
              localnj.a.a();
              return;
            }
            lo.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nj
 * JD-Core Version:    0.7.0.1
 */