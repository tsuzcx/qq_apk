package cooperation.vip.manager;

import android.content.Intent;
import awmb;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class CommonRequestManager$1
  implements Runnable
{
  public CommonRequestManager$1(awmb paramawmb, Intent paramIntent) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), this.this$0.getClass());
    localNewIntent.putExtras(this.val$intent);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.manager.CommonRequestManager.1
 * JD-Core Version:    0.7.0.1
 */