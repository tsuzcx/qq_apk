import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;

class wzp
  implements View.OnFocusChangeListener
{
  wzp(wzo paramwzo) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      GoldMsgAioState.a(this.a.a.getWindow(), this.a.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzp
 * JD-Core Version:    0.7.0.1
 */