import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajoz
{
  public String bRS = "";
  public String bRT = "";
  public String btnUrl = "";
  private boolean cpB;
  public String d1 = "";
  public String imageUrl = "";
  public String moreUrl = "";
  public String toUin = "";
  
  public static ajoz a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramString = (String)ajrb.c(paramString, "cike_guide_content", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramInt == 0) {
          paramString = paramString.optJSONObject("publish_menu_alert_config");
        }
        for (;;)
        {
          return a(paramContext, paramString);
          if (paramInt == 1) {
            paramString = paramString.optJSONObject("sendmsg_alert_config");
          } else {
            paramString = paramString.optJSONObject("authenticated_user_alert_config");
          }
        }
      }
      QLog.e("CikeConfigData", 1, "parseManageConfig, get config failed");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("CikeConfigData", 1, "parseManageConfig, exception: " + paramContext.getMessage());
      }
    }
    return null;
  }
  
  public static ajoz a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      ajoz localajoz = new ajoz();
      localajoz.imageUrl = paramJSONObject.optString("iconurl");
      localajoz.bRS = paramJSONObject.optString("title_text");
      if (bt(paramContext))
      {
        localajoz.cpB = true;
        localajoz.bRT = paramJSONObject.optString("download_installapp_text");
      }
      for (localajoz.btnUrl = paramJSONObject.optString("jump_app_scheme");; localajoz.btnUrl = paramJSONObject.optString("download_url_android"))
      {
        localajoz.moreUrl = paramJSONObject.optString("moreurl");
        return localajoz;
        localajoz.cpB = false;
        localajoz.bRT = paramJSONObject.optString("download_text");
      }
    }
    QLog.e("CikeConfigData", 1, "parseJson, config is null");
    return null;
  }
  
  public static boolean bt(Context paramContext)
  {
    return aqiz.isAppInstalled(paramContext, "com.tencent.litenow");
  }
  
  public void ki(long paramLong)
  {
    if ((this.cpB) && (paramLong != 0L) && (!TextUtils.isEmpty(this.btnUrl)))
    {
      if (this.btnUrl.contains("?")) {
        this.btnUrl = (this.btnUrl + "&uid=" + paramLong);
      }
    }
    else {
      return;
    }
    this.btnUrl = (this.btnUrl + "?uid=" + paramLong);
  }
  
  public String toString()
  {
    return "imageUrl:" + this.imageUrl + " titleTxt:" + this.bRS + " btnTxt:" + this.bRT + " btnUrl:" + this.btnUrl + " moreUrl:" + this.moreUrl + " d1:" + this.d1 + " toUin: " + this.toUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoz
 * JD-Core Version:    0.7.0.1
 */