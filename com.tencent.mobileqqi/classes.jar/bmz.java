import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.tencent.biz.PoiMapActivity;

class bmz
  implements Runnable
{
  bmz(bmy parambmy) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.b = false;
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmz
 * JD-Core Version:    0.7.0.1
 */