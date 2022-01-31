import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.utils.NetworkUtil;

public class eka
  implements DialogInterface.OnKeyListener
{
  public eka(BaseActivityView paramBaseActivityView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (this.a.a.i()) && (NetworkUtil.e(this.a.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eka
 * JD-Core Version:    0.7.0.1
 */