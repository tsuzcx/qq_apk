import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class arne
  extends BroadcastReceiver
{
  public arne(WXShareHelper paramWXShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WXShareHelper.a(this.c) != null) {
      WXShareHelper.a(this.c).handleIntent(paramIntent, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arne
 * JD-Core Version:    0.7.0.1
 */