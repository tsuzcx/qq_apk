import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.activity.profile.friend.StrangerProfileFragment;

public class atbx
  implements DialogInterface.OnClickListener
{
  public atbx(StrangerProfileFragment paramStrangerProfileFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbx
 * JD-Core Version:    0.7.0.1
 */