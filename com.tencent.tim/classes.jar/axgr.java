import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axgr
  implements View.OnClickListener
{
  axgr(axgq paramaxgq) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.m != null) && (axgq.a(this.this$0) != null)) {
      axgq.a(this.this$0).a(paramView, this.this$0.m, axgq.a(this.this$0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgr
 * JD-Core Version:    0.7.0.1
 */