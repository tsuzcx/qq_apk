import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aygr
  implements View.OnClickListener
{
  aygr(aygp paramaygp) {}
  
  public void onClick(View paramView)
  {
    this.a.b.changeState(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygr
 * JD-Core Version:    0.7.0.1
 */