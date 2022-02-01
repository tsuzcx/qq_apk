import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class zrl
  implements View.OnClickListener
{
  public zrl(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.bsG) {
        anot.a(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (!this.a.bsG) {
        break label140;
      }
      zsz.crF();
    }
    for (;;)
    {
      if ((CameraPreviewActivity.a(this.a) != null) && (CameraPreviewActivity.a(this.a).size() > 0)) {
        auqv.dK((String)CameraPreviewActivity.a(this.a).get(0), true);
      }
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label140:
      zsz.crD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrl
 * JD-Core Version:    0.7.0.1
 */