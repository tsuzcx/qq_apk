import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class cwc
  implements Runnable
{
  cwc(cwb paramcwb) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131561929)).setMessage(String.format(this.a.a.getString(2131561417), new Object[] { this.a.a.b })).setPositiveButton(2131562701, new cwd(this));
    localQQCustomDialog.setOnDismissListener(new cwe(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwc
 * JD-Core Version:    0.7.0.1
 */