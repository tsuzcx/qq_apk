import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;

public class wzh
  implements CompoundButton.OnCheckedChangeListener
{
  public wzh(GoldMsgSettingActivity paramGoldMsgSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean != this.a.a) {
      GoldMsgSettingActivity.a(this.a, paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */