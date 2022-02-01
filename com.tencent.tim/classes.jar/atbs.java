import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;

public class atbs
  implements DialogInterface.OnClickListener
{
  public atbs(FriendProfileFragment paramFriendProfileFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbs
 * JD-Core Version:    0.7.0.1
 */