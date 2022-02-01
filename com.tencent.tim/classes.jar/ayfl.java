import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayfl
  implements View.OnClickListener
{
  ayfl(ayfh paramayfh) {}
  
  public void onClick(View paramView)
  {
    this.a.b.changeState(22);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfl
 * JD-Core Version:    0.7.0.1
 */