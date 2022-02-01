package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import com.tencent.wifisdk.services.common.api.d;
import java.util.ArrayList;
import java.util.Iterator;

public class hd
  extends BroadcastReceiver
{
  private static hd sN;
  private Handler mHandler;
  private boolean sO = false;
  private final SparseArray<ArrayList<d>> sP = new SparseArray();
  private IThreadPool sd;
  
  private hd(IThreadPool paramIThreadPool)
  {
    this.sd = paramIThreadPool;
  }
  
  public static hd a(IThreadPool paramIThreadPool)
  {
    if (sN == null) {}
    try
    {
      if ((sN == null) && (paramIThreadPool != null)) {
        sN = new hd(paramIThreadPool);
      }
      return sN;
    }
    finally {}
  }
  
  private void fm()
  {
    if (this.sO) {
      return;
    }
    this.sO = true;
    IntentFilter localIntentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
    try
    {
      gv.dE().registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private Handler getHandler()
  {
    if ((this.mHandler == null) && (this.sd != null))
    {
      HandlerThread localHandlerThread = this.sd.newFreeHandlerThread("MsgHandler", 5);
      if (localHandlerThread != null)
      {
        localHandlerThread.start();
        this.mHandler = new Handler(localHandlerThread.getLooper());
      }
    }
    return this.mHandler;
  }
  
  private void unregister()
  {
    try
    {
      gv.dE().unregisterReceiver(this);
      label7:
      this.sO = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label7;
    }
  }
  
  public void a(int paramInt, d paramd)
  {
    if (paramd == null) {
      return;
    }
    synchronized (this.sP)
    {
      ArrayList localArrayList2 = (ArrayList)this.sP.get(paramInt);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.sP.put(paramInt, localArrayList1);
      }
      if (!localArrayList1.contains(paramd))
      {
        localArrayList1.add(paramd);
        fm();
      }
      return;
    }
  }
  
  public void a(d paramd)
  {
    int j;
    synchronized (this.sP)
    {
      j = this.sP.size();
      i = 0;
      if (i < j)
      {
        ArrayList localArrayList = (ArrayList)this.sP.valueAt(i);
        if (localArrayList == null) {
          break label121;
        }
        localArrayList.remove(paramd);
      }
    }
    int i = j - 1;
    for (;;)
    {
      if (i >= 0)
      {
        paramd = (ArrayList)this.sP.valueAt(i);
        if ((paramd != null) && (paramd.size() <= 0)) {
          this.sP.removeAt(i);
        }
      }
      else
      {
        if (this.sP.size() <= 0) {
          unregister();
        }
        return;
        label121:
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    label99:
    for (;;)
    {
      return;
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction())) {}
      for (int i = 101;; i = -1)
      {
        if (i < 0) {
          break label99;
        }
        Object localObject = (ArrayList)this.sP.get(i);
        if (localObject == null) {
          break;
        }
        paramContext = getHandler();
        if (paramContext == null) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramContext.post(new hd.1(this, (d)((Iterator)localObject).next(), i, paramIntent));
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.hd
 * JD-Core Version:    0.7.0.1
 */