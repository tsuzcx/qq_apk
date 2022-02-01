package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qqpimsecure.wificore.api.event.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cs
{
  private final ArrayList<c> ia = new ArrayList();
  private BroadcastReceiver ib;
  
  private void a(Intent paramIntent)
  {
    synchronized (this.ia)
    {
      List localList = bb();
      localList.size();
      ??? = localList.iterator();
      while (((Iterator)???).hasNext()) {
        ((c)((Iterator)???).next()).a(paramIntent);
      }
      return;
    }
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  private void b(Intent paramIntent)
  {
    synchronized (this.ia)
    {
      List localList = bb();
      localList.size();
      ??? = localList.iterator();
      while (((Iterator)???).hasNext()) {
        ((c)((Iterator)???).next()).b(paramIntent);
      }
      return;
    }
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  private List<c> bb()
  {
    synchronized (this.ia)
    {
      ArrayList localArrayList2 = new ArrayList(this.ia);
      return localArrayList2;
    }
  }
  
  private void c(Intent paramIntent)
  {
    synchronized (this.ia)
    {
      List localList = bb();
      localList.size();
      ??? = localList.iterator();
      while (((Iterator)???).hasNext()) {
        ((c)((Iterator)???).next()).c(paramIntent);
      }
      return;
    }
    for (;;)
    {
      throw paramIntent;
    }
  }
  
  public void a(c paramc)
  {
    if (paramc != null) {
      synchronized (this.ia)
      {
        this.ia.add(paramc);
        return;
      }
    }
  }
  
  public void aZ()
  {
    bz.av().ax().post(new cs.1(this));
  }
  
  public void ba()
  {
    try
    {
      bz.av().t().unregisterReceiver(this.ib);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cs
 * JD-Core Version:    0.7.0.1
 */