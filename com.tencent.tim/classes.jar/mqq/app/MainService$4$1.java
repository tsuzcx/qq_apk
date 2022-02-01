package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MainService$4$1
  implements Runnable
{
  MainService$4$1(MainService.4 param4, String paramString) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent("mqq.intent.action.OVERLOAD_PUSH");
      localIntent.putExtra("msg", this.val$msg);
      localIntent.addFlags(268435456);
      MainService.access$000(this.this$1.this$0).startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("mqq", 1, "overload push notify fail, except: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MainService.4.1
 * JD-Core Version:    0.7.0.1
 */