import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class acy
  implements View.OnClickListener
{
  public acy(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.h();
      }
      return;
    }
    ChatHistory.a(this.a).setEnabled(true);
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.getString(2131362785));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     acy
 * JD-Core Version:    0.7.0.1
 */