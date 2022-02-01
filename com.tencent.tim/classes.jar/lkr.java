import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lkr
  implements View.OnClickListener
{
  lkr(lko paramlko, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = kwt.acF + aqgo.encodeToString(this.val$uin.getBytes(), 2);
    kxm.aJ(lko.a(this.a), str);
    lko.a(this.a, kxm.f(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkr
 * JD-Core Version:    0.7.0.1
 */