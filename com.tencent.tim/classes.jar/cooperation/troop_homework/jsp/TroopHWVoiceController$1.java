package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import awjs;
import awkc;

public class TroopHWVoiceController$1
  implements Runnable
{
  public TroopHWVoiceController$1(awkc paramawkc) {}
  
  public void run()
  {
    String str = awjs.so(awkc.a(this.this$0));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = awkc.a(this.this$0).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.1
 * JD-Core Version:    0.7.0.1
 */