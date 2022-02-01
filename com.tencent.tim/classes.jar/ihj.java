import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.AnyChatReqTimeoutRunnable;
import com.tencent.av.app.VideoAppInterface;

public class ihj
  implements DialogInterface.OnClickListener
{
  public ihj(VideoController.AnyChatReqTimeoutRunnable paramAnyChatReqTimeoutRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.this$0.b().peerUin == null) {
      this.b.this$0.b().peerUin = this.b.this$0.b().a.peerUin;
    }
    this.b.this$0.a(this.b.seq, 2131230754, 1, this.b.this$0.b);
    this.b.this$0.b().Y("AnyChatReqTimeoutRunnable", 6);
    this.b.this$0.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.b.this$0.b().peerUin, Long.valueOf(this.b.seq) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihj
 * JD-Core Version:    0.7.0.1
 */