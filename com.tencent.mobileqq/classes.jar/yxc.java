import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;

public class yxc
  implements PopupWindow.OnDismissListener
{
  public yxc(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842853);
    if (CustomMenuBar.a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131165996));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = true;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131165995));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxc
 * JD-Core Version:    0.7.0.1
 */