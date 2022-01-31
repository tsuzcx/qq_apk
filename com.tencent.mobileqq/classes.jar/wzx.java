import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class wzx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  wzx(wzt paramwzt) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.d.getMeasuredWidth();
    i = (int)(this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() - i - bbdv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F));
    this.a.c.setMaxWidth(i);
    this.a.c.setText(new ayjw(this.a.jdField_a_of_type_Azpg.h, 16).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzx
 * JD-Core Version:    0.7.0.1
 */