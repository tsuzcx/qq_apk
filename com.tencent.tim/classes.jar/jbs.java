import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.QLog;

public class jbs
  implements DialogInterface.OnClickListener
{
  public jbs(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.uw()) {
      return;
    }
    this.val$view.setEnabled(false);
    this.this$0.oD = this.this$0.a.a(this.this$0.aqx, this.this$0.awJ, this.this$0.md);
    QLog.w(this.this$0.TAG, 1, "kickOutUsers begin, mGAudioRoomId[" + this.this$0.oD + "]");
    this.this$0.a.c(1, this.this$0.aqx, this.this$0.awJ, this.this$0.md);
    anot.a(null, "CliOper", "", "", "0X8009E2A", "0X8009E2A", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbs
 * JD-Core Version:    0.7.0.1
 */