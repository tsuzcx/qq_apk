import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.10;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.3;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.5;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.6;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.7;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.8;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.9;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver.1;
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

public class apew
  extends Observable
  implements apey.a, INetInfoHandler
{
  private static apew a;
  private LinkedList<UUID> ad = new LinkedList();
  private LinkedList<apey> ae = new LinkedList();
  public boolean cQf;
  private Map<UUID, apey> nE = new HashMap();
  
  private String Bb()
  {
    return " WS:" + this.nE.size() + " QS:" + this.ad.size() + " RS:" + this.ae.size();
  }
  
  public static apew a()
  {
    try
    {
      if (a == null) {
        a = new apew();
      }
      apew localapew = a;
      return localapew;
    }
    finally {}
  }
  
  private int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (f(paramItem.Id))
    {
      apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (agpf.a().alU()) && (paramItem.ProgressTotal > agpf.a().fW())) {}
    for (paramBundle = agph.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = apey.a(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.nE.put(paramItem.Id, paramBundle);
    this.ad.add(paramItem.Id);
    paramBundle.dYV();
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + Bb());
    dYU();
    return 0;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.ae.iterator();
    while (paramBundle.hasNext())
    {
      apey localapey = (apey)paramBundle.next();
      if (paramUUID.equals(localapey.a()))
      {
        localapey.stop(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (apey)this.nE.remove(paramUUID);
        if (paramBundle == null) {
          break label153;
        }
        paramBundle.stop(0);
        bool1 |= true;
      }
      label153:
      for (;;)
      {
        bool2 = this.ad.remove(paramUUID) | bool1;
        if (bool2) {
          apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramUUID.toString() + "] stopDownload." + Bb());
        }
        dYU();
        return 0;
      }
    }
  }
  
  private int d(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (f(paramItem.Id))
    {
      apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = apfd.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.nE.put(paramItem.Id, paramBundle);
    this.ad.add(paramItem.Id);
    paramBundle.dYV();
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + Bb());
    dYU();
    return 0;
  }
  
  private void dYU()
  {
    if (this.ae.size() >= 2) {}
    label78:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.ad.size() <= 0) {
          break label78;
        }
        Object localObject = (UUID)this.ad.remove(0);
        localObject = (apey)this.nE.remove(localObject);
        if (localObject != null)
        {
          this.ae.add(localObject);
          if (((apey)localObject).start()) {
            break;
          }
          this.ae.remove(localObject);
        }
      }
    }
  }
  
  private final void n(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  protected void WD(int paramInt)
  {
    apef.b.w("TroopFileDownloadMgr", apef.b.USR, "failAll. reason:" + paramInt);
    apdz.b(new TroopFileDownloadMgr.8(this, paramInt), false);
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    paramItem = apfb.a(paramLong, paramItem);
    if (paramItem == null) {
      return -3;
    }
    if (!paramItem.getPreviewInfo()) {
      return -5;
    }
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "stopUpload item.id null.");
      return -2;
    }
    apdz.b(new TroopFileDownloadMgr.6(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface != null) {
      smq.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new apex(this, paramItem, localQQAppInterface, paramLong, paramBundle));
    }
  }
  
  protected final void a(apcy paramapcy, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "[" + paramapcy.TroopUin + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
    localFileManagerEntity.peerNick = aqgv.F(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = paramapcy.TroopUin;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = agoy.t(ahav.A(paramapcy.LocalFile));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = agoy.t(ahav.x(paramapcy.LocalFile));
      }
    }
    localFileManagerEntity.str10Md5 = aqhs.bytes2HexStr(ahav.t(paramapcy.LocalFile));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramapcy.LocalFile).lastModified();
      label265:
      localQQAppInterface.a().s(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().u(localFileManagerEntity);
      return;
    }
    catch (Exception paramapcy)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, apey paramapey)
  {
    apdz.b(new TroopFileDownloadMgr.7(this, paramUUID, paramBoolean, paramInt, paramapey), false);
  }
  
  public void b(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.ae.iterator();
    apey localapey;
    while (localIterator.hasNext())
    {
      localapey = (apey)localIterator.next();
      localapey.stop(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localapey.hs()));
      }
    }
    this.ae.clear();
    localIterator = this.nE.values().iterator();
    while (localIterator.hasNext())
    {
      localapey = (apey)localIterator.next();
      localapey.stop(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localapey.hs()));
      }
    }
    this.nE.clear();
    this.ad.clear();
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "stopAllInter");
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, apey paramapey)
  {
    this.ae.remove(paramapey);
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + Bb());
    dYU();
  }
  
  public int c(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      apef.b.e("TroopFileDownloadMgr", apef.b.USR, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    apdz.b(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  protected boolean f(UUID paramUUID)
  {
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((apey)localIterator.next()).a())) {
        return true;
      }
    }
    return this.nE.containsKey(paramUUID);
  }
  
  public void init()
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  public void onNetMobile2None()
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "onNetMobile2None");
    WD(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "onNetNone2Mobile");
    apdz.b(new TroopFileDownloadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    apdz.b(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "onNetWifi2None");
    WD(3);
  }
  
  public void release()
  {
    apef.b.i("TroopFileDownloadMgr", apef.b.USR, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      b(2, null);
      return;
    }
    apdz.b(new TroopFileDownloadMgr.3(this), true);
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
      p((Set)paramObject[0]);
    }
    
    protected void p(Set<Long> paramSet) {}
    
    public void update(Observable paramObservable, Object paramObject)
    {
      if (paramObject == null) {
        return;
      }
      paramObservable = Looper.getMainLooper();
      if (Thread.currentThread() != paramObservable.getThread())
      {
        new Handler(paramObservable).post(new TroopFileDownloadMgr.FileDownloadMgrObserver.1(this, paramObject));
        return;
      }
      onUpdate(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apew
 * JD-Core Version:    0.7.0.1
 */