import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ual
  implements View.OnClickListener
{
  ual(uaj paramuaj) {}
  
  public void onClick(View paramView)
  {
    this.b.b.bF();
    uaj.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ual
 * JD-Core Version:    0.7.0.1
 */