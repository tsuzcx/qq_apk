import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufs
  implements View.OnClickListener
{
  ufs(ufp paramufp) {}
  
  public void onClick(View paramView)
  {
    upe.a("comment", "onClick hide comment");
    ufp.a(this.a);
    uhd.a().a(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufs
 * JD-Core Version:    0.7.0.1
 */