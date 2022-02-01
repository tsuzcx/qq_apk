import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.qphone.base.util.QLog;

public class vhm
  implements DialogInterface.OnClickListener
{
  public vhm(MainFragment paramMainFragment, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    try
    {
      this.this$0.startActivity(this.val$intent);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("MainFragment", 1, "keep alive guide start error", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */