import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.activity.profile.friend.StrangerProfileFragment;

public class atbw
  implements DialogInterface.OnClickListener
{
  public atbw(StrangerProfileFragment paramStrangerProfileFragment, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b(this.val$app, this.val$activity, this.b);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbw
 * JD-Core Version:    0.7.0.1
 */