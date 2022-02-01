import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uuw
  implements CompoundButton.OnCheckedChangeListener
{
  public uuw(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.enableTalkBack)
    {
      localObject1 = this.this$0.getString(2131694514);
      DiscussionInfoCardActivity.b(this.this$0).setContentDescription((CharSequence)localObject1);
    }
    boolean bool2 = DiscussionInfoCardActivity.a(this.this$0).a(this.this$0.a);
    Object localObject1 = DiscussionInfoCardActivity.a(this.this$0);
    Object localObject2 = this.this$0.a;
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      ((acdt)localObject1).a((DiscussionInfo)localObject2, bool1);
      localObject2 = new anov(this.this$0.app).a("dc00899").b("Grp_Dis_set").c("Dis_info");
      if (!bool2) {
        break label145;
      }
    }
    label145:
    for (localObject1 = "Clk_unstick";; localObject1 = "Clk_stick")
    {
      ((anov)localObject2).d((String)localObject1).report();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuw
 * JD-Core Version:    0.7.0.1
 */