import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rcw
  implements View.OnClickListener
{
  rcw(rcu paramrcu) {}
  
  public void onClick(View paramView)
  {
    this.a.b.changeState(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcw
 * JD-Core Version:    0.7.0.1
 */