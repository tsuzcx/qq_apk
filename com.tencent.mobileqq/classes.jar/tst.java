import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class tst
  extends BroadcastReceiver
{
  private tst(tsp paramtsp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    if ("action_update_native_auth_info".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("type", 1);
      j = paramIntent.getIntExtra("status", 0);
      paramContext = paramIntent.getStringExtra("tagName");
      if (i != 2) {
        break label59;
      }
      i = tra.a(j);
      tra.a(tqg.a(), i, paramContext);
    }
    for (;;)
    {
      tqg.b();
      return;
      label59:
      if (i == 3)
      {
        i = tra.a(j);
        tra.a(tqg.b(), i, paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */