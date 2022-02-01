import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class tzi
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  tzi(tze paramtze, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - tze.a(this.jdField_a_of_type_Tze) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.dp2px(140.5F, tze.a(this.jdField_a_of_type_Tze).getResources());
      tze.a(this.jdField_a_of_type_Tze).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      tze.b(this.jdField_a_of_type_Tze, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - tze.a(this.jdField_a_of_type_Tze) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.dp2px(40.0F, tze.a(this.jdField_a_of_type_Tze).getResources());
      tze.a(this.jdField_a_of_type_Tze).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      tze.b(this.jdField_a_of_type_Tze, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */