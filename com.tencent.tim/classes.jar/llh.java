import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class llh
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.mGalleryPicNumber > 3)
    {
      localJSONObject.put("id_gallery_cnt", new JSONObject());
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("gallery_icon", "qq_readinjoy_gallery_count");
      localJSONObject.put("id_gallery_img", localObject1);
      localJSONObject.put("id_gallery_bg", new JSONObject());
    }
    Object localObject3;
    Object localObject2;
    label143:
    Object localObject4;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localObject3 = ndi.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localObject3 == null) || (((JSONArray)localObject3).length() < 3)) {
        return localJSONObject;
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(0);
      if (localObject1 == null)
      {
        localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject2 = ((JSONArray)localObject3).optJSONObject(1);
        if (localObject2 != null) {
          break label289;
        }
        localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
        localObject3 = ((JSONArray)localObject3).optJSONObject(2);
        if (localObject3 != null) {
          break label299;
        }
      }
      label289:
      label299:
      for (localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject3 = ((JSONObject)localObject3).optString("picture"))
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("multi_img_url1", localObject1);
        localJSONObject.put("id_multi_img_1", localObject4);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject2);
        localJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", localObject3);
        localJSONObject.put("id_multi_img_3", localObject1);
        llu.a(paramBaseArticleInfo, localJSONObject, true);
        llu.m(paramBaseArticleInfo, localJSONObject);
        llu.j(paramBaseArticleInfo, localJSONObject);
        llu.X(localJSONObject);
        localJSONObject.put("style_ID", "ReadInjoy_gallery_channel_triple_img_big_cell");
        llu.a(localJSONObject, paramBaseArticleInfo);
        return localJSONObject;
        localObject1 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject2 = ((JSONObject)localObject2).optString("picture");
        break label143;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label332:
      localObject2 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label414;
      }
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label360:
      localObject3 = ((URL)localObject1).getFile();
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label424;
      }
    }
    label414:
    label424:
    for (Object localObject1 = paramBaseArticleInfo.mSinglePicture;; localObject1 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = ((URL)localObject1).getFile();
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label332;
      localObject1 = paramBaseArticleInfo.mPictures[1];
      break label360;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llh
 * JD-Core Version:    0.7.0.1
 */