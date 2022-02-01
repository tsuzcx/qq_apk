import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.os.MqqHandler;

class kbj
  extends BroadcastReceiver
{
  kbj(kaw paramkaw, boolean paramBoolean, MqqHandler paramMqqHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.adt)
    {
      this.this$0.a(str, i, 12, -1, null);
      if (this.a != null) {
        this.a.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.this$0.scanResultReceiver);
        label65:
        this.this$0.scanResultReceiver = null;
        return;
        this.this$0.a(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbj
 * JD-Core Version:    0.7.0.1
 */