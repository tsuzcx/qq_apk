import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rlx
  implements View.OnClickListener
{
  rlx(rlv paramrlv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (rlv.a(this.this$0) != null) {
      rlv.a(this.this$0).xI(this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlx
 * JD-Core Version:    0.7.0.1
 */