import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class btw
  implements DialogInterface.OnDismissListener
{
  public btw(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btw
 * JD-Core Version:    0.7.0.1
 */