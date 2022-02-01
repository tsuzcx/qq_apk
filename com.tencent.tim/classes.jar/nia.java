import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nia
  implements View.OnClickListener
{
  nia(nhz paramnhz) {}
  
  public void onClick(View paramView)
  {
    nhz.b(true, -1, nhz.a(this.a));
    if (nhz.a(this.a) != null) {
      nhz.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */