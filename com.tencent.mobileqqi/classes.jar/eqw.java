import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.utils.AlbumUtil;

public class eqw
  implements View.OnClickListener
{
  public eqw(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    AlbumUtil.a(this.a, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqw
 * JD-Core Version:    0.7.0.1
 */