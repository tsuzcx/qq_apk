import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mpa
  implements View.OnClickListener
{
  mpa(moz parammoz) {}
  
  public void onClick(View paramView)
  {
    moz.a(this.a).cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpa
 * JD-Core Version:    0.7.0.1
 */