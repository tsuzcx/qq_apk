import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

class ayao
  extends BroadcastReceiver
{
  ayao(ayan paramayan) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.this$0.a.getActivity();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightWeightCameraCaptureUnit", 2, "receive ACTION_START_VIDEO_CHAT.");
          }
          this.this$0.eEV();
          return;
        }
      } while (!"tencent.qq.ipc.event".equals(paramContext));
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        AIOLongCaptureCtrl.eA(paramContext);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LightWeightCameraCaptureUnit", 2, "receive ACTION_START_IPC_EVENT. extras=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayao
 * JD-Core Version:    0.7.0.1
 */