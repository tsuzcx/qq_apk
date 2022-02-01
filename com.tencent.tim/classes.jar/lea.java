import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import org.json.JSONObject;

public class lea
  implements nrz.a
{
  public lea(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void e(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.this$0.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = kvp.a(this.this$0.getActivity(), this.this$0.nh(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      kvp.a locala = new kvp.a(paramBaseArticleInfo);
      locala.r3 = String.valueOf(paramBaseArticleInfo.mArticleID);
      locala.r4 = String.valueOf(paramBaseArticleInfo.mStrategyId);
      locala.r5 = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        locala.toUin = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.uin);
      }
      locala.subAction = "0X8009A79";
      locala.actionName = "0X8009A79";
      kvp.a(locala);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.this$0.nh());
      localJSONObject.put("folder_status", kxm.aMw);
      localJSONObject.put("kandian_mode", kxm.nR());
      localJSONObject.put("feeds_type", "" + kxm.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", odv.r(paramBaseArticleInfo));
      localJSONObject.toString();
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lea
 * JD-Core Version:    0.7.0.1
 */