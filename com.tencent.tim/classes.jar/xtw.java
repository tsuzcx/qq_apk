import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xtw
  implements View.OnClickListener
{
  xtw(xtp paramxtp) {}
  
  public void onClick(View paramView)
  {
    this.this$0.yc(((TextView)paramView).getText().toString());
    this.this$0.ceQ();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtw
 * JD-Core Version:    0.7.0.1
 */