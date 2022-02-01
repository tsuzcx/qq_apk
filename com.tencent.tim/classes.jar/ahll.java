import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class ahll
  implements DialogInterface.OnClickListener
{
  ahll(long paramLong, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->qbShowShareResultDialog--stay");
    }
    ahlj.a(this.aaG, this.dab, this.val$activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */