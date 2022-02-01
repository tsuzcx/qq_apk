import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.c;

public class soa
  implements DialogInterface.OnShowListener
{
  public soa(TroopGiftPanel.c paramc) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ((InputMethodManager)this.a.this$0.getContext().getSystemService("input_method")).showSoftInput(this.a.aj, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soa
 * JD-Core Version:    0.7.0.1
 */