import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class avq
  implements Runnable
{
  avq(avp paramavp) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131363625)).setMessage(String.format(this.a.a.getString(2131363626), new Object[] { this.a.a.b })).setPositiveButton(2131363052, new avr(this));
    localQQCustomDialog.setOnDismissListener(new avs(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avq
 * JD-Core Version:    0.7.0.1
 */