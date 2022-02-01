import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class jev
  extends BroadcastReceiver
{
  jev(jeu paramjeu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      l = jlc.a(paramIntent);
      if (!paramContext.equals("tencent.video.invite.accept")) {
        break label32;
      }
      this.this$0.dP(l);
    }
    label32:
    do
    {
      return;
      if (paramContext.equals("tencent.video.invite.refuse"))
      {
        this.this$0.dQ(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaaccept"))
      {
        this.this$0.dS(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaignore"))
      {
        this.this$0.dR(l);
        return;
      }
    } while (!paramContext.equals("tencent.video.q2v.sdk.onRequestVideo"));
    QLog.d("VideoInviteFloatBarUICtr", 1, "onReceive action = " + paramContext);
    this.this$0.wO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jev
 * JD-Core Version:    0.7.0.1
 */