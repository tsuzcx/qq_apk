import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class lod
  implements ViewBase.OnClickListener
{
  lod(loa paramloa, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.j.mNewPolymericInfo.f != null)
    {
      paramViewBase = this.j.mNewPolymericInfo.f;
      muj.a(this.c.getContext(), paramViewBase);
      loa.a(this.a, this.j, paramViewBase.WT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lod
 * JD-Core Version:    0.7.0.1
 */