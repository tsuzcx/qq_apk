import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ugn
  implements DialogInterface.OnClickListener
{
  public ugn(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail -> to LoginActivity which=" + paramInt);
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(this.this$0.getPackageName());
    paramDialogInterface.setClass(this.this$0, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("fromsubaccount", true);
    if (this.this$0.aKS != null) {
      paramDialogInterface.putExtra("uin", this.this$0.aKS);
    }
    paramDialogInterface.putExtra("befault_uin", this.this$0.app.getCurrentAccountUin());
    this.this$0.startActivityForResult(paramDialogInterface, 1011);
    this.this$0.aKS = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugn
 * JD-Core Version:    0.7.0.1
 */