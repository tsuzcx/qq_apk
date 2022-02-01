import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class awve
  implements View.OnClickListener
{
  awve(awvc paramawvc, awur.c paramc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((awur)this.this$0.bu.get()).aE(this.a.itemView, this.val$position);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awve
 * JD-Core Version:    0.7.0.1
 */