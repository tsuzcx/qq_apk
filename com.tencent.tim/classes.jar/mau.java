import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mau
  implements View.OnClickListener
{
  public mau(ComponentComment paramComponentComment, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    kxm.aJ(this.b.getContext(), this.val$url);
    lkg.av(1, kxm.f(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mau
 * JD-Core Version:    0.7.0.1
 */