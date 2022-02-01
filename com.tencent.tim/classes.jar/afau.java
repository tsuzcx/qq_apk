import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class afau
  implements DialogInterface.OnCancelListener
{
  afau(afat paramafat) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (afat.a(this.this$0).equals("checked corrupt"))
    {
      paramDialogInterface = this.this$0.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0);
      String str = paramDialogInterface.getString(this.this$0.mUin + DBFixManager.bCN, "");
      paramDialogInterface.edit().putString(this.this$0.mUin + DBFixManager.bCN, str + "_Cancel").commit();
      QLog.d(afat.access$100(), 1, "dialog cancel");
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afau
 * JD-Core Version:    0.7.0.1
 */