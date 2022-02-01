import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class urb
{
  public static stSimpleMetaFeed a(String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = null;
    try
    {
      paramString = new JSONObject(paramString);
      Gson localGson = new Gson();
      localstSimpleMetaFeed = new stSimpleMetaFeed();
      if (paramString != null)
      {
        localstSimpleMetaFeed.id = paramString.optString("id");
        localstSimpleMetaFeed.ding_count = paramString.optInt("dingCount");
        localstSimpleMetaFeed.is_ding = paramString.optInt("isDing");
        localstSimpleMetaFeed.total_comment_num = paramString.optInt("commentNum");
        localstSimpleMetaFeed.material_desc = paramString.optString("materialDesc");
        localstSimpleMetaFeed.material_thumburl = paramString.optString("materialThumburl");
        localstSimpleMetaFeed.feed_desc = paramString.optString("feedDesc");
        localstSimpleMetaFeed.video = ((stMetaUgcVideoSeg)localGson.fromJson(paramString.optJSONObject("video").toString(), stMetaUgcVideoSeg.class));
        localstSimpleMetaFeed.video_url = paramString.optString("videoUrl");
        ArrayList localArrayList = new ArrayList();
        stMetaUgcImage localstMetaUgcImage = new stMetaUgcImage();
        localstMetaUgcImage.url = paramString.optString("coverUrl");
        localstMetaUgcImage.height = paramString.optInt("coverHeight");
        localstMetaUgcImage.width = paramString.optInt("coverWidth");
        localArrayList.add(localstMetaUgcImage);
        localstSimpleMetaFeed.images = localArrayList;
        localstSimpleMetaFeed.poster_id = paramString.optString("posterId");
        localstSimpleMetaFeed.poster = ((stSimpleMetaPerson)localGson.fromJson(paramString.optJSONObject("poster").toString(), stSimpleMetaPerson.class));
        paramString = new stFloatingLayerCardStyle();
        paramString.cardType = 3;
        localstSimpleMetaFeed.floatingLayerCardStyle = paramString;
      }
      return localstSimpleMetaFeed;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localstSimpleMetaFeed;
      }
    }
  }
  
  public static ArrayList<stSimpleMetaFeed> a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramstSimpleMetaFeed != null) {
      localArrayList.add(paramstSimpleMetaFeed);
    }
    return localArrayList;
  }
  
  public static boolean a(stSimpleMetaFeed paramstSimpleMetaFeed, Context paramContext)
  {
    if ((paramContext == null) || (paramstSimpleMetaFeed == null)) {
      return false;
    }
    ArrayList localArrayList = a(paramstSimpleMetaFeed);
    if ((localArrayList != null) && (localArrayList.size() > 0) && (localArrayList.get(0) != null) && (((stSimpleMetaFeed)localArrayList.get(0)).poster != null) && (paramstSimpleMetaFeed.poster != null) && (TextUtils.equals(((stSimpleMetaFeed)localArrayList.get(0)).poster.id, uqt.f()))) {}
    WSVerticalPageFragment.a(paramContext, "qqchat", "qqchat", localArrayList, 0, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urb
 * JD-Core Version:    0.7.0.1
 */