import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufu
  implements View.OnClickListener
{
  ufu(ufr paramufr) {}
  
  public void onClick(View paramView)
  {
    uqf.a("comment", "onClick hide comment");
    ufr.a(this.a);
    uhf.a().a(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufu
 * JD-Core Version:    0.7.0.1
 */