import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vck
  implements View.OnClickListener
{
  public vck(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.start(this.this$0, LangSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vck
 * JD-Core Version:    0.7.0.1
 */