import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vmi
  extends MqqHandler
{
  public vmi(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      QLog.d("IphoneTitleBarActivity", 2, "TEST more info message handler: " + paramMessage.what);
    }
    do
    {
      return;
    } while (!((String)paramMessage.obj).equals(this.this$0.e.uin));
    label86:
    FormSwitchItem localFormSwitchItem;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if (bool1 == this.this$0.aw.isChecked()) {
        break label154;
      }
      this.this$0.aw.setOnCheckedChangeListener(null);
      localFormSwitchItem = this.this$0.aw;
      if (paramMessage.arg1 != 1) {
        break label156;
      }
    }
    label154:
    label156:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      this.this$0.aw.setOnCheckedChangeListener(this.this$0);
      return;
      bool1 = false;
      break label86;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmi
 * JD-Core Version:    0.7.0.1
 */