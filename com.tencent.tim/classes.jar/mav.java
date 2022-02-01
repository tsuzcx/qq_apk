import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mav
  implements View.OnClickListener
{
  public mav(ComponentComment paramComponentComment, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = kwt.acF + aqgo.encodeToString(String.valueOf(this.val$uin).getBytes(), 2);
    kxm.aJ(this.b.getContext(), str);
    lkg.av(1, kxm.f(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mav
 * JD-Core Version:    0.7.0.1
 */