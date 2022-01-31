import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.tencent.biz.PoiMapActivity;

public class jx
  implements DialogInterface.OnDismissListener
{
  public jx(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHandler().postDelayed(new jy(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jx
 * JD-Core Version:    0.7.0.1
 */