import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.tencent.biz.PoiMapActivity;

public class bmy
  implements DialogInterface.OnDismissListener
{
  public bmy(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHandler().postDelayed(new bmz(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmy
 * JD-Core Version:    0.7.0.1
 */