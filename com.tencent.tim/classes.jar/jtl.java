import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jtl
  implements View.OnClickListener
{
  jtl(jtg paramjtg) {}
  
  public void onClick(View paramView)
  {
    this.this$0.ok(this.this$0.mX());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtl
 * JD-Core Version:    0.7.0.1
 */