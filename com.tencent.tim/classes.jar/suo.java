import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class suo
  implements View.OnClickListener
{
  suo(sun paramsun) {}
  
  public void onClick(View paramView)
  {
    this.a.cH.setClickable(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     suo
 * JD-Core Version:    0.7.0.1
 */