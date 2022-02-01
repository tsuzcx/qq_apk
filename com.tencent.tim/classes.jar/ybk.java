import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ybk
  implements View.OnClickListener
{
  ybk(ybb paramybb) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aSY) {
      ybb.d(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybk
 * JD-Core Version:    0.7.0.1
 */