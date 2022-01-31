package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class e
  extends i
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -2;
  public static final int d = -3;
  public static final int e = -4;
  private static final String g = "WifiDetector";
  private static final String h = "_wifi_detect_history";
  private static final long i = 7200000L;
  private static final long j = 60000L;
  private static final long k = 86400000L;
  private static final int s = 1000;
  private MsfCore l;
  private AtomicBoolean m = new AtomicBoolean(false);
  private volatile int n = 0;
  private int o = -1;
  private String p;
  private String q;
  private HashMap r = new HashMap();
  private Handler t = new f(this);
  private a.a u = new g(this);
  
  public e(MsfCore paramMsfCore)
  {
    this.l = paramMsfCore;
    g();
    e();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case -2: 
    case -1: 
    default: 
      return -1;
    case 0: 
      return 0;
    }
    return -2;
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((this.o != -2) || (paramInt == 0)) {
      this.o = paramInt;
    }
    if (this.o == -2) {
      this.p = paramString;
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = new h(paramString, paramLong, paramBoolean);
    this.r.put(paramString, localObject1);
    localObject1 = this.r.entrySet().iterator();
    JSONArray localJSONArray;
    for (;;)
    {
      Object localObject2;
      try
      {
        localJSONArray = new JSONArray();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (h)((Map.Entry)localObject3).getValue();
        if ((!((h)localObject3).a.equals(paramString)) && (System.currentTimeMillis() - ((h)localObject3).b > 86400000L))
        {
          this.r.remove(localObject2);
          continue;
        }
        localObject2 = ((h)localObject3).a();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (localObject2 != null) {
        localJSONArray.put(localObject2);
      }
    }
    MsfStore.getNativeConfigStore().setConfig("_wifi_detect_history", localJSONArray.toString());
  }
  
  private void b(String paramString, long paramLong)
  {
    this.t.removeMessages(1000);
    Message localMessage = this.t.obtainMessage();
    localMessage.obj = paramString;
    this.t.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (!NetConnInfoCenterImpl.isWifiConn())
        {
          QLog.d("WifiDetector", 1, "WIFI detect start failed, wifi is not connected!");
          return;
        }
        if (!d(paramString))
        {
          QLog.d("WifiDetector", 1, "WIFI detect start failed, ssid is invalid!");
          continue;
        }
        if (this.m.compareAndSet(false, true)) {
          break label76;
        }
      }
      finally {}
      QLog.d("WifiDetector", 1, "WIFI detect start failed, there is detect running!");
      b(paramString, 60000L);
      continue;
      label76:
      QLog.d("WifiDetector", 1, "WIFI detect started!");
      this.q = paramString;
      a(this.q, System.currentTimeMillis());
      b(paramString, 7200000L);
      while (i1 < this.f.length)
      {
        this.n |= 1 << i1;
        paramString = a(this.f[i1], i1, this.u);
        if (paramString != null)
        {
          paramString = new Thread(paramString);
          paramString.setName("WifiDetectEchoThread");
          paramString.start();
        }
        i1 += 1;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(NetConnInfoCenterImpl.getLastWifiSSID()));
  }
  
  private void e()
  {
    if ((NetConnInfoCenterImpl.isWifiConn()) && (d(NetConnInfoCenterImpl.getLastWifiSSID()))) {
      a(NetConnInfoCenterImpl.getLastWifiSSID());
    }
  }
  
  private void f()
  {
    this.m.set(false);
    this.n = 0;
    this.o = -1;
    this.p = null;
    this.q = "";
  }
  
  private void g()
  {
    Object localObject = MsfStore.getNativeConfigStore().getConfig("_wifi_detect_history");
    try
    {
      localObject = new JSONArray((String)localObject);
      int i1 = 0;
      while (i1 < ((JSONArray)localObject).length())
      {
        h localh = h.a(((JSONArray)localObject).getJSONObject(i1));
        if (localh != null) {
          this.r.put(localh.a, localh);
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiDisconnected!");
    this.t.removeMessages(1000);
  }
  
  public void a(String paramString)
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnected!");
    h localh = (h)this.r.get(paramString);
    long l1 = System.currentTimeMillis();
    if (localh == null)
    {
      a(paramString, false);
      c(paramString);
      return;
    }
    if (!localh.c)
    {
      c(paramString);
      return;
    }
    if (l1 - localh.b >= 7200000L)
    {
      c(paramString);
      return;
    }
    b(paramString, 7200000L - (l1 - localh.b));
  }
  
  public void a(String paramString, long paramLong)
  {
    h localh = (h)this.r.get(paramString);
    if (localh != null)
    {
      a(paramString, paramLong, localh.c);
      return;
    }
    a(paramString, paramLong, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    h localh = (h)this.r.get(paramString);
    if (localh != null) {
      a(paramString, localh.b, paramBoolean);
    }
  }
  
  public void b()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiAllConnFailed!");
    c(NetConnInfoCenterImpl.getLastWifiSSID());
  }
  
  public void b(String paramString)
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnSucc!");
    a(paramString, true);
  }
  
  public void c()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnFake!");
    c(NetConnInfoCenterImpl.getLastWifiSSID());
  }
  
  public void d()
  {
    int i1 = this.o;
    String str = this.p;
    if (NetConnInfoCenterImpl.isWifiConn()) {
      if (i1 == 0) {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OK");
      }
    }
    for (;;)
    {
      f();
      return;
      if (i1 == -1)
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_EXCEPTION");
      }
      else if ((i1 == -2) && (!this.l.sender.a.b()) && (d(this.q)))
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NEED_AUTH");
        FromServiceMsg localFromServiceMsg = new FromServiceMsg(NetConnInfoCenterImpl.msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_netNeedSignon");
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.setMsfCommand(MsfCommand.onNetNeedSignon);
        localFromServiceMsg.addAttribute("signonurl", str);
        MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
        NetConnInfoCenterImpl.msfCore.addRespToQuque(null, localFromServiceMsg);
      }
      else
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OTHER");
        continue;
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NONE");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.e
 * JD-Core Version:    0.7.0.1
 */