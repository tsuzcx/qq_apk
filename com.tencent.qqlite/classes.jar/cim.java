import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class cim
  implements View.OnClickListener
{
  public cim(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
    }
    PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 2, true);
    paramView.setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cim
 * JD-Core Version:    0.7.0.1
 */