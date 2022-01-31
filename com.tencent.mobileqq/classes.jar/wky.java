import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class wky
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  wky(wku paramwku) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.c.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - bacc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.b.setMaxWidth(i);
    this.a.b.setText(new axjq(this.a.jdField_a_of_type_Ayoo.g, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wky
 * JD-Core Version:    0.7.0.1
 */