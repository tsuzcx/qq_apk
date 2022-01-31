import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.tencent.biz.PoiMapActivity;

class jy
  implements Runnable
{
  jy(jx paramjx) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentBizPoiMapActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jy
 * JD-Core Version:    0.7.0.1
 */