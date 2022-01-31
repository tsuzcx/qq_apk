import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.utils.FileUtils.1;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;

public class vyk
  implements DialogInterface.OnClickListener
{
  public vyk(FileUtils.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a.a, QQSettingMsgHistoryActivity.class);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */