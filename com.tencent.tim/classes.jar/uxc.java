import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class uxc
  implements DialogInterface.OnClickListener
{
  public uxc(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardFriendListActivity.a(this.this$0).dismiss();
    ForwardFriendListActivity.a(this.this$0, ForwardFriendListActivity.a(this.this$0).getEditText());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */