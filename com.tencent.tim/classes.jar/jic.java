import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jic
  implements View.OnClickListener
{
  jic(jib paramjib) {}
  
  public void onClick(View paramView)
  {
    this.this$0.b(true, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jic
 * JD-Core Version:    0.7.0.1
 */