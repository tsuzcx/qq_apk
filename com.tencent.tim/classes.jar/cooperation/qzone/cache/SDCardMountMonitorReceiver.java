package cooperation.qzone.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import avsu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SDCardMountMonitorReceiver
  extends BroadcastReceiver
{
  private static SDCardMountMonitorReceiver a;
  private boolean doH;
  private boolean doI;
  private boolean doJ;
  private boolean doK;
  private boolean doL;
  private List<a> observers = new ArrayList();
  
  public static SDCardMountMonitorReceiver a()
  {
    if (a == null) {
      a = new SDCardMountMonitorReceiver();
    }
    return a;
  }
  
  private boolean aLA()
  {
    if (!this.doK) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!avsu.isStorageReallyCanwrite(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.doJ = bool;
      this.doK = true;
      return this.doJ;
    }
  }
  
  private void notifyObservers(boolean paramBoolean)
  {
    synchronized (this.observers)
    {
      a[] arrayOfa = new a[this.observers.size()];
      this.observers.toArray(arrayOfa);
      if (arrayOfa != null)
      {
        int j = arrayOfa.length;
        int i = 0;
        if (i < j)
        {
          arrayOfa[i].hg(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.observers)
    {
      if (!this.observers.contains(parama)) {
        this.observers.add(parama);
      }
      return;
    }
  }
  
  public boolean aLB()
  {
    if (!this.doL) {}
    try
    {
      this.doI = "mounted".equals(Environment.getExternalStorageState());
      this.doL = true;
      return this.doI;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("CacheManager", 2, "getExternalStorageState error:" + localException.getMessage());
      }
    }
  }
  
  public boolean aLC()
  {
    return (aLB()) && (aLA());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.doI = "mounted".equals(Environment.getExternalStorageState());
    if (this.doI) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!avsu.isStorageReallyCanwrite(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      this.doJ = bool;
      this.doK = true;
      this.doL = true;
      avsu.eBN();
      notifyObservers(this.doI);
      QLog.i("CacheManager", 1, "SDCardMountMonitorReceiver onReceive mIsSDCardMount:" + this.doI + ",canWrite" + this.doJ);
      return;
    }
  }
  
  public void registerReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      BaseApplicationImpl.getContext().registerReceiver(this, localIntentFilter);
      this.doH = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void unregisterReceiver()
  {
    if ((a != null) && (a.doH == true))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(a);
      a.doH = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void hg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.cache.SDCardMountMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */