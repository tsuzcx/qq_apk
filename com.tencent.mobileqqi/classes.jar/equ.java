import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;

public class equ
  implements View.OnClickListener
{
  public equ(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    PhotoUtils.a(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 1, true);
    paramView.setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     equ
 * JD-Core Version:    0.7.0.1
 */