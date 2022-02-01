import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.MemoryManager;

public class viw
  implements DialogInterface.OnClickListener
{
  public viw(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      boolean bool = this.s.isChecked();
      if (this.aYN != bool) {
        this.val$sp.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
      }
      MemoryManager.a().d(this.this$0, this.this$0.app);
      return;
    }
    catch (Exception paramDialogInterface) {}finally
    {
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     viw
 * JD-Core Version:    0.7.0.1
 */