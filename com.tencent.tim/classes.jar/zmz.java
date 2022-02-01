import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zmz
  implements View.OnClickListener
{
  zmz(zmw paramzmw) {}
  
  public void onClick(View paramView)
  {
    this.c.o = null;
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmz
 * JD-Core Version:    0.7.0.1
 */