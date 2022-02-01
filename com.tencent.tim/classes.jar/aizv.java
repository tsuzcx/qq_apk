import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aizv
  implements View.OnClickListener
{
  public aizv(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.a.mApp, "dc00898", "", "", "0X800A698", "0X800A698", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    PublicFragmentActivity.start(this.a.getActivity(), localIntent, MatchChatSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizv
 * JD-Core Version:    0.7.0.1
 */