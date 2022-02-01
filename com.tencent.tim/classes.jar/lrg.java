import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

public class lrg
  implements ViewBase.OnClickListener
{
  private ArticleInfo articleInfo;
  private VafContext c;
  
  public lrg(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    this.articleInfo = paramArticleInfo;
    this.c = paramVafContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.articleInfo == null) {
      return;
    }
    if (kxm.k(this.articleInfo))
    {
      ksz.a(this.c.getCurActivity(), this.articleInfo, null, 17, "", "", false, null, -1);
      kvp.a(this.c.getCurActivity(), this.articleInfo, "0X8009A72", null);
      return;
    }
    if (odv.aT(this.articleInfo.mChannelID)) {}
    for (paramViewBase = "0X80094A0";; paramViewBase = "0X800949E") {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "x");
        kbp.a(null, this.articleInfo.mSubscribeID, paramViewBase, paramViewBase, 0, 0, String.valueOf(this.articleInfo.mSocialFeedInfo.mFeedId), String.valueOf(this.articleInfo.mArticleID), "" + this.articleInfo.mStrategyId, localJSONObject.toString(), false);
        return;
      }
      catch (JSONException paramViewBase)
      {
        paramViewBase.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrg
 * JD-Core Version:    0.7.0.1
 */