package moai.patch.log;

import android.app.IntentService;
import android.content.Intent;
import moai.patch.handle.PatchHandler;

public class PatchEventService
  extends IntentService
{
  public PatchEventService()
  {
    super("PatchEventService");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Log localLog = PatchHandler.getLogger();
    int i = paramIntent.getIntExtra("logId", 0);
    int j = paramIntent.getIntExtra("level", 2);
    String str1 = paramIntent.getStringExtra("msg");
    long l = paramIntent.getLongExtra("cost", 0L);
    String str2 = paramIntent.getStringExtra("processName");
    int k = paramIntent.getIntExtra("processId", -1);
    if (localLog != null)
    {
      localLog.log(j, i, str1, l, str2, k);
      return;
    }
    android.util.Log.i(String.valueOf(i), str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.PatchEventService
 * JD-Core Version:    0.7.0.1
 */