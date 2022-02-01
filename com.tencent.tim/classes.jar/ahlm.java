import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

final class ahlm
  implements DialogInterface.OnClickListener
{
  ahlm(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog back");
    }
    ahlj.a(this.aaG, this.dab, this.val$activity, this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlm
 * JD-Core Version:    0.7.0.1
 */