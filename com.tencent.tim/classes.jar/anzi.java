import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tablequery.TReportData;
import com.tencent.mobileqq.tablequery.TableQueryController.2.1;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class anzi
  extends BroadcastReceiver
{
  anzi(anzh paramanzh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action.query.data.viewer" == paramContext)
    {
      paramIntent = (TReportData)paramIntent.getSerializableExtra("queryData");
      if (paramIntent != null) {}
    }
    int i;
    do
    {
      do
      {
        return;
        anzg localanzg = new anzg();
        localanzg.description = "";
        localanzg.reportId = (paramIntent.actionName + "\n" + paramIntent.subAction + "\n" + paramIntent.mainAction + "\n");
        if (paramIntent.actionName == null) {}
        for (paramContext = paramIntent.mainAction;; paramContext = paramIntent.subAction)
        {
          localanzg.ciE = paramContext;
          if ((anzh.isRunning) && (!anzh.cKQ) && (anzh.a(this.this$0) != null)) {
            anzh.a(this.this$0).a(localanzg);
          }
          if ((anzh.isRunning) && ((anzh.cKR) || (anzh.access$000()))) {
            anzh.a(this.this$0).a((QQAppInterface)anzh.a(this.this$0).get(), paramIntent.table, 2, paramIntent.mainAction, paramIntent.actionName, paramIntent.subAction);
          }
          QLog.d("TableQueryController", 1, paramIntent.actionName + "\n" + paramIntent.mainAction + "\n" + paramIntent.subAction + "\n" + paramIntent.table + "\n");
          return;
        }
      } while ("com.tencent.plugin.state.change" != paramContext);
      i = paramIntent.getIntExtra("key_plugin_state", -1);
      if (1 == i)
      {
        this.this$0.show();
        paramContext = new TableQueryController.2.1(this);
        ThreadManager.getSubThreadHandler().postDelayed(paramContext, 2000L);
        return;
      }
    } while (i != 0);
    this.this$0.hide();
    anzh.isRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzi
 * JD-Core Version:    0.7.0.1
 */