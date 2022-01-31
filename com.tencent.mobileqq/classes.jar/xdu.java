import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;

public class xdu
  implements PopupWindow.OnDismissListener
{
  public xdu(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842656);
    if (CustomMenuBar.a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131165957));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = true;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable, 50L);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131165956));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xdu
 * JD-Core Version:    0.7.0.1
 */