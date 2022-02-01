import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.ReportData;
import java.util.HashMap;

class afby
  extends BroadcastReceiver
{
  afby(afbx paramafbx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ReportData)paramIntent.getSerializableExtra("reportData");
    paramIntent = (afbz)afbx.a(this.this$0).get(paramContext.actionName);
    if ((paramIntent != null) && (paramIntent.isChecked()))
    {
      this.this$0.show();
      afbx.a(this.this$0).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afby
 * JD-Core Version:    0.7.0.1
 */