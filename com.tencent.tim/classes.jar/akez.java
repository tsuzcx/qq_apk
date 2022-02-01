import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akez
  implements View.OnClickListener
{
  akez(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.a.onBackEvent())
    {
      this.this$0.a.finish();
      this.this$0.a.MJ(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akez
 * JD-Core Version:    0.7.0.1
 */