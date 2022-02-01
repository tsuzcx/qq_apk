import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class jen
  implements DialogInterface.OnClickListener
{
  public jen(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.this$0.isDestroyed())) {
      return;
    }
    if (paramInt == 1)
    {
      this.this$0.dP(this.kQ);
      return;
    }
    ChatActivityUtils.a(this.this$0, this.Pd, new jeo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jen
 * JD-Core Version:    0.7.0.1
 */