import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGallery;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class maw
  implements View.OnClickListener
{
  public maw(ComponentContentGallery paramComponentContentGallery, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGallery.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ndi.a locala = ComponentContentGallery.a(this.a).a();
      if (locala != null) {
        locala.a(this.a.getContext(), this.d, this.val$index, this.Vu, 1, ComponentContentGallery.a(this.a), this.val$pos);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     maw
 * JD-Core Version:    0.7.0.1
 */