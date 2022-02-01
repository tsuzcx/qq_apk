import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akhg
  implements View.OnClickListener
{
  public akhg(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    this.b.MO(false);
    if (this.b.a.app != null)
    {
      if ((NearbyProfileFragment.a(this.b).iIsGodFlag != 1) || (NearbyProfileFragment.a(this.b).gender != 0)) {
        break label89;
      }
      anot.a(this.b.a.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      if ((NearbyProfileFragment.a(this.b).iIsGodFlag == 1) && (NearbyProfileFragment.a(this.b).gender == 1)) {
        anot.a(this.b.a.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhg
 * JD-Core Version:    0.7.0.1
 */