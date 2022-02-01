import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class jcj
  extends BroadcastReceiver
{
  jcj(jci paramjci) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QavDoubleVideoSharpnessMangaer", 2, "onReceive SVIPPayResultReceiver");
    }
    if (("tencent.video.q2v.SVIP.PAY".equals(paramContext)) && (jci.a(this.b) != null))
    {
      paramContext = jci.a(this.b).b();
      if ((paramContext != null) && (paramContext.amI == 2)) {
        jci.a(this.b).sendSelectVideoModeRequest(Long.valueOf(paramContext.peerUin).longValue(), jci.a(this.b));
      }
      this.b.atI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcj
 * JD-Core Version:    0.7.0.1
 */