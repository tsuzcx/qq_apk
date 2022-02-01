package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import awrq;
import axiy;
import ayzk;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private awrq a;
  
  public QIMCameraBroadcastReceiver(awrq paramawrq)
  {
    this.a = paramawrq;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.getActivity();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            axiy.i("QIMCameraBroadcastReceiver", "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.drs) || (!this.a.drA));
          this.a.eEV();
          return;
        } while (!"new_qq_android_native_ptu_res_".equals(paramContext));
        angh.cFq = true;
      } while (ayzk.cYq == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(ayzk.cYq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */