import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class kkx
{
  public String WW;
  public int aJK;
  public int aJL;
  public String aaA;
  public String aaB;
  public String aaC;
  public String aaD;
  public String aaE;
  public String aaF;
  public String aaG;
  public String aaH;
  public String aaI;
  public String aaJ;
  public String aaK;
  public String aaL;
  public String aaM;
  public String aaN;
  public String aaO;
  public String aaP;
  public String aaQ;
  public String aaR;
  public String aat;
  public String aau;
  public String aav;
  public String aaw;
  public String aax;
  public String aay;
  public String aaz;
  public int accountId;
  public String button;
  public String buttonTxt;
  public int contentType;
  public String goodsName;
  public int goodsType;
  public String jmpUrl;
  public int sourceId;
  
  public kkx(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementSoftInfo", 2, "softData = " + paramString);
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramString = new JSONObject(new JSONObject(paramString).optString("SoftAd"));
        O(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramString.getMessage());
          }
          paramString = null;
        }
      }
    }
    QLog.d("AdvertisementSoftInfo", 2, "softData = null");
  }
  
  public kkx(JSONObject paramJSONObject)
  {
    O(paramJSONObject);
  }
  
  private void O(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        this.WW = paramJSONObject.optString("sAdID");
        this.aat = paramJSONObject.optString("adImg");
        this.aav = paramJSONObject.optString("adTxt");
        this.aau = paramJSONObject.optString("adAbb");
        this.buttonTxt = paramJSONObject.optString("buttonTxt");
        this.jmpUrl = paramJSONObject.optString("jmpUrl");
        this.aaw = paramJSONObject.optString("appScheme");
        this.aax = paramJSONObject.optString("miniProgramUrl");
        this.contentType = paramJSONObject.optInt("contentType");
        this.aJK = paramJSONObject.optInt("video_percent");
        this.sourceId = paramJSONObject.optInt("sourceId");
        this.aJL = paramJSONObject.optInt("bizPlatId");
        this.goodsType = paramJSONObject.optInt("goodsType");
        this.aay = paramJSONObject.optString("goodsId");
        this.goodsName = paramJSONObject.optString("goodsName");
        this.accountId = paramJSONObject.optInt("accountId");
        this.aaz = paramJSONObject.optString("goodsPrice");
        this.aaA = paramJSONObject.optString("goodsPromotionPrice");
        this.aaB = paramJSONObject.optString("goodsPromotionTxt");
        this.button = paramJSONObject.optString("button");
        paramJSONObject = new JSONObject(paramJSONObject.optString("extendInfo"));
        this.aaC = paramJSONObject.optString("game_pkg_name");
        this.aaD = paramJSONObject.optString("game_app_id");
        this.aaE = paramJSONObject.optString("game_app_name");
        this.aaF = paramJSONObject.optString("game_apk_url");
        this.aaG = paramJSONObject.optString("app_download_schema");
        this.aaH = paramJSONObject.optString("download_api_url");
        this.aaI = paramJSONObject.optString("downloadNum");
        this.aaJ = paramJSONObject.optString("game_adtag");
        this.aaK = paramJSONObject.optString("__ADSTR__");
        this.aaL = paramJSONObject.optString("cmsid");
        this.aaM = paramJSONObject.optString("soft_video_style");
        this.aaO = paramJSONObject.optString("big_card_show_percent");
        this.aaP = paramJSONObject.optString("big_card_show_second");
        this.aaN = paramJSONObject.optString("big_card_show_type");
        this.aaQ = paramJSONObject.optString("small_card_start_time");
        this.aaR = paramJSONObject.optString("bizPlatName");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramJSONObject.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkx
 * JD-Core Version:    0.7.0.1
 */