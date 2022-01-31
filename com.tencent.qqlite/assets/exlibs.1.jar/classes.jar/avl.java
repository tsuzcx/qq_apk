import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class avl
  implements Runnable
{
  avl(avk paramavk) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131363614)).setMessage(String.format(this.a.a.getString(2131363615), new Object[] { this.a.a.b })).setPositiveButton(2131363042, new avm(this));
    localQQCustomDialog.setOnDismissListener(new avn(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avl
 * JD-Core Version:    0.7.0.1
 */