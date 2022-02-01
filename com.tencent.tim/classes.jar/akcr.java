import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akcr
  implements View.OnClickListener
{
  public akcr(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.ax != null) && (!this.this$0.isFinishing()))
    {
      this.this$0.ax.dismiss();
      this.this$0.ax = null;
    }
    this.this$0.dAy();
    this.this$0.MI(true);
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004824", "0X8004824", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcr
 * JD-Core Version:    0.7.0.1
 */