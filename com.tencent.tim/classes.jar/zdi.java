import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class zdi
  implements DialogInterface.OnClickListener
{
  zdi(zdf paramzdf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      zdf.c(this.this$0);
    }
    while (paramInt != 0) {
      return;
    }
    zdf.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdi
 * JD-Core Version:    0.7.0.1
 */