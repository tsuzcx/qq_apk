import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udp
  implements View.OnClickListener
{
  public udp(AddAccountActivity paramAddAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.pj != null) && (this.this$0.pj.isShown())) {
      this.this$0.pj.setVisibility(8);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    libsafeedit.clearPassBuffer();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udp
 * JD-Core Version:    0.7.0.1
 */