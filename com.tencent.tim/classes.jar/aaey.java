import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class aaey
  implements DialogInterface.OnClickListener
{
  public aaey(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.this$0) != null) && (DrawRedpacketPannelPreviewFragment.a(this.this$0).isShowing())) {
      DrawRedpacketPannelPreviewFragment.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaey
 * JD-Core Version:    0.7.0.1
 */