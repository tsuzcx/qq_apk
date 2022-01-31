package wf7;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.wifisdk.ui.api.RProxy.string;
import com.wifisdk.ui.view.c;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class hs
{
  private Context mContext;
  private Handler mHandler = new hs.1(this, Looper.myLooper());
  private List<Integer> tP;
  private ho tQ;
  private ho tR;
  private hq tS;
  private LinkedHashMap<String, hp> tT = new LinkedHashMap();
  private LinkedHashMap<String, hp> tU = new LinkedHashMap();
  private boolean tV = false;
  private boolean tW = false;
  private c tx;
  
  public hs(Context paramContext)
  {
    this.mContext = paramContext;
    this.tQ = new ho(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_title));
    this.tR = new ho(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_title));
    this.tS = new hq();
    fz();
    fA();
    ca.a((WifiManager)this.mContext.getApplicationContext().getSystemService("wifi"));
  }
  
  private void A(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.tx.aE(paramInt2);
      this.tS.tH = 0;
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        this.tx.aF(paramInt2);
        this.tS.tH = 1;
        return;
      }
    } while (paramInt1 != 3);
    this.tx.aG(paramInt2);
    this.tS.tH = 2;
  }
  
  private void a(List<hn> paramList, Collection paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return;
    }
    paramCollection = new ArrayList(paramCollection);
    try
    {
      Collections.reverse(paramCollection);
      paramList.addAll(paramCollection);
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
  
  private static String ae(String paramString)
  {
    paramString = ha.X(paramString);
    if (paramString == null) {
      return null;
    }
    if (paramString.allowedKeyManagement.get(1)) {
      return "WPA2";
    }
    if ((paramString.allowedKeyManagement.get(2)) || (paramString.allowedKeyManagement.get(3))) {
      return "EAP";
    }
    if (paramString.wepKeys[0] != null) {
      return "WEP";
    }
    return "未加密";
  }
  
  private void fA()
  {
    this.tU.clear();
    this.tW = false;
    this.tU.put("EST_Fake", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_item1), true, 1, 0));
    this.tU.put("EST_Phishing", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_item2), true, 1, 0));
    this.tU.put("EST_DnsException", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_item3), true, 1, 0));
    this.tU.put("EST_Monitored", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_item4), true, 1, 0));
    this.tU.put("EST_PasswordLeak", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_cloud_item5), true, 1, 0));
  }
  
  private void fB()
  {
    if ((this.tT == null) || (this.tT.size() != 6))
    {
      this.tV = false;
      return;
    }
    if (!ca.b(this.mContext))
    {
      this.tV = false;
      this.mHandler.sendEmptyMessage(2);
      return;
    }
    try
    {
      Object localObject1 = ca.getConnectionInfo();
      hp localhp = (hp)this.tT.get("ssid");
      if (localhp != null) {
        localhp.tD = ca.aI();
      }
      localhp = (hp)this.tT.get("singal_level");
      if ((localhp != null) && (localObject1 != null)) {
        localhp.tD = (ca.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 100) + "%");
      }
      localhp = (hp)this.tT.get("security_type");
      if (localhp != null)
      {
        String str = ae(ca.aI());
        if (str != null) {
          localhp.tD = str;
        }
      }
      localhp = (hp)this.tT.get("link_speed");
      if ((localhp != null) && (localObject1 != null)) {
        localhp.tD = (((WifiInfo)localObject1).getLinkSpeed() + "Mbps");
      }
      localObject1 = (hp)this.tT.get("ip");
      if (localObject1 != null) {
        ((hp)localObject1).tD = ca.aH();
      }
      localObject1 = (hp)this.tT.get("mac");
      if (localObject1 != null) {
        ((hp)localObject1).tD = ca.aG();
      }
      this.tV = true;
      this.mHandler.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  private void fC()
  {
    int m = 0;
    int j = 0;
    if ((this.tU == null) || (this.tU.size() != 5))
    {
      this.tW = false;
      localObject = Message.obtain();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).arg2 = 0;
      this.mHandler.sendMessageDelayed((Message)localObject, 2000L);
      return;
    }
    Object localObject = this.tU.values().iterator();
    hp localhp;
    while (((Iterator)localObject).hasNext())
    {
      localhp = (hp)((Iterator)localObject).next();
      localhp.tG = 1;
      localhp.tE = 0;
      localhp.tD = this.mContext.getString(RProxy.string.tmsdk_wifi_security_item_safe);
    }
    if (!ca.b(this.mContext))
    {
      this.tW = true;
      localObject = Message.obtain();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).arg2 = 0;
      this.mHandler.sendMessageDelayed((Message)localObject, 2000L);
      return;
    }
    int i;
    int k;
    if ((this.tP != null) && (!this.tP.isEmpty()) && (!this.tP.contains(Integer.valueOf(1))))
    {
      Iterator localIterator = this.tP.iterator();
      i = 0;
      m = j;
      k = i;
      if (localIterator.hasNext())
      {
        switch (((Integer)localIterator.next()).intValue())
        {
        default: 
          k = j;
          localObject = "";
          localhp = null;
          j = i;
          i = k;
        }
        for (;;)
        {
          localhp.tE = 1;
          localhp.tD = this.mContext.getString(RProxy.string.tmsdk_wifi_security_item_danger);
          this.tU.remove(localObject);
          this.tU.put(localObject, localhp);
          k = j;
          j = i;
          i = k;
          break;
          localhp = (hp)this.tU.get("EST_DnsException");
          if (localhp == null) {
            break;
          }
          k = j + 1;
          j = i;
          localObject = "EST_DnsException";
          i = k;
          continue;
          localhp = (hp)this.tU.get("EST_Phishing");
          if (localhp == null) {
            break;
          }
          k = j + 1;
          j = i;
          localObject = "EST_Phishing";
          i = k;
          continue;
          localhp = (hp)this.tU.get("EST_PasswordLeak");
          if (localhp == null) {
            break;
          }
          k = i + 1;
          localObject = "EST_PasswordLeak";
          i = j;
          j = k;
          continue;
          localhp = (hp)this.tU.get("EST_Fake");
          if (localhp == null) {
            break;
          }
          k = j + 1;
          j = i;
          localObject = "EST_Fake";
          i = k;
          continue;
          localhp = (hp)this.tU.get("EST_Monitored");
          if (localhp == null) {
            break;
          }
          k = i + 1;
          localObject = "EST_Monitored";
          i = j;
          j = k;
        }
      }
    }
    else
    {
      k = 0;
    }
    if (m > 0) {
      i = 3;
    }
    for (;;)
    {
      this.tW = true;
      localObject = Message.obtain();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = i;
      ((Message)localObject).arg2 = (k + m);
      this.mHandler.sendMessageDelayed((Message)localObject, 2000L);
      return;
      if (k > 0) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  private void fz()
  {
    this.tT.clear();
    this.tV = false;
    this.tT.put("mac", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_mac), true));
    this.tT.put("ip", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_ip), true));
    this.tT.put("link_speed", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_link_speed), true));
    this.tT.put("security_type", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_security_type), true));
    this.tT.put("singal_level", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_signal_level), true));
    this.tT.put("ssid", new hp(this.mContext.getString(RProxy.string.tmsdk_wifi_security_local_item_ssid), true));
  }
  
  public void a(c paramc)
  {
    this.tx = paramc;
    paramc.l(this);
  }
  
  public void fx()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void fy()
  {
    this.mHandler.removeMessages(3);
    Message.obtain().what = 3;
    this.mHandler.obtainMessage(3).sendToTarget();
  }
  
  public void r(List<Integer> paramList)
  {
    this.tP = paramList;
    this.mHandler.removeMessages(0);
    this.mHandler.obtainMessage(0).sendToTarget();
    fx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hs
 * JD-Core Version:    0.7.0.1
 */