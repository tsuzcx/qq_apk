import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yfi
  implements View.OnClickListener
{
  yfi(yfh paramyfh) {}
  
  public void onClick(View paramView)
  {
    yfh.a(this.this$0, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfi
 * JD-Core Version:    0.7.0.1
 */