import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vcj
  implements View.OnClickListener
{
  public vcj(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.start(this.this$0.getActivity(), QQSettingAutoDownloadAndSaveFragment.class);
    anot.a(null, "CliOper", "", "", "0X800A2DB", "0X800A2DB", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcj
 * JD-Core Version:    0.7.0.1
 */