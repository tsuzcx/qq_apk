import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity.RobotPickerData;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wdl
  implements View.OnClickListener
{
  public wdl(TroopRobotPickerActivity paramTroopRobotPickerActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, CountrySelectActivity.class);
    localIntent.putExtra("key_country_code", this.a.a.mLocationCountyCode);
    localIntent.putExtra("key_no_limit_allow", true);
    this.a.startActivityForResult(localIntent, 111);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdl
 * JD-Core Version:    0.7.0.1
 */