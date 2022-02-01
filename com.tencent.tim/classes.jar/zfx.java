import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity.a;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class zfx
  implements ChatSettingActivity.a
{
  public zfx(ChatHistoryC2CSettingFragment paramChatHistoryC2CSettingFragment) {}
  
  public void bt(Activity paramActivity)
  {
    QQToast.a(paramActivity, 2, 2131692510, 0).show(this.a.getActivity().getTitleBarHeight());
    paramActivity.setResult(-1);
    paramActivity.finish();
  }
  
  public void h(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 2, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 2, 0, "", "", "", "");
  }
  
  public void i(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 2, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfx
 * JD-Core Version:    0.7.0.1
 */