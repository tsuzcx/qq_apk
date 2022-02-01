import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lrf
  implements ViewBase.OnClickListener
{
  ArticleInfo articleInfo;
  Context context;
  ndi d;
  
  public lrf(ArticleInfo paramArticleInfo, Context paramContext, ndi paramndi)
  {
    this.articleInfo = paramArticleInfo;
    this.context = paramContext;
    this.d = paramndi;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (ndi.K(this.articleInfo)) {
      kxm.a(this.context, this.articleInfo, 1, false, 0, 1);
    }
    for (;;)
    {
      kvp.a(this.context, this.articleInfo, this.d);
      lqv.a(this.articleInfo, "0X8009442", "0X8009445");
      return;
      if (kxm.k(this.articleInfo))
      {
        kxm.a(this.context, this.articleInfo);
        kvp.a(this.context, this.articleInfo, "0X8009A77", null);
      }
      else
      {
        kxm.a(this.context, this.articleInfo, 0, false, 0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrf
 * JD-Core Version:    0.7.0.1
 */