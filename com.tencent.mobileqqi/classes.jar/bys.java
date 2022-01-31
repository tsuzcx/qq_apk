import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionManager;

public class bys
  implements View.OnTouchListener
{
  public bys(ChatActivity paramChatActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if ((!this.a.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        paramView = new PermissionsDialog();
        paramMotionEvent = this.a.a();
        localbyt = new byt(this);
        paramView.a(paramMotionEvent, new String[] { "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" }, localbyt);
      }
    }
    while (paramMotionEvent.getAction() != 1)
    {
      byt localbyt;
      return false;
      this.a.findViewById(2131231203).setBackgroundResource(2130840096);
      return false;
    }
    this.a.findViewById(2131231203).setBackgroundResource(2130840095);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bys
 * JD-Core Version:    0.7.0.1
 */