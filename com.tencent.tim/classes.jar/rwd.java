import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class rwd
  extends BroadcastReceiver
{
  rwd(rwc paramrwc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) && (TextUtils.equals(paramIntent.getStringExtra("from"), rwc.a(this.b))))
    {
      if (rwc.a(this.b) != null) {
        rwc.a(this.b).removeMessages(108);
      }
      if (rwc.a(this.b) != null) {
        rwc.a(this.b).aup();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwd
 * JD-Core Version:    0.7.0.1
 */