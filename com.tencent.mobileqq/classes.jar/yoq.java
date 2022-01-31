import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class yoq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  yoq(yom paramyom) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.d.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - bdcq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.c.setMaxWidth(i);
    this.a.c.setText(new bahs(this.a.jdField_a_of_type_Bbnp.h, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoq
 * JD-Core Version:    0.7.0.1
 */