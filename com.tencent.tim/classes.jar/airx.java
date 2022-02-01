import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.6;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class airx
  implements DialogInterface.OnClickListener
{
  public airx(LocationDialogUtil.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "onClick: invoked. showStartShareLocationDialog  ", " which: ", Integer.valueOf(paramInt) });
    }
    if (BaseActivity.sTopActivity != null) {
      LocationShareFragment.d(BaseActivity.sTopActivity, this.a.alR, this.a.Ub, this.a.val$from);
    }
    try
    {
      aiqs.a(BaseActivity.sTopActivity.app).Lt(true);
      label79:
      airk.dq(this.a.val$from, "0X800A769");
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airx
 * JD-Core Version:    0.7.0.1
 */