import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class ito
  implements DialogInterface.OnClickListener
{
  public ito(ScreenShareCtrl paramScreenShareCtrl, AVActivity paramAVActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AVShare", 2, "startOrStopScreenShare, onClick");
    this.this$0.a(VideoConstants.EmShareOps.STOP);
    if (this.b == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = this.b.a())
    {
      if (paramDialogInterface != null) {
        paramDialogInterface.stop(1);
      }
      ScreenShareCtrl.a(this.this$0).mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(this.kQ) });
      paramDialogInterface = ScreenShareCtrl.a(this.this$0).b();
      TraeHelper.a().dN(this.kQ);
      paramDialogInterface.PU = false;
      paramDialogInterface.ana = 1;
      paramDialogInterface.Qh = true;
      String str = paramDialogInterface.peerUin;
      ScreenShareCtrl.a(this.this$0).alF();
      ScreenShareCtrl.a(this.this$0).O(str, 237);
      ScreenShareCtrl.a(this.this$0).ko(237);
      ScreenShareCtrl.a(this.this$0).P(str, paramDialogInterface.ana);
      paramDialogInterface.O("onClick_HangeUP", false);
      paramDialogInterface.Z("onClick_HangeUP", 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ito
 * JD-Core Version:    0.7.0.1
 */