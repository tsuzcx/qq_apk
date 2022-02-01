import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class lqe
  implements ViewBase.OnClickListener
{
  ArticleInfo b;
  Context context;
  
  public lqe(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.b = paramArticleInfo;
    this.context = paramContext;
  }
  
  private void report()
  {
    kbp.a(null, null, "0X80097D7", "0X80097D7", 0, 0, "", "", "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    String str = "";
    paramViewBase = str;
    if (this.context != null)
    {
      paramViewBase = str;
      if (this.b != null)
      {
        paramViewBase = str;
        if (this.b.mSocialFeedInfo != null)
        {
          paramViewBase = str;
          if (this.b.mSocialFeedInfo.ahQ != null)
          {
            paramViewBase = this.b.mSocialFeedInfo.ahQ;
            kxm.C(this.context, paramViewBase);
          }
        }
      }
    }
    QLog.d("OnFriendsBiuClickListener", 1, "jump channel,  context:" + this.context + "  url:" + paramViewBase);
    report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqe
 * JD-Core Version:    0.7.0.1
 */