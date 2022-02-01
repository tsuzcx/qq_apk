import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aawq
  implements View.OnClickListener
{
  public aawq(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.bAB) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(2130772000, 2130772001);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.this$0.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawq
 * JD-Core Version:    0.7.0.1
 */