import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.CardHandler;

public class vjn
  implements DialogInterface.OnClickListener
{
  public vjn(NotifyPCActiveActivity paramNotifyPCActiveActivity, CardHandler paramCardHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.d.Er(true);
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vjn
 * JD-Core Version:    0.7.0.1
 */