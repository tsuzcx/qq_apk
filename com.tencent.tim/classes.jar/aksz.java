import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aksz
  implements View.OnClickListener
{
  public aksz(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    aktm.L(AutoReplyEditActivity.a(this.this$0), false);
    String str2 = String.valueOf(AutoReplyEditActivity.a(this.this$0).getText());
    String str1;
    if (AutoReplyEditActivity.a(this.this$0) != null)
    {
      str1 = AutoReplyEditActivity.a(this.this$0).getRawText();
      if (str2.equals(str1)) {
        break label75;
      }
      AutoReplyEditActivity.a(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = "";
      break;
      label75:
      AutoReplyEditActivity.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksz
 * JD-Core Version:    0.7.0.1
 */