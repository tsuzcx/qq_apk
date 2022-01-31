import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import java.lang.ref.WeakReference;

class eom
  implements DialogInterface.OnClickListener
{
  eom(eol parameol) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((TroopFileError.a != null) && (TroopFileError.a.get() != null)) {
      ((TroopFileError.TroopFileErrorObserver)TroopFileError.a.get()).a = 0;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eom
 * JD-Core Version:    0.7.0.1
 */