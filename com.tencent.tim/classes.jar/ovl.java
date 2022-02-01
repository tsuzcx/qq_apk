import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ovl
  implements View.OnClickListener
{
  ovl(ovk paramovk) {}
  
  public void onClick(View paramView)
  {
    this.a.ur(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovl
 * JD-Core Version:    0.7.0.1
 */