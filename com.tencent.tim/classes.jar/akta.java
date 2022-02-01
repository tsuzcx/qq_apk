import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akta
  implements View.OnClickListener
{
  public akta(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(View paramView)
  {
    aktm.L(AutoReplyEditActivity.a(this.this$0), true);
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:new_text", AutoReplyEditActivity.b(this.this$0));
    if (AutoReplyEditActivity.a(this.this$0) != null) {
      localIntent.putExtra("AutoReplyEditActivity:text", new AutoReplyText(AutoReplyText.trimRawString(String.valueOf(AutoReplyEditActivity.a(this.this$0).getText()), false), AutoReplyEditActivity.a(this.this$0).getTextId()));
    }
    this.this$0.getActivity().setResult(325, localIntent);
    this.this$0.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akta
 * JD-Core Version:    0.7.0.1
 */