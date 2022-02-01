import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajuc
  implements View.OnClickListener
{
  public ajuc(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.av != null) && (!this.this$0.isFinishing()))
    {
      this.this$0.av.dismiss();
      this.this$0.av = null;
      this.this$0.AF(acfp.m(2131708732));
      if (this.this$0.c == null) {
        this.this$0.c = ((ajrs)this.this$0.app.getBusinessHandler(60));
      }
      this.this$0.c.iO(NearbyPeopleProfileActivity.dmr, 5);
      this.this$0.uu("0X8005909");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuc
 * JD-Core Version:    0.7.0.1
 */