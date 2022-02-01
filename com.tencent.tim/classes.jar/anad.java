import MAAccessClient.AccessReq;
import MAAccessClient.AccessRsp;
import MAAccessClient.CheckSinglePkgSigReq;
import MAAccessClient.GetSinglePkgSigReq;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
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

public class anad
  extends swr
{
  private static final String[] gu = { "ConfigServantObj", "ConfigService", "MAAControl", "ResourceConfig" };
  
  private AccessReq a(byte[] paramArrayOfByte)
  {
    AccessReq localAccessReq = new AccessReq();
    localAccessReq.gray = 0;
    String str2 = aqgz.getIMEI();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.imei = str1;
    str2 = aqgz.getManufacturer();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.manufacture = str1;
    str2 = aqgz.getModel();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.mode = str1;
    str2 = aqgz.getRomInfo();
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localAccessReq.rom = str1;
    localAccessReq.body = paramArrayOfByte;
    localAccessReq.platform = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "createAccessReq:\nimei:" + localAccessReq.imei + "\ngray:" + localAccessReq.gray);
    }
    return localAccessReq;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    return (AccessRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), paramString, new AccessRsp());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
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
    localArrayList.add(Integer.valueOf(AppSetting.getAppId()));
    localSDKUpgradeReq.vAppid = localArrayList;
    paramUniPacket.put("SDKUpgradeReq", localSDKUpgradeReq);
    paramToServiceMsg.setTimeout(20000L);
    return true;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    ArrayList localArrayList = (ArrayList)paramToServiceMsg.extraData.getSerializable("getResourceReqInfos");
    GetResourceReq localGetResourceReq = new GetResourceReq();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localGetResourceReq.vecResReqInfo = localArrayList;
      localGetResourceReq.sLanCodeType = 1;
    }
    paramUniPacket.put("req", localGetResourceReq);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "encode request,servantName is:ConfigServantObj,funcName is:GetResourceReq,AppSeq is:" + paramToServiceMsg.getAppSeq());
    }
    return true;
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    CheckSinglePkgSigReq localCheckSinglePkgSigReq = new CheckSinglePkgSigReq();
    localCheckSinglePkgSigReq.pkgName = BaseApplicationImpl.sApplication.getPackageName();
    String str2 = paramToServiceMsg.extraData.getString("ac");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localCheckSinglePkgSigReq.pkgSig = str1;
    localCheckSinglePkgSigReq.versionCode = aewh.getVersionCode(BaseApplicationImpl.sApplication);
    localCheckSinglePkgSigReq.marketVer = paramToServiceMsg.extraData.getInt("mv");
    localCheckSinglePkgSigReq.sysVer = aqgz.getOsVersion();
    paramToServiceMsg = localCheckSinglePkgSigReq.toByteArray();
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "CheckSinglePkgSigReq:\nversionCode:" + localCheckSinglePkgSigReq.versionCode);
    }
    paramUniPacket.put("MAAControl.CheckSinglePkgSig", a(paramToServiceMsg));
    return true;
  }
  
  private Object m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetResourceResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new GetResourceResp());
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("ConfigServantObj");
    paramUniPacket.setFuncName("GetResourceReq");
    GetSinglePkgSigReq localGetSinglePkgSigReq = new GetSinglePkgSigReq();
    localGetSinglePkgSigReq.pkgName = paramToServiceMsg.extraData.getString("pn");
    localGetSinglePkgSigReq.versionCode = paramToServiceMsg.extraData.getInt("vc");
    localGetSinglePkgSigReq.marketVer = paramToServiceMsg.extraData.getInt("mv");
    localGetSinglePkgSigReq.sysVer = paramToServiceMsg.extraData.getInt("sv");
    paramUniPacket.put("MAAControl.GetSinglePkgSig", a(localGetSinglePkgSigReq.toByteArray()));
    return true;
  }
  
  private Object n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SDKUpgradeRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "SDKUpgradeRes", new SDKUpgradeRes());
    if (QLog.isColorLevel())
    {
      QLog.d("UpgradeController", 2, "Get Upgrade Config Resp: " + paramToServiceMsg);
      if (paramToServiceMsg != null)
      {
        if ((paramToServiceMsg.vUpgradeInfo != null) && (paramToServiceMsg.vUpgradeInfo.size() > 0)) {
          break label86;
        }
        QLog.d("UpgradeController", 2, "Not vUpgradeInfo");
      }
    }
    return paramToServiceMsg;
    label86:
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
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("ResourceConfig.GetResourceReq".equals(str)) {
      return m(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ConfigService.ClientReq".equals(str)) {
      return n(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MAAControl.CheckSinglePkgSig".equals(str)) {
      return a(paramToServiceMsg, paramFromServiceMsg, str);
    }
    if ("MAAControl.GetSinglePkgSig".equals(str)) {
      return a(paramToServiceMsg, paramFromServiceMsg, str);
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("ConfigService.ClientReq".equals(str)) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if ("ResourceConfig.GetResourceReq".equals(str)) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if ("MAAControl.CheckSinglePkgSig".equals(str)) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("MAAControl.GetSinglePkgSig".equals(str)) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] y()
  {
    return gu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anad
 * JD-Core Version:    0.7.0.1
 */