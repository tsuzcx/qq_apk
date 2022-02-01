import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class uxb
  implements DialogInterface.OnClickListener
{
  public uxb(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ForwardFriendListActivity.a(this.this$0).getInputValue();
    if (!TextUtils.isEmpty(paramDialogInterface))
    {
      ForwardFriendListActivity.a(this.this$0, ForwardFriendListActivity.a(this.this$0).getEditText());
      Intent localIntent = new Intent();
      localIntent.putExtras(this.this$0.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_name", paramDialogInterface);
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxb
 * JD-Core Version:    0.7.0.1
 */