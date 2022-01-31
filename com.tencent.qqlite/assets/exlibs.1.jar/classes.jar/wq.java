import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class wq
  implements DialogInterface.OnClickListener
{
  public wq(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendLogicActivity.c(this.a) == 1)
    {
      this.a.finish();
      return;
    }
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wq
 * JD-Core Version:    0.7.0.1
 */