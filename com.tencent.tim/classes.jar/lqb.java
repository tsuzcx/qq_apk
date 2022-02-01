import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lqb
  implements ViewBase.OnClickListener
{
  public final String TAG = "OnCommunityCapsuleClickListener";
  private ArticleInfo b;
  private Context mContext;
  
  public lqb(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  private void aMV()
  {
    if (this.b == null) {}
    String str;
    do
    {
      return;
      str = this.b.mSocialFeedInfo.a.jumpUrl;
      if (QLog.isColorLevel()) {
        QLog.d("OnCommunityCapsuleClickListener", 2, "business url is " + str);
      }
    } while ((TextUtils.isEmpty(str)) || (this.mContext == null));
    kxm.aJ(this.mContext, str);
    kbp.a(this.b);
    ndi.g(this.b, (int)this.b.mChannelID);
    kbp.a(null, "", "0X8009BA6", "0X8009BA6", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), this.b.mSocialFeedInfo.a.bid + "", this.b.mChannelID + "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    aMV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqb
 * JD-Core Version:    0.7.0.1
 */