import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ydk
  implements View.OnClickListener
{
  ydk(ycd paramycd, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout) {}
  
  public void onClick(View paramView)
  {
    this.ie.removeView(this.ho);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydk
 * JD-Core Version:    0.7.0.1
 */