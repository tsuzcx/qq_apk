import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class plf
  implements View.OnClickListener
{
  plf(plc paramplc) {}
  
  public void onClick(View paramView)
  {
    if (plc.a(this.a) != null) {
      plc.a(this.a).e(plc.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plf
 * JD-Core Version:    0.7.0.1
 */