import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

public class axbh
  extends swr
{
  private static final String[] ba = { "CameraModuleSvc" };
  public static final HashMap<String, String> qX = new HashMap();
  private AppInterface app;
  
  public axbh(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  private boolean bw(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetCameraConfigReq();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCameraConfig");
    paramUniPacket.put("CameraModuleSvc.GetCameraConfig", paramToServiceMsg);
    return true;
  }
  
  private boolean bx(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GetCategoryMaterialReq localGetCategoryMaterialReq = new GetCategoryMaterialReq();
    localGetCategoryMaterialReq.ServiceId = paramToServiceMsg.extraData.getString("ServiceId");
    localGetCategoryMaterialReq.ETag = sz("CameraModuleSvc.GetCompressedCategoryMaterial" + localGetCategoryMaterialReq.ServiceId);
    localGetCategoryMaterialReq.SdkInfos = eI();
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetCompressedCategoryMaterial");
    paramUniPacket.put("CameraModuleSvc.GetCompressedCategoryMaterial", localGetCategoryMaterialReq);
    return true;
  }
  
  private boolean by(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new GetPlayShowCatMatTreeReq();
    paramToServiceMsg.ETag = sz("CameraModuleSvc.GetPlayShowCatMatTree");
    paramToServiceMsg.MqVersion = "3.4.4";
    paramUniPacket.setServantName("CameraModuleSvc");
    paramUniPacket.setFuncName("CameraModuleSvc.GetPlayShowCatMatTree");
    paramUniPacket.put("CameraModuleSvc.GetPlayShowCatMatTree", paramToServiceMsg);
    return true;
  }
  
  private ArrayList<MetaSdkInfo> eI()
  {
    ArrayList localArrayList = new ArrayList();
    MetaSdkInfo localMetaSdkInfo = new MetaSdkInfo();
    localMetaSdkInfo.sdk = 0;
    localMetaSdkInfo.sdkVersion = AEModule.getVersion(this.app.getApp());
    localArrayList.add(localMetaSdkInfo);
    return localArrayList;
  }
  
  private String sz(String paramString)
  {
    return axis.a().t(paramString, "", 4);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return decodePacket(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCameraConfig", new GetCameraConfigRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) {
      return b(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetCompressedCategoryMaterial", new GetCategoryMaterialRsp());
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return b(paramFromServiceMsg.getWupBuffer(), "CameraModuleSvc.GetPlayShowCatMatTree", new GetPlayShowCatMatTreeRsp());
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) {
      return bw(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) {
      return bx(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) {
      return by(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public final <T> T b(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    axbp localaxbp = new axbp(true);
    try
    {
      localaxbp.setEncodeName("utf-8");
      localaxbp.decode(paramArrayOfByte);
      return localaxbp.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public String[] y()
  {
    return ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbh
 * JD-Core Version:    0.7.0.1
 */