import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;

public class aoe
  implements DialogInterface.OnClickListener
{
  public aoe(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.g();
    if ((FriendProfileCardActivity.a(this.a) != null) && (FriendProfileCardActivity.a(this.a).isShowing())) {
      FriendProfileCardActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aoe
 * JD-Core Version:    0.7.0.1
 */