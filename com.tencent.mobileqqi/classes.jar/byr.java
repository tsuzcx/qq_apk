import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionManager;

public class byr
  implements View.OnTouchListener
{
  public byr(ChatActivity paramChatActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if ((!this.a.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        paramView = new PermissionsDialog();
        paramMotionEvent = this.a.a();
        localbys = new bys(this);
        paramView.a(paramMotionEvent, new String[] { "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE" }, localbys);
      }
    }
    while (paramMotionEvent.getAction() != 1)
    {
      bys localbys;
      return false;
      this.a.findViewById(2131231202).setBackgroundResource(2130840096);
      return false;
    }
    this.a.findViewById(2131231202).setBackgroundResource(2130840095);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byr
 * JD-Core Version:    0.7.0.1
 */