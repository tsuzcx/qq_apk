import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhk
  implements View.OnClickListener
{
  public arhk(ProfileCardMoreInfoView paramProfileCardMoreInfoView, View paramView) {}
  
  public void onClick(View paramView)
  {
    aldf.a().dE(this.this$0.app);
    this.FY.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhk
 * JD-Core Version:    0.7.0.1
 */