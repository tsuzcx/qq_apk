import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abqk
{
  public static String TAG = "cmgame_process.CmGameADInfo";
  public int adId;
  public String adsContent;
  public double appScore = 0.0D;
  public String bannerBaseInfoText;
  public String bannerImgName;
  public String bannerLogo;
  public String bhq;
  public long downloadNum;
  public String exposureUrl;
  public long jsState;
  public String previewImgUrl;
  public int productType;
  public String url;
  public int vSize;
  public String vid;
  
  public static abqk a(String paramString)
  {
    abqk localabqk = new abqk();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localabqk.productType = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localabqk.vid = localJSONObject1.optString("tencent_video_id");
      localabqk.vSize = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localabqk.previewImgUrl = localJSONObject4.optString("img");
      localabqk.bannerBaseInfoText = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localabqk.adId = localJSONObject3.optInt("advertiser_id");
      localabqk.bannerLogo = localJSONObject3.optString("corporate_logo");
      localabqk.bannerImgName = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localabqk.bhq = localJSONObject3.optString("click_url");
      localabqk.exposureUrl = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localabqk.downloadNum = localJSONObject2.optLong("download_num");
      localabqk.url = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localabqk.url)) && (localabqk.url.startsWith("https://"))) {
        localabqk.url = localabqk.url.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localabqk.appScore = localJSONObject2.optDouble("app_score_num");
      }
      localabqk.adsContent = paramString;
      return localabqk;
    }
    catch (Throwable paramString)
    {
      QLog.e(TAG, 1, paramString, new Object[0]);
    }
    return localabqk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqk
 * JD-Core Version:    0.7.0.1
 */