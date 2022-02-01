import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lpx
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lpx(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    lqw.a(this.b, this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpx
 * JD-Core Version:    0.7.0.1
 */