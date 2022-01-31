import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;

public class xew
  implements View.OnClickListener
{
  public xew(GoldMsgSettingActivity paramGoldMsgSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.a()))
    {
      GoldMsgAioState.a(this.a.getWindow(), this.a, null);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xew
 * JD-Core Version:    0.7.0.1
 */