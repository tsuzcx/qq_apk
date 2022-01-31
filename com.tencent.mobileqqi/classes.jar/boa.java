import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.PopupMenu;

public class boa
  implements View.OnClickListener
{
  public boa(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, PopupMenu paramPopupMenu) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu == null)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838492);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131362088));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
          return;
        }
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu == this.jdField_a_of_type_ComTencentBizUiPopupMenu)
      {
        if (!this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838492);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131362088));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
          return;
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838492);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131362088));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     boa
 * JD-Core Version:    0.7.0.1
 */