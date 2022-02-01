import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lqq
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqq(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = ndi.k(this.b);
    if ((this.b == null) || (this.mContext == null) || (i == 76) || (i == 78) || (i == 77)) {
      return;
    }
    if (this.b.isPGCShortContent())
    {
      this.b.click_area = 6;
      lrm.b(this.mContext, this.b);
      kxm.b(this.mContext, this.b, (int)this.b.mChannelID);
      return;
    }
    if (this.b.mFeedType == 36)
    {
      kxm.c(this.mContext, this.b, 6);
      return;
    }
    kxm.a(this.mContext, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqq
 * JD-Core Version:    0.7.0.1
 */