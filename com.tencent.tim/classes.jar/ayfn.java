import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayfn
  implements View.OnClickListener
{
  ayfn(ayfh paramayfh) {}
  
  public void onClick(View paramView)
  {
    this.a.b.changeState(34);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfn
 * JD-Core Version:    0.7.0.1
 */