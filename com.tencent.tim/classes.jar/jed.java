import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jed
  implements DialogInterface.OnClickListener
{
  public jed(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.mContext != null) {
      QLog.w(this.this$0.TAG, 1, "showPermissionDialog.Cancel, seq[" + this.kQ + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jed
 * JD-Core Version:    0.7.0.1
 */