import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;

public class vbz
  implements DialogInterface.OnClickListener
{
  public vbz(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.f.dismiss();
    paramDialogInterface = this.a.getIntent();
    paramDialogInterface.putExtra("delHead_fileid", FriendProfilePicBrowserActivity.a(this.a));
    this.a.setResult(-1, paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbz
 * JD-Core Version:    0.7.0.1
 */