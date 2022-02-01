import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vxb
  implements View.OnClickListener
{
  public vxb(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.jdField_a_of_type_Aqzl != null)
    {
      this.this$0.jdField_a_of_type_Aqzl.a.cYn = false;
      this.this$0.jdField_a_of_type_Aqzl.a.aO = Boolean.valueOf(true);
      if (this.this$0.jdField_a_of_type_Arcd != null) {
        this.this$0.jdField_a_of_type_Arcd.ehp();
      }
    }
    this.this$0.onClick(this.this$0.jdField_a_of_type_Aqzl.rightViewImg);
    this.this$0.report(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxb
 * JD-Core Version:    0.7.0.1
 */