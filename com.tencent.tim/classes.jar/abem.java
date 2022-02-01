import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abem
  implements View.OnClickListener
{
  abem(abel paramabel) {}
  
  public void onClick(View paramView)
  {
    abel.a(this.b).eK(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abem
 * JD-Core Version:    0.7.0.1
 */