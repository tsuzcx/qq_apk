import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.statistics.ReportController;

public class wsw
  implements View.OnClickListener
{
  public wsw(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.b) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (!this.a.b) {
        break label92;
      }
      StatisticConstants.d();
    }
    for (;;)
    {
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
      return;
      label92:
      StatisticConstants.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsw
 * JD-Core Version:    0.7.0.1
 */