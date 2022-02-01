import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aayo
  implements View.OnClickListener
{
  aayo(aaym paramaaym) {}
  
  public void onClick(View paramView)
  {
    aaym.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayo
 * JD-Core Version:    0.7.0.1
 */