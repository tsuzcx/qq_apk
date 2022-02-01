import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aanb
  implements View.OnClickListener
{
  public aanb(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.pj != null) && (this.this$0.pj.isShown())) {
      this.this$0.pj.setVisibility(8);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    LoginView.c(this.this$0);
    libsafeedit.clearPassBuffer();
    LoginView.d(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanb
 * JD-Core Version:    0.7.0.1
 */