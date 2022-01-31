import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;

public class wwc
  implements View.OnClickListener
{
  public wwc(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    this.a.finish();
    AlbumUtil.a(this.a, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwc
 * JD-Core Version:    0.7.0.1
 */