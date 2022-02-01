import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;

public class umw
  implements DialogInterface.OnClickListener
{
  public umw(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.this$0.CC.setEnabled(false);
      this.this$0.bJH();
      anot.a(this.this$0.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    this.this$0.CC.setEnabled(true);
    this.this$0.F.dismiss();
    if (this.this$0.D != null) {
      this.this$0.D.dismiss();
    }
    this.this$0.a.setVisibility(0);
    this.this$0.CE.setText(this.this$0.getString(2131693404));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */