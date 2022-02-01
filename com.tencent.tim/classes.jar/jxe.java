import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class jxe
{
  public String UD;
  public String UE = "";
  public String UF = "";
  public String UG = "";
  public String UH = "";
  public String UI;
  public String UJ;
  public String UK;
  public String UL;
  public String UM;
  public String UN;
  public String UO;
  public String UP;
  public String UQ;
  public String UR;
  public String US;
  public int aDU = 5;
  public int aDV;
  public int aDW;
  public int aDX;
  public int aDY;
  public int aDZ;
  public int aEa;
  public int aEb;
  public int aEc;
  public int aEd;
  public boolean acC;
  public boolean acD;
  public boolean acE;
  public boolean acF;
  public String appId = "";
  public String appName = "";
  public String bannerText = "";
  public int downloadType;
  public String downloadUrl = "";
  public String hT = "";
  public int jumpType;
  public String jumpUrl = "";
  public String mNickName;
  public String packagename = "";
  
  private jxe() {}
  
  public jxe(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.UD = paramString.optString("paUin", "");
      this.mNickName = paramString.optString("paName", "");
      this.hT = paramString.optString("adId", "");
      this.UE = paramString.optString("adPosId", "");
      this.acD = paramString.optBoolean("bannerShow", false);
      this.aDW = paramString.optInt("bannertype", 0);
      this.jumpType = paramString.optInt("jumpType", 0);
      this.jumpUrl = paramString.optString("jumpUrl", "");
      this.appId = paramString.optString("appId", "");
      this.packagename = paramString.optString("packagename", "");
      this.downloadUrl = paramString.optString("androidDownloadUrl", "");
      this.UG = paramString.optString("bannerImgUrl", "");
      this.bannerText = paramString.optString("bannerText", "");
      this.UH = paramString.optString("bannerButtonText", "");
      this.acE = paramString.optBoolean("silentDownload", false);
      this.appName = paramString.optString("appName", "");
      this.UF = paramString.optString("reportLink", "");
      this.acC = paramString.optBoolean("horizontalVideo", false);
      this.aDU = paramString.optInt("audioFadeinDuration", 5);
      this.aDV = paramString.optInt("audioSwitchType", 0);
      this.downloadType = paramString.optInt("preDownloadType", 0);
      this.downloadType = PAAdPreloadTask.checkNetworkType(this.downloadType);
      if ((!TextUtils.isEmpty(this.UF)) && (!this.UF.contains("https"))) {
        this.UF = this.UF.replace("http", "https");
      }
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, "reportLink :" + this.UF);
      }
      this.UJ = paramString.optString("str_openJumpUrlGuide", "");
      this.UI = paramString.optString("str_myappDownloadUrl", "");
      this.UK = paramString.optString("jumpTypeParams");
      this.aDZ = paramString.optInt("canScorll");
      if (this.aDZ == 1) {}
      for (;;)
      {
        this.acF = bool;
        this.aEa = paramString.optInt("controlVariable");
        this.aEb = paramString.optInt("uint32_control_plugin_time");
        this.aEc = paramString.optInt("uint32_autoJump");
        this.aDY = paramString.optInt("dDCategoryId", -1);
        this.UL = paramString.optString("dDCategoryName", "");
        this.aDX = paramString.optInt("dDItemID", -1);
        this.UM = paramString.optString("str_clickLink", "");
        this.aEd = paramString.optInt("uint32_monitorType", 0);
        this.UN = paramString.getString("str_share_nick");
        this.UO = paramString.getString("str_share_ad_head_url");
        this.UP = paramString.getString("str_share_ad_brief");
        this.UQ = paramString.getString("str_share_ad_txt");
        this.UR = paramString.getString("str_share_ad_icon_url");
        this.US = paramString.getString("str_share_jump_url");
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static jxe a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    jxe localjxe = new jxe();
    localjxe.UD = paramString2;
    localjxe.mNickName = paramString3;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        localjxe.hT = paramString1.optString("str_adId", "");
        localjxe.UE = paramString1.optString("str_adPosId", "");
        localjxe.acD = paramString1.optBoolean("bool_bannerShow", false);
        localjxe.aDW = paramString1.optInt("uint32_bannertype", 0);
        localjxe.jumpType = paramString1.optInt("uint32_jumpType", 0);
        localjxe.jumpUrl = paramString1.optString("str_jumpUrl", "");
        localjxe.appId = paramString1.optString("str_appId", "");
        localjxe.packagename = paramString1.optString("str_packagename", "");
        localjxe.downloadUrl = paramString1.optString("str_androidDownloadUrl", "");
        localjxe.UG = paramString1.optString("str_bannerImgUrl", "");
        localjxe.bannerText = paramString1.optString("str_bannerText", "");
        localjxe.UH = paramString1.optString("str_bannerButtonText", "");
        localjxe.acE = paramString1.optBoolean("bool_silentDownload", false);
        localjxe.appName = paramString1.optString("str_appName", "");
        localjxe.UF = paramString1.optString("str_reportLink", "");
        if ((!TextUtils.isEmpty(localjxe.UF)) && (!localjxe.UF.contains("https"))) {
          localjxe.UF = localjxe.UF.replace("http", "https");
        }
        localjxe.acC = paramString1.optBoolean("bool_horizontalVideo", false);
        localjxe.aDU = paramString1.optInt("uint32_audioFadeinDuration", 5);
        localjxe.aDV = paramString1.optInt("uint32_audioSwitchType", 0);
        localjxe.downloadType = paramString1.optInt("uint32_preDownloadType", 0);
        localjxe.downloadType = PAAdPreloadTask.checkNetworkType(localjxe.downloadType);
        localjxe.UJ = paramString1.optString("str_openJumpUrlGuide", "");
        localjxe.UI = paramString1.optString("str_myappDownloadUrl", "");
        localjxe.UK = paramString1.optString("str_jumpTypeParams", "");
        localjxe.aDZ = paramString1.optInt("uint32_scrollUpToJump", 0);
        if (localjxe.aDZ == 1)
        {
          localjxe.acF = bool;
          localjxe.aEa = paramString1.optInt("uint32_controlVariable", 0);
          localjxe.aEb = paramString1.optInt("uint32_control_plugin_time", 0);
          localjxe.aEc = paramString1.optInt("uint32_autoJump", 0);
          if (localjxe.jumpType >= 3)
          {
            bool = TextUtils.isEmpty(localjxe.UK);
            if (bool) {}
          }
          try
          {
            paramString2 = new JSONObject(localjxe.UK);
            localjxe.aDY = paramString2.optInt("class_id", -1);
            localjxe.UL = paramString2.optString("class_name", "");
            localjxe.aDX = paramString2.optInt("pendant_id", -1);
            localjxe.UM = paramString1.optString("str_clickLink", "");
            localjxe.aEd = paramString1.optInt("uint32_monitorType", 0);
            localjxe.UN = paramString1.optString("str_share_nick", "");
            localjxe.UO = paramString1.optString("str_share_ad_head_url", "");
            localjxe.UP = paramString1.optString("str_share_ad_brief", "");
            localjxe.UQ = paramString1.optString("str_share_ad_txt", "");
            localjxe.UR = paramString1.optString("str_share_ad_icon_url", "");
            localjxe.US = paramString1.optString("str_share_jump_url", "");
            return localjxe;
          }
          catch (JSONException paramString2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.w("AdvertisementRecentUserManager", 2, "parse jumpTypeParams fail" + paramString2.getMessage());
            continue;
          }
        }
        bool = false;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
  }
  
  public JSONObject l()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("paUin", this.UD);
      localJSONObject.put("paName", this.mNickName);
      localJSONObject.put("bannerShow", this.acD);
      localJSONObject.put("bannertype", this.aDW);
      localJSONObject.put("jumpType", this.jumpType);
      localJSONObject.put("jumpUrl", this.jumpUrl);
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("packagename", this.packagename);
      localJSONObject.put("androidDownloadUrl", this.downloadUrl);
      localJSONObject.put("bannerImgUrl", this.UG);
      localJSONObject.put("bannerText", this.bannerText);
      localJSONObject.put("bannerButtonText", this.UH);
      localJSONObject.put("silentDownload", this.acE);
      localJSONObject.put("adId", this.hT);
      localJSONObject.put("adPosId", this.UE);
      localJSONObject.put("appName", this.appName);
      localJSONObject.put("reportLink", this.UF);
      localJSONObject.put("horizontalVideo", this.acC);
      localJSONObject.put("audioFadeinDuration", this.aDU);
      localJSONObject.put("audioSwitchType", this.aDV);
      localJSONObject.put("preDownloadType", this.downloadType);
      localJSONObject.put("str_openJumpUrlGuide", this.UJ);
      localJSONObject.put("str_myappDownloadUrl", this.UI);
      localJSONObject.put("jumpTypeParams", this.UK);
      localJSONObject.put("canScorll", this.aDZ);
      localJSONObject.put("controlVariable", this.aEa);
      localJSONObject.put("uint32_control_plugin_time", this.aEb);
      localJSONObject.put("uint32_autoJump", this.aEc);
      localJSONObject.put("dDCategoryId", this.aDY);
      localJSONObject.put("dDCategoryName", this.UL);
      localJSONObject.put("dDItemID", this.aDX);
      localJSONObject.put("str_clickLink", this.UM);
      localJSONObject.put("uint32_monitorType", this.aEd);
      localJSONObject.put("str_share_nick", this.UN);
      localJSONObject.put("str_share_ad_head_url", this.UO);
      localJSONObject.put("str_share_ad_brief", this.UP);
      localJSONObject.put("str_share_ad_txt", this.UQ);
      localJSONObject.put("str_share_ad_icon_url", this.UR);
      localJSONObject.put("str_share_jump_url", this.US);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "VideoDownloadItem{mTrueUin='" + this.UD + '\'' + ", mNickName='" + this.mNickName + '\'' + ", adId='" + this.hT + '\'' + ", adPosId='" + this.UE + '\'' + ", reportLink='" + this.UF + '\'' + ", audioFadeinDuration=" + this.aDU + ", horizontalVideo=" + this.acC + ", audioMode=" + this.aDV + ", bannerShow=" + this.acD + ", bannertype=" + this.aDW + ", bannerImgUrl='" + this.UG + '\'' + ", bannerText='" + this.bannerText + '\'' + ", bannerButtonText='" + this.UH + '\'' + ", jumpType=" + this.jumpType + ", downloadUrl='" + this.downloadUrl + '\'' + ", myappDownloadUrl='" + this.UI + '\'' + ", appId='" + this.appId + '\'' + ", packagename='" + this.packagename + '\'' + ", appName='" + this.appName + '\'' + ", silentDownload=" + this.acE + ", downloadType=" + this.downloadType + ", jumpUrl='" + this.jumpUrl + '\'' + ", openJumpUrlGuide='" + this.UJ + '\'' + ", jumpTypeParams='" + this.UK + '\'' + ", dDItemID=" + this.aDX + ", dDCategoryName='" + this.UL + '\'' + ", dDCategoryId=" + this.aDY + ", canScorll=" + this.aDZ + ", controlVariable=" + this.aEa + ", plugin_time=" + this.aEb + ", scrollUpToJump=" + this.acF + ", uint32_autoJump=" + this.aEc + ", mClickReportLink='" + this.UM + '\'' + ", mReportPlatType=" + this.aEd + ", mShareNickname='" + this.UN + '\'' + ", mShareHeaderUrl='" + this.UO + '\'' + ", mShareBrief='" + this.UP + '\'' + ", mShareTxt='" + this.UQ + '\'' + ", mShareIconUrl='" + this.UR + '\'' + ", mShareJumpUrl='" + this.US + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jxe
 * JD-Core Version:    0.7.0.1
 */