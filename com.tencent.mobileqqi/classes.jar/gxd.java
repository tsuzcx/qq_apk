import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;

public class gxd
  implements View.OnClickListener
{
  public gxd(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayLogic.a(this.a).a()) {
      if (VideoPlayLogic.a(this.a) != null)
      {
        VideoPlayLogic.a(this.a).setVisibility(0);
        if (VideoPlayLogic.a(this.a)) {
          ReportController.b(VideoPlayLogic.a(this.a).b, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, VideoPlayLogic.a(this.a).a, "1", "", "");
        }
      }
    }
    while (VideoPlayLogic.a(this.a) == null) {
      return;
    }
    if (VideoPlayLogic.a(this.a)) {
      ReportController.b(VideoPlayLogic.a(this.a).b, "P_CliOper", "Grp_AIO", "", "video", "close_barrage", 0, 0, VideoPlayLogic.a(this.a).a, "0", "", "");
    }
    VideoPlayLogic.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxd
 * JD-Core Version:    0.7.0.1
 */