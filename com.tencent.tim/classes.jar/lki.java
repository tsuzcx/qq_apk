import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lki
  implements View.OnClickListener
{
  lki(lkg paramlkg, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = kwt.acF + aqgo.encodeToString(String.valueOf(this.val$uin).getBytes(), 2);
    kxm.aJ(lkg.a(this.a), str);
    lkg.av(1, kxm.f(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lki
 * JD-Core Version:    0.7.0.1
 */