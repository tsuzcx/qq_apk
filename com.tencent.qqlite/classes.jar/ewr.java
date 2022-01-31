import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;

public class ewr
  extends BroadcastReceiver
{
  public ewr(SDCardMountInforUtil paramSDCardMountInforUtil) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.MEDIA_MOUNTED".equals(paramContext)) || ("android.intent.action.MEDIA_SCANNER_STARTED".equals(paramContext)) || ("android.intent.action.MEDIA_SCANNER_FINISHED".equals(paramContext)) || ("android.intent.action.MEDIA_REMOVED".equals(paramContext)) || ("android.intent.action.MEDIA_UNMOUNTED".equals(paramContext)) || ("android.intent.action.MEDIA_BAD_REMOVAL".equals(paramContext))) {
      SDCardMountInforUtil.a(this.a, SDCardMountInforUtil.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ewr
 * JD-Core Version:    0.7.0.1
 */