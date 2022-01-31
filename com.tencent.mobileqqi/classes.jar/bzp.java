import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class bzp
  implements DialogInterface.OnClickListener
{
  public bzp(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendLogicActivity.a(this.a) == 1)
    {
      this.a.finish();
      return;
    }
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bzp
 * JD-Core Version:    0.7.0.1
 */