import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pbj
  implements View.OnClickListener
{
  pbj(pbc parampbc) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getContext() instanceof Activity)) {
      ((Activity)this.this$0.getContext()).finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbj
 * JD-Core Version:    0.7.0.1
 */