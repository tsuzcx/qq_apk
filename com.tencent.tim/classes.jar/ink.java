import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class ink
  implements DialogInterface.OnClickListener
{
  public ink(GaInviteActivity paramGaInviteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.a, true, new inl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ink
 * JD-Core Version:    0.7.0.1
 */