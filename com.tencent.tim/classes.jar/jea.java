import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jea
  implements DialogInterface.OnClickListener
{
  public jea(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.this$0.isDestroyed()) {
      return;
    }
    QLog.w(this.this$0.TAG, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.kQ + "]");
    jll.openPermissionActivity(this.this$0.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jea
 * JD-Core Version:    0.7.0.1
 */