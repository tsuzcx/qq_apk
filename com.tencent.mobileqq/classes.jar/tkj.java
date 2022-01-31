import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class tkj
  implements DialogInterface.OnClickListener
{
  public tkj(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.executeOnNetWorkThread(new tkk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */