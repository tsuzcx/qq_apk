package com.tencent.mobileqq.service.config;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceReq;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.SDKUpgradeReq;
import protocol.KQQConfig.SDKUpgradeRes;
import protocol.KQQConfig.UpgradeInfo;

public class ConfigService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ConfigServantObj", "ConfigService" };
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetResourceResp)a(paramFromServiceMsg.getWupBuffer(), "res", new GetResourceResp());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("ClientReq");
    paramUniPacket.put("iCmdType", Integer.valueOf(1));
    SDKUpgradeReq localSDKUpgradeReq = new SDKUpgradeReq();
    localSDKUpgradeReq.cProtocolVer = 1;
    localSDKUpgradeReq.iActionType = paramToServiceMsg.extraData.getInt("iActionType");
    localSDKUpgradeReq.iWidth = paramToServiceMsg.extraData.getInt("iWidth");
    localSDKUpgradeReq.iHeight = paramToServiceMsg.extraData.getInt("iHeight");
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "Get Config: " + localSDKUpgradeReq.iActionType + localSDKUpgradeReq.iActionType + ", " + localSDKUpgradeReq.iWidth + ", " + localSDKUpgradeReq.iHeight);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramToServiceMsg.getUin());
    localSDKUpgradeReq.vUin = localArrayList;
    localSDKUpgradeReq.bSdkUpdateFlag = false;
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(AppSetting.a));
    localSDKUpgradeReq.vAppid = localArrayList;
    paramUniPacket.put("SDKUpgradeReq", localSDKUpgradeReq);
    paramToServiceMsg.setTimeout(20000L);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SDKUpgradeRes)a(paramFromServiceMsg.getWupBuffer(), "SDKUpgradeRes", new SDKUpgradeRes());
    if (QLog.isColorLevel())
    {
      QLog.d("UpgradeController", 2, "Get Upgrade Config Resp: " + paramToServiceMsg);
      if (paramToServiceMsg != null)
      {
        if ((paramToServiceMsg.vUpgradeInfo != null) && (paramToServiceMsg.vUpgradeInfo.size() > 0)) {
          break label83;
        }
        QLog.d("UpgradeController", 2, "Not vUpgradeInfo");
      }
    }
    return paramToServiceMsg;
    label83:
    paramFromServiceMsg = (UpgradeInfo)paramToServiceMsg.vUpgradeInfo.get(0);
    QLog.d("UpgradeController", 2, "Get UpgradeInfo: " + paramFromServiceMsg);
    QLog.d("UpgradeController", 2, "iAppid: " + paramFromServiceMsg.iAppid);
    QLog.d("UpgradeController", 2, "bAppType: " + paramFromServiceMsg.bAppType);
    QLog.d("UpgradeController", 2, "iUpgradeType: " + paramFromServiceMsg.iUpgradeType);
    QLog.d("UpgradeController", 2, "iUpgradeSdkId: " + paramFromServiceMsg.iUpgradeSdkId);
    QLog.d("UpgradeController", 2, "strTitle: " + paramFromServiceMsg.strTitle);
    QLog.d("UpgradeController", 2, "strUpgradeDesc: " + paramFromServiceMsg.strUpgradeDesc);
    QLog.d("UpgradeController", 2, "strUrl: " + paramFromServiceMsg.strUrl);
    QLog.d("UpgradeController", 2, "iActionType=0: " + paramFromServiceMsg.iActionType);
    QLog.d("UpgradeController", 2, "bNewSwitch: " + paramFromServiceMsg.bNewSwitch);
    QLog.d("UpgradeController", 2, "iNewTimeStamp: " + paramFromServiceMsg.iNewTimeStamp);
    QLog.d("UpgradeController", 2, "strUpgradePageUrl: " + paramFromServiceMsg.strUpgradePageUrl);
    QLog.d("UpgradeController", 2, "iIncrementUpgrade: " + paramFromServiceMsg.iIncrementUpgrade);
    QLog.d("UpgradeController", 2, "iTipsType: " + paramFromServiceMsg.iTipsType);
    QLog.d("UpgradeController", 2, "strBannerPicUrl: " + paramFromServiceMsg.strBannerPicUrl);
    QLog.d("UpgradeController", 2, "strNewUpgradeDescURL: " + paramFromServiceMsg.strNewUpgradeDescURL);
    QLog.d("UpgradeController", 2, "iDisplayDay: " + paramFromServiceMsg.iDisplayDay);
    QLog.d("UpgradeController", 2, "iTipsWaitDay: " + paramFromServiceMsg.iTipsWaitDay);
    QLog.d("UpgradeController", 2, "strProgressName: " + paramFromServiceMsg.strProgressName);
    QLog.d("UpgradeController", 2, "strNewTipsDescURL: " + paramFromServiceMsg.strNewTipsDescURL);
    QLog.d("UpgradeController", 2, "strNewSoftwareURL: " + paramFromServiceMsg.strNewSoftwareURL);
    QLog.d("UpgradeController", 2, "bGray: " + paramFromServiceMsg.bGray);
    return paramToServiceMsg;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("getResourceReqInfos");
    GetResourceReq localGetResourceReq = new GetResourceReq();
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      localGetResourceReq.vecResReqInfo = paramToServiceMsg;
      localGetResourceReq.sLanCodeType = 1;
    }
    paramUniPacket.put("req", localGetResourceReq);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "encode request,servantName is:ConfigServantObj,funcName is:GetResourceReq");
    }
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("ConfigService.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ConfigService.ClientReq".equals(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg) {}
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("ConfigService.ClientReq".equals(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("ConfigService.GetResourceReq".equals(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.config.ConfigService
 * JD-Core Version:    0.7.0.1
 */