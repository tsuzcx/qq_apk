import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.1.1;

public class izs
  extends BroadcastReceiver
{
  izs(izr paramizr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l = jlc.a(paramIntent);
    if (paramContext.equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION")) {
      if (this.this$0.mUinType == 1) {
        this.this$0.mApp.getHandler().postDelayed(new MultiIncomingCallUICtr.1.1(this), 500L);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramContext = igv.a().a();
          this.this$0.a(l, paramContext);
          this.this$0.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(this.this$0.mGroupId), Integer.valueOf(3) });
        } while (this.this$0.a == null);
        this.this$0.a.hide();
        return;
        if (paramContext.equals("tencent.video.invite.multiaccept"))
        {
          paramContext = igv.a().a();
          this.this$0.a(l, paramContext);
          return;
        }
        if (!paramContext.equals("tencent.video.invite.multirefuse")) {
          break;
        }
      } while (this.this$0.cx(0));
      this.this$0.a(l, true, null);
      return;
    } while (!paramContext.equals("tencent.video.destroyService"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izs
 * JD-Core Version:    0.7.0.1
 */