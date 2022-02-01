import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7;

public class ayhg
  implements DialogInterface.OnClickListener
{
  public ayhg(EditVideoPartManager.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axiy.i("Q.qqstory.publish.edit.EditVideoPartManager", "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = this.a.this$0.a.getActivity();
    if (paramInt == 1)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", localActivity.getPackageName(), null));
      localActivity.startActivity(localIntent);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhg
 * JD-Core Version:    0.7.0.1
 */