import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class vfd
  extends BroadcastReceiver
{
  private vfd(vfa paramvfa) {}
  
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
      i = uzg.a(j);
      uzg.a(uyn.a(), i, paramContext);
    }
    for (;;)
    {
      uyn.b();
      return;
      label59:
      if (i == 3)
      {
        i = uzg.a(j);
        uzg.a(uyn.b(), i, paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfd
 * JD-Core Version:    0.7.0.1
 */