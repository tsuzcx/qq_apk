import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhh
  implements View.OnClickListener
{
  public arhh(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void onClick(View paramView)
  {
    ProfileCardMoreInfoView.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhh
 * JD-Core Version:    0.7.0.1
 */