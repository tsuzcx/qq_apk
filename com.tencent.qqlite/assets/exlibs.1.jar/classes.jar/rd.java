import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;

public class rd
  implements PopupWindow.OnDismissListener
{
  public rd(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838352);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131427443));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = true;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     rd
 * JD-Core Version:    0.7.0.1
 */