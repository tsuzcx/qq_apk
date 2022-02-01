import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;

public class afun
  implements DialogInterface.OnClickListener
{
  public afun(ExtendFriendEditFragment paramExtendFriendEditFragment, ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ExtendFriendEditFragment.b(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afun
 * JD-Core Version:    0.7.0.1
 */