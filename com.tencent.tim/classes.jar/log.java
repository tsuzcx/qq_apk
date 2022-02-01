import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class log
  implements ViewBase.OnClickListener
{
  log(loe paramloe, lie paramlie, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.b.a();
    if (paramViewBase != null)
    {
      kxm.a(this.c.getContext(), paramViewBase.mArticleContentUrl, null);
      ndi.g(paramViewBase, 0);
      loe.b(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     log
 * JD-Core Version:    0.7.0.1
 */