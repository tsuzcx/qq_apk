import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aivi
  implements View.OnClickListener
{
  aivi(aivd paramaivd, aiut paramaiut) {}
  
  public void onClick(View paramView)
  {
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivi
 * JD-Core Version:    0.7.0.1
 */