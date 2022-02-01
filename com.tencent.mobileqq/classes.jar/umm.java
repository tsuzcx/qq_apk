import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class umm
  implements View.OnClickListener
{
  umm(umj paramumj) {}
  
  public void onClick(View paramView)
  {
    uya.a("comment", "onClick hide comment");
    umj.a(this.a);
    unw.a().a(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umm
 * JD-Core Version:    0.7.0.1
 */