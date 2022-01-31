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
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.d.f;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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
  private static int _activeNetInfoType = 0;
  static int _dayOfYear = 0;
  private static String _lastMobileApn;
  private static String _lastWifiSSID;
  private static AtomicBoolean _netSupport;
  static String currentAPN;
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
  int lastGsmStrength;
  int lastWifiStrength;
  private int sendGetServerTimeMsgCount = 0;
  
  static
  {
    netChangeCount = new AtomicInteger(0);
    _dayOfYear = Calendar.getInstance().get(6);
    _activeNetInfoType = 0;
    _netSupport = new AtomicBoolean(false);
    lastConnSuccWithoutNet = new AtomicBoolean();
    lastConnSuccWithoutNetTime = 0L;
    currentAPN = "";
    subtypeName = "";
  }
  
  public static void callQQProcess(String paramString)
  {
    try
    {
      if (e.l)
      {
        Object localObject = new Intent(paramString);
        paramString = e.m;
        int i = msfCore.getUinPushStatus(paramString);
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("istatus", i);
        ((Intent)localObject).putExtra("gatewayip", l.l());
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.a.a.q(), (PendingIntent)localObject);
        QLog.d(tag, 1, "send bootAction for QQ " + paramString);
        e.l = false;
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
      localToServiceMsg.setAppId(msfCore.sender.h());
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
      localToServiceMsg.setAppId(msfCore.sender.h());
      localToServiceMsg.setTimeout(30000L);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localUniPacket = new UniPacket(true);
      localUniPacket.setServantName("test");
      localUniPacket.setFuncName("cmdstr");
      locald = new d(1, 15, MsfCore.getNextSeq(), 1, "0", msfCore.sender.h(), String.valueOf(msfCore.sender.h()), "123", 0);
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
    if (!_netSupport.get()) {
      msfCore.sender.a.v = 0L;
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
      f.e();
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
      f.e();
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
  
  public void checkServerTime()
  {
    System.currentTimeMillis();
    if (this.sendGetServerTimeMsgCount < 10)
    {
      sendOldCheckServerTime();
      this.sendGetServerTimeMsgCount += 1;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if ((this.firstGetServerTime == 0L) || (l - this.firstGetServerTime > 600000L))
      {
        this.firstGetServerTime = l;
        this.sendGetServerTimeMsgCount = 0;
      }
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
    MsfCore.initAppProMsg("*", msfCore.sender.h());
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
  }
  
  public void onRecvFirstResp()
  {
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
    //   2: invokestatic 740	com/tencent/mobileqq/msf/core/a/d:c	()Ljava/lang/String;
    //   5: astore 5
    //   7: invokestatic 742	com/tencent/mobileqq/msf/core/a/d:b	()Ljava/lang/String;
    //   10: astore 6
    //   12: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   15: iload_1
    //   16: if_icmpne +239 -> 255
    //   19: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +54 -> 76
    //   25: getstatic 55	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   28: iconst_2
    //   29: new 187	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 744
    //   39: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 746	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:isNetSupport	()Z
    //   45: invokevirtual 439	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: ldc_w 748
    //   51: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_1
    //   55: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 750
    //   61: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   67: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 5
    //   78: ifnull +86 -> 164
    //   81: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   90: aload 5
    //   92: invokevirtual 756	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +69 -> 164
    //   98: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +43 -> 144
    //   104: getstatic 55	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   107: iconst_2
    //   108: new 187	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 758
    //   118: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 760
    //   129: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   135: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: putstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   149: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: ifnull +12 -> 164
    //   155: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   158: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   161: invokevirtual 767	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   164: aload 6
    //   166: ifnull +86 -> 252
    //   169: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   172: ifnull +14 -> 186
    //   175: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   178: aload 6
    //   180: invokevirtual 756	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne +69 -> 252
    //   186: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +43 -> 232
    //   192: ldc_w 771
    //   195: iconst_2
    //   196: new 187	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 773
    //   206: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 6
    //   211: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 775
    //   217: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   223: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload 6
    //   234: putstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   237: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   240: ifnull +12 -> 252
    //   243: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   246: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   249: invokevirtual 776	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   252: aload_0
    //   253: monitorexit
    //   254: return
    //   255: iload_1
    //   256: ifle +238 -> 494
    //   259: iconst_1
    //   260: invokestatic 778	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   263: getstatic 88	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNet	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   266: invokevirtual 274	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   269: ifeq +74 -> 343
    //   272: new 780	java/util/HashMap
    //   275: dup
    //   276: invokespecial 781	java/util/HashMap:<init>	()V
    //   279: astore 7
    //   281: aload 7
    //   283: ldc_w 783
    //   286: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   289: getstatic 90	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:lastConnSuccWithoutNetTime	J
    //   292: lsub
    //   293: ldc2_w 396
    //   296: ldiv
    //   297: invokestatic 786	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   300: invokeinterface 791 3 0
    //   305: pop
    //   306: aload 7
    //   308: ldc_w 793
    //   311: iload_1
    //   312: invokestatic 387	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   315: invokeinterface 791 3 0
    //   320: pop
    //   321: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   324: invokevirtual 480	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   327: ldc_w 795
    //   330: iconst_0
    //   331: lconst_0
    //   332: lconst_0
    //   333: aload 7
    //   335: iconst_0
    //   336: iconst_0
    //   337: invokevirtual 798	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   340: invokestatic 800	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:resetLastConnSuccWithoutNet	()V
    //   343: getstatic 55	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   346: iconst_1
    //   347: new 187	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 802
    //   357: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   363: invokestatic 804	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   366: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 806
    //   372: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload_1
    //   376: invokestatic 804	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:getNetStatusMsg	(I)Ljava/lang/String;
    //   379: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: aload_0
    //   389: invokevirtual 808	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:checkWifiSignalStrengths	()V
    //   392: iload_1
    //   393: iconst_2
    //   394: if_icmpeq +8 -> 402
    //   397: iload_1
    //   398: iconst_3
    //   399: if_icmpne +367 -> 766
    //   402: iconst_1
    //   403: istore 4
    //   405: iload 4
    //   407: invokestatic 810	com/tencent/mobileqq/msf/core/d/f:a	(Z)V
    //   410: ldc 92
    //   412: invokestatic 812	com/tencent/mobileqq/msf/core/l:b	(Ljava/lang/String;)V
    //   415: iconst_0
    //   416: invokestatic 814	com/tencent/mobileqq/msf/core/l:b	(I)V
    //   419: iconst_0
    //   420: istore_3
    //   421: iload_1
    //   422: iconst_1
    //   423: if_icmpne +354 -> 777
    //   426: iload_3
    //   427: istore_2
    //   428: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   431: ifeq +13 -> 444
    //   434: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   437: bipush 254
    //   439: if_icmpne +95 -> 534
    //   442: iload_3
    //   443: istore_2
    //   444: iload_1
    //   445: putstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   448: iload_2
    //   449: ifeq +7 -> 456
    //   452: aload_0
    //   453: invokespecial 816	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:closeNowConn	()V
    //   456: iload_1
    //   457: ifle -205 -> 252
    //   460: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   463: ifnull -211 -> 252
    //   466: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   469: getfield 652	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/c/e;
    //   472: ifnull -220 -> 252
    //   475: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   478: getfield 652	com/tencent/mobileqq/msf/core/MsfCore:pushManager	Lcom/tencent/mobileqq/msf/core/c/e;
    //   481: invokevirtual 818	com/tencent/mobileqq/msf/core/c/e:c	()V
    //   484: goto -232 -> 252
    //   487: astore 5
    //   489: aload_0
    //   490: monitorexit
    //   491: aload 5
    //   493: athrow
    //   494: iconst_0
    //   495: invokestatic 778	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:setNetSupport	(Z)V
    //   498: goto -155 -> 343
    //   501: astore 7
    //   503: getstatic 55	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   506: iconst_1
    //   507: new 187	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 820
    //   517: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload 7
    //   522: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: goto -121 -> 410
    //   534: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   537: iconst_2
    //   538: if_icmpeq +12 -> 550
    //   541: iload_3
    //   542: istore_2
    //   543: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   546: iconst_3
    //   547: if_icmpne -103 -> 444
    //   550: aload 6
    //   552: ifnull +220 -> 772
    //   555: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   558: ifnull +14 -> 572
    //   561: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   564: aload 6
    //   566: invokevirtual 756	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   569: ifne +203 -> 772
    //   572: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +43 -> 618
    //   578: ldc_w 771
    //   581: iconst_2
    //   582: new 187	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 822
    //   592: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload 6
    //   597: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 775
    //   603: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   609: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload 6
    //   620: putstatic 769	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastMobileApn	Ljava/lang/String;
    //   623: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   626: ifnull +146 -> 772
    //   629: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   632: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   635: invokevirtual 776	com/tencent/mobileqq/msf/core/a/d:e	()V
    //   638: goto +134 -> 772
    //   641: iload_3
    //   642: istore_2
    //   643: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   646: ifeq -202 -> 444
    //   649: iload_3
    //   650: istore_2
    //   651: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   654: bipush 254
    //   656: if_icmpeq -212 -> 444
    //   659: iload_3
    //   660: istore_2
    //   661: getstatic 77	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_activeNetInfoType	I
    //   664: iconst_1
    //   665: if_icmpne -221 -> 444
    //   668: aload 5
    //   670: ifnull +86 -> 756
    //   673: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   676: ifnull +14 -> 690
    //   679: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   682: aload 5
    //   684: invokevirtual 756	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   687: ifne +69 -> 756
    //   690: invokestatic 434	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +43 -> 736
    //   696: getstatic 55	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:tag	Ljava/lang/String;
    //   699: iconst_2
    //   700: new 187	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 758
    //   710: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 5
    //   715: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc_w 760
    //   721: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: getstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   727: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: aload 5
    //   738: putstatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:_lastWifiSSID	Ljava/lang/String;
    //   741: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   744: ifnull +12 -> 756
    //   747: getstatic 124	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   750: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/d;
    //   753: invokevirtual 767	com/tencent/mobileqq/msf/core/a/d:f	()V
    //   756: iconst_1
    //   757: istore_2
    //   758: goto -314 -> 444
    //   761: iconst_1
    //   762: istore_2
    //   763: goto -319 -> 444
    //   766: iconst_0
    //   767: istore 4
    //   769: goto -364 -> 405
    //   772: iconst_1
    //   773: istore_2
    //   774: goto -330 -> 444
    //   777: iload_1
    //   778: iconst_2
    //   779: if_icmpeq -138 -> 641
    //   782: iload_1
    //   783: iconst_3
    //   784: if_icmpne -23 -> 761
    //   787: goto -146 -> 641
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	NetConnInfoCenterImpl
    //   0	790	1	paramInt	int
    //   427	347	2	i	int
    //   420	240	3	j	int
    //   403	365	4	bool	boolean
    //   5	140	5	str1	String
    //   487	250	5	localObject	Object
    //   10	609	6	str2	String
    //   279	55	7	localHashMap	java.util.HashMap
    //   501	20	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	76	487	finally
    //   81	98	487	finally
    //   98	144	487	finally
    //   144	164	487	finally
    //   169	186	487	finally
    //   186	232	487	finally
    //   232	252	487	finally
    //   259	343	487	finally
    //   343	392	487	finally
    //   405	410	487	finally
    //   410	419	487	finally
    //   428	442	487	finally
    //   444	448	487	finally
    //   452	456	487	finally
    //   460	484	487	finally
    //   494	498	487	finally
    //   503	531	487	finally
    //   534	541	487	finally
    //   543	550	487	finally
    //   555	572	487	finally
    //   572	618	487	finally
    //   618	638	487	finally
    //   643	649	487	finally
    //   651	659	487	finally
    //   661	668	487	finally
    //   673	690	487	finally
    //   690	736	487	finally
    //   736	756	487	finally
    //   405	410	501	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl
 * JD-Core Version:    0.7.0.1
 */