import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import org.json.JSONObject;

public class tqi
{
  public static String a(int paramInt)
  {
    return "id_view_AdDownloadView" + b(paramInt);
  }
  
  public static void a(AdData paramAdData, JSONObject paramJSONObject)
  {
    if (paramAdData == null) {
      return;
    }
    int i = Aladdin.getConfig(341).getIntegerFromString("bottom_ad_style", 0);
    if (i == 1) {}
    try
    {
      paramJSONObject.put("visible_one", "show");
      paramJSONObject.put("mask_image_path", "mengceng_60.png");
      paramJSONObject.put("inner_title", paramAdData.b);
      String str;
      if (TextUtils.isEmpty(paramAdData.i))
      {
        str = paramAdData.A;
        label67:
        paramJSONObject.put("author_text", str);
        paramJSONObject.put("title", paramAdData.b);
        paramJSONObject.put("author_icon", paramAdData.B);
        if (paramAdData.D != null) {
          break label221;
        }
        paramJSONObject.put("dislike_text_android", "广告");
      }
      for (;;)
      {
        twp.a("bindArticleBottom", "adStyle = " + i + " adsIconText = " + paramAdData.D);
        paramJSONObject.put("article_model", paramAdData);
        paramJSONObject.put("seperator_visible", "show");
        return;
        if (i == 2)
        {
          paramJSONObject.put("visible_two", "show");
          break;
        }
        if (i == 3)
        {
          paramJSONObject.put("visible_three", "show");
          break;
        }
        paramJSONObject.put("visible_origin", "show");
        break;
        str = paramAdData.i;
        break label67;
        label221:
        if (!TextUtils.isEmpty(paramAdData.D)) {
          paramJSONObject.put("dislike_text_android", paramAdData.D);
        }
      }
      return;
    }
    catch (Exception paramAdData) {}
  }
  
  private static String b(int paramInt)
  {
    if (paramInt == 1) {
      return "_one";
    }
    if (paramInt == 2) {
      return "_two";
    }
    if (paramInt == 3) {
      return "_three";
    }
    return "_origin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqi
 * JD-Core Version:    0.7.0.1
 */