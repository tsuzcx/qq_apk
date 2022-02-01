import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.p;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class lqi
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqi(Context paramContext, ArticleInfo paramArticleInfo)
  {
    this.mContext = paramContext;
    this.b = paramArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.b == null) || (this.b.mSocialFeedInfo == null) || (this.b.mSocialFeedInfo.a == null)) {}
    do
    {
      do
      {
        return;
        paramViewBase = this.b.mSocialFeedInfo.a;
      } while (kxm.getLongAccountUin() != this.b.mSocialFeedInfo.a.vR);
      QLog.d("OnPivacyClickListener", 2, "privacy type is  " + paramViewBase.aSZ + "| feedsid is " + paramViewBase.vd);
    } while (paramViewBase.aSZ != 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("feeds_id", paramViewBase.vd);
    PublicFragmentActivity.start(this.mContext, localIntent, ReadInJoyPrivacyListFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqi
 * JD-Core Version:    0.7.0.1
 */