import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4;

public class aybq
  implements DialogInterface.OnClickListener
{
  public aybq(LightWeightSoDownloadUnit.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = aybp.a(this.a.this$0).getActivity();
    if (paramInt == 1)
    {
      this.a.this$0.a.setCameraPermissionResult(false);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramDialogInterface.getPackageName(), null));
      paramDialogInterface.startActivity(localIntent);
      return;
    }
    paramDialogInterface.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybq
 * JD-Core Version:    0.7.0.1
 */