import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.PopupMenu;
import com.tencent.mobileqq.statistics.ReportController;

public class rj
  implements View.OnClickListener
{
  public rj(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, PopupMenu paramPopupMenu, String paramString1, int paramInt, String paramString2) {}
  
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
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838362);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131427479));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
          ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0));
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
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838362);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131427479));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0));
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838362);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131427479));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupMenu = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
        ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     rj
 * JD-Core Version:    0.7.0.1
 */