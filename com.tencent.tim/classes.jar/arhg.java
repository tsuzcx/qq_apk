import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arhg
  implements View.OnClickListener
{
  public arhg(ProfileCardMoreInfoView paramProfileCardMoreInfoView, View paramView) {}
  
  public void onClick(View paramView)
  {
    aldf.a().dF(this.this$0.app);
    this.jY.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhg
 * JD-Core Version:    0.7.0.1
 */