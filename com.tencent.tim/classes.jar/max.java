import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class max
  implements View.OnClickListener
{
  public max(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentGalleryBiu.a(this.a, this.k);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     max
 * JD-Core Version:    0.7.0.1
 */