import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;
import com.tencent.mobileqq.widget.QQToast;

public class xzf
  extends BroadcastReceiver
{
  public xzf(StoryPlayerWebFragment paramStoryPlayerWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    yuk.a("StoryPlayerWebFragment", "onReceive() Action: %s", paramIntent.getAction());
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("event");
      yuk.a("StoryPlayerWebFragment", "onReceive() Event: %s", paramContext);
      if (!"closeMeEvent".equals(paramContext)) {
        break label70;
      }
      if (this.a.a != null) {
        this.a.a.a();
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
    this.a.a.b();
    return;
    QQToast.a(this.a.getActivity(), 1, "unknown event: " + paramContext, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzf
 * JD-Core Version:    0.7.0.1
 */