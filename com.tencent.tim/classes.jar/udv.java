import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.LoginActivity;

public class udv
  implements DialogInterface.OnClickListener
{
  public udv(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.this$0, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.this$0.getIntent().getExtras());
      paramDialogInterface.putExtra("appid", AddFriendLogicActivity.c(this.this$0));
      paramDialogInterface.putExtra("openid", AddFriendLogicActivity.aKF);
      paramDialogInterface.putExtra("key_action", AddFriendLogicActivity.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.this$0.x.cancel();
      this.this$0.startActivity(paramDialogInterface);
      this.this$0.finish();
    }
    while (paramInt != 0) {
      return;
    }
    this.this$0.setResult(0);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udv
 * JD-Core Version:    0.7.0.1
 */