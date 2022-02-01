package cooperation.qzone.contentbox;

import android.content.SharedPreferences;
import android.os.Handler;
import avcb;

class TimeHeaderLayout$1
  implements Runnable
{
  TimeHeaderLayout$1(TimeHeaderLayout paramTimeHeaderLayout) {}
  
  public void run()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    if (!this.this$0.preferences.contains(TimeHeaderLayout.cNI)) {
      arrayOfBoolean[0] = avcb.aKs();
    }
    for (;;)
    {
      this.this$0.handler.post(new TimeHeaderLayout.1.1(this));
      return;
      arrayOfBoolean[0] = this.this$0.preferences.getBoolean(TimeHeaderLayout.cNI, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout.1
 * JD-Core Version:    0.7.0.1
 */