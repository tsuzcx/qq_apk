import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akcu
  implements View.OnClickListener
{
  public akcu(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.av != null) && (!this.this$0.isFinishing()))
    {
      this.this$0.av.dismiss();
      this.this$0.av = null;
    }
    this.this$0.ko(300L);
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcu
 * JD-Core Version:    0.7.0.1
 */