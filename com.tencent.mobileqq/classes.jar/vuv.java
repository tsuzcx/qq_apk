import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class vuv
  extends BroadcastReceiver
{
  vuv(vuu paramvuu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) && (TextUtils.equals(paramIntent.getStringExtra("from"), vuu.a(this.a))))
    {
      if (vuu.a(this.a) != null) {
        vuu.a(this.a).removeMessages(108);
      }
      if (vuu.a(this.a) != null) {
        vuu.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vuv
 * JD-Core Version:    0.7.0.1
 */