import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class algk
  implements View.OnClickListener
{
  public algk(ProfileHeaderView paramProfileHeaderView, alcn paramalcn) {}
  
  public void onClick(View paramView)
  {
    ProfileHeaderView.a(this.this$0, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algk
 * JD-Core Version:    0.7.0.1
 */