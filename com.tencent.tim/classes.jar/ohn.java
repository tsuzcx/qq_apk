import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohn
  implements View.OnClickListener
{
  ohn(ohl paramohl) {}
  
  public void onClick(View paramView)
  {
    ooz.i("comment", "onClick hide comment");
    ohl.a(this.this$0);
    oiv.a().b(new WSCommentShowEvent(false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohn
 * JD-Core Version:    0.7.0.1
 */