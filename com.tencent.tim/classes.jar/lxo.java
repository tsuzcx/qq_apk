import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lxo
  implements View.OnClickListener
{
  lxo(lxn paramlxn) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArticleInfo localArticleInfo = ((lie)this.a.aN).a();
      if (localArticleInfo != null)
      {
        int i = ComponentContentGalleryBiu.a(localArticleInfo, this.a.d);
        ndi.a locala = this.a.d.a();
        if (locala != null) {
          locala.a(this.a.context, localArticleInfo, 0, localArticleInfo.innerUniqueID, i, this.a.aQl, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lxo
 * JD-Core Version:    0.7.0.1
 */