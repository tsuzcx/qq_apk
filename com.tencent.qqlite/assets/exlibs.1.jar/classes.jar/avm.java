import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class avm
  implements Runnable
{
  avm(avl paramavl) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131363620)).setMessage(String.format(this.a.a.getString(2131363621), new Object[] { this.a.a.b })).setPositiveButton(2131363039, new avn(this));
    localQQCustomDialog.setOnDismissListener(new avo(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avm
 * JD-Core Version:    0.7.0.1
 */