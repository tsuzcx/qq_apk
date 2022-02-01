import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class umr
  implements View.OnClickListener
{
  public umr(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.this$0.a.setVisibility(8);
      if (this.this$0.mType == 0) {
        this.this$0.bJL();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.CC.setEnabled(true);
      if (this.this$0.D != null) {
        this.this$0.D.dismiss();
      }
      this.this$0.a.setVisibility(0);
      this.this$0.CE.setText(this.this$0.getString(2131693404));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */