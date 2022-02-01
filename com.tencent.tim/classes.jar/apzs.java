import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class apzs
  extends BroadcastReceiver
{
  public apzs(SnapshotService paramSnapshotService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("id", -1L);
    int i = paramIntent.getIntExtra("action", -1);
    if ((l == 0L) && (i == 1) && (SnapshotService.a(this.this$0) > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i(SnapshotService.access$000(), 2, "receive broadcast: destroy snapshot service");
      }
      SnapshotService.access$602(false);
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzs
 * JD-Core Version:    0.7.0.1
 */