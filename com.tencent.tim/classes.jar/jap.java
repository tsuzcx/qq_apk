import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jap
  implements DialogInterface.OnClickListener
{
  public jap(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, VideoAppInterface paramVideoAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.w(this.this$0.TAG, 1, "showConfirmBoxToHangup, yes, mRelationId[" + this.this$0.md + "]");
    this.this$0.dl(0L);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("uin", String.valueOf(this.this$0.md));
    this.b.a(4, 0, 0, paramDialogInterface, null);
    if (!aqjl.mv(this.awB)) {
      jik.a(this.b, String.valueOf(this.this$0.md), 3000, this.b.getApp().getString(2131697809));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jap
 * JD-Core Version:    0.7.0.1
 */