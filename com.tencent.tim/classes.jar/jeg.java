import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class jeg
  implements DialogInterface.OnClickListener
{
  public jeg(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.this$0.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.this$0, true, new jeh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jeg
 * JD-Core Version:    0.7.0.1
 */