import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class gwv
  implements View.OnClickListener
{
  public gwv(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayLogic.a(this.a) != null) {
      VideoPlayLogic.a(this.a).c();
    }
    if (VideoPlayLogic.a(this.a))
    {
      if (this.a.c()) {
        ReportController.b(VideoPlayLogic.a(this.a).b, "P_CliOper", "Grp_AIO", "", "video", "jump", 0, 0, VideoPlayLogic.a(this.a).a, "1", "", "");
      }
      for (;;)
      {
        new StructMsgForGeneralShare.GeneralClickHandler(VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a), VideoPlayLogic.a(this.a)).a(VideoPlayLogic.a(this.a));
        return;
        ReportController.b(VideoPlayLogic.a(this.a).b, "P_CliOper", "Grp_AIO", "", "video", "jump", 0, 0, VideoPlayLogic.a(this.a).a, "0", "", "");
      }
    }
    this.a.a(VideoPlayLogic.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwv
 * JD-Core Version:    0.7.0.1
 */