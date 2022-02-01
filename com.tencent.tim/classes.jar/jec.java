import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jec
  implements DialogInterface.OnClickListener
{
  public jec(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface arg1, int paramInt)
  {
    if (this.this$0.isDestroyed()) {}
    long l;
    do
    {
      do
      {
        return;
        QLog.w(this.this$0.TAG, 1, "showPermissionDialog.gotoSetting, seq[" + this.kQ + "]");
        if ((this.this$0.Yh) && (this.this$0.RH != null)) {
          anot.a(null, "CliOper", "", "", this.this$0.RH, this.this$0.RH, 0, 0, "", "", this.this$0.deviceName, "");
        }
        jll.openPermissionActivity(this.this$0.a());
      } while ((this.this$0.axH != 2) && (this.this$0.axH != 1));
      this.this$0.c.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.kQ) });
      l = Long.valueOf(this.this$0.mApp.getCurrentAccountUin()).longValue();
      paramInt = this.this$0.a.b().b(l, 1);
    } while (paramInt == -1);
    this.this$0.a.b().jdField_if.remove(paramInt);
    synchronized (this.this$0.a.b().ig)
    {
      paramInt = this.this$0.a.b().c(l, 1);
      if (paramInt != -1)
      {
        this.this$0.a.b().ig.remove(paramInt);
        this.this$0.a.b().amI();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jec
 * JD-Core Version:    0.7.0.1
 */