import MCommon.Sharkfin;
import MConch.CSPullConchs;
import MConch.SCPullConchs;
import MShark.CSGUIDRegist;
import MShark.SCGUIDRegist;
import MWIFI.CSGet3rdCloudCheck;
import MWIFI.SCGet3rdCloudCheck;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.jce.wup.WupHexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class andy
  extends swr
{
  private QQAppInterface app;
  
  public andy(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private Sharkfin a(String paramString)
  {
    Sharkfin localSharkfin = new Sharkfin();
    localSharkfin.sessionId = "";
    localSharkfin.buildno = 6601;
    localSharkfin.apn = 0;
    localSharkfin.netType = 0;
    localSharkfin.authType = 0;
    localSharkfin.guid = paramString;
    localSharkfin.accountId = 0L;
    localSharkfin.bootType = 0;
    localSharkfin.wsGuid = "";
    localSharkfin.ext1 = "";
    return localSharkfin;
  }
  
  private CSPullConchs a()
  {
    CSPullConchs localCSPullConchs = new CSPullConchs();
    localCSPullConchs.cmdId = -1;
    return localCSPullConchs;
  }
  
  private CSGet3rdCloudCheck a(Context paramContext, ToServiceMsg paramToServiceMsg)
  {
    Object localObject4 = null;
    Object localObject1 = null;
    int i = arnb.getNetWorkType(paramContext);
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "encodeReqMsg, networkType is none");
      }
    }
    CSGet3rdCloudCheck localCSGet3rdCloudCheck;
    Object localObject3;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return null;
          localCSGet3rdCloudCheck = new CSGet3rdCloudCheck();
          if (i != 1) {
            break label470;
          }
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("WifiSdk", 2, "encodeReqMsg, systmeWifiMgr is null");
        return null;
        localObject3 = alkz.a(paramContext);
        if (localObject3 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "encodeReqMsg, currentWifi is null");
      return null;
      localObject2 = ((android.net.wifi.WifiInfo)localObject3).getSSID();
      localObject3 = ((android.net.wifi.WifiInfo)localObject3).getBSSID();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "encodeReqMsg, ssid or bssid is null");
    return null;
    paramToServiceMsg.addAttribute("bssid", localObject3);
    paramToServiceMsg.addAttribute("ssid", localObject2);
    localCSGet3rdCloudCheck.networkType = 1;
    localCSGet3rdCloudCheck.wifiInfo = new MWIFI.WifiInfo();
    localCSGet3rdCloudCheck.wifiInfo.ssid = ((String)localObject2);
    localCSGet3rdCloudCheck.wifiInfo.bssid = ((String)localObject3);
    for (;;)
    {
      try
      {
        localObject2 = paramContext.getDhcpInfo();
        if (localObject2 == null) {
          break label493;
        }
        paramContext = arnb.am(((DhcpInfo)localObject2).dns1);
        localObject3 = paramContext;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = arnb.am(((DhcpInfo)localObject2).dns2);
          localObject1 = paramContext;
          paramContext = (Context)localObject2;
          localObject3 = localObject1;
          localObject1 = paramContext;
          localCSGet3rdCloudCheck.vecDns = new ArrayList(2);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localCSGet3rdCloudCheck.vecDns.add(localObject3);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localCSGet3rdCloudCheck.vecDns.add(localObject1);
          }
          paramContext = auri.getIMEI("f5cc92");
          if (!TextUtils.isEmpty(paramContext)) {
            localCSGet3rdCloudCheck.imei = paramContext;
          }
          localCSGet3rdCloudCheck.mac = arnb.getMac();
          localCSGet3rdCloudCheck.vid = arnb.CZ();
          paramToServiceMsg.addAttribute("network_type", Integer.valueOf(localCSGet3rdCloudCheck.networkType));
          if (QLog.isColorLevel()) {
            QLog.i("WifiSdk", 2, "encodeReqMsg, imei: " + localCSGet3rdCloudCheck.imei + " mac: " + localCSGet3rdCloudCheck.mac + " vid: " + localCSGet3rdCloudCheck.vid);
          }
          return localCSGet3rdCloudCheck;
        }
        catch (Exception localException2)
        {
          break label418;
        }
        localException1 = localException1;
        paramContext = null;
      }
      label418:
      localObject1 = localObject4;
      if (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "encodeReqMsg, get dns info exception: " + localException1.getMessage());
        localObject3 = paramContext;
        localObject1 = localObject4;
        continue;
        label470:
        localCSGet3rdCloudCheck.networkType = i;
        localCSGet3rdCloudCheck.operType = arnb.aL(paramContext);
        continue;
        label493:
        paramContext = null;
      }
    }
  }
  
  private SCGet3rdCloudCheck a(ToServiceMsg paramToServiceMsg, SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    if ((paramSCGet3rdCloudCheck == null) || (paramToServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, response or request is null");
      }
      paramToServiceMsg = null;
    }
    do
    {
      return paramToServiceMsg;
      if (((Integer)paramToServiceMsg.getAttribute("network_type", Integer.valueOf(-1))).intValue() == 1)
      {
        Object localObject1 = this.app.getApplication().getApplicationContext();
        if (arnb.getNetWorkType((Context)localObject1) != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, networkType is invaild");
          }
          return null;
        }
        Object localObject2 = alkz.a((WifiManager)((Context)localObject1).getSystemService("wifi"));
        localObject1 = ((android.net.wifi.WifiInfo)localObject2).getSSID();
        localObject2 = ((android.net.wifi.WifiInfo)localObject2).getBSSID();
        String str = (String)paramToServiceMsg.getAttribute("ssid", "");
        paramToServiceMsg = (String)paramToServiceMsg.getAttribute("bssid", "");
        if ((!TextUtils.equals((CharSequence)localObject1, str)) && (!TextUtils.equals((CharSequence)localObject2, paramToServiceMsg)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, ssid and bssid is not the same");
          }
          return null;
        }
      }
      paramToServiceMsg = paramSCGet3rdCloudCheck;
    } while (!TextUtils.isEmpty(paramSCGet3rdCloudCheck.tips));
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "handleWifiSecurityCheckInfo, tips is null");
    }
    return null;
  }
  
  public CSGUIDRegist a(Context paramContext)
  {
    CSGUIDRegist localCSGUIDRegist = new CSGUIDRegist();
    localCSGUIDRegist.imei = auri.getIMEI("f5cc92");
    localCSGUIDRegist.imsi = auri.ru("f5cc92");
    localCSGUIDRegist.mac = arnb.getMac();
    localCSGUIDRegist.lc = "FF4A5386F7B20DCB";
    localCSGUIDRegist.buildno = 6601;
    localCSGUIDRegist.channelid = "102769";
    localCSGUIDRegist.pkgname = paramContext.getPackageName();
    localCSGUIDRegist.build_brand = Build.BRAND;
    localCSGUIDRegist.build_version_incremental = Build.VERSION.INCREMENTAL;
    localCSGUIDRegist.build_version_release = Build.VERSION.RELEASE;
    localCSGUIDRegist.isbuildin = false;
    localCSGUIDRegist.platform = 2;
    localCSGUIDRegist.product = 106;
    localCSGUIDRegist.subplatform = 201;
    localCSGUIDRegist.ua = Build.MODEL;
    return localCSGUIDRegist;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "decode, serviceCmd: " + paramToServiceMsg.getServiceCmd());
    }
    try
    {
      if (!"WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd())) {
        break label492;
      }
      k = ((Integer)paramToServiceMsg.getAttribute("request_type", Integer.valueOf(-1))).intValue();
      localObject1 = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = new byte[localObject1.length - 4];
      System.arraycopy(localObject1, 4, paramFromServiceMsg, 0, localObject1.length - 4);
      if (!QLog.isColorLevel()) {
        break label463;
      }
      localObject1 = WupHexUtil.bytes2HexStr(paramFromServiceMsg);
      QLog.i("WifiSdk", 2, "decode, full data: " + (String)localObject1);
      QLog.i("WifiSdk", 2, "decode, requestType: " + k);
      if (localObject1 == null) {
        break label463;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      int m = ((String)localObject1).length();
      localObject2 = new StringBuilder();
      for (int i = 0; (i < m) && (j < m); i = j)
      {
        j = i + 2;
        ((StringBuilder)localObject2).append(((String)localObject1).substring(i, j)).append(" ");
      }
      QLog.i("WifiSdk", 2, "decode, full data: " + ((StringBuilder)localObject2).toString());
    }
    catch (Throwable paramToServiceMsg)
    {
      int k;
      Object localObject1;
      Object localObject2;
      if (!QLog.isColorLevel()) {
        break label492;
      }
      QLog.i("WifiSdk", 2, "decode exception: " + paramToServiceMsg.getMessage());
      break label492;
      switch (k)
      {
      }
    }
    paramToServiceMsg = new UniPacket(true);
    paramToServiceMsg.setEncodeName("utf-8");
    paramToServiceMsg.decode(paramFromServiceMsg);
    return (SCPullConchs)paramToServiceMsg.get("SCPullConchs", null);
    paramToServiceMsg = new UniPacket(true);
    paramToServiceMsg.setEncodeName("utf-8");
    paramToServiceMsg.decode(paramFromServiceMsg);
    paramToServiceMsg = (SCGUIDRegist)paramToServiceMsg.get("SCGUIDRegist", null);
    if (paramToServiceMsg == null) {
      return null;
    }
    return paramToServiceMsg.guid;
    localObject1 = new UniPacket(true);
    ((UniPacket)localObject1).setEncodeName("utf-8");
    ((UniPacket)localObject1).decode(paramFromServiceMsg);
    paramFromServiceMsg = (SCGet3rdCloudCheck)((UniPacket)localObject1).get("SCGet3rdCloudCheck", null);
    localObject2 = new arnc();
    ((arnc)localObject2).a = ((SCPullConchs)((UniPacket)localObject1).get("SCPullConchs", null));
    ((arnc)localObject2).b = a(paramToServiceMsg, paramFromServiceMsg);
    return localObject2;
    label463:
    label492:
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "encodeReqMsg, serviceCmd: " + paramToServiceMsg.getServiceCmd());
    }
    for (;;)
    {
      Context localContext;
      int i;
      try
      {
        if (!"WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd())) {
          break label241;
        }
        localContext = this.app.getApplication().getApplicationContext();
        i = ((Integer)paramToServiceMsg.getAttribute("request_type", Integer.valueOf(-1))).intValue();
        if (!QLog.isColorLevel()) {
          break label293;
        }
        QLog.i("WifiSdk", 2, "encodeReqMsg, requestType: " + i);
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label241;
        }
        QLog.i("WifiSdk", 2, "encodeReqMsg exception: " + paramToServiceMsg.getMessage());
      }
      paramUniPacket.setServantName("WifiSdkObj");
      paramUniPacket.setFuncName("req");
      paramToServiceMsg = arna.ao(this.app.getApp(), this.app.getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 1, "encodeReqMsg, guid: " + paramToServiceMsg);
      }
      paramUniPacket.put("Sharkfin", a(paramToServiceMsg));
      return true;
      paramUniPacket.put("CSPullConchs", a());
      continue;
      label241:
      return false;
      paramUniPacket.put("CSGUIDRegist", a(localContext));
      continue;
      paramToServiceMsg = a(localContext, paramToServiceMsg);
      if (paramToServiceMsg != null) {
        paramUniPacket.put("CSGet3rdCloudCheck", paramToServiceMsg);
      }
      paramUniPacket.put("CSPullConchs", a());
      continue;
      label293:
      switch (i)
      {
      }
    }
  }
  
  public String[] y()
  {
    return new String[] { "WifiCloudCheckSvc" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andy
 * JD-Core Version:    0.7.0.1
 */