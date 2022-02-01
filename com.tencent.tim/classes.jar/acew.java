import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acew
  implements View.OnClickListener
{
  public acew(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((FrameHelperActivity.a(this.this$0) != null) && (FrameHelperActivity.a(this.this$0).isShowing())) {
      FrameHelperActivity.a(this.this$0).dismiss();
    }
    anot.a(this.val$app, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acew
 * JD-Core Version:    0.7.0.1
 */