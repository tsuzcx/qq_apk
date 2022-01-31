import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;

public class eoj
  implements View.OnClickListener
{
  public eoj(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayLogic.a(this.a).a()) {
      if (VideoPlayLogic.a(this.a) != null)
      {
        VideoPlayLogic.a(this.a).setVisibility(0);
        VideoPlayLogic.a(this.a, false);
        if (VideoPlayLogic.a(this.a)) {
          ReportController.b(VideoPlayLogic.a(this.a).app, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, VideoPlayLogic.a(this.a).a, "1", "", "");
        }
      }
    }
    while (VideoPlayLogic.a(this.a) == null) {
      return;
    }
    if (VideoPlayLogic.a(this.a)) {
      ReportController.b(VideoPlayLogic.a(this.a).app, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, VideoPlayLogic.a(this.a).a, "0", "", "");
    }
    VideoPlayLogic.a(this.a).setVisibility(8);
    VideoPlayLogic.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eoj
 * JD-Core Version:    0.7.0.1
 */