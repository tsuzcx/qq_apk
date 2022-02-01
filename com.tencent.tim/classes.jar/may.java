import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class may
  implements View.OnClickListener
{
  public may(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo, long paramLong, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGalleryBiu.a(this.a) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ComponentContentGalleryBiu.a(this.d, ComponentContentGalleryBiu.a(this.a));
      ndi.a locala = ComponentContentGalleryBiu.a(this.a).a();
      if (locala != null) {
        locala.a(this.a.getContext(), this.d, (int)this.uN, this.Vu, i, ComponentContentGalleryBiu.a(this.a), this.val$pos);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     may
 * JD-Core Version:    0.7.0.1
 */