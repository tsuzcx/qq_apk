import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class afva
  implements DialogInterface.OnDismissListener
{
  public afva(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ExtendFriendFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afva
 * JD-Core Version:    0.7.0.1
 */