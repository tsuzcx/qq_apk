import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import org.json.JSONObject;

public class okj
{
  private stSimpleMetaFeed a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Gson localGson = new Gson();
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = paramJSONObject.optString("id");
      localstSimpleMetaFeed.ding_count = paramJSONObject.optInt("dingCount");
      localstSimpleMetaFeed.is_ding = paramJSONObject.optInt("isDing");
      localstSimpleMetaFeed.total_comment_num = paramJSONObject.optInt("commentNum");
      localstSimpleMetaFeed.material_desc = paramJSONObject.optString("materialDesc");
      localstSimpleMetaFeed.material_thumburl = paramJSONObject.optString("materialThumburl");
      localstSimpleMetaFeed.feed_desc = paramJSONObject.optString("feedDesc");
      localstSimpleMetaFeed.video = ((stMetaUgcVideoSeg)localGson.fromJson(paramJSONObject.optJSONObject("video").toString(), stMetaUgcVideoSeg.class));
      localstSimpleMetaFeed.video_url = paramJSONObject.optString("videoUrl");
      ArrayList localArrayList = new ArrayList();
      stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
      localstMetaUgcImage.url = paramJSONObject.optString("coverUrl");
      localstMetaUgcImage.height = paramJSONObject.optInt("coverHeight");
      localstMetaUgcImage.width = paramJSONObject.optInt("coverWidth");
      localArrayList.add(localstMetaUgcImage);
      localstSimpleMetaFeed.images = localArrayList;
      localstSimpleMetaFeed.poster_id = paramJSONObject.optString("posterId");
      localstSimpleMetaFeed.poster = ((stSimpleMetaPerson)localGson.fromJson(paramJSONObject.optJSONObject("poster").toString(), stSimpleMetaPerson.class));
      paramJSONObject = new stFloatingLayerCardStyle();
      paramJSONObject.cardType = 1;
      localstSimpleMetaFeed.floatingLayerCardStyle = paramJSONObject;
      return localstSimpleMetaFeed;
    }
    return null;
  }
  
  private ArrayList<stSimpleMetaFeed> a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    Object localObject = (String)paramHashMap.get("feeds");
    paramHashMap = (String)paramHashMap.get("scene");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (TextUtils.isEmpty(paramHashMap)) {
      opn.pQ(paramHashMap);
    }
    try
    {
      paramHashMap = URLDecoder.decode((String)localObject, "UTF-8");
      ooz.d("WSMiniAppHelper", "小程序传过来的feed： " + paramHashMap);
    }
    catch (UnsupportedEncodingException paramHashMap)
    {
      for (;;)
      {
        try
        {
          localObject = new ArrayList();
          paramHashMap = a(new JSONObject(paramHashMap));
          if (paramHashMap != null) {
            ((ArrayList)localObject).add(paramHashMap);
          }
          return localObject;
        }
        catch (Exception paramHashMap)
        {
          paramHashMap.printStackTrace();
          ooz.e("WSMiniAppHelper", "parse json error: " + paramHashMap.getMessage());
        }
        paramHashMap = paramHashMap;
        paramHashMap.printStackTrace();
        paramHashMap = (HashMap<String, String>)localObject;
      }
    }
    return null;
  }
  
  public static okj a()
  {
    return okj.a.b();
  }
  
  public static String fw(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "_ct=" + System.currentTimeMillis();
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&" + str;; paramString = paramString + "?" + str) {
      return paramString;
    }
  }
  
  public boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      return false;
    }
    ArrayList localArrayList = a(paramHashMap);
    String str2 = "mini_app_personal_guest";
    String str3 = "homepage_guest";
    String str1 = str2;
    paramHashMap = str3;
    if (localArrayList != null)
    {
      str1 = str2;
      paramHashMap = str3;
      if (localArrayList.size() > 0)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)localArrayList.get(0);
        str1 = str2;
        paramHashMap = str3;
        if (localstSimpleMetaFeed.poster != null)
        {
          str1 = str2;
          paramHashMap = str3;
          if (TextUtils.equals(localstSimpleMetaFeed.poster.id, opn.getPersonId()))
          {
            str1 = "mini_app_personal_main";
            paramHashMap = "homepage_main";
          }
        }
      }
    }
    WSVerticalPageFragment.a(paramContext, str1, paramHashMap, localArrayList, 0, true);
    return true;
  }
  
  public void aW(Context paramContext, String paramString)
  {
    ogj.a(paramContext, paramString, new okk(this));
  }
  
  static class a
  {
    private static final okj b = new okj(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okj
 * JD-Core Version:    0.7.0.1
 */