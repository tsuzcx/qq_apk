import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class agqh
  extends BroadcastReceiver
{
  public agqh(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(5)
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqh
 * JD-Core Version:    0.7.0.1
 */