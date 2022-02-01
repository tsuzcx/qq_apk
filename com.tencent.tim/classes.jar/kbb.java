import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class kbb
  extends BroadcastReceiver
{
  kbb(kaw paramkaw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.aGR == 2)
    {
      int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.picResultData", -1);
      paramIntent = paramIntent.getStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s");
      this.this$0.a(null, 0, 14, i, paramIntent);
    }
    try
    {
      paramContext.unregisterReceiver(this.this$0.ae);
      label50:
      this.this$0.ae = null;
      this.this$0.aGR = 0;
      return;
    }
    catch (Exception paramContext)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbb
 * JD-Core Version:    0.7.0.1
 */