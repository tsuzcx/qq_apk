import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class adg
  implements DialogInterface.OnClickListener
{
  public adg(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ChatHistory.a(this.a).setEnabled(false);
      this.a.e();
      ReportController.b(this.a.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    ChatHistory.a(this.a).setEnabled(true);
    this.a.c.dismiss();
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.getString(2131362785));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adg
 * JD-Core Version:    0.7.0.1
 */