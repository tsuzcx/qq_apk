import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.1;

public class agma
  extends BroadcastReceiver
{
  public agma(UniformDownloadMgr.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getBundleExtra("param");
    paramIntent = paramIntent.getStringExtra("url");
    aglz.a().y(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agma
 * JD-Core Version:    0.7.0.1
 */