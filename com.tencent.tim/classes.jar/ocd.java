import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ocd
  implements View.OnClickListener
{
  ocd(obw paramobw) {}
  
  public void onClick(View paramView)
  {
    this.this$0.G.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocd
 * JD-Core Version:    0.7.0.1
 */