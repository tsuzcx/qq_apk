import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.utils.FileUtils.1;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;

public class roz
  implements DialogInterface.OnClickListener
{
  public roz(FileUtils.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a.val$context, QQSettingMsgHistoryActivity.class);
    this.a.val$context.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roz
 * JD-Core Version:    0.7.0.1
 */