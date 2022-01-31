import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class bgx
  extends BroadcastReceiver
{
  public bgx(VideoAppInterface paramVideoAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((this.a.a(paramIntent, paramContext)) && (this.a.a(paramContext)) && ((this.a.a == null) || (this.a.a.a().a()))) {
        this.a.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgx
 * JD-Core Version:    0.7.0.1
 */