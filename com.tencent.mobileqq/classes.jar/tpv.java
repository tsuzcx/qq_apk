import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class tpv
{
  private static String a = "https://img.nfa.qq.com/gmaster_prod/15910560/gmaster_3v18id3oaaw0_full_star.png";
  private static String b = "https://img.nfa.qq.com/gmaster_prod/15910560/gmaster_4wn7qj0hara0_half_star.png";
  private static String c = "https://img.nfa.qq.com/gmaster_prod/15910560/gmaster_ol3wqukwhr4_empty_star.png";
  
  public static String a(float paramFloat, int paramInt)
  {
    float f1 = paramInt;
    float f2 = paramInt;
    if (paramFloat <= f1) {
      return c;
    }
    if ((paramFloat > f1) && (paramFloat <= f2 + 0.5F)) {
      return b;
    }
    return a;
  }
  
  private static void a(float paramFloat, JSONObject paramJSONObject)
  {
    String str1 = a(paramFloat, 0);
    String str2 = a(paramFloat, 1);
    String str3 = a(paramFloat, 2);
    String str4 = a(paramFloat, 3);
    String str5 = a(paramFloat, 4);
    try
    {
      paramJSONObject.put("star1", str1);
      paramJSONObject.put("star2", str2);
      paramJSONObject.put("star3", str3);
      paramJSONObject.put("star4", str4);
      paramJSONObject.put("star5", str5);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("full_star");
    String str2 = paramJSONObject.optString("half_star");
    paramJSONObject = paramJSONObject.optString("empty_star");
    if (!TextUtils.isEmpty(str1)) {
      a = str1;
    }
    if (!TextUtils.isEmpty(str2)) {
      b = str2;
    }
    if (!TextUtils.isEmpty(paramJSONObject)) {
      c = paramJSONObject;
    }
  }
  
  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {}
    do
    {
      do
      {
        return;
        a(paramJSONObject1);
        if (!paramJSONObject1.has("app_score_num")) {
          break;
        }
      } while (paramJSONObject1.has("video_guide"));
      a((float)paramJSONObject1.optDouble("app_score_num"), paramJSONObject2);
      return;
    } while (!paramJSONObject1.has("ad_guide_text"));
    paramJSONObject1 = paramJSONObject1.optString("ad_guide_text");
    try
    {
      paramJSONObject2.put("ad_guide_text", paramJSONObject1);
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      paramJSONObject1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpv
 * JD-Core Version:    0.7.0.1
 */