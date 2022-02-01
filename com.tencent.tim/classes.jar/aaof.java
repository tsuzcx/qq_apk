import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaof
  implements View.OnClickListener
{
  public aaof(TimLoginQQView paramTimLoginQQView) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.pj != null) && (this.this$0.pj.isShown())) {
      this.this$0.pj.setVisibility(8);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    TimLoginQQView.c(this.this$0);
    libsafeedit.clearPassBuffer();
    TimLoginQQView.d(this.this$0);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
    this.this$0.mK.setImageResource(2130851638);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaof
 * JD-Core Version:    0.7.0.1
 */