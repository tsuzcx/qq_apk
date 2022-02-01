import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class lra
  implements ViewBase.OnClickListener
{
  private mih.b a;
  private ArticleInfo b;
  private ausj mActionSheet;
  private Context mContext;
  
  public lra(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
    s(paramArticleInfo);
  }
  
  private void aNe()
  {
    if (this.a == null) {}
    do
    {
      return;
      if (this.a.isFollow != 1) {
        break;
      }
    } while (kxm.E(this.b));
    Qq();
    return;
    nE(true);
    if (!kxm.E(this.b))
    {
      str1 = kxm.f(this.b);
      String str2 = kxm.a(this.b.mAlgorithmID, kxm.a(this.b), (int)this.b.mChannelID, aqiw.isWifiConnected(this.mContext), str1, this.b.innerUniqueID, this.b, this.b.businessId + "");
      kbp.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.b.mFeedId), Long.toString(this.b.mArticleID), Long.toString(this.b.mAlgorithmID), str2, false);
      ndi.g(this.b, (int)this.b.mChannelID);
      return;
    }
    if (odv.aT(this.b.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      ndi.b(this.b, str1, str1, (int)this.b.mChannelID);
      lbz.k(this.b);
      break;
    }
  }
  
  private void nE(boolean paramBoolean)
  {
    Object localObject = kxm.getAppRuntime();
    if (this.a != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicRecommendHeaderFollowClickListener", 2, "before request0x978 articleInfo articleID = ，isfollow = " + paramBoolean + " businessId = " + this.a.businessId);
      }
      if (paramBoolean) {
        lbz.a().a().a((String)localObject, Long.toString(this.a.businessId), true, new lrd(this, paramBoolean), 3);
      }
    }
    else
    {
      return;
    }
    lbz.a().a().a((String)localObject, Long.toString(this.a.businessId), false, new lre(this, paramBoolean), 3);
  }
  
  private void s(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (this.b.mTopicRecommendFeedsInfo != null) && (this.b.mTopicRecommendFeedsInfo.ld != null) && (this.b.mTopicRecommendFeedsInfo.ld.size() > 0)) {
      this.a = ((mih.b)this.b.mTopicRecommendFeedsInfo.ld.get(0));
    }
  }
  
  protected void Qq()
  {
    this.mActionSheet = ((ausj)auss.a(this.mContext, null));
    this.mActionSheet.addButton(2131697480, 3);
    this.mActionSheet.addCancelButton(2131721058);
    this.mActionSheet.setOnDismissListener(new lrb(this));
    this.mActionSheet.a(new lrc(this));
    if (!this.mActionSheet.isShowing()) {
      this.mActionSheet.show();
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    aNe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lra
 * JD-Core Version:    0.7.0.1
 */