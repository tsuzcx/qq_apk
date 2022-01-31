import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class ws
  implements DialogInterface.OnDismissListener
{
  public ws(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ws
 * JD-Core Version:    0.7.0.1
 */