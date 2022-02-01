import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.qphone.base.util.QLog;

public class nqp
  extends lsz
{
  public final String TAG = "UserSpan";
  private final String anx;
  private final ArticleInfo articleInfo;
  private final long mUin;
  
  public nqp(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    super(-15504151, 13421772, 860716207);
    this.mUin = paramLong;
    this.articleInfo = paramArticleInfo;
    this.anx = paramString;
  }
  
  private void f(long paramLong, Context paramContext)
  {
    if ((this.articleInfo == null) || (this.articleInfo.mSocialFeedInfo == null)) {}
    ArticleInfo localArticleInfo;
    String str;
    do
    {
      return;
      QLog.d("UserSpan", 1, new Object[] { "openPersonUrl, uin = ", Long.valueOf(paramLong) });
      kxm.aJ(paramContext, kwt.acF + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localArticleInfo = this.articleInfo;
      kxm.c = localArticleInfo;
      str = kxm.a(this.anx, localArticleInfo, paramLong);
      if (odv.aT(localArticleInfo.mChannelID)) {}
      for (paramContext = "0X800935C"; TextUtils.equals(this.anx, "3"); paramContext = "0X8007BA3")
      {
        kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
        ndi.g(localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      if (TextUtils.equals(this.anx, "5"))
      {
        if (mas.F(localArticleInfo))
        {
          kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
          ndi.g(localArticleInfo, (int)localArticleInfo.mChannelID);
          return;
        }
        kbp.a(null, localArticleInfo.mSubscribeID, paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str, false);
        return;
      }
    } while (!TextUtils.equals(this.anx, "2"));
    kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
  }
  
  public void onClick(View paramView)
  {
    f(this.mUin, paramView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nqp
 * JD-Core Version:    0.7.0.1
 */