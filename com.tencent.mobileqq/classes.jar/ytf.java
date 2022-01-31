import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class ytf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ytf(ytb paramytb) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.d.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - bdgz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.c.setMaxWidth(i);
    this.a.c.setText(new bamb(this.a.jdField_a_of_type_Bbry.h, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytf
 * JD-Core Version:    0.7.0.1
 */