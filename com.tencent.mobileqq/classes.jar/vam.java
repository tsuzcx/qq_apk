import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vam
  implements View.OnClickListener
{
  vam(vaj paramvaj) {}
  
  public void onClick(View paramView)
  {
    vmp.a("comment", "onClick hide comment");
    vaj.a(this.a);
    vbw.a().a(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vam
 * JD-Core Version:    0.7.0.1
 */