import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uhj
  implements View.OnClickListener
{
  public uhj(AuthDevEnableCompleteActivity paramAuthDevEnableCompleteActivity) {}
  
  public void onClick(View paramView)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131368846);
    if (localImageView != null)
    {
      int i = 0;
      if (localImageView.getVisibility() == 0) {
        i = 4;
      }
      localImageView.setVisibility(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhj
 * JD-Core Version:    0.7.0.1
 */