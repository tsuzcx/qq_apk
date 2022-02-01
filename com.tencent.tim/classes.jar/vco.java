import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vco
  implements View.OnClickListener
{
  public vco(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    ajgt.report("0X800A22D");
    PublicFragmentActivity.start(this.this$0.getActivity(), MsgBackupWelcomeFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vco
 * JD-Core Version:    0.7.0.1
 */