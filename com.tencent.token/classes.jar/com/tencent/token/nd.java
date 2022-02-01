package com.tencent.token;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.NetworkInfo;

final class nd
{
  private static nd d;
  ng a;
  final BroadcastReceiver b = new ne(this);
  final BroadcastReceiver c = new nf(this);
  
  public static nd a()
  {
    try
    {
      if (d == null) {
        d = new nd();
      }
      nd localnd = d;
      return localnd;
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
        nd localnd = nd.this;
        if (localnd.a != null)
        {
          localnd.a.a();
          return;
        }
        li.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
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
      nd localnd = nd.this;
      if (localObject != null)
      {
        localObject = oa.b;
        oa.b();
        String str = oa.b;
        if (!((String)localObject).equals(str))
        {
          if ((((String)localObject).equals(oa.a)) && (oa.f()))
          {
            if (localnd.a != null)
            {
              localnd.a.a();
              return;
            }
            li.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
            return;
          }
          if ((!str.equals(oa.a)) && (oa.f()))
          {
            if (localnd.a != null)
            {
              localnd.a.a();
              return;
            }
            li.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nd
 * JD-Core Version:    0.7.0.1
 */