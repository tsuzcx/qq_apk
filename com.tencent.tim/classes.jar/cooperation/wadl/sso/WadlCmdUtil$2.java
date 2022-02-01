package cooperation.wadl.sso;

import android.content.Intent;
import aqhq;
import awot;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import tbb;

public class WadlCmdUtil$2
  implements Runnable
{
  public WadlCmdUtil$2(awot paramawot, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = awot.R();
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (aqhq.writeFile(((File)localObject).getAbsolutePath(), this.val$content, false))
    {
      tbb.j("LAST_GET_CONF_VERSION", this.aBt);
      tbb.j("LAST_GET_CONF_TIME", awot.a(this.this$0));
      localObject = new Intent("com.tencent.gamecenter.action");
      ((Intent)localObject).setPackage(BaseApplicationImpl.getApplication().getPackageName());
      ((Intent)localObject).putExtra("key_event_id", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.2
 * JD-Core Version:    0.7.0.1
 */