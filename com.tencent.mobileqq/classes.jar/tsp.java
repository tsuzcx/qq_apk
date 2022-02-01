import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class tsp
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  tsp(tsl paramtsl, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - tsl.a(this.jdField_a_of_type_Tsl) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = agej.a(140.5F, tsl.a(this.jdField_a_of_type_Tsl).getResources());
      tsl.a(this.jdField_a_of_type_Tsl).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      tsl.b(this.jdField_a_of_type_Tsl, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - tsl.a(this.jdField_a_of_type_Tsl) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = agej.a(40.0F, tsl.a(this.jdField_a_of_type_Tsl).getResources());
      tsl.a(this.jdField_a_of_type_Tsl).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      tsl.b(this.jdField_a_of_type_Tsl, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsp
 * JD-Core Version:    0.7.0.1
 */