import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class wt
  implements DialogInterface.OnClickListener
{
  public wt(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      AddFriendLogicActivity.a(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wt
 * JD-Core Version:    0.7.0.1
 */