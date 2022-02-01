import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class kbc
  extends BroadcastReceiver
{
  kbc(kaw paramkaw, String paramString, boolean paramBoolean) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    double d1 = Double.parseDouble(paramIntent.getStringExtra("latitude"));
    double d2 = Double.parseDouble(paramIntent.getStringExtra("longitude"));
    paramIntent = paramIntent.getStringExtra("name");
    this.this$0.a(d1, d2, paramIntent, this.val$key, this.ads);
    try
    {
      paramContext.unregisterReceiver(this.this$0.af);
      label58:
      this.this$0.af = null;
      return;
    }
    catch (Exception paramContext)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbc
 * JD-Core Version:    0.7.0.1
 */