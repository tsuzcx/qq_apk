import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixDialogActivity;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI.2;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI.8;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class afat
  implements afbc.a
{
  private static String TAG = "DBFix";
  public static String bCA = "0X8007961";
  public static String bCB = "0X8007962";
  public static String bCC = "0X8007963";
  public static String bCD = "0X8007964";
  public static String bCz = "0X8007960";
  public static Dialog dialog;
  private DBFixManager a;
  private String bCy = "";
  private int cPI;
  DialogInterface.OnCancelListener e = new afau(this);
  QQAppInterface mApp;
  public Context mContext;
  String mUin;
  
  public afat(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mUin = paramQQAppInterface.getCurrentAccountUin();
    this.a = ((DBFixManager)this.mApp.getManager(205));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    QLog.d(TAG, 1, "DBFixDialogUI showDialog, " + paramString);
    this.bCy = paramString;
    this.mApp.runOnUiThread(new DBFixDialogUI.2(this, paramDialog));
  }
  
  private void cYe()
  {
    this.a.HF(true);
    dialog = new afbc(this.mApp, this.mContext, this);
    dialog.setOnCancelListener(this.e);
    a(dialog, "fixing");
  }
  
  private void cYf()
  {
    dialog = aqha.a(this.mContext, 230).setMessage(acfp.m(2131704694)).setPositiveButton(acfp.m(2131704700), new afay(this));
    dialog.setOnKeyListener(new afaz(this));
    dialog.setOnCancelListener(this.e);
    a(dialog, "fix succ");
    anot.a(this.mApp, "CliOper", "", this.mUin, bCC, bCC, 0, 0, "", "", "", "");
  }
  
  private void cYg()
  {
    dialog = aqha.a(this.mContext, 230).setMessage(acfp.m(2131704695)).setPositiveButton("重启QQ", new afba(this));
    dialog.setOnCancelListener(this.e);
    a(dialog, "fix fail");
  }
  
  private void cYh()
  {
    dialog = aqha.a(this.mContext, 230).setMessage(acfp.m(2131704697)).setPositiveButton(acfp.m(2131704693), new afav(this)).setNegativeButton(acfp.m(2131704699), new afbb(this));
    dialog.setOnCancelListener(this.e);
    a(dialog, "memory alert");
  }
  
  public void Mo(int paramInt)
  {
    this.cPI = paramInt;
    this.mApp.runOnUiThread(new DBFixDialogUI.8(this, paramInt));
  }
  
  public void finish()
  {
    dialog = null;
    if ((this.mContext instanceof DBFixDialogActivity)) {
      ((DBFixDialogActivity)this.mContext).finish();
    }
    this.a.HF(false);
    if (this.cPI != afbc.cPO)
    {
      Object localObject = this.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0);
      String str = this.mApp.getCurrentAccountUin();
      if (((SharedPreferences)localObject).getInt(str + DBFixManager.bCH, 0) == DBFixManager.cPT)
      {
        QLog.d(TAG, 1, "DBFixDialogUI 2, max count, delete db");
        this.a.HG(false);
        this.a.cYj();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.bCG);
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.bCH);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void ii()
  {
    dialog = aqha.a(this.mContext, 230).setMessage(acfp.m(2131704696)).setPositiveButton(acfp.m(2131704698), new afax(this)).setNegativeButton("取消", new afaw(this));
    dialog.setOnCancelListener(this.e);
    a(dialog, "checked corrupt");
    anot.a(this.mApp, "CliOper", "", this.mUin, bCz, bCz, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afat
 * JD-Core Version:    0.7.0.1
 */