import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class jbe
  implements DialogInterface.OnClickListener
{
  public jbe(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    if (this.this$0.a.b().kK() == -1) {
      this.this$0.dr(this.kQ);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.this$0.wk())
      {
        MultiVideoCtrlLayerUIBase.a(this.this$0, true);
        this.this$0.O(this.kQ, 65535);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.this$0.TAG, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbe
 * JD-Core Version:    0.7.0.1
 */