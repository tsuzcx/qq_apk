import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;

public class xev
  implements View.OnClickListener
{
  public xev(GoldMsgSettingActivity paramGoldMsgSettingActivity) {}
  
  public void onClick(View paramView)
  {
    GoldMsgAioState.a(this.a.getWindow(), this.a, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xev
 * JD-Core Version:    0.7.0.1
 */