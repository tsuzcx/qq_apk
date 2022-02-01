import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aawr
  implements View.OnClickListener
{
  public aawr(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.bAB) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      anot.a(this.this$0.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_cancel", 0, 0, "", "" + this.this$0.cmn, "", "");
      this.this$0.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.this$0.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawr
 * JD-Core Version:    0.7.0.1
 */