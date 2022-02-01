import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;

public class yly
  implements DialogInterface.OnKeyListener
{
  public yly(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {}
    do
    {
      return true;
      if (paramInt != 4) {
        break;
      }
    } while (BlessSelectMemberActivity.b() == null);
    BlessSelectMemberActivity.b().sendEmptyMessage(1);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yly
 * JD-Core Version:    0.7.0.1
 */