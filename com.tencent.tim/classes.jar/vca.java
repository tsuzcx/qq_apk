import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vca
  implements View.OnClickListener
{
  public vca(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((altq)this.this$0.app.getManager(36)).OS("100190.100194");
      Intent localIntent = new Intent();
      localIntent.putExtra("set_display_type", 1);
      PublicFragmentActivity.start(this.this$0.getActivity(), localIntent, QQSettingMsgClearFragment.class);
      anot.a(this.this$0.app, "CliOper", "", "", "0X800A1F2", "0X800A1F2", 0, 0, "", "", "", "");
      anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vca
 * JD-Core Version:    0.7.0.1
 */