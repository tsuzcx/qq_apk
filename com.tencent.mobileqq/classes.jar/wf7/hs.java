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
      return;
    }
    if (paramInt1 == 2)
    {
      this.tx.aF(paramInt2);
      this.tS.tH = 1;
      return;
    }
    if (paramInt1 == 3)
    {
      this.tx.aG(paramInt2);
      this.tS.tH = 2;
    }
  }
  
  private void a(List<hn> paramList, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      if (paramCollection.isEmpty()) {
        return;
      }
      paramCollection = new ArrayList(paramCollection);
      try
      {
        Collections.reverse(paramCollection);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      paramList.addAll(paramCollection);
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
    if ((!paramString.allowedKeyManagement.get(2)) && (!paramString.allowedKeyManagement.get(3)))
    {
      if (paramString.wepKeys[0] != null) {
        return "WEP";
      }
      return "未加密";
    }
    return "EAP";
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
    Object localObject1 = this.tT;
    if ((localObject1 != null) && (((LinkedHashMap)localObject1).size() == 6))
    {
      if (!ca.b(this.mContext))
      {
        this.tV = false;
        this.mHandler.sendEmptyMessage(2);
        return;
      }
      localObject1 = null;
      try
      {
        WifiInfo localWifiInfo = ca.getConnectionInfo();
        localObject1 = localWifiInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      hp localhp = (hp)this.tT.get("ssid");
      if (localhp != null) {
        localhp.tD = ca.aI();
      }
      localhp = (hp)this.tT.get("singal_level");
      Object localObject2;
      if ((localhp != null) && (localObject1 != null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ca.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 100));
        ((StringBuilder)localObject2).append("%");
        localhp.tD = ((StringBuilder)localObject2).toString();
      }
      localhp = (hp)this.tT.get("security_type");
      if (localhp != null)
      {
        localObject2 = ae(ca.aI());
        if (localObject2 != null) {
          localhp.tD = ((String)localObject2);
        }
      }
      localhp = (hp)this.tT.get("link_speed");
      if ((localhp != null) && (localObject1 != null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((WifiInfo)localObject1).getLinkSpeed());
        ((StringBuilder)localObject2).append("Mbps");
        localhp.tD = ((StringBuilder)localObject2).toString();
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
    this.tV = false;
  }
  
  private void fC()
  {
    Object localObject1 = this.tU;
    int k = 0;
    int j = 0;
    if ((localObject1 != null) && (((LinkedHashMap)localObject1).size() == 5))
    {
      localObject1 = this.tU.values().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (hp)((Iterator)localObject1).next();
        ((hp)localObject2).tG = 1;
        ((hp)localObject2).tE = 0;
        ((hp)localObject2).tD = this.mContext.getString(RProxy.string.tmsdk_wifi_security_item_safe);
      }
      if (!ca.b(this.mContext))
      {
        this.tW = true;
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 4;
        ((Message)localObject1).arg1 = 1;
        ((Message)localObject1).arg2 = 0;
        this.mHandler.sendMessageDelayed((Message)localObject1, 2000L);
        return;
      }
      localObject1 = this.tP;
      int m = 2;
      int i;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()) && (!this.tP.contains(Integer.valueOf(1))))
      {
        Iterator localIterator = this.tP.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (Integer)localIterator.next();
          Object localObject3 = null;
          k = ((Integer)localObject1).intValue();
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                if (k != 5)
                {
                  if (k != 6)
                  {
                    localObject2 = "";
                    break label436;
                  }
                  localObject2 = "EST_Monitored";
                  localObject3 = (hp)this.tU.get("EST_Monitored");
                  localObject1 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject1 = "EST_Fake";
                  localObject3 = (hp)this.tU.get("EST_Fake");
                  localObject2 = localObject3;
                  if (localObject3 != null) {
                    break label424;
                  }
                }
              }
              else
              {
                localObject2 = "EST_PasswordLeak";
                localObject3 = (hp)this.tU.get("EST_PasswordLeak");
                localObject1 = localObject3;
                if (localObject3 == null) {
                  continue;
                }
              }
              j += 1;
              localObject3 = localObject1;
              break label436;
            }
            else
            {
              localObject1 = "EST_Phishing";
              localObject3 = (hp)this.tU.get("EST_Phishing");
              localObject2 = localObject3;
              if (localObject3 != null) {}
            }
          }
          else
          {
            localObject1 = "EST_DnsException";
            localObject3 = (hp)this.tU.get("EST_DnsException");
            localObject2 = localObject3;
            if (localObject3 == null) {
              continue;
            }
          }
          label424:
          i += 1;
          localObject3 = localObject2;
          localObject2 = localObject1;
          label436:
          ((hp)localObject3).tE = 1;
          ((hp)localObject3).tD = this.mContext.getString(RProxy.string.tmsdk_wifi_security_item_danger);
          this.tU.remove(localObject2);
          this.tU.put(localObject2, localObject3);
        }
        k = i;
      }
      else
      {
        j = 0;
      }
      if (k > 0) {
        i = 3;
      } else if (j > 0) {
        i = m;
      } else {
        i = 1;
      }
      this.tW = true;
      localObject1 = Message.obtain();
      ((Message)localObject1).what = 4;
      ((Message)localObject1).arg1 = i;
      ((Message)localObject1).arg2 = (j + k);
      this.mHandler.sendMessageDelayed((Message)localObject1, 2000L);
      return;
    }
    this.tW = false;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 4;
    ((Message)localObject1).arg1 = 1;
    ((Message)localObject1).arg2 = 0;
    this.mHandler.sendMessageDelayed((Message)localObject1, 2000L);
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