import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adhg
{
  @TargetApi(9)
  public static ArCloudConfigInfo a(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      Object localObject2;
      Object localObject1;
      try
      {
        localJSONObject1 = new JSONObject(paramString);
        paramString = new ArCloudConfigInfo();
        if (localJSONObject1.has("BusinessId")) {
          paramString.businessId = Integer.parseInt(localJSONObject1.getString("BusinessId"));
        }
        if (localJSONObject1.has("SDKVersion")) {
          paramString.bsN = localJSONObject1.getString("SDKVersion");
        }
        if (localJSONObject1.has("CloseCache")) {
          paramString.cFe = localJSONObject1.getInt("CloseCache");
        }
        if (localJSONObject1.has("Type")) {
          paramString.type = localJSONObject1.getInt("Type");
        }
        if (localJSONObject1.has("TrackMode"))
        {
          paramString.cCF = localJSONObject1.getInt("TrackMode");
          if (paramString.cCF == 4) {
            paramString.cCF = 1;
          }
          if (paramString.cCF == 1)
          {
            localObject2 = (SensorManager)BaseApplication.getContext().getSystemService("sensor");
            if (!addz.adJ()) {
              break label1960;
            }
            i = 15;
            localObject1 = ((SensorManager)localObject2).getSensorList(i);
            localObject2 = ((SensorManager)localObject2).getDefaultSensor(4);
            if ((((List)localObject1).size() <= 0) || (localObject2 == null) || (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
              continue;
            }
            paramString.cCF = 1;
          }
          if (paramString.type == 8) {
            paramString.cCF = 2;
          }
        }
        if (localJSONObject1.has("PicId")) {
          paramString.picId = localJSONObject1.getString("PicId");
        }
        if (localJSONObject1.has("LotterySet")) {
          paramString.cFf = localJSONObject1.getInt("LotterySet");
        }
        if (localJSONObject1.has("Award"))
        {
          localObject1 = localJSONObject1.getJSONObject("Award");
          localObject2 = new ArAwardInfo();
          if (((JSONObject)localObject1).has("AwardDistance")) {
            ((ArAwardInfo)localObject2).cHY = localJSONObject1.getInt("AwardDistance");
          }
          if (((JSONObject)localObject1).has("BusinessBanner")) {
            ((ArAwardInfo)localObject2).btY = localJSONObject1.getString("BusinessBanner");
          }
          if (((JSONObject)localObject1).has("BusinessLogo")) {
            ((ArAwardInfo)localObject2).businessLogo = localJSONObject1.getString("BusinessLogo");
          }
          if (((JSONObject)localObject1).has("BusinessName")) {
            ((ArAwardInfo)localObject2).bub = localJSONObject1.getString("BusinessName");
          }
          if (((JSONObject)localObject1).has("BusinessWishing")) {
            ((ArAwardInfo)localObject2).btZ = localJSONObject1.getString("BusinessWishing");
          }
          if (((JSONObject)localObject1).has("NotPlayModel"))
          {
            if (localJSONObject1.getInt("NotPlayModel") == 1) {
              ((ArAwardInfo)localObject2).cHZ = 0;
            }
          }
          else {
            paramString.jdField_a_of_type_ComTencentMobileqqArModelArAwardInfo = ((ArAwardInfo)localObject2);
          }
        }
        else
        {
          if (localJSONObject1.has("Feature"))
          {
            localObject1 = localJSONObject1.getJSONObject("Feature");
            localObject2 = new ArFeatureInfo();
            if (((JSONObject)localObject1).has("FeatureMD5")) {
              ((ArFeatureInfo)localObject2).buc = ((JSONObject)localObject1).getString("FeatureMD5");
            }
            if (((JSONObject)localObject1).has("FeatureSize")) {
              ((ArFeatureInfo)localObject2).Uq = ((JSONObject)localObject1).getLong("FeatureSize");
            }
            if (((JSONObject)localObject1).has("FeatureUrl")) {
              ((ArFeatureInfo)localObject2).bud = ((JSONObject)localObject1).getString("FeatureUrl");
            }
            paramString.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject2);
          }
          if (localJSONObject1.has("ModelResource"))
          {
            localObject1 = localJSONObject1.getJSONObject("ModelResource");
            localObject2 = new ArModelResource();
            if (((JSONObject)localObject1).has("ModelResourceSize")) {
              ((ArModelResource)localObject2).Ur = ((JSONObject)localObject1).getLong("ModelResourceSize");
            }
            if (((JSONObject)localObject1).has("ModelResourceMD5")) {
              ((ArModelResource)localObject2).bum = ((JSONObject)localObject1).getString("ModelResourceMD5");
            }
            if (((JSONObject)localObject1).has("ModelResourceUrl")) {
              ((ArModelResource)localObject2).bun = ((JSONObject)localObject1).getString("ModelResourceUrl");
            }
            if (((JSONObject)localObject1).has("ModelResourceBgMusic")) {
              ((ArModelResource)localObject2).buo = ((JSONObject)localObject1).getString("ModelResourceBgMusic");
            }
            if (((JSONObject)localObject1).has("ModelConfigFile")) {
              ((ArModelResource)localObject2).bup = ((JSONObject)localObject1).getString("ModelConfigFile");
            }
            if (((JSONObject)localObject1).has("ModelRepeatTimes")) {
              ((ArModelResource)localObject2).cIc = ((JSONObject)localObject1).getInt("ModelRepeatTimes");
            }
            if (((JSONObject)localObject1).has("ModelLayout")) {
              ((ArModelResource)localObject2).buq = ((JSONObject)localObject1).getString("ModelLayout");
            }
            paramString.jdField_a_of_type_ComTencentMobileqqArModelArModelResource = ((ArModelResource)localObject2);
          }
          if (localJSONObject1.has("Web"))
          {
            localObject1 = localJSONObject1.getJSONObject("Web");
            localObject2 = new ArWebInfo();
            if (((JSONObject)localObject1).has("IsUrlAutoJump"))
            {
              if (((JSONObject)localObject1).getInt("IsUrlAutoJump") != 1) {
                break label1966;
              }
              bool = true;
              ((ArWebInfo)localObject2).bNZ = bool;
            }
            if (((JSONObject)localObject1).has("IsUrlTransparent"))
            {
              if (((JSONObject)localObject1).getInt("IsUrlTransparent") != 1) {
                break label1971;
              }
              bool = true;
              ((ArWebInfo)localObject2).bOa = bool;
            }
            if (((JSONObject)localObject1).has("WebJumpUrl")) {
              ((ArWebInfo)localObject2).but = ((JSONObject)localObject1).getString("WebJumpUrl");
            }
            if (((JSONObject)localObject1).has("HtmlOfflineBid")) {
              ((ArWebInfo)localObject2).buu = ((JSONObject)localObject1).getString("HtmlOfflineBid");
            }
            if ((Build.VERSION.SDK_INT < 16) && (((ArWebInfo)localObject2).bOa))
            {
              QLog.i("AREngine_MarkerJsonParser", 1, "isUrlTransparent isUrlTransparent forse to  false");
              ((ArWebInfo)localObject2).bOa = false;
              ((ArWebInfo)localObject2).but = "";
              ((ArWebInfo)localObject2).bNZ = false;
            }
            paramString.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo = ((ArWebInfo)localObject2);
          }
          if (!localJSONObject1.has("VideoResource")) {
            break label1323;
          }
          localObject1 = localJSONObject1.getJSONArray("VideoResource");
          localObject2 = new ArrayList();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label1317;
          }
          JSONObject localJSONObject2 = ((JSONArray)localObject1).getJSONObject(i);
          ArVideoResourceInfo localArVideoResourceInfo = new ArVideoResourceInfo();
          if (localJSONObject2.has("VideoConnectType")) {
            localArVideoResourceInfo.cId = localJSONObject2.getInt("VideoConnectType");
          }
          if (localJSONObject2.has("VideoKeyingConfig")) {
            localArVideoResourceInfo.bur = localJSONObject2.getString("VideoKeyingConfig");
          }
          if (localJSONObject2.has("VideoSize")) {
            localArVideoResourceInfo.videoSize = localJSONObject2.getLong("VideoSize");
          }
          if (localJSONObject2.has("VideoLayout")) {
            localArVideoResourceInfo.buq = localJSONObject2.getString("VideoLayout");
          }
          if (localJSONObject2.has("VideoMD5")) {
            localArVideoResourceInfo.videoMd5 = localJSONObject2.getString("VideoMD5");
          }
          if (localJSONObject2.has("VideoRepeatTimes")) {
            localArVideoResourceInfo.cIe = localJSONObject2.getInt("VideoRepeatTimes");
          }
          if (localJSONObject2.has("VideoTrackMode")) {
            localArVideoResourceInfo.cIf = localJSONObject2.getInt("VideoTrackMode");
          }
          if (localJSONObject2.has("VideoType")) {
            localArVideoResourceInfo.videoType = localJSONObject2.getInt("VideoType");
          }
          if (localJSONObject2.has("VideoUrl")) {
            localArVideoResourceInfo.videoUrl = localJSONObject2.getString("VideoUrl");
          }
          ((ArrayList)localObject2).add(localArVideoResourceInfo);
          i += 1;
          continue;
          paramString.cCF = 2;
          QLog.i("AREngine_MarkerJsonParser", 1, "no support sensor or GT-I9500. make trackmode 1 to 2");
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("ar_model", Build.MODEL);
          ((HashMap)localObject1).put("ar_type", "1");
          ((HashMap)localObject1).put("ar_reason", "1");
          anpc.a(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, (HashMap)localObject1, "", true);
          continue;
        }
        ((ArAwardInfo)localObject2).cHZ = 1;
      }
      catch (JSONException paramString)
      {
        QLog.i("AREngine_MarkerJsonParser", 1, "parseCloudInfo parse json failed. error msg = " + paramString.getMessage());
        return null;
      }
      continue;
      label1317:
      paramString.uk = ((ArrayList)localObject2);
      label1323:
      if (localJSONObject1.has("IsRelationShip")) {
        paramString.cFh = localJSONObject1.getInt("IsRelationShip");
      }
      if (localJSONObject1.has("traversing360")) {
        paramString.jdField_a_of_type_Adbm = adbm.a(localJSONObject1.getJSONObject("traversing360"));
      }
      if (localJSONObject1.has("ARRelationShip"))
      {
        localObject1 = localJSONObject1.getJSONObject("ARRelationShip");
        localObject2 = new ARRelationShip();
        if (((JSONObject)localObject1).has("TaskId"))
        {
          paramString.cFe = 1;
          paramString.type = 7;
          ((ARRelationShip)localObject2).taskId = ((JSONObject)localObject1).getString("TaskId");
        }
        if (((JSONObject)localObject1).has("ARRelationShipResourceUrl")) {
          ((ARRelationShip)localObject2).btM = ((JSONObject)localObject1).getString("ARRelationShipResourceUrl");
        }
        if (((JSONObject)localObject1).has("ARRelationShipResourceMd5")) {
          ((ARRelationShip)localObject2).btN = ((JSONObject)localObject1).getString("ARRelationShipResourceMd5");
        }
        if (((JSONObject)localObject1).has("AIOMsgImageUrl")) {
          ((ARRelationShip)localObject2).btV = ((JSONObject)localObject1).getString("AIOMsgImageUrl");
        }
        if (((JSONObject)localObject1).has("AIOMsgJumpUrl")) {
          ((ARRelationShip)localObject2).btU = ((JSONObject)localObject1).getString("AIOMsgJumpUrl");
        }
        if (((JSONObject)localObject1).has("AIOMsgSummary")) {
          ((ARRelationShip)localObject2).btT = ((JSONObject)localObject1).getString("AIOMsgSummary");
        }
        if (((JSONObject)localObject1).has("AIOMsgTitle")) {
          ((ARRelationShip)localObject2).btS = ((JSONObject)localObject1).getString("AIOMsgTitle");
        }
        if (((JSONObject)localObject1).has("ARRelationShipResourceSize")) {
          ((ARRelationShip)localObject2).Up = ((JSONObject)localObject1).getLong("ARRelationShipResourceSize");
        }
        if (((JSONObject)localObject1).has("GuideWebPageUrl")) {
          ((ARRelationShip)localObject2).btR = ((JSONObject)localObject1).getString("GuideWebPageUrl");
        }
        if (((JSONObject)localObject1).has("SendMsgSuccessUrl")) {
          ((ARRelationShip)localObject2).btQ = ((JSONObject)localObject1).getString("SendMsgSuccessUrl");
        }
        if (((JSONObject)localObject1).has("ShareTopicUrl")) {
          ((ARRelationShip)localObject2).btP = ((JSONObject)localObject1).getString("ShareTopicUrl");
        }
        if (((JSONObject)localObject1).has("CardDefaultText")) {
          ((ARRelationShip)localObject2).btW = ((JSONObject)localObject1).getString("CardDefaultText");
        }
        if (((JSONObject)localObject1).has("StarUin")) {
          ((ARRelationShip)localObject2).btX = ((JSONObject)localObject1).getString("StarUin");
        }
        if (((JSONObject)localObject1).has("StarNickName")) {
          ((ARRelationShip)localObject2).nickName = ((JSONObject)localObject1).getString("StarNickName");
        }
        paramString.jdField_a_of_type_ComTencentMobileqqArModelARRelationShip = ((ARRelationShip)localObject2);
      }
      if (localJSONObject1.has("LbsActivity"))
      {
        localJSONObject1 = localJSONObject1.getJSONObject("LbsActivity");
        localObject1 = new ArLBSActivity();
        if (localJSONObject1.has("ActivityName")) {
          ((ArLBSActivity)localObject1).activityName = localJSONObject1.getString("ActivityName");
        }
        if (localJSONObject1.has("Logo")) {
          ((ArLBSActivity)localObject1).logoUrl = localJSONObject1.getString("Logo");
        }
        if (localJSONObject1.has("MapBackground")) {
          ((ArLBSActivity)localObject1).bug = localJSONObject1.getString("MapBackground");
        }
        if (localJSONObject1.has("PrizeImage")) {
          ((ArLBSActivity)localObject1).buh = localJSONObject1.getString("PrizeImage");
        }
        if (localJSONObject1.has("PrizeName")) {
          ((ArLBSActivity)localObject1).bui = localJSONObject1.getString("PrizeName");
        }
        if (localJSONObject1.has("TipsForOutsideLBSLocation")) {
          ((ArLBSActivity)localObject1).buj = localJSONObject1.getString("TipsForOutsideLBSLocation");
        }
        if (localJSONObject1.has("TipsTitleForNoLBSLocation")) {
          ((ArLBSActivity)localObject1).buk = localJSONObject1.getString("TipsTitleForNoLBSLocation");
        }
        if (localJSONObject1.has("TipsContentForNoLBSLocation")) {
          ((ArLBSActivity)localObject1).bul = localJSONObject1.getString("TipsContentForNoLBSLocation");
        }
        paramString.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity = ((ArLBSActivity)localObject1);
      }
      return paramString;
      label1960:
      int i = 11;
      continue;
      label1966:
      boolean bool = false;
      continue;
      label1971:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhg
 * JD-Core Version:    0.7.0.1
 */