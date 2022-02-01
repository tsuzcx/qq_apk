import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;

public class afuw
  implements DialogInterface.OnClickListener
{
  public afuw(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = "";
    paramDialogInterface = str;
    if (ExtendFriendEditFragment.a(this.a) != null)
    {
      paramDialogInterface = str;
      if (ExtendFriendEditFragment.a(this.a).app != null) {
        paramDialogInterface = ((afsi)ExtendFriendEditFragment.a(this.a).app.getManager(264)).uG();
      }
    }
    afxn.E(this.a.getActivity(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuw
 * JD-Core Version:    0.7.0.1
 */