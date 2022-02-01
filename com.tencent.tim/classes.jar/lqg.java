import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class lqg
  extends lqv
{
  public lqg(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  private void a(ButtonBase paramButtonBase)
  {
    boolean bool = true;
    int i;
    if (paramButtonBase.isSelected())
    {
      i = -1;
      paramButtonBase = this.articleInfo.mSocialFeedInfo;
      paramButtonBase.mLikeCount += i;
      if (this.articleInfo.mSocialFeedInfo.mLikeCount < 0) {
        this.articleInfo.mSocialFeedInfo.mLikeCount = 0;
      }
      paramButtonBase = this.articleInfo.mSocialFeedInfo;
      if (i <= 0) {
        break label136;
      }
    }
    label136:
    for (int j = 1;; j = 0)
    {
      paramButtonBase.aSH = j;
      this.articleInfo.invalidateProteusTemplateBean();
      kxm.c = this.articleInfo;
      if ((!kxm.k(this.articleInfo)) || (TextUtils.isEmpty(this.articleInfo.innerUniqueID))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
      lcc.a().aCi();
      return;
      i = 1;
      break;
    }
    label141:
    paramButtonBase = lbz.a();
    long l1 = kxm.getLongAccountUin();
    long l2 = this.articleInfo.mFeedId;
    if (i > 0) {}
    for (;;)
    {
      paramButtonBase.a(l1, l2, bool, this.articleInfo.clone());
      break;
      bool = false;
    }
  }
  
  protected void b(ViewBase paramViewBase)
  {
    QLog.d("OnLikeClickListener", 1, "cick like");
    if ((paramViewBase instanceof ButtonBase)) {
      a((ButtonBase)paramViewBase);
    }
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_like_button");
    } while ((paramViewBase == null) || (!(paramViewBase instanceof lry)));
    ((lry)paramViewBase).onClick();
  }
  
  protected int getOperation()
  {
    if (this.articleInfo.mSocialFeedInfo.aSH == 1) {
      return 2;
    }
    return 13;
  }
  
  protected void o(ArticleInfo paramArticleInfo)
  {
    String str2 = kxm.d(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    boolean bool = odv.aT(paramArticleInfo.mChannelID);
    Object localObject;
    String str1;
    if (bool)
    {
      localObject = "0X800935E";
      if (!bool) {
        break label163;
      }
      str1 = "0X800935F";
      label35:
      if (localSocializeFeedsInfo.aSH != 1) {
        break label268;
      }
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label170;
      }
      if (!ndi.Y(paramArticleInfo)) {
        kbp.a(null, String.valueOf(localSocializeFeedsInfo.a.cuin), (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!kxm.r(paramArticleInfo)) && (!kxm.s(paramArticleInfo))) {
        ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
    }
    label163:
    label170:
    do
    {
      return;
      localObject = "0X8007B65";
      break;
      str1 = "0X8007B66";
      break label35;
      if (kxm.k(paramArticleInfo))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("like", 0);
          kvp.a(this.context, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      kbp.a(null, paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
      return;
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label383;
      }
      if (!ndi.Y(paramArticleInfo)) {
        kbp.a(null, String.valueOf(localSocializeFeedsInfo.a.cuin), localJSONException1, localJSONException1, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
    } while ((kxm.r(paramArticleInfo)) || (kxm.s(paramArticleInfo)));
    label268:
    ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    return;
    label383:
    if (kxm.k(paramArticleInfo))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("like", 1);
        kvp.a(this.context, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    kbp.a(null, paramArticleInfo.mSubscribeID, localJSONException2, localJSONException2, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqg
 * JD-Core Version:    0.7.0.1
 */