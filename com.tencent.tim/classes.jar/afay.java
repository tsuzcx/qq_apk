import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import mqq.app.MobileQQ;

class afay
  implements DialogInterface.OnClickListener
{
  afay(afat paramafat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    afat.a(this.this$0).cYj();
    this.this$0.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0).edit().remove(this.this$0.mUin + DBFixManager.bCJ).commit();
    anot.a(this.this$0.mApp, "CliOper", "", this.this$0.mUin, afat.bCD, afat.bCD, 0, 0, "", "", "", "");
    afat.a(this.this$0).cYk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afay
 * JD-Core Version:    0.7.0.1
 */