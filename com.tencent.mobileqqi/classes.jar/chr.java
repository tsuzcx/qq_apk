import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class chr
  implements View.OnClickListener
{
  public chr(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.a.b.setVisibility(8);
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.i();
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.b.setVisibility(0);
    this.a.c.setText(this.a.getString(2131562452));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chr
 * JD-Core Version:    0.7.0.1
 */