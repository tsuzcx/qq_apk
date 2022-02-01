package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetConnInfoCenter
  extends BroadcastReceiver
{
  public static final String ACTION_FILTER_MSF_NET_CHANGE = "com.tencent.mobileqq.msf.bd.netchange";
  public static byte[] GUID;
  public static String RDMREPORT_INTENT;
  public static final String TAG = "NetConnInfoCenter";
  public static boolean isUseNewImpl = true;
  public static MsfCore msfCore;
  public static boolean needWifiAuth;
  private static AtomicBoolean netSupport = new AtomicBoolean(false);
  public static int sAppTimeoutConfig;
  private static boolean sHasBooted;
  public static NetConnInfoCenter sNetConnIfnoCenter = new NetConnInfoCenter();
  public static long servetTimeSecondInterv = 0L;
  public static volatile int socketConnState = 0;
  
  static
  {
    RDMREPORT_INTENT = "com.tencent.tim.rdm.report";
    GUID = new byte[0];
    sHasBooted = false;
    sAppTimeoutConfig = 2000;
  }
  
  public static void callQQProcess(String paramString)
  {
    int i = 0;
    try
    {
      if (g.s)
      {
        long l = com.tencent.mobileqq.msf.core.a.a.X();
        Object localObject = new Intent(paramString);
        paramString = g.t;
        if (msfCore != null) {
          i = msfCore.getUinPushStatus(paramString);
        }
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", ak.o());
        ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
        if (l > 0L)
        {
          localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
          ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.X(), (PendingIntent)localObject);
          QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " delayed: " + l);
        }
        for (;;)
        {
          g.s = false;
          return;
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(paramString) + " right now");
        }
      }
      QLog.d("NetConnInfoCenter", 1, "not need send bootAction for QQ");
    }
    catch (Exception paramString)
    {
      QLog.d("NetConnInfoCenter", 1, "send bootAction for QQ error " + paramString);
      return;
    }
  }
  
  public static void checkConnInfo()
  {
    aa.a().a(BaseApplication.getContext(), null, false);
  }
  
  public static void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    aa.a().a(paramContext, paramNetworkInfo, paramBoolean);
  }
  
  public static void checkConnInfo(Context paramContext, boolean paramBoolean)
  {
    aa.a().a(paramContext, null, paramBoolean);
  }
  
  public static void checkRecordTime()
  {
    aa.a().z();
  }
  
  public static int getActiveNetIpFamily(boolean paramBoolean)
  {
    return aa.a().c(paramBoolean);
  }
  
  public static int getActiveNetworkType()
  {
    return aa.a().x();
  }
  
  public static int getCdmaStrength()
  {
    return aa.a().B();
  }
  
  public static String getCurrentAPN()
  {
    return aa.a().u();
  }
  
  public static String getCurrentAPN(boolean paramBoolean)
  {
    return aa.a().b(paramBoolean);
  }
  
  public static String getCurrentSSID()
  {
    return aa.a().q();
  }
  
  public static String getCurrentSSID(boolean paramBoolean)
  {
    return aa.a().a(paramBoolean);
  }
  
  public static int getGsmStrength()
  {
    return aa.a().C();
  }
  
  public static String getLastWifiSSID()
  {
    return aa.a().r();
  }
  
  public static int getMobileNetworkType()
  {
    return aa.a().t();
  }
  
  public static long getServerTime()
  {
    return System.currentTimeMillis() / 1000L + servetTimeSecondInterv;
  }
  
  public static long getServerTimeMillis()
  {
    return System.currentTimeMillis() + servetTimeSecondInterv * 1000L;
  }
  
  public static String getSignalStrengthsLog()
  {
    return " SignalStrengths wifi:" + getWifiStrength() + " gsm:" + getGsmStrength() + " cdma:" + getCdmaStrength() + " net:" + getSystemNetworkType();
  }
  
  public static int getSystemNetState()
  {
    return aa.a().k();
  }
  
  public static String getSystemNetStateString()
  {
    return com.tencent.mobileqq.msf.sdk.a.a.a(getSystemNetState());
  }
  
  public static int getSystemNetworkType()
  {
    return aa.a().w();
  }
  
  public static int getWifiStrength()
  {
    return aa.a().A();
  }
  
  public static void handleGetServerTimeResp(long paramLong)
  {
    aa.a().a(paramLong);
  }
  
  public static void init(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    aa.a().a(paramMsfCore);
    if (Build.VERSION.SDK_INT >= 24)
    {
      int i = BaseApplication.getContext().getApplicationInfo().targetSdkVersion;
      if (i >= 24)
      {
        paramMsfCore = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        BaseApplication.getContext().registerReceiver(sNetConnIfnoCenter, paramMsfCore);
        if ((Build.VERSION.SDK_INT >= 26) && (i >= 26))
        {
          paramMsfCore = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
          BaseApplication.getContext().registerReceiver(sNetConnIfnoCenter, paramMsfCore);
        }
      }
    }
  }
  
  public static InetAddress intToInetAddress(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(new byte[] { i, j, k, m });
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw new AssertionError();
    }
  }
  
  public static boolean isMobileConn()
  {
    return aa.a().o();
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public static boolean isNeedWifiAuth()
  {
    return needWifiAuth;
  }
  
  public static boolean isNetSupport()
  {
    return netSupport.get();
  }
  
  public static boolean isWifiConn()
  {
    return aa.a().n();
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return aa.a().m();
  }
  
  public static void onConnClosed(com.tencent.qphone.base.a parama)
  {
    aa.a().a(parama);
  }
  
  public static void onConnOpened(String paramString1, String paramString2)
  {
    aa.a().c(paramString1, paramString2);
  }
  
  public static void onOepnConnAllFailed()
  {
    aa.a().p();
  }
  
  public static void onRecvFirstResp()
  {
    aa.a().s();
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    aa.a().j();
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    netSupport.set(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("NetConnInfoCenter", 2, "setNetSupport " + paramBoolean);
    }
  }
  
  public static void startOrBindService(Intent paramIntent)
  {
    try
    {
      BaseApplication.getContext().startService(paramIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NetConnInfoCenter", 1, "init msf startService exception:", localException);
      try
      {
        BaseApplication.getContext().bindService(paramIntent, new z(), 1);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.d("NetConnInfoCenter", 1, "init msf bindService exception:", paramIntent);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("NetConnInfoCenter", 2, "receive broadcast intent == null return");
      }
    }
    do
    {
      do
      {
        do
        {
          boolean bool1;
          do
          {
            do
            {
              return;
              QLog.d("NetConnInfoCenter", 1, "receive broadcast " + paramIntent + ", init = " + MsfService.inited);
              if (paramIntent.getAction() != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("NetConnInfoCenter", 2, "receive broadcast intent.getAction() == null return");
            return;
            if (paramIntent.getAction().equals("com.tencent.tim.msf.receiveofflinepush"))
            {
              msfCore.pushManager.n();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.tim.msf.offlinepushclearall"))
            {
              msfCore.pushManager.i();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.tim.msf.receiveofflinepushav"))
            {
              msfCore.pushManager.o();
              return;
            }
            if (paramIntent.getAction().equals("com.tencent.tim.msf.offlinepushclearallav"))
            {
              msfCore.pushManager.j();
              return;
            }
            boolean bool2 = false;
            bool1 = bool2;
            if (!sHasBooted)
            {
              sHasBooted = true;
              if (SystemClock.elapsedRealtime() >= 300000L)
              {
                bool1 = bool2;
                if (!"android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent.getAction())) {}
              }
              else
              {
                bool1 = true;
              }
            }
            Intent localIntent;
            if ((!MsfService.inited) && ("1".equals(paramContext.getSharedPreferences("c_profile_sharepreference", 4).getString("privacypolicy_state", "0"))))
            {
              MsfService.sIsCreatedByAutoBoot = bool1;
              localIntent = new Intent(paramContext, MsfService.class);
              localIntent.putExtra("key_action_name", paramIntent.getAction());
              startOrBindService(localIntent);
            }
            if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
              break;
            }
            try
            {
              paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
              if (QLog.isColorLevel()) {
                QLog.i("NetConnInfoCenter", 2, "onReceive CONNECTIVITY_CHANGE, extra: " + paramIntent);
              }
              localIntent = new Intent();
              localIntent.setAction("com.tencent.mobileqq.msf.bd.netchange");
              localIntent.setPackage("com.tencent.tim");
              localIntent.putExtra("networkInfo", paramIntent);
              paramContext.sendBroadcast(localIntent);
              checkConnInfo(paramContext, paramIntent, true);
              ac.a().d();
              return;
            }
            catch (Exception paramContext) {}
          } while (!QLog.isColorLevel());
          QLog.d("NetConnInfoCenter", 2, paramContext.toString(), paramContext);
          return;
          if ((paramIntent.getAction().equals("android.intent.action.TIME_SET")) || (paramIntent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NetConnInfoCenter", 2, "recv broadcast " + paramIntent.getAction());
            }
            aa.a().y();
            return;
          }
          if (!bool1) {
            break;
          }
          com.tencent.mobileqq.msf.core.a.a.a(true);
          com.tencent.mobileqq.msf.core.c.k.S = true;
        } while (!QLog.isColorLevel());
        QLog.d("NetConnInfoCenter", 2, "set StatReporter.needReportBooting true");
        return;
        if (!paramIntent.getAction().equals(RDMREPORT_INTENT)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NetConnInfoCenter", 2, "receive reportRDM call");
      return;
    } while (!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramIntent.getAction()));
    if (QLog.isColorLevel()) {
      QLog.i("NetConnInfoCenter", 2, "receive WIFI_STATE_CHANGED_ACTION");
    }
    ac.a().a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenter
 * JD-Core Version:    0.7.0.1
 */