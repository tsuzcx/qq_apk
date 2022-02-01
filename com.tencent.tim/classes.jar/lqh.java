import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class lqh
  implements ViewBase.OnClickListener
{
  ArticleInfo articleInfo;
  Context context;
  
  public lqh(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.articleInfo = paramArticleInfo;
    this.context = paramContext;
  }
  
  public static void d(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i = 1;
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("algorithm_id", paramArticleInfo.mAlgorithmID);
        ((JSONObject)localObject2).put("folder_status", kxm.aMw);
        ((JSONObject)localObject2).put("feeds_type", paramInt);
        ((JSONObject)localObject2).put("time", System.currentTimeMillis());
        ((JSONObject)localObject2).put("channel_id", paramArticleInfo.mChannelID);
        if (!NetworkState.isWifiConn()) {
          continue;
        }
        paramInt = 2;
        ((JSONObject)localObject2).put("network_type", paramInt);
        ((JSONObject)localObject2).put("feeds_source", kxm.f(paramArticleInfo));
        ((JSONObject)localObject2).put("imei", kxm.iT());
        ((JSONObject)localObject2).put("imsi", kxm.iU());
        if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)) {
          ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
        }
        ((JSONObject)localObject2).put("comment", paramArticleInfo.mSocialFeedInfo.mCommentCount);
        if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          continue;
        }
        paramInt = i;
        ((JSONObject)localObject2).put("reddot_style", paramInt);
        ((JSONObject)localObject2).put("tab_source", kxm.nQ());
        ((JSONObject)localObject2).put("kandian_mode", "" + kxm.nR());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        String str2;
        localJSONException.printStackTrace();
        continue;
        String str1 = paramArticleInfo.mArticleID + "";
        continue;
      }
      if ((!ndi.ak(paramArticleInfo)) && (!ndi.S(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        continue;
      }
      localObject2 = "0";
      str2 = "0X8009492";
      if (paramArticleInfo.mChannelID == 70L) {
        str2 = "0X8009488";
      }
      kbp.a(null, kxm.f(paramArticleInfo), str2, str2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), (String)localObject2, "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = kxm.a(this.articleInfo);
    lbz.a().a(this.articleInfo.mExtraBiuBriefInfo, this.articleInfo);
    d(this.articleInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqh
 * JD-Core Version:    0.7.0.1
 */