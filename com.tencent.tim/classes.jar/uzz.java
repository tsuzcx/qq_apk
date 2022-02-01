import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public final class uzz
  implements DialogInterface.OnClickListener
{
  public uzz(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FriendProfileCardActivity.b(this.val$app, this.val$activity, this.b);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzz
 * JD-Core Version:    0.7.0.1
 */