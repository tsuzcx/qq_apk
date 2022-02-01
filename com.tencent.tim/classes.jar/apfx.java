import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.10;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.2;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.3;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.4;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.5;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.7;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.8;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.9;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;
import mqq.os.MqqHandler;

public class apfx
  extends Observable
  implements INetInfoHandler
{
  private static apfx a;
  private LinkedList<apfx.b> ae = new LinkedList();
  private LinkedList<UUID> ah = new LinkedList();
  private LinkedList<UUID> ai = new LinkedList();
  private LinkedList<UUID> aj = new LinkedList();
  apfx.c b = new apfy(this);
  public boolean cQf;
  private Map<UUID, apfx.b> nE = new HashMap();
  
  private String Bb()
  {
    return " WS:" + this.nE.size() + " QS:" + this.ah.size() + " PS:" + this.ai.size() + " PPS:" + this.aj.size() + " RS:" + this.ae.size();
  }
  
  public static apfx a()
  {
    try
    {
      if (a == null) {
        a = new apfx();
      }
      apfx localapfx = a;
      return localapfx;
    }
    finally {}
  }
  
  private int b(UUID paramUUID, long paramLong, String paramString1, String paramString2, apfx.c paramc)
  {
    if (f(paramUUID))
    {
      apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramUUID.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    paramString1 = new apfz(paramUUID, paramLong, paramString1, paramString2);
    paramString1.a(paramc);
    paramString1.a(this.b);
    this.nE.put(paramUUID, paramString1);
    this.ai.add(paramUUID);
    paramString1.dYV();
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramUUID.toString() + "] startUpload filePath. " + paramString2 + Bb());
    dYU();
    return 0;
  }
  
  private int d(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.ae.iterator();
    while (paramBundle.hasNext())
    {
      apfx.b localb = (apfx.b)paramBundle.next();
      if (paramUUID.equals(localb.a()))
      {
        localb.stop(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (apfx.b)this.nE.remove(paramUUID);
        if (paramBundle == null) {
          break label185;
        }
        paramBundle.stop(0);
        bool1 |= true;
      }
      label185:
      for (;;)
      {
        boolean bool3 = this.ah.remove(paramUUID);
        boolean bool4 = this.ai.remove(paramUUID);
        bool2 = this.aj.remove(paramUUID) | bool1 | bool3 | bool4;
        if (bool2) {
          apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramUUID.toString() + "] stopUpload." + Bb());
        }
        dYU();
        return 0;
      }
    }
  }
  
  private void dYU()
  {
    if (this.ae.size() >= 4) {}
    label588:
    label590:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = this.aj.iterator();
      Object localObject2;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label590;
        }
        localObject2 = (UUID)((Iterator)localObject1).next();
        apfx.b localb = (apfx.b)this.nE.get(localObject2);
        if (localb == null)
        {
          ((Iterator)localObject1).remove();
          this.nE.remove(localObject2);
          apef.b.e("TroopFileUploadMgr", apef.b.USR, "[" + ((UUID)localObject2).toString() + "] runNextWorker worker not find." + Bb());
        }
        else if (!qx(localb.getFilePath()))
        {
          ((Iterator)localObject1).remove();
          this.nE.remove(localObject2);
          this.ae.add(localb);
          if (localb.start()) {
            break;
          }
          this.ae.remove(localb);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label593;
        }
        while (this.ai.size() > 0)
        {
          localObject1 = (UUID)this.ai.remove(0);
          localObject2 = (apfx.b)this.nE.remove(localObject1);
          if (localObject2 != null)
          {
            if (qx(((apfx.b)localObject2).getFilePath()))
            {
              this.aj.add(localObject1);
              this.nE.put(localObject1, localObject2);
              apef.b.w("TroopFileUploadMgr", apef.b.USR, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + Bb());
            }
            else
            {
              this.ae.add(localObject2);
              if (((apfx.b)localObject2).start()) {
                break;
              }
              this.ae.remove(localObject2);
            }
          }
          else {
            apef.b.e("TroopFileUploadMgr", apef.b.USR, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 2." + Bb());
          }
        }
        if (this.ae.size() >= 2) {
          break;
        }
        for (;;)
        {
          if (this.ah.size() <= 0) {
            break label588;
          }
          localObject1 = (UUID)this.ah.remove(0);
          localObject2 = (apfx.b)this.nE.remove(localObject1);
          if (localObject2 != null)
          {
            if (qx(((apfx.b)localObject2).getFilePath()))
            {
              this.aj.add(localObject1);
              this.nE.put(localObject1, localObject2);
              apef.b.w("TroopFileUploadMgr", apef.b.USR, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + Bb());
              continue;
            }
            this.ae.add(localObject2);
            if (((apfx.b)localObject2).start()) {
              break;
            }
            this.ae.remove(localObject2);
            continue;
          }
          apef.b.e("TroopFileUploadMgr", apef.b.USR, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 3." + Bb());
        }
        break;
      }
    }
  }
  
  private int f(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (f(paramItem.Id))
    {
      apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    long l = ahav.getFileSizes(paramItem.LocalFile);
    if ((l > 0L) && (agpf.a().alT()) && (l > agpf.a().fV())) {}
    for (paramBundle = agps.a(paramLong, paramItem, paramBundle, this.b); paramBundle == null; paramBundle = apgb.a(paramLong, paramItem, paramBundle, this.b)) {
      return -3;
    }
    this.nE.put(paramItem.Id, paramBundle);
    this.ah.add(paramItem.Id);
    paramBundle.dYV();
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startUpload filePath. " + paramItem.LocalFile + Bb());
    dYU();
    return 0;
  }
  
  private final void n(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private boolean qx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((apfx.b)localIterator.next()).getFilePath())) {
        return true;
      }
    }
    return false;
  }
  
  protected void WD(int paramInt)
  {
    apef.b.w("TroopFileUploadMgr", apef.b.USR, "failAll. reason:" + paramInt);
    apdz.b(new TroopFileUploadMgr.8(this, paramInt), false);
  }
  
  public int a(UUID paramUUID, long paramLong, String paramString1, String paramString2, apfx.c paramc)
  {
    apdz.b(new TroopFileUploadMgr.5(this, paramUUID, paramLong, paramString1, paramString2, paramc), false);
    return 0;
  }
  
  public void b(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.ae.iterator();
    apfx.b localb;
    while (localIterator.hasNext())
    {
      localb = (apfx.b)localIterator.next();
      localb.stop(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localb.hs()));
      }
    }
    this.ae.clear();
    localIterator = this.nE.values().iterator();
    while (localIterator.hasNext())
    {
      localb = (apfx.b)localIterator.next();
      localb.stop(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localb.hs()));
      }
    }
    this.nE.clear();
    this.ai.clear();
    this.ah.clear();
    this.aj.clear();
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "stopAllInter. reason:" + paramInt);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, apfx.b paramb)
  {
    this.ae.remove(paramb);
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + Bb());
    dYU();
  }
  
  public int c(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      apef.b.e("TroopFileUploadMgr", apef.b.USR, "stopUpload item.id null.");
      return -2;
    }
    apdz.b(new TroopFileUploadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public int e(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      apef.b.e("TroopFileUploadMgr", apef.b.USR, "startUpload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileUploadMgr", apef.b.USR, "startUpload item.id null.");
      return -2;
    }
    apdz.b(new TroopFileUploadMgr.4(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  protected boolean f(UUID paramUUID)
  {
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((apfx.b)localIterator.next()).a())) {
        return true;
      }
    }
    return this.nE.containsKey(paramUUID);
  }
  
  public void init()
  {
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.1(this));
  }
  
  public void onNetMobile2None()
  {
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "onNetMobile2None");
    WD(3);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "onNetNone2Mobile");
    apdz.b(new TroopFileUploadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    apdz.b(new TroopFileUploadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "onNetWifi2None");
    WD(3);
  }
  
  public void release()
  {
    apef.b.i("TroopFileUploadMgr", apef.b.USR, "release");
    try
    {
      ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.2(this));
      if (Build.VERSION.SDK_INT == 19)
      {
        b(2, null);
        return;
      }
      apdz.b(new TroopFileUploadMgr.3(this), true);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static class a
    implements Observer
  {
    private final void onUpdate(Object paramObject)
    {
      paramObject = (Object[])paramObject;
      int i = ((Integer)paramObject[0]).intValue();
      paramObject = (Object[])paramObject[1];
      switch (i)
      {
      default: 
        return;
      }
      o((Set)paramObject[0]);
    }
    
    protected void o(Set<Long> paramSet) {}
    
    public void update(Observable paramObservable, Object paramObject)
    {
      if (paramObject == null) {
        return;
      }
      paramObservable = Looper.getMainLooper();
      if (Thread.currentThread() != paramObservable.getThread())
      {
        new Handler(paramObservable).post(new TroopFileUploadMgr.FileUploadMgrObserver.1(this, paramObject));
        return;
      }
      onUpdate(paramObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract String Bh();
    
    public abstract String Bi();
    
    public abstract String Bj();
    
    public abstract int Lp();
    
    public abstract UUID a();
    
    public abstract boolean aAY();
    
    public abstract String getFilePath();
    
    public abstract long getFileSize();
    
    public abstract int getImgHeight();
    
    public abstract int getImgWidth();
    
    public abstract int getVideoDuration();
    
    public abstract long hs();
    
    public abstract boolean start();
    
    public abstract void stop(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(UUID paramUUID, boolean paramBoolean, int paramInt, apfx.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfx
 * JD-Core Version:    0.7.0.1
 */