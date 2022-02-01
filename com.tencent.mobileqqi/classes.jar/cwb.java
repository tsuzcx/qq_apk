import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class cwb
  implements Runnable
{
  cwb(cwa paramcwa) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131561929)).setMessage(String.format(this.a.a.getString(2131561417), new Object[] { this.a.a.b })).setPositiveButton(2131562701, new cwc(this));
    localQQCustomDialog.setOnDismissListener(new cwd(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwb
 * JD-Core Version:    0.7.0.1
 */