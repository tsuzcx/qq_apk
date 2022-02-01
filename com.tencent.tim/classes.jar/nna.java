import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nna
{
  public static void a(ProteusItemData paramProteusItemData)
  {
    if (!lvy.a().CN()) {}
    String str3;
    do
    {
      do
      {
        return;
        if ((paramProteusItemData == null) || (paramProteusItemData.aD == null))
        {
          QLog.i("FastWebPtsLiteDataUtil", 1, "[processProteusItemData] error, proteusItemData is null.");
          return;
        }
        localObject = paramProteusItemData.aD;
      } while (!TextUtils.isEmpty(((JSONObject)localObject).optString("id_recommend_category_txt")));
      String str1 = j((JSONObject)localObject);
      String str2 = l((JSONObject)localObject);
      Object localObject = n((JSONObject)localObject);
      str3 = lwe.a().T("native_article", str1);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str3)))
      {
        paramProteusItemData.ptsLitePageName = str1;
        paramProteusItemData.ame = str2;
        paramProteusItemData.ptsItemData = new PTSItemData.Builder().withPageName(str1).withItemID(str2).withJsonData((String)localObject).withFrameTreeJson(str3).build();
      }
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
        QLog.i("FastWebPtsLiteDataUtil", 2, "[processProteusItemData] finished, pageName = " + str1 + ", itemId = " + str2 + ", jsonData = " + (String)localObject);
      }
    } while (!TextUtils.isEmpty(str3));
    QLog.i("FastWebPtsLiteDataUtil", 1, "[processProteusItemData] finished, frameTreeJson is empty.");
  }
  
  private static String j(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (TextUtils.equals("ReadInjoy_native_recommend_small_cell", paramJSONObject.optString("style_ID")))) {
      return "recommend_small_card";
    }
    return "";
  }
  
  private static String l(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optJSONObject("card_info") != null)) {
      return paramJSONObject.optJSONObject("card_info").optString("rowKey");
    }
    QLog.e("FastWebPtsLiteDataUtil", 1, "[getItemId], rowKey is null.");
    return "";
  }
  
  private static String n(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.optJSONObject("card_info") == null))
    {
      QLog.i("FastWebPtsLiteDataUtil", 1, "[getJsonData], card_info is null.");
      return "";
    }
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("card_info");
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("rowKey", localJSONObject2.optString("rowKey"));
      if (paramJSONObject.optJSONObject("id_recommend_title") != null) {
        localJSONObject1.put("title", paramJSONObject.optJSONObject("id_recommend_title").optString("text"));
      }
      if (paramJSONObject.optJSONObject("id_native_recommend_small_container") != null) {
        localJSONObject1.put("jumpUrl", paramJSONObject.optJSONObject("id_native_recommend_small_container").optString("jump_url"));
      }
      if (paramJSONObject.optJSONObject("id_recommend_cover_img") != null) {
        localJSONObject1.put("image_url", paramJSONObject.optJSONObject("id_recommend_cover_img").optString("image_url"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("label_separator_line_top_bg_color"))) {
        localJSONObject1.put("top_separator", "1");
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("label_separator_line_bottom_bg_color"))) {
        localJSONObject1.put("bottom_separator", "1");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("FastWebPtsLiteDataUtil", 1, "[getJsonData], e = " + paramJSONObject);
      }
    }
    QLog.i("FastWebPtsLiteDataUtil", 1, "[getJsonData], res = " + localJSONObject1.toString());
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nna
 * JD-Core Version:    0.7.0.1
 */