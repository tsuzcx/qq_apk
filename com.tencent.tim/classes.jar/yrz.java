import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;

public class yrz
  implements DialogInterface.OnDismissListener
{
  public yrz(NewFriendActivity paramNewFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.progressDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrz
 * JD-Core Version:    0.7.0.1
 */