import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apxs
  implements View.OnClickListener
{
  public apxs(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.a.this$0.ecE();
    apxr localapxr = this.a.a.this$0;
    localapxr.dXR += 1;
    if (this.a.a.this$0.aYG)
    {
      this.a.a.this$0.aYG = false;
      this.a.a.this$0.a(this.a.a.c, this.a.a.c.frienduin, this.a.a.c.interactId, this.a.a.c.animationPackageId, this.a.a.this$0.dXR, false);
    }
    if (this.a.a.this$0.dXR % 5 == 0) {
      this.a.a.this$0.a.Ud(this.a.a.c.animationPackageId + "");
    }
    anot.a(null, "dc00899", "Grp_flower", "", "inter_gift", "clk_ball", 0, 0, this.a.a.c.frienduin, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxs
 * JD-Core Version:    0.7.0.1
 */