import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class algm
  implements View.OnClickListener
{
  public algm(ProfileHeaderView paramProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    aldf.a().dF(this.this$0.app);
    this.FY.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algm
 * JD-Core Version:    0.7.0.1
 */