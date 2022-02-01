import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin.1.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public final class stk
  extends ajpa
{
  stk(BaseActivity paramBaseActivity, String paramString1, String paramString2, int paramInt, String paramString3, arhz paramarhz, Bundle paramBundle, long paramLong) {}
  
  public void O(long paramLong1, long paramLong2)
  {
    if (paramLong2 > 0L) {
      stj.b(this.val$activity, String.valueOf(paramLong2), this.aGq, this.aGr, stj.access$000(this.val$scene), stj.n(this.val$scene, this.aGs), this.p, this.val$bundle);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, String.format("handleGetTinyId [%s, %s, %s] ", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(System.currentTimeMillis() - this.AG) }));
      }
      return;
      this.val$activity.runOnUiThread(new NewReportPlugin.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stk
 * JD-Core Version:    0.7.0.1
 */