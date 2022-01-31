package wf7;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.wifisdk.TMSDKFreeWifiInfo;
import com.tencent.wifisdk.TMSDKWifiEventListener;
import com.tencent.wifisdk.TMSDKWifiListUpdateListener;
import com.wifisdk.ui.view.a;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class hu
  implements TMSDKWifiEventListener, TMSDKWifiListUpdateListener
{
  private bq qP;
  private a ub;
  private volatile int uc;
  private volatile String ud = null;
  private boolean ue = false;
  private Handler uf;
  private final AtomicBoolean ug = new AtomicBoolean(false);
  
  public hu(int paramInt)
  {
    this.uc = paramInt;
    this.uf = new Handler(fq.getSubThreadLooper());
    this.qP = hm.fq();
  }
  
  private void N(boolean paramBoolean)
  {
    if (!this.ug.get()) {
      return;
    }
    this.uf.post(new hu.1(this, paramBoolean));
  }
  
  private void a(LinkedList<hr> paramLinkedList)
  {
    if (!hj.a(paramLinkedList)) {}
    label91:
    label92:
    for (;;)
    {
      return;
      Collections.sort(paramLinkedList, new hu.3(this));
      Object localObject = null;
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        hr localhr = (hr)localIterator.next();
        localhr.tN = false;
        if ((localObject != null) || (!localhr.isBestWiFi)) {
          break label91;
        }
        localhr.tN = true;
        localObject = localhr;
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label92;
        }
        paramLinkedList.remove(localObject);
        paramLinkedList.push(localObject);
        return;
      }
    }
  }
  
  private void a(List<hr> paramList, String paramString)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        hr localhr = (hr)paramList.next();
        if ((localhr == null) || (TextUtils.equals(localhr.ssid, paramString))) {
          paramList.remove();
        }
      }
    }
  }
  
  private LinkedList<hr> aA(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 1)
    {
      Object localObject = hm.fv();
      if (hj.a((Collection)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localLinkedList.add(new hr((bn)((Iterator)localObject).next()));
        }
      }
    }
    if (paramInt == 2) {
      this.qP.a(new hu.2(this, localLinkedList));
    }
    return localLinkedList;
  }
  
  private void b(LinkedList<hr> paramLinkedList)
  {
    if (!hj.a(paramLinkedList)) {}
    for (;;)
    {
      return;
      Collections.sort(paramLinkedList, new hu.4(this));
      Object localObject = ha.getConfiguredNetworks();
      if (hj.a((Collection)localObject))
      {
        LinkedList localLinkedList = new LinkedList();
        ListIterator localListIterator = paramLinkedList.listIterator();
        for (;;)
        {
          if (!localListIterator.hasNext()) {
            break label128;
          }
          hr localhr = (hr)localListIterator.next();
          Iterator localIterator = ((List)localObject).iterator();
          if (localIterator.hasNext())
          {
            if (!TextUtils.equals(ha.j(((WifiConfiguration)localIterator.next()).SSID), localhr.ssid)) {
              break;
            }
            localLinkedList.push(localhr);
            localListIterator.remove();
          }
        }
        label128:
        localObject = localLinkedList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramLinkedList.push((hr)((Iterator)localObject).next());
        }
      }
    }
  }
  
  public void a(a parama)
  {
    this.ub = parama;
  }
  
  public void onConnectionCancel()
  {
    this.ud = null;
  }
  
  public void onConnectionFailed(int paramInt) {}
  
  public void onConnectionStart(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    this.ud = paramTMSDKFreeWifiInfo.ssid;
  }
  
  public void onConnectionStateChanged(int paramInt, TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    if ((paramTMSDKFreeWifiInfo == null) || (paramTMSDKFreeWifiInfo.ssid == null)) {
      return;
    }
    this.ud = paramTMSDKFreeWifiInfo.ssid;
  }
  
  public void onConnectionSuccess(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    if (paramTMSDKFreeWifiInfo == null) {
      return;
    }
    this.ud = paramTMSDKFreeWifiInfo.ssid;
    N(false);
  }
  
  public void onGPSDisabled()
  {
    this.ub.aD(2);
    this.ud = null;
  }
  
  public void onGPSEnabled()
  {
    if (!hm.fu())
    {
      N(false);
      return;
    }
    this.ub.aD(4);
  }
  
  public void onScanResult(@NonNull List<bn> paramList)
  {
    if (hm.fu()) {
      return;
    }
    this.ug.set(true);
    N(false);
  }
  
  public void onUpdateFinish(int paramInt, List<TMSDKFreeWifiInfo> paramList)
  {
    this.ug.set(true);
    dg.a(fq.cr(), "更新完成：" + paramInt + "|" + hj.b(paramList));
    if (paramInt == -1)
    {
      this.ub.aD(1);
      return;
    }
    if (paramInt == -3)
    {
      this.ub.aD(2);
      return;
    }
    if (paramInt == -2)
    {
      this.ub.aD(3);
      return;
    }
    if (paramInt == -4)
    {
      this.ub.aD(5);
      return;
    }
    N(false);
  }
  
  public void onUpdateStart()
  {
    this.ug.set(false);
    this.ub.aD(4);
  }
  
  public void onWifiDisabled()
  {
    this.ub.aD(3);
    this.ud = null;
  }
  
  public void onWifiEnabled()
  {
    if (!hm.fu()) {
      N(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.hu
 * JD-Core Version:    0.7.0.1
 */