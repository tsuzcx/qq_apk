import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment.a;
import com.tencent.mobileqq.widget.QQToast;

public class qnx
  extends BroadcastReceiver
{
  public qnx(StoryPlayerWebFragment paramStoryPlayerWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ram.b("StoryPlayerWebFragment", "onReceive() Action: %s", paramIntent.getAction());
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("event");
      ram.b("StoryPlayerWebFragment", "onReceive() Event: %s", paramContext);
      if (!"closeMeEvent".equals(paramContext)) {
        break label70;
      }
      if (this.a.a != null) {
        this.a.a.bpu();
      }
    }
    label70:
    do
    {
      return;
      if (!"readyEvent".equals(paramContext)) {
        break;
      }
    } while (this.a.a == null);
    this.a.a.bpv();
    return;
    QQToast.a(this.a.getActivity(), 1, "unknown event: " + paramContext, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnx
 * JD-Core Version:    0.7.0.1
 */