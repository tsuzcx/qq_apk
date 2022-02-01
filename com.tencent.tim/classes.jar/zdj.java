import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class zdj
  implements DialogInterface.OnClickListener
{
  zdj(zdf paramzdf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      zdf.a(this.this$0, zdf.a(this.this$0), Long.valueOf(zdf.a(this.this$0)).longValue());
      zdf.a(this.this$0);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdj
 * JD-Core Version:    0.7.0.1
 */