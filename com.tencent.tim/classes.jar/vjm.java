import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;

public class vjm
  implements DialogInterface.OnClickListener
{
  public vjm(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjm
 * JD-Core Version:    0.7.0.1
 */