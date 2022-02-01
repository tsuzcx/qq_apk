import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class owd
  implements View.OnClickListener
{
  owd(owc paramowc) {}
  
  public void onClick(View paramView)
  {
    if (owc.a(this.a)) {
      owc.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owd
 * JD-Core Version:    0.7.0.1
 */