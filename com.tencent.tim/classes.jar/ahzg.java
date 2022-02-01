import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.c;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class ahzg
  extends BroadcastReceiver
{
  private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
  private final String SYSTEM_DIALOG_REASON_KEY = "reason";
  
  public ahzg(HotPicPageView paramHotPicPageView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManagerHotPicPageView", 2, "onReceive ===>" + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      HotPicPageView.cjn = true;
    }
    label49:
    do
    {
      do
      {
        do
        {
          do
          {
            break label49;
            break label49;
            do
            {
              return;
            } while ("android.intent.action.SCREEN_ON".equals(paramContext));
            if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
            {
              HotPicPageView.cjn = true;
              return;
            }
          } while (("tencent.av.v2q.StopVideoChat".equals(paramContext)) || (!paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")));
          paramContext = paramIntent.getStringExtra("reason");
          if (paramContext != null) {
            break;
          }
        } while ((this.this$0.a == null) || (this.this$0.a.mPlayState != 3));
        paramContext = this.this$0.a.a();
      } while (paramContext == null);
      paramContext.pauseVideo();
      return;
    } while (!paramContext.equals("homekey"));
    HotPicPageView.cjn = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzg
 * JD-Core Version:    0.7.0.1
 */