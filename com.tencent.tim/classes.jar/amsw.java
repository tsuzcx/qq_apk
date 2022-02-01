import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amsw
  implements View.OnClickListener
{
  amsw(amsv paramamsv) {}
  
  public void onClick(View paramView)
  {
    amsv.a(this.a).cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */