import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class amzr
  extends swr
{
  private static final String[] ba = { "StatSvc" };
  private AppInterface app;
  
  public amzr(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    VendorPushInfo localVendorPushInfo = new VendorPushInfo();
    localSvcReqRegister.cConnType = 0;
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.lUin = Long.parseLong(paramToServiceMsg.getUin());
    AppRuntime.Status localStatus = (AppRuntime.Status)paramToServiceMsg.extraData.getSerializable("onlineStatus");
    localSvcReqRegister.iStatus = localStatus.getValue();
    localSvcReqRegister.bKikPC = 0;
    localSvcReqRegister.bKikWeak = 0;
    localSvcReqRegister.timeStamp = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
    localSvcReqRegister.iLargeSeq = paramToServiceMsg.extraData.getLong("K_SEQ", 0L);
    localSvcReqRegister.bRegType = 0;
    localSvcReqRegister.bIsSetStatus = 1;
    localSvcReqRegister.uExtOnlineStatus = paramToServiceMsg.extraData.getLong("extOnlineStatus", -1L);
    if ((localStatus == AppRuntime.Status.online) && (akto.cw(localSvcReqRegister.uExtOnlineStatus))) {
      localSvcReqRegister.iBatteryStatus = akti.getSendBatteryStatus(paramToServiceMsg.extraData.getInt("batteryCapacity", 0), paramToServiceMsg.extraData.getInt("powerConnect", -1));
    }
    try
    {
      for (;;)
      {
        localSvcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
        if (!NetConnInfoCenter.isMobileConn()) {
          break;
        }
        localSvcReqRegister.cNetType = 0;
        localSvcReqRegister.vecGuid = NetConnInfoCenter.GUID;
        localSvcReqRegister.strDevName = Build.MODEL;
        localSvcReqRegister.strDevType = Build.MODEL;
        localSvcReqRegister.strOSVer = Build.VERSION.RELEASE;
        localVendorPushInfo.uVendorType = auqe.getThirdPushType();
        localSvcReqRegister.stVendorPushInfo = localVendorPushInfo;
        paramUniPacket.put("SvcReqRegister", localSvcReqRegister);
        paramUniPacket.setServantName("PushService");
        paramUniPacket.setFuncName("SvcReqRegister");
        return true;
        localSvcReqRegister.iBatteryStatus = 0;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        continue;
        if (NetConnInfoCenter.isWifiConn()) {
          localSvcReqRegister.cNetType = 1;
        }
      }
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("StatSvc.SetStatusFromClient".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("StatSvc.SetStatusFromClient")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    return true;
  }
  
  public String[] y()
  {
    return ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzr
 * JD-Core Version:    0.7.0.1
 */