import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;

public class eqv
  implements View.OnClickListener
{
  public eqv(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqv
 * JD-Core Version:    0.7.0.1
 */