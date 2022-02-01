import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class vcw
  implements DialogInterface.OnDismissListener
{
  public vcw(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!GesturePWDUnlockActivity.a(this.this$0))
    {
      GesturePWDUnlockActivity.a(this.this$0, true);
      return;
    }
    this.this$0.bPH();
    GesturePWDUtils.setGestureUnlockFailedType(this.this$0, 1);
    anpc.a(this.this$0.getBaseContext()).a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcw
 * JD-Core Version:    0.7.0.1
 */