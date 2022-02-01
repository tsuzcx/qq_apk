import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

class afax
  implements DialogInterface.OnClickListener
{
  afax(afat paramafat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.this$0.mContext.getDatabasePath(this.this$0.mApp.getCurrentAccountUin() + ".db");
    boolean bool = false;
    if ((paramDialogInterface.exists()) && ((float)paramDialogInterface.length() * 1.7F > aqhq.getAvailableInnernalMemorySize()))
    {
      bool = true;
      afat.a(this.this$0);
      paramDialogInterface = this.this$0.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0);
      String str = paramDialogInterface.getString(this.this$0.mUin + DBFixManager.bCN, "");
      paramDialogInterface.edit().putString(this.this$0.mUin + DBFixManager.bCN, str + "_MemoryAlert").commit();
    }
    for (;;)
    {
      paramDialogInterface = new HashMap();
      paramDialogInterface.put("isMemAlert", String.valueOf(bool));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, DBFixManager.bCQ, true, -1L, 0L, paramDialogInterface, null, false);
      anot.a(this.this$0.mApp, "CliOper", "", this.this$0.mUin, afat.bCA, afat.bCA, 0, 0, "", "", "", "");
      return;
      afat.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afax
 * JD-Core Version:    0.7.0.1
 */