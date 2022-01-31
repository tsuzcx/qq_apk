import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;

public class wsz
  implements DialogInterface.OnCancelListener
{
  public wsz(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsz
 * JD-Core Version:    0.7.0.1
 */