import android.app.Activity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class uov
  implements ChatSettingActivity.a
{
  public uov(ChatSettingActivity paramChatSettingActivity) {}
  
  public void bt(Activity paramActivity)
  {
    QQToast.a(this.this$0, 2, 2131692510, 0).show(this.this$0.getTitleBarHeight());
  }
  
  public void h(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 1, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 1, 0, "", "", "", "");
  }
  
  public void i(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 1, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */