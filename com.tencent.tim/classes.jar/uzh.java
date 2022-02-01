import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uzh
  implements View.OnClickListener
{
  public uzh(FriendProfileCardActivity paramFriendProfileCardActivity, TextView paramTextView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.Ds.setVisibility(8);
    aqrf.a(paramView.getContext(), aqrc.gj(this.bHd), aqrc.gk(this.bHd), 3, false, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzh
 * JD-Core Version:    0.7.0.1
 */