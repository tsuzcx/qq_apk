import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class kkp
{
  public String ZL;
  public String ZM;
  public String ZN;
  public String ZO;
  public String ZP;
  public String ZQ;
  public String ZR;
  public String ZS;
  public String ZT;
  public String ZU;
  public String ZV;
  public String ZW;
  public String ZX;
  public String ZY;
  public String ZZ;
  public kkr a = new kkr();
  public String aaa;
  public String activityUrl;
  public String appid;
  public String businessType;
  public String buttonDesc;
  public String detailUrl;
  public String gameIcon;
  public String gameName;
  public int id;
  public String packageName = "";
  
  public static kkp a(String paramString, kkp paramkkp)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramkkp == null) {
      paramkkp = new kkp();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramkkp.buttonDesc = paramString.optString("button_desc", "");
        paramkkp.ZV = paramString.optString("word_content_no_wifi", "");
        paramkkp.ZW = paramString.optString("word_content_wifi", "");
        paramkkp.ZX = paramString.optString("word_highlight", "");
        paramkkp.ZY = paramString.optString("word_highlight_color", "");
        paramkkp.ZZ = paramString.optString("word_title", "");
        paramkkp.detailUrl = paramString.optString("detail_url", "");
        paramkkp.activityUrl = paramString.optString("activity_url", "");
        paramkkp.gameIcon = paramString.optString("game_icon", "");
        paramkkp.aaa = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramkkp;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramkkp.a = kkr.a(str);
        return paramkkp;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramkkp;
      }
    }
  }
  
  public static kkp a(String paramString, kkp paramkkp, kko paramkko)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramkkp == null) {
      paramkkp = new kkp();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramkkp.id = paramString.optInt("id", 0);
        paramkkp.gameName = paramString.optString("game_name", "");
        paramkkp.packageName = paramString.optString("package_name", "");
        paramkkp.businessType = paramString.optString("business_type", "");
        paramkkp.ZL = paramString.optString("plat_form", "");
        paramkkp.appid = paramString.optString("appid", "");
        paramkkp.ZM = paramString.optString("oper_type", "");
        paramkkp.ZU = paramString.optString("game_stage", "");
        paramkkp.ZN = paramString.optString("game_status", "");
        paramkkp.ZO = paramString.optString("game_kind", "");
        paramkkp.ZP = paramString.optString("game_sub_kind", "");
        paramkkp.ZQ = paramString.optString("play_nums", "");
        paramkkp.ZR = paramString.optString("game_tags", "");
        paramkkp.ZS = paramString.optString("game_download_url", "");
        paramkkp.ZT = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramkkp.packageName)) {
          paramkko.pkgName = paramkkp.packageName;
        }
        if (!TextUtils.isEmpty(paramkkp.ZS)) {
          paramkko.ZK = paramkkp.ZS;
        }
        paramString = paramkkp;
        if (TextUtils.isEmpty(paramkkp.appid)) {
          break;
        }
        paramkko.appid = paramkkp.appid;
        return paramkkp;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramkkp;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, kkp paramkkp, kko paramkko)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramkkp, paramkko);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramkkp);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramkko.businessType > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramkkp.packageName)))
    {
      paramkkp.packageName = paramkko.pkgName;
      paramkkp.aaa = String.valueOf(paramkko.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkp
 * JD-Core Version:    0.7.0.1
 */