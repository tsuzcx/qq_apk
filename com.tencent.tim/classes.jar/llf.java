import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class llf
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.mGalleryPicNumber > 2)
    {
      localJSONObject.put("id_gallery_cnt", new JSONObject());
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject.put("id_gallery_img", localObject1);
      localJSONObject.put("id_gallery_bg", new JSONObject());
    }
    Object localObject2;
    Object localObject3;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject2 = ndi.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() < 2)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject2).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject2).optJSONObject(1);
        if (localObject2 != null) {
          break label246;
        }
      }
      label246:
      for (localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject2).optString("picture"))
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("multi_img_url1", localObject1);
        localJSONObject.put("id_multi_img_1", localObject3);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject2);
        localJSONObject.put("id_multi_img_2", localObject1);
        llu.a(paramBaseArticleInfo, localJSONObject, true);
        llu.m(paramBaseArticleInfo, localJSONObject);
        llu.j(paramBaseArticleInfo, localJSONObject);
        llu.X(localJSONObject);
        localJSONObject.put("style_ID", "ReadInjoy_gallery_channel_double_img_cell");
        llu.a(localJSONObject, paramBaseArticleInfo);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label279:
      localObject2 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label329;
      }
    }
    label329:
    for (Object localObject1 = paramBaseArticleInfo.mSinglePicture;; localObject1 = paramBaseArticleInfo.mPictures[1])
    {
      localObject3 = ((URL)localObject1).getFile();
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label279;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llf
 * JD-Core Version:    0.7.0.1
 */