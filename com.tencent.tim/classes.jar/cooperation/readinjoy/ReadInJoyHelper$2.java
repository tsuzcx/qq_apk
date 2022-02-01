package cooperation.readinjoy;

import android.content.SharedPreferences;
import awit;
import mqq.app.AppRuntime;

public final class ReadInJoyHelper$2
  implements Runnable
{
  public ReadInJoyHelper$2(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    int i = 1;
    SharedPreferences localSharedPreferences = awit.a(this.val$app, true, true);
    if (localSharedPreferences == null) {
      return;
    }
    if (localSharedPreferences.getBoolean("free_time_refresh_push", true)) {}
    for (;;)
    {
      awit.access$002(i);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.2
 * JD-Core Version:    0.7.0.1
 */