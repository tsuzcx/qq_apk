import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.ae.AEPituCameraUnit.31;

public class awud
  implements DialogInterface.OnClickListener
{
  public awud(AEPituCameraUnit.31 param31) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axiy.i("AEPituCameraUnit", "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = awtq.a(this.a.this$0).getActivity();
    if (paramInt == 1)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", localActivity.getPackageName(), null));
      localActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awud
 * JD-Core Version:    0.7.0.1
 */