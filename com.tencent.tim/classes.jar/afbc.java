import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class afbc
  extends ReportDialog
  implements Handler.Callback
{
  private static String TAG = "DBFix";
  public static int cPK = 1;
  public static int cPM;
  public static int cPN = 1;
  public static int cPO = 2;
  public static int cPP = 3;
  public static int cPQ = 1;
  public static int cPR = 2;
  public static int cPS = 3;
  private long Xe;
  private afbc.a a;
  private File ar;
  private File as;
  private long beginTime;
  private int cPL = cPM;
  private aurf d = new aurf(Looper.getMainLooper(), this);
  private Runnable go = new DBFixLoadingDialog.2(this);
  private QQAppInterface mApp;
  private Context mContext;
  private TextView mText;
  private String nS;
  private float vV;
  
  afbc(QQAppInterface paramQQAppInterface, Context paramContext, afbc.a parama)
  {
    super(paramContext);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = parama;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == cPQ) {
      if (this.cPL == cPN)
      {
        j = (int)((float)(System.currentTimeMillis() - this.beginTime) / (10.0F * this.vV));
        i = j;
        if (j > 90) {
          i = (j - 90) / 10 + 90;
        }
        i = Math.min(i, 99);
        paramMessage = String.format(acfp.m(2131704701), new Object[] { Integer.valueOf(i) });
        this.mText.setText(paramMessage);
        this.d.sendEmptyMessageDelayed(cPQ, 500L);
      }
    }
    while (paramMessage.what != cPR)
    {
      do
      {
        int j;
        int i;
        return false;
        if (this.cPL == cPO)
        {
          ((DBFixManager)this.mApp.getManager(205)).HG(true);
          if (!this.as.renameTo(this.ar))
          {
            QLog.d(TAG, 1, "db fix succ but copy fail");
            boolean bool = aqhq.copyFile(this.as, this.ar);
            aqhq.deleteFile(this.as.getPath());
            if (!bool)
            {
              QLog.d(TAG, 1, "db fix succ but copy fail final");
              paramMessage = new HashMap();
              anpc.a(BaseApplication.getContext()).collectPerformance(null, DBFixManager.bCP, true, -1L, 0L, paramMessage, null, false);
            }
          }
          this.mText.setText(acfp.m(2131704702));
          this.d.sendEmptyMessageDelayed(cPR, 100L);
          return false;
        }
      } while (this.cPL != cPP);
      dismiss();
      this.a.Mo(this.cPL);
      return false;
    }
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      dismiss();
    }
    this.a.Mo(this.cPL);
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559534);
    this.mText = ((TextView)super.findViewById(2131365634));
    this.nS = this.mApp.getCurrentAccountUin();
    this.ar = this.mContext.getDatabasePath(this.nS + ".db");
    this.as = this.mContext.getDatabasePath(this.nS + "_dump.db");
    this.Xe = this.ar.length();
    this.vV = ((float)this.Xe / 1216348.1F);
    this.beginTime = System.currentTimeMillis();
    paramBundle = this.mApp.getAccount();
    SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences(DBFixManager.bCE, 0);
    cPK = localSharedPreferences.getInt(paramBundle + DBFixManager.bCF, 2);
    if (localSharedPreferences.getInt(paramBundle + DBFixManager.bCH, 0) > 2) {
      if (cPK != 2) {
        break label398;
      }
    }
    label398:
    for (int i = 1;; i = 2)
    {
      cPK = i;
      localSharedPreferences.edit().putInt(paramBundle + DBFixManager.bCF, cPK).commit();
      String str = localSharedPreferences.getString(paramBundle + DBFixManager.bCN, "");
      localSharedPreferences.edit().putString(paramBundle + DBFixManager.bCN, str + "_" + cPK).commit();
      ThreadManager.post(this.go, 10, null, true);
      super.setOnKeyListener(new afbd(this));
      return;
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.d.sendEmptyMessage(cPQ);
  }
  
  public static abstract interface a
  {
    public abstract void Mo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbc
 * JD-Core Version:    0.7.0.1
 */