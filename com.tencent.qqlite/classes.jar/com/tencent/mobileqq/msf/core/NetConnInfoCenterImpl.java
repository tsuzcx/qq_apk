package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.core.net.h;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NetConnInfoCenterImpl
{
  public static final String KEY_RECORD_SERVER_TIME = "recordSysTimeKey";
  private static int _activeNetInfoType = 0;
  static int _dayOfYear = 0;
  private static String _lastMobileApn;
  private static String _lastWifiSSID;
  private static AtomicBoolean _netSupport;
  static String currentAPN;
  private static long lastCheckTime = 0L;
  private static AtomicBoolean lastConnSuccWithoutNet;
  private static long lastConnSuccWithoutNetTime = 0L;
  private static int mobileNetworkType = 0;
  private static final byte mobileStat = 0;
  public static MsfCore msfCore;
  static boolean needWifiAuth = false;
  static AtomicInteger netChangeCount;
  private static final String serverTimeDiffKey = "servetTimeDiff";
  static String subtypeName;
  static String tag = "MSF.C.NetConnInfoCenter";
  private static final byte wifiStat = 1;
  boolean calculateSignalLevel = true;
  private long firstGetServerTime = 0L;
  int lastCdmaStrenght;
  private long lastGetServerTimeInterval = 0L;
  int lastGsmStrength;
  int lastWifiStrength;
  private int sendGetServerTimeMsgCount = 0;
  
  static
  {
    netChangeCount = new AtomicInteger(0);
    _dayOfYear = Calendar.getInstance().get(6);
    _activeNetInfoType = 0;
    _netSupport = new AtomicBoolean(false);
    lastCheckTime = -1L;
    lastConnSuccWithoutNet = new AtomicBoolean();
    lastConnSuccWithoutNetTime = 0L;
    currentAPN = "";
    subtypeName = "";
  }
  
  public static void callQQProcess(String paramString)
  {
    try
    {
      if (f.n)
      {
        Object localObject = new Intent(paramString);
        paramString = f.o;
        int i = msfCore.getUinPushStatus(paramString);
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", l.m());
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.y(), (PendingIntent)localObject);
        QLog.d(tag, 1, "send bootAction for QQ " + paramString);
        f.n = false;
        return;
      }
      QLog.d(tag, 1, "not need send bootAction for QQ");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d(tag, 1, "send bootAction for QQ error " + paramString);
    }
  }
  
  private void closeNowConn()
  {
    if ((msfCore != null) && (msfCore.sender != null)) {
      msfCore.sender.a(com.tencent.qphone.base.a.b);
    }
  }
  
  public static String getCurrentAPN()
  {
    return currentAPN;
  }
  
  public static String getLastWifiSSID()
  {
    return _lastWifiSSID;
  }
  
  public static int getMobileNetworkType()
  {
    return mobileNetworkType;
  }
  
  private static String getNetStatusMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "NONE";
    case 1: 
      return "MOBILE";
    case 2: 
      return "WiFi";
    }
    return "WiFi";
  }
  
  public static String getNetSubtypeName()
  {
    return subtypeName;
  }
  
  public static int getSystemNetState()
  {
    if (isWifiConn()) {
      return 2;
    }
    if (isMobileConn()) {
      return 1;
    }
    return 0;
  }
  
  public static int getSystemNetworkType()
  {
    int i = 0;
    if (isWifiConn()) {
      i = _activeNetInfoType;
    }
    while (!isMobileConn()) {
      return i;
    }
    return getMobileNetworkType() + 10000;
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
    return _activeNetInfoType == 1;
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
    return _netSupport.get();
  }
  
  public static boolean isWifiConn()
  {
    return (_activeNetInfoType == 2) || (_activeNetInfoType == 3);
  }
  
  public static boolean isWifiOrMobileConn()
  {
    return (isWifiConn()) || (isMobileConn());
  }
  
  private void mobileConnected(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null) {
      mobileNetworkType = paramNetworkInfo.getSubtype();
    }
    for (;;)
    {
      setConnInfo(_activeNetInfoType | 0x1);
      return;
      try
      {
        mobileNetworkType = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
      }
      catch (Exception paramNetworkInfo)
      {
        paramNetworkInfo.printStackTrace();
      }
    }
  }
  
  private void mobileDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFE);
  }
  
  private void onWifiConnChanged()
  {
    if (isWifiConn()) {
      if ((msfCore != null) && (msfCore.sender != null)) {
        msfCore.sender.a.h.a(_lastWifiSSID);
      }
    }
    while ((msfCore == null) || (msfCore.sender == null)) {
      return;
    }
    msfCore.sender.a.h.a();
  }
  
  private static void resetLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNet.set(false);
    lastConnSuccWithoutNetTime = 0L;
  }
  
  private void sendNewCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "Client.CorrectTime");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      localToServiceMsg.setAppId(msfCore.sender.i());
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.addAttribute("__base_tag_isAppMsg", Boolean.valueOf(true));
      localToServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
      msfCore.sender.b(localToServiceMsg);
    }
    while (!QLog.isDevelopLevel())
    {
      ToServiceMsg localToServiceMsg;
      return;
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  private void sendOldCheckServerTime()
  {
    if (msfCore != null)
    {
      localToServiceMsg = new ToServiceMsg("", "0", "login.time");
      localToServiceMsg.setMsfCommand(MsfCommand.getServerTime);
      localToServiceMsg.setAppId(msfCore.sender.i());
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localUniPacket = new UniPacket(true);
      localUniPacket.setServantName("test");
      localUniPacket.setFuncName("cmdstr");
      locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", msfCore.sender.i(), String.valueOf(msfCore.sender.i()), "123", 0);
      localc = new c();
      localc.a = ((int)(System.currentTimeMillis() / 1000L));
      localUniPacket.put("RequestHeader", locald);
      localUniPacket.put("RequestGetServerTime", localc);
      localToServiceMsg.putWupBuffer(localUniPacket.encode());
      msfCore.sender.b(localToServiceMsg);
    }
    while (!QLog.isDevelopLevel())
    {
      ToServiceMsg localToServiceMsg;
      UniPacket localUniPacket;
      d locald;
      c localc;
      return;
    }
    QLog.d(tag, 4, "msfCore not inited. can not send checkServerTimeMsg.");
  }
  
  public static void setLastConnSuccWithoutNet()
  {
    lastConnSuccWithoutNetTime = System.currentTimeMillis();
    lastConnSuccWithoutNet.set(true);
  }
  
  static void setMsfCore(MsfCore paramMsfCore)
  {
    msfCore = paramMsfCore;
    NetConnInfoCenter.servetTimeSecondInterv = BaseApplication.getContext().getSharedPreferences(tag, 0).getLong("servetTimeDiff", 0L);
  }
  
  public static void setNeedWifiAuth(boolean paramBoolean)
  {
    needWifiAuth = paramBoolean;
  }
  
  public static void setNetSupport(boolean paramBoolean)
  {
    _netSupport.set(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "setNetSupport " + _netSupport.get());
    }
  }
  
  private void wifiConnected()
  {
    WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null)
    {
      int i = localWifiInfo.getIpAddress();
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "wifiConnected localAddress " + i + "(" + intToInetAddress(i).getHostAddress() + "), " + localWifiInfo.toString());
      }
      if (msfCore != null) {
        msfCore.getStatReporter().a(localWifiInfo);
      }
    }
    setConnInfo(_activeNetInfoType | 0x2);
  }
  
  private void wifiDisConnected()
  {
    setConnInfo(_activeNetInfoType & 0xFFFFFFFD);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    checkConnInfo(paramContext, paramNetworkInfo, false);
  }
  
  public void checkConnInfo(Context paramContext, NetworkInfo paramNetworkInfo, boolean paramBoolean)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramBoolean) {
      com.tencent.mobileqq.msf.core.b.i.e();
    }
    checkConnInfo(localConnectivityManager.getActiveNetworkInfo(), paramNetworkInfo);
    try
    {
      paramContext = localConnectivityManager.getNetworkInfo(0);
      if (paramContext != null) {
        break label98;
      }
      paramContext = localConnectivityManager.getNetworkInfo(50);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d(tag, 1, "get currentAPN error " + paramContext);
      }
    }
    if (paramContext != null) {
      currentAPN = paramContext.getExtraInfo();
    }
    if (paramBoolean) {
      com.tencent.mobileqq.msf.core.b.i.e();
    }
  }
  
  public void checkConnInfo(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    String str;
    if (paramNetworkInfo1 != null) {
      str = paramNetworkInfo1.getTypeName();
    }
    do
    {
      do
      {
        try
        {
          subtypeName = paramNetworkInfo1.getSubtypeName();
          if (str.toLowerCase().contains("mobile_mms")) {
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  QLog.d(tag, 1, "get subtypeName error " + localException);
                }
                QLog.d(tag, 1, "currentAPN:" + currentAPN + ". received networkInfo: " + paramNetworkInfo1.getDetailedState() + " :" + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
                if ((!paramNetworkInfo1.isAvailable()) || (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.CONNECTED)) {
                  break;
                }
                if (1 == paramNetworkInfo1.getType())
                {
                  wifiConnected();
                  return;
                }
              } while (!isMobileNetworkInfo(paramNetworkInfo1));
              wifiDisConnected();
              mobileConnected(paramNetworkInfo1);
              return;
            } while ((paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo1.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED));
            if (1 == paramNetworkInfo1.getType())
            {
              wifiDisConnected();
              return;
            }
          } while (!isMobileNetworkInfo(paramNetworkInfo1));
          mobileDisConnected();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(tag, 2, "currentAPN:" + currentAPN + ". active NetworkInfo: " + paramNetworkInfo1 + ". extra NetworkInfo: " + paramNetworkInfo2);
        }
      } while ((paramNetworkInfo2 == null) || ((paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.FAILED) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.IDLE) && (paramNetworkInfo2.getDetailedState() != NetworkInfo.DetailedState.SUSPENDED)));
      if (1 == paramNetworkInfo2.getType())
      {
        wifiDisConnected();
        return;
      }
    } while (!isMobileNetworkInfo(paramNetworkInfo2));
    mobileDisConnected();
  }
  
  public void checkRecordTime()
  {
    try
    {
      String str;
      if ((-1L == lastCheckTime) && (MsfStore.getNativeConfigStore() != null))
      {
        str = MsfStore.getNativeConfigStore().getConfig("recordSysTimeKey");
        if (str == null) {}
      }
      long l;
      try
      {
        lastCheckTime = Long.parseLong(str);
        l = System.currentTimeMillis();
        if (-1L != lastCheckTime)
        {
          if (l <= lastCheckTime + com.tencent.mobileqq.msf.core.a.a.q()) {
            return;
          }
          checkServerTime();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "get lastCheckTime catch Exception " + localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        QLog.d(tag, 2, "checkRecordTime catch Exception " + localException2);
        return;
        lastCheckTime = l;
        if (MsfStore.getNativeConfigStore() != null) {
          MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(lastCheckTime));
        }
      }
    }
  }
  
  public void checkServerTime()
  {
    System.currentTimeMillis();
    long l = SystemClock.elapsedRealtime();
    if ((l - this.lastGetServerTimeInterval > 0L) && (l - this.lastGetServerTimeInterval <= com.tencent.mobileqq.msf.core.a.a.p()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "quit to checkTimeMsg too frequency.");
      }
      return;
    }
    if (this.sendGetServerTimeMsgCount < 10)
    {
      sendOldCheckServerTime();
      this.sendGetServerTimeMsgCount += 1;
      this.lastGetServerTimeInterval = l;
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      if ((this.firstGetServerTime == 0L) || (l - this.firstGetServerTime > 600000L))
      {
        this.firstGetServerTime = l;
        this.sendGetServerTimeMsgCount = 0;
      }
      lastCheckTime = l;
      if (MsfStore.getNativeConfigStore() == null) {
        break;
      }
      MsfStore.getNativeConfigStore().n_setConfig("recordSysTimeKey", String.valueOf(l));
      return;
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "also send checkTimeMsg " + this.sendGetServerTimeMsgCount);
      }
    }
  }
  
  void checkWifiSignalStrengths()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.calculateSignalLevel;
        if (!bool) {
          break label134;
        }
        try
        {
          Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
          if (localObject1 != null)
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              continue;
            }
            i = 1;
            if (((WifiInfo)localObject1).getBSSID() == null) {
              continue;
            }
            j = 1;
            if ((j & i) != 0) {
              this.lastWifiStrength = WifiManager.calculateSignalLevel(((WifiInfo)localObject1).getRssi(), 32);
            }
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          QLog.d(tag, 1, "check WifiState error " + localException, localException);
          this.calculateSignalLevel = false;
          continue;
        }
        return;
      }
      finally {}
      i = 0;
      continue;
      j = 0;
      continue;
      label134:
      this.lastWifiStrength = 0;
    }
  }
  
  public void handleGetServerTimeResp(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(tag, 4, "handleGetServerTimeResp servertime is " + paramLong);
    }
    NetConnInfoCenter.servetTimeSecondInterv = paramLong - System.currentTimeMillis() / 1000L;
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(tag, 0).edit();
    localEditor.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "set serverTime is " + msfCore.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + NetConnInfoCenter.servetTimeSecondInterv * 1000L)));
    }
    MsfCore.initAppProMsg("*", msfCore.sender.i());
  }
  
  public void onConnClosed(com.tencent.qphone.base.a parama)
  {
    NetConnInfoCenter.socketConnState = 1;
    msfCore.pushManager.a(parama);
    parama = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connClosed");
    parama.setMsgSuccess();
    parama.setMsfCommand(MsfCommand.onConnClosed);
    MsfSdkUtils.addFromMsgProcessName("*", parama);
    msfCore.addRespToQuque(null, parama);
  }
  
  public void onConnOpened(String paramString1, String paramString2)
  {
    NetConnInfoCenter.socketConnState = 2;
    msfCore.pushManager.d();
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connOpened");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localFromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
    localFromServiceMsg.addAttribute("resp_connopen_serverAdd", paramString1);
    localFromServiceMsg.addAttribute("resp_connopen_localAdd", paramString2);
    if (msfCore.pushManager.b()) {
      localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
    }
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    msfCore.addRespToQuque(null, localFromServiceMsg);
  }
  
  public void onOepnConnAllFailed()
  {
    NetConnInfoCenter.socketConnState = 3;
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connAllFailed");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localFromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
    if (msfCore.pushManager.b()) {
      localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
    }
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    msfCore.addRespToQuque(null, localFromServiceMsg);
    msfCore.sender.a.h.b();
  }
  
  public void onRecvFirstResp()
  {
    if (isWifiConn()) {
      msfCore.sender.a.h.b(_lastWifiSSID);
    }
    NetConnInfoCenter.socketConnState = 4;
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_recvFirstResp");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localFromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
    if (msfCore.pushManager.b()) {
      localFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
    }
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    msfCore.addRespToQuque(null, localFromServiceMsg);
  }
  
  public void registerSignalStrengthsChanged(Context paramContext)
  {
    Object localObject = new a(null);
    ((TelephonyManager)paramContext.getSystemService("phone")).listen((PhoneStateListener)localObject, 256);
    localObject = new b(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)localObject, localIntentFilter);
  }
  
  /* Error */
  public void setConnInfo(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 809	com/tencent/mobileqq/msf/core/a/d:c	()Ljava/lang/String;
    //   5: astore 5
    //   7: invokestatic 811	com/tencent/mobileqq/msf/core/a/d:b	()Ljava/lang/String;
    //   10: astore 6
    //   12: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   15: iload_1
    //   16: if_icmpne +243 -> 259
    //   19: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +54 -> 76
    //   25: getstatic 60	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   28: iconst_2
    //   29: new 199	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 813
    //   39: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 815	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   45: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: ldc_w 817
    //   51: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_1
    //   55: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 819
    //   61: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   67: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 5
    //   78: ifnull +90 -> 168
    //   81: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   90: aload 5
    //   92: invokevirtual 823	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +73 -> 168
    //   98: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +43 -> 144
    //   104: getstatic 60	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   107: iconst_2
    //   108: new 199	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 825
    //   118: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 827
    //   129: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   135: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: putstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   149: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: ifnull +16 -> 168
    //   155: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   158: getfield 831	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   161: invokevirtual 834	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   164: aload_0
    //   165: invokespecial 836	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   168: aload 6
    //   170: ifnull +86 -> 256
    //   173: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   176: ifnull +14 -> 190
    //   179: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   182: aload 6
    //   184: invokevirtual 823	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifne +69 -> 256
    //   190: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +43 -> 236
    //   196: ldc_w 840
    //   199: iconst_2
    //   200: new 199	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 842
    //   210: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 6
    //   215: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 844
    //   221: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   227: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 6
    //   238: putstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   241: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   244: ifnull +12 -> 256
    //   247: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   250: getfield 831	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   253: invokevirtual 845	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   256: aload_0
    //   257: monitorexit
    //   258: return
    //   259: iload_1
    //   260: ifle +242 -> 502
    //   263: iconst_1
    //   264: invokestatic 847	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   267: getstatic 97	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNet	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   270: invokevirtual 289	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   273: ifeq +74 -> 347
    //   276: new 849	java/util/HashMap
    //   279: dup
    //   280: invokespecial 850	java/util/HashMap:<init>	()V
    //   283: astore 7
    //   285: aload 7
    //   287: ldc_w 852
    //   290: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   293: getstatic 99	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNetTime	J
    //   296: lsub
    //   297: ldc2_w 427
    //   300: ldiv
    //   301: invokestatic 633	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   304: invokeinterface 857 3 0
    //   309: pop
    //   310: aload 7
    //   312: ldc_w 859
    //   315: iload_1
    //   316: invokestatic 418	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   319: invokeinterface 857 3 0
    //   324: pop
    //   325: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   328: invokevirtual 503	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/b/m;
    //   331: ldc_w 861
    //   334: iconst_0
    //   335: lconst_0
    //   336: lconst_0
    //   337: aload 7
    //   339: iconst_0
    //   340: iconst_0
    //   341: invokevirtual 864	com/tencent/mobileqq/msf/core/b/m:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   344: invokestatic 866	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:resetLastConnSuccWithoutNet	()V
    //   347: getstatic 60	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   350: iconst_1
    //   351: new 199	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 868
    //   361: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   367: invokestatic 870	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   370: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 872
    //   376: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: iload_1
    //   380: invokestatic 870	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   383: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_0
    //   393: invokevirtual 874	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:checkWifiSignalStrengths	()V
    //   396: iload_1
    //   397: iconst_2
    //   398: if_icmpeq +8 -> 406
    //   401: iload_1
    //   402: iconst_3
    //   403: if_icmpne +371 -> 774
    //   406: iconst_1
    //   407: istore 4
    //   409: iload 4
    //   411: invokestatic 876	com/tencent/mobileqq/msf/core/b/i:a	(Z)V
    //   414: ldc 101
    //   416: invokestatic 877	com/tencent/mobileqq/msf/core/l:b	(Ljava/lang/String;)V
    //   419: iconst_0
    //   420: invokestatic 879	com/tencent/mobileqq/msf/core/l:b	(I)V
    //   423: iconst_0
    //   424: istore_3
    //   425: iload_1
    //   426: iconst_1
    //   427: if_icmpne +358 -> 785
    //   430: iload_3
    //   431: istore_2
    //   432: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   435: ifeq +13 -> 448
    //   438: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   441: bipush 254
    //   443: if_icmpne +99 -> 542
    //   446: iload_3
    //   447: istore_2
    //   448: iload_1
    //   449: putstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   452: aload_0
    //   453: invokespecial 836	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:onWifiConnChanged	()V
    //   456: iload_2
    //   457: ifeq +7 -> 464
    //   460: aload_0
    //   461: invokespecial 881	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:closeNowConn	()V
    //   464: iload_1
    //   465: ifle -209 -> 256
    //   468: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   471: ifnull -215 -> 256
    //   474: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   477: getfield 718	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   480: ifnull -224 -> 256
    //   483: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   486: getfield 718	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/push/f;
    //   489: invokevirtual 883	com/tencent/mobileqq/msf/core/push/f:c	()V
    //   492: goto -236 -> 256
    //   495: astore 5
    //   497: aload_0
    //   498: monitorexit
    //   499: aload 5
    //   501: athrow
    //   502: iconst_0
    //   503: invokestatic 847	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   506: goto -159 -> 347
    //   509: astore 7
    //   511: getstatic 60	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   514: iconst_1
    //   515: new 199	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   522: ldc_w 885
    //   525: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 7
    //   530: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: goto -125 -> 414
    //   542: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   545: iconst_2
    //   546: if_icmpeq +12 -> 558
    //   549: iload_3
    //   550: istore_2
    //   551: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   554: iconst_3
    //   555: if_icmpne -107 -> 448
    //   558: aload 6
    //   560: ifnull +220 -> 780
    //   563: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   566: ifnull +14 -> 580
    //   569: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   572: aload 6
    //   574: invokevirtual 823	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   577: ifne +203 -> 780
    //   580: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +43 -> 626
    //   586: ldc_w 840
    //   589: iconst_2
    //   590: new 199	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   597: ldc_w 887
    //   600: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 6
    //   605: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 844
    //   611: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: getstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   617: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: aload 6
    //   628: putstatic 838	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   631: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   634: ifnull +146 -> 780
    //   637: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   640: getfield 831	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   643: invokevirtual 845	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   646: goto +134 -> 780
    //   649: iload_3
    //   650: istore_2
    //   651: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   654: ifeq -206 -> 448
    //   657: iload_3
    //   658: istore_2
    //   659: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   662: bipush 254
    //   664: if_icmpeq -216 -> 448
    //   667: iload_3
    //   668: istore_2
    //   669: getstatic 82	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   672: iconst_1
    //   673: if_icmpne -225 -> 448
    //   676: aload 5
    //   678: ifnull +86 -> 764
    //   681: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   684: ifnull +14 -> 698
    //   687: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   690: aload 5
    //   692: invokevirtual 823	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   695: ifne +69 -> 764
    //   698: invokestatic 465	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +43 -> 744
    //   704: getstatic 60	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   707: iconst_2
    //   708: new 199	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 825
    //   718: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 5
    //   723: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc_w 827
    //   729: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: getstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   735: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload 5
    //   746: putstatic 239	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   749: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   752: ifnull +12 -> 764
    //   755: getstatic 135	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   758: getfield 831	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   761: invokevirtual 834	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   764: iconst_1
    //   765: istore_2
    //   766: goto -318 -> 448
    //   769: iconst_1
    //   770: istore_2
    //   771: goto -323 -> 448
    //   774: iconst_0
    //   775: istore 4
    //   777: goto -368 -> 409
    //   780: iconst_1
    //   781: istore_2
    //   782: goto -334 -> 448
    //   785: iload_1
    //   786: iconst_2
    //   787: if_icmpeq -138 -> 649
    //   790: iload_1
    //   791: iconst_3
    //   792: if_icmpne -23 -> 769
    //   795: goto -146 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	this	NetConnInfoCenterImpl
    //   0	798	1	paramInt	int
    //   431	351	2	i	int
    //   424	244	3	j	int
    //   407	369	4	bool	boolean
    //   5	140	5	str1	String
    //   495	250	5	localObject	Object
    //   10	617	6	str2	String
    //   283	55	7	localHashMap	java.util.HashMap
    //   509	20	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	76	495	finally
    //   81	98	495	finally
    //   98	144	495	finally
    //   144	168	495	finally
    //   173	190	495	finally
    //   190	236	495	finally
    //   236	256	495	finally
    //   263	347	495	finally
    //   347	396	495	finally
    //   409	414	495	finally
    //   414	423	495	finally
    //   432	446	495	finally
    //   448	456	495	finally
    //   460	464	495	finally
    //   468	492	495	finally
    //   502	506	495	finally
    //   511	539	495	finally
    //   542	549	495	finally
    //   551	558	495	finally
    //   563	580	495	finally
    //   580	626	495	finally
    //   626	646	495	finally
    //   651	657	495	finally
    //   659	667	495	finally
    //   669	676	495	finally
    //   681	698	495	finally
    //   698	744	495	finally
    //   744	764	495	finally
    //   409	414	509	java/io/IOException
  }
  
  private class a
    extends PhoneStateListener
  {
    private a() {}
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      int i = paramSignalStrength.getCdmaDbm();
      NetConnInfoCenterImpl.this.lastCdmaStrenght = i;
      int j = paramSignalStrength.getGsmSignalStrength();
      i = j;
      if (j == 99) {
        i = -3;
      }
      NetConnInfoCenterImpl.this.lastGsmStrength = i;
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      NetConnInfoCenterImpl.this.checkWifiSignalStrengths();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl
 * JD-Core Version:    0.7.0.1
 */