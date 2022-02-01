import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.b;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class lnw
  implements ProteusRecycleView.b
{
  lnw(lnv paramlnv, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void aCI()
  {
    if (this.j.multiVideoColumnInfo.d != null)
    {
      UrlJumpInfo localUrlJumpInfo = this.j.multiVideoColumnInfo.d;
      muj.a(this.e.getContext(), localUrlJumpInfo);
      lnv.a(this.a, this.j, 1, localUrlJumpInfo.WT, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnw
 * JD-Core Version:    0.7.0.1
 */