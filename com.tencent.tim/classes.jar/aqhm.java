import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aqhm
  implements View.OnClickListener
{
  aqhm(aqju paramaqju) {}
  
  public void onClick(View paramView)
  {
    if (this.L != null) {
      this.L.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhm
 * JD-Core Version:    0.7.0.1
 */