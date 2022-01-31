import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;

public class ego
  implements View.OnClickListener
{
  public ego(VideoItemBuilder paramVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (VideoController.b() != 1)
    {
      paramView = (MessageForVideo)AIOUtils.a(paramView);
      if (paramView.type != 13) {
        break label141;
      }
      ReportController.b(VideoItemBuilder.a(this.a), "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (paramView.type == 2) {
        ReportController.b(VideoItemBuilder.b(this.a), "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramView.type == 0) {
        ReportController.b(VideoItemBuilder.c(this.a), "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      VideoItemBuilder.a(this.a, paramView, bool);
      return;
      label141:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ego
 * JD-Core Version:    0.7.0.1
 */