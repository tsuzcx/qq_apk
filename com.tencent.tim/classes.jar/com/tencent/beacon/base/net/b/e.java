package com.tencent.beacon.base.net.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.RequiresPermission;
import com.tencent.beacon.a.b.a;
import com.tencent.beacon.base.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends BroadcastReceiver
  implements Runnable
{
  private static final List<a> a = new ArrayList();
  private static volatile boolean b = false;
  private boolean c = true;
  private volatile boolean d = false;
  
  private void a()
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).a();
      }
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    if (paramContext == null) {
      c.b("[net] context == null!", new Object[0]);
    }
    for (;;)
    {
      return;
      synchronized (a)
      {
        if (!a.contains(parama)) {
          a.add(parama);
        }
        if (b) {
          continue;
        }
        parama = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.registerReceiver(new e(), parama);
        b = true;
        return;
      }
    }
  }
  
  public static void a(a parama)
  {
    synchronized (a)
    {
      a.remove(parama);
      return;
    }
  }
  
  private void b()
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).b();
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.c) {
      this.c = false;
    }
    while (this.d) {
      return;
    }
    a.a().a(this);
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public void run()
  {
    this.d = true;
    if (d.d())
    {
      c.d("[net] current network available!", new Object[0]);
      a();
    }
    for (;;)
    {
      this.d = false;
      return;
      c.d("[net] current network unavailable!", new Object[0]);
      b();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.e
 * JD-Core Version:    0.7.0.1
 */