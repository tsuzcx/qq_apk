import android.os.Bundle;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class axbi
  extends accg
{
  private static final String TAG = axbi.class.getSimpleName();
  public static final Type e = new axbj().getType();
  protected Map<String, Long> mB = new HashMap();
  private EntityManager mEntityManager;
  
  public axbi(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    LogUtils.setEnable(false);
    this.mEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void s(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (awyu.aOl()) {
        awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", "succeeded with content"));
      }
      axis.a().ai("CameraModuleSvc.GetCompressedCategoryMaterialMqStoryCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      aqhq.writeFile(axbr.HB(), paramObject);
      paramObject = (axbr)axov.a().c(18);
      if (paramObject != null)
      {
        paramObject.eID();
        paramObject.eIL();
      }
      axbk.e().postValue(Boolean.valueOf(true));
      ((axbr)axov.a(18)).aco(awtn.b.cSN);
      if ((this.mB == null) || (!this.mB.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"))) {
        break label258;
      }
    }
    label258:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.mB.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera")).longValue());; paramObject = "-1")
    {
      axim.a().l(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!awyu.aOl()) {
        break;
      }
      axzu localaxzu = awyu.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        localaxzu.postValue(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera", "response", paramObject));
        break;
      }
    }
  }
  
  private void t(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)paramObject;
    Object localObject;
    if ((localGetCategoryMaterialRsp != null) && (localGetCategoryMaterialRsp.Code == 0) && (!localGetCategoryMaterialRsp.Categories.isEmpty()))
    {
      if (awyu.aOl()) {
        awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
      }
      axis.a().ai("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", localGetCategoryMaterialRsp.ETag, 4);
      paramObject = new Gson().toJson(localGetCategoryMaterialRsp);
      localObject = new File(awtn.c.b.cSX);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      aqhq.writeFile(awtn.c.cSN, paramObject);
      axbk.d().postValue(Boolean.valueOf(true));
      if ((this.mB == null) || (!this.mB.containsKey("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"))) {
        break label246;
      }
    }
    label246:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.mB.get("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera")).longValue());; paramObject = "-1")
    {
      axim.a().l(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", localGetCategoryMaterialRsp.Code);
      return;
      if (!awyu.aOl()) {
        break;
      }
      localObject = awyu.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((axzu)localObject).postValue(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera", "response", paramObject));
        break;
      }
    }
  }
  
  private void u(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(TAG, 4, "[handlePlayShowCategoryMaterials] start");
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)paramObject;
    Object localObject;
    if ((localGetPlayShowCatMatTreeRsp != null) && (localGetPlayShowCatMatTreeRsp.Code == 0) && (!localGetPlayShowCatMatTreeRsp.Categories.isEmpty()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d(TAG, 4, "[handlePlayShowCategoryMaterials] response=" + localGetPlayShowCatMatTreeRsp);
      }
      if (awyu.aOl()) {
        awyu.a().postValue(new awyu.c("CameraModuleSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
      }
      axis.a().ai("CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.ETag, 4);
      paramObject = GsonUtils.obj2Json(localGetPlayShowCatMatTreeRsp, e);
      localObject = new File(awtn.d.b.cSX);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      aqhq.writeFile(awtn.d.cSZ, paramObject);
      axbk.f().postValue(Boolean.valueOf(true));
      if ((this.mB == null) || (!this.mB.containsKey("CameraModuleSvc.GetPlayShowCatMatTree"))) {
        break label329;
      }
    }
    label329:
    for (paramObject = "" + (System.currentTimeMillis() - ((Long)this.mB.get("CameraModuleSvc.GetPlayShowCatMatTree")).longValue());; paramObject = "-1")
    {
      axim.a().l(paramFromServiceMsg.getResultCode(), paramObject, "CameraModuleSvc.GetPlayShowCatMatTree", localGetPlayShowCatMatTreeRsp.Code);
      if (QLog.isDebugVersion()) {
        QLog.d(TAG, 4, "[handlePlayShowCategoryMaterials] end");
      }
      return;
      if (QLog.isDebugVersion()) {
        QLog.d(TAG, 4, "[handlePlayShowCategoryMaterials] response=empty");
      }
      if (!awyu.aOl()) {
        break;
      }
      localObject = awyu.a();
      if (paramFromServiceMsg.isSuccess()) {}
      for (paramObject = "succeeded without content";; paramObject = "failed")
      {
        ((axzu)localObject).postValue(new awyu.c("CameraModuleSvc.GetPlayShowCatMatTree", "response", paramObject));
        break;
      }
    }
  }
  
  public void acl(String paramString)
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w(TAG, "[reqCompressedMaterials] no network....");
      return;
    }
    axiy.i(TAG, "【REQUEST】requestCompressedMaterials" + paramString);
    if (awyu.aOl()) {
      awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, "request", "null"));
    }
    this.mB.put("CameraModuleSvc.GetCompressedCategoryMaterial." + paramString, Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCompressedCategoryMaterial");
    localToServiceMsg.extraData.putString("ServiceId", paramString);
    send(localToServiceMsg);
  }
  
  public void eIA()
  {
    if (!aqiw.isNetworkAvailable())
    {
      if (QLog.isDebugVersion())
      {
        QLog.d(TAG, 4, "[reqPlayShowCategoryMaterials] no network....");
        QLog.d(TAG, 4, "[reqPlayShowCategoryMaterials] end");
      }
      return;
    }
    axiy.i(TAG, "【REQUEST】reqPlayShowCategoryMaterials");
    if (awyu.aOl()) {
      awyu.a().postValue(new awyu.c("CameraModuleSvc.GetPlayShowCatMatTree", "request", "null"));
    }
    this.mB.put("CameraModuleSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetPlayShowCatMatTree");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  public void eIz()
  {
    if (!aqiw.isNetworkAvailable())
    {
      LogUtils.w(TAG, "[reqCameraConfig] no network....");
      return;
    }
    if (awyu.aOl()) {
      awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCameraConfig", "request", "null"));
    }
    axiy.i(TAG, "【REQUEST】reqCameraConfig");
    this.mB.put("CameraModuleSvc.GetCameraConfig", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetCameraConfig");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", false);
    send(localToServiceMsg);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCompressedCategoryMaterial"))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("ServiceId");
      if (paramToServiceMsg.endsWith("MqStoryCamera")) {
        s(paramFromServiceMsg, paramObject);
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramToServiceMsg.endsWith("MqEmoCamera"));
      t(paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
      {
        r(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetPlayShowCatMatTree"));
    u(paramFromServiceMsg, paramObject);
  }
  
  protected void r(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    axiy.i(TAG, "【Handle】handleCameraConfig:" + paramFromServiceMsg.isSuccess());
    if (!paramFromServiceMsg.isSuccess())
    {
      if (awyu.aOl()) {
        awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCameraConfig", "response", "failed"));
      }
      return;
    }
    GetCameraConfigRsp localGetCameraConfigRsp = (GetCameraConfigRsp)paramObject;
    Object localObject1;
    Object localObject2;
    String str;
    Object localObject6;
    Object localObject3;
    if (localGetCameraConfigRsp.ConfigMap != null)
    {
      if (awyu.aOl()) {
        awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCameraConfig", "response", "succeeded with content"));
      }
      paramObject = "";
      localObject1 = "";
      localObject2 = "";
      Iterator localIterator = localGetCameraConfigRsp.ConfigMap.entrySet().iterator();
      str = "";
      if (localIterator.hasNext())
      {
        localObject6 = (Map.Entry)localIterator.next();
        localObject3 = (CameraConfig)((Map.Entry)localObject6).getValue();
        if (TextUtils.isEmpty(str))
        {
          str = ((CameraConfig)localObject3).ExpId;
          label184:
          localObject6 = (String)((Map.Entry)localObject6).getKey();
          if (!"app_ui_playshow_ad_id".equals(localObject6)) {
            break label268;
          }
          localObject3 = ((CameraConfig)localObject3).ConfigContent;
          paramObject = localObject2;
          localObject2 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = paramObject;
      paramObject = localObject3;
      break;
      str = str + "," + ((CameraConfig)localObject3).ExpId;
      break label184;
      label268:
      if ("app_alg_aio_camera_type_id".equals(localObject6))
      {
        localObject3 = ((CameraConfig)localObject3).ConfigContent;
        localObject1 = localObject2;
        localObject2 = paramObject;
        paramObject = localObject1;
        localObject1 = localObject3;
      }
      else if ("app_alg_entrance_qzone_id_from833".equals(localObject6))
      {
        localObject3 = ((CameraConfig)localObject3).ConfigContent;
        localObject2 = paramObject;
        paramObject = localObject3;
      }
      else
      {
        Object localObject4;
        if ("app_ui_camera_ad_id".equals(localObject6))
        {
          try
          {
            localObject3 = new JsonParser().parse(((CameraConfig)localObject3).ConfigContent).getAsJsonArray();
            if ((localObject3 != null) && (((JsonArray)localObject3).size() > 0))
            {
              localObject3 = (JsonObject)((JsonArray)localObject3).get(0);
              axis.a().ai("camera_ad_op_id", GsonUtils.optString((JsonObject)localObject3, "opID"), 4);
              axis.a().n("camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject3, "showOp"), 4);
              axis.a().ai("camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject3, "opIcon"), 4);
              axis.a().ai("camera_ad_type", GsonUtils.optString((JsonObject)localObject3, "type"), 4);
              axis.a().ai("camera_ad_schema", GsonUtils.optString((JsonObject)localObject3, "schema"), 4);
            }
            else
            {
              axis.a().ai("camera_ad_op_id", "", 4);
              axis.a().n("camera_ad_show", false, 4);
              axis.a().ai("camera_ad_icon_url", "", 4);
              axis.a().ai("camera_ad_type", "", 4);
              axis.a().ai("camera_ad_schema", "", 4);
            }
          }
          catch (Exception localException1)
          {
            axiy.e(TAG, "camera ad ab test inflate error.");
            localObject4 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject4;
          }
        }
        else
        {
          if ("app_alg_filter_timeout_id".equals(localObject6))
          {
            localObject4 = ((CameraConfig)localObject4).ConfigContent;
            axis.a().ai("app_alg_filter_timeout_id", (String)localObject4, 4);
            localObject4 = paramObject;
            paramObject = localObject2;
            localObject2 = localObject4;
            continue;
          }
          if ("app_ui_camera_circle_ad_id".equals(localObject6)) {
            try
            {
              localObject4 = new JsonParser().parse(((CameraConfig)localObject4).ConfigContent).getAsJsonArray();
              if ((localObject4 != null) && (((JsonArray)localObject4).size() > 0))
              {
                localObject4 = (JsonObject)((JsonArray)localObject4).get(0);
                axis.a().ai("circle_camera_ad_op_id", GsonUtils.optString((JsonObject)localObject4, "opID"), 4);
                axis.a().ai("circle_camera_ad_icon_url", GsonUtils.optString((JsonObject)localObject4, "opIcon"), 4);
                axis.a().ai("circle_camera_ad_type", GsonUtils.optString((JsonObject)localObject4, "type"), 4);
                axis.a().ai("circle_camera_ad_schema", GsonUtils.optString((JsonObject)localObject4, "schema"), 4);
                axis.a().n("circle_camera_ad_show", GsonUtils.optBoolean((JsonObject)localObject4, "showOp"), 4);
              }
              else
              {
                axis.a().ai("circle_camera_ad_op_id", "", 4);
                axis.a().ai("circle_camera_ad_icon_url", "", 4);
                axis.a().ai("circle_camera_ad_type", "", 4);
                axis.a().ai("circle_camera_ad_schema", "", 4);
                axis.a().n("circle_camera_ad_show", false, 4);
              }
            }
            catch (Exception localException2)
            {
              axiy.e(TAG, "camera ad ab test inflate error.");
            }
          }
          localObject5 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject5;
          continue;
          axis.a().ai("CameraModuleSvc.GetCameraConfig", str, 4);
          axis.a().ai("app_ui_playshow_ad_id", paramObject, 4);
          axis.a().ai("app_alg_aio_camera_type_id", (String)localObject1, 4);
          axis.a().ai("app_alg_entrance_qzone_id_from833", (String)localObject2, 4);
          paramObject = axim.a();
          int i = paramFromServiceMsg.getResultCode();
          long l2 = System.currentTimeMillis();
          if (this.mB.containsKey("CameraModuleSvc.GetCameraConfig")) {}
          for (long l1 = ((Long)this.mB.get("CameraModuleSvc.GetCameraConfig")).longValue();; l1 = 0L)
          {
            paramObject.l(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig", localGetCameraConfigRsp.Code);
            return;
            if (!awyu.aOl()) {
              break;
            }
            awyu.a().postValue(new awyu.c("CameraModuleSvc.GetCameraConfig", "response", "succeeded without content"));
            break;
          }
        }
        Object localObject5 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject5;
        continue;
        localObject5 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbi
 * JD-Core Version:    0.7.0.1
 */