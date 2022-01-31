import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class xwh
  extends BroadcastReceiver
{
  xwh(xwg paramxwg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) && (TextUtils.equals(paramIntent.getStringExtra("from"), xwg.a(this.a))))
    {
      if (xwg.a(this.a) != null) {
        xwg.a(this.a).removeMessages(108);
      }
      if (xwg.a(this.a) != null) {
        xwg.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwh
 * JD-Core Version:    0.7.0.1
 */