import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xzb
  implements View.OnClickListener
{
  xzb(xys paramxys) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aSY) {
      ujt.a(this.this$0.sessionInfo, this.this$0.app, this.this$0.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzb
 * JD-Core Version:    0.7.0.1
 */