import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ijd
  extends BroadcastReceiver
{
  ijd(ijc paramijc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE")) {
      this.b.bq(paramContext);
    }
    while (!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) {
      return;
    }
    this.b.bq(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijd
 * JD-Core Version:    0.7.0.1
 */