import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.4.1;
import com.tencent.mobileqq.widget.QQMapView;

public class jnd
  implements DialogInterface.OnDismissListener
{
  public jnd(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PoiMapActivity.d(this.this$0).setEnabled(false);
    this.this$0.mRootView.getHandler().postDelayed(new PoiMapActivity.4.1(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnd
 * JD-Core Version:    0.7.0.1
 */