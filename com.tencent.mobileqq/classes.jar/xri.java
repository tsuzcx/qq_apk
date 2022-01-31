import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.utils.FileUtils.1;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;

public class xri
  implements DialogInterface.OnClickListener
{
  public xri(FileUtils.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a.a, QQSettingMsgHistoryActivity.class);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */