import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class shr
  implements View.OnClickListener
{
  shr(shq paramshq, xaf.a parama) {}
  
  public void onClick(View paramView)
  {
    shq.a(this.this$0).removeCallbacks(shq.a(this.this$0));
    shq.a(this.this$0, true);
    shq.a(this.this$0, this.a, this.a.pos);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shr
 * JD-Core Version:    0.7.0.1
 */