import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lqd
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqd(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.b == null) {
      return;
    }
    if (kxm.k(this.b)) {
      kxm.a(this.mContext, this.b);
    }
    kvp.a(this.mContext, this.b, "0X8009A73", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqd
 * JD-Core Version:    0.7.0.1
 */