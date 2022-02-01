import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.2.1;
import com.tencent.mobileqq.widget.NewStyleDropdownView.AutoCompleteView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class argh
  implements View.OnClickListener
{
  public argh(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.clearFocus();
    this.this$0.d.hideSoftInputFromWindow(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getWindowToken(), 0);
    boolean bool;
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter() != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount() > 0))
    {
      int i = this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount();
      if (i >= 5) {
        break label334;
      }
      int j = wja.dp2px(7.5F, this.this$0.getResources());
      int k = wja.dp2px(40.0F, this.this$0.getResources());
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(i * (j * 2 + k) + j * 2);
      Object localObject = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localObject != this.this$0.gc) {
          break label359;
        }
        bool = true;
        label177:
        QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.this$0.dab);
      }
      if ((localObject != this.this$0.gc) || (this.this$0.dab)) {
        break label365;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a.Cw(false);
      }
      NewStyleDropdownView.a(this.this$0).postDelayed(new NewStyleDropdownView.2.1(this, paramView), 500L);
      localObject = paramView.getContext();
      if ((localObject != null) && ((localObject instanceof LoginActivity))) {
        anot.c(((LoginActivity)localObject).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label334:
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(wja.dp2px(251.5F, this.this$0.getResources()));
      break;
      label359:
      bool = false;
      break label177;
      label365:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a.Cw(true);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.dismissDropDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argh
 * JD-Core Version:    0.7.0.1
 */