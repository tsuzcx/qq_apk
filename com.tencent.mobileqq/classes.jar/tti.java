import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.SpaceLowNoticeActiviy;

public class tti
  implements DialogInterface.OnKeyListener
{
  public tti(SpaceLowNoticeActiviy paramSpaceLowNoticeActiviy) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tti
 * JD-Core Version:    0.7.0.1
 */