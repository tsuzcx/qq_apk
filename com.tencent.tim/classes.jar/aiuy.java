import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiuy
  implements View.OnClickListener
{
  aiuy(aiut paramaiut, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.fp.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiuy
 * JD-Core Version:    0.7.0.1
 */