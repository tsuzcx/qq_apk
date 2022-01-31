import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment;

public class twf
  extends BroadcastReceiver
{
  public twf(StoryPlayerWebFragment paramStoryPlayerWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    urk.a("StoryPlayerWebFragment", "onReceive() Action: %s", paramIntent.getAction());
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("event");
      urk.a("StoryPlayerWebFragment", "onReceive() Event: %s", paramContext);
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
    bbmy.a(this.a.getActivity(), 1, "unknown event: " + paramContext, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twf
 * JD-Core Version:    0.7.0.1
 */