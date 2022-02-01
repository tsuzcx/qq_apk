import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class vib
  implements View.OnClickListener
{
  public vib(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < this.this$0.qU.size())
    {
      ((View.OnClickListener)this.this$0.qU.get(i)).onClick(paramView);
      i += 1;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vib
 * JD-Core Version:    0.7.0.1
 */