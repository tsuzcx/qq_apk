import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.a;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class zob
  implements MiniMsgTabFragment.a
{
  public zob(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (paramRecentBaseData.qx().equals("0"))
    {
      MiniMsgTabFragment.a(this.this$0).findViewById(2131379941).performClick();
      return;
    }
    MiniChatActivity.a(localFragmentActivity, paramRecentBaseData.ng(), paramRecentBaseData.qx(), paramRecentBaseData.getTitleName(), false, MiniMsgTabFragment.b(this.this$0));
    znm.report("0X8009C2D");
    if (MiniMsgTabFragment.a(this.this$0) == null) {
      MiniMsgTabFragment.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.getActivity(), 2130772007));
    }
    MiniMsgTabFragment.b(this.this$0).startAnimation(MiniMsgTabFragment.a(this.this$0));
    MiniMsgTabFragment.a(this.this$0).setAnimationListener(new zoc(this, localFragmentActivity));
    MiniMsgTabFragment.b(this.this$0).setVisibility(8);
    int i = paramRecentBaseData.ng();
    if (top.fv(i)) {
      i = 1;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A0F7", "0X800A0F7", MiniMsgTabFragment.b(this.this$0), 1, "" + i, "", "", "");
      return;
      if (i == 1) {
        i = 2;
      } else if (i == 3000) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zob
 * JD-Core Version:    0.7.0.1
 */