import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoei
  implements View.OnClickListener
{
  aoei(aoeh paramaoeh) {}
  
  public void onClick(View paramView)
  {
    if (aoeh.a(this.this$0).isShowing()) {
      aoeh.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoei
 * JD-Core Version:    0.7.0.1
 */