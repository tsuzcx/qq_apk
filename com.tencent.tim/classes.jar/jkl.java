import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.utils.PopupDialogQQSide;

public class jkl
  implements DialogInterface.OnDismissListener
{
  public jkl(PopupDialogQQSide paramPopupDialogQQSide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.mDialog) {
      this.a.mDialog = null;
    }
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().doOnBackPressed();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkl
 * JD-Core Version:    0.7.0.1
 */