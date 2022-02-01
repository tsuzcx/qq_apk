import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class unk
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  unk(ung paramung, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ung.a(this.jdField_a_of_type_Ung) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.dp2px(140.5F, ung.a(this.jdField_a_of_type_Ung).getResources());
      ung.a(this.jdField_a_of_type_Ung).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ung.b(this.jdField_a_of_type_Ung, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ung.a(this.jdField_a_of_type_Ung) > 500L)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = AIOUtils.dp2px(40.0F, ung.a(this.jdField_a_of_type_Ung).getResources());
      ung.a(this.jdField_a_of_type_Ung).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      ung.b(this.jdField_a_of_type_Ung, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unk
 * JD-Core Version:    0.7.0.1
 */