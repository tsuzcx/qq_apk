import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.7;

public class aywx
  implements DialogInterface.OnCancelListener
{
  public aywx(CaptureQmcfSoDownloadFragment.7 param7) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    CaptureQmcfSoDownloadFragment.a(this.a.this$0).setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywx
 * JD-Core Version:    0.7.0.1
 */