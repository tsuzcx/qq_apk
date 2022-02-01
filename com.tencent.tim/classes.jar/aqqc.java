import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.vas.FriendCloneSettingFragment;

public class aqqc
  implements DialogInterface.OnCancelListener
{
  public aqqc(FriendCloneSettingFragment paramFriendCloneSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.mActivity != null) {
      this.a.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */