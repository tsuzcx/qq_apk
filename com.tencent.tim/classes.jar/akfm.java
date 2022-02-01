import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akfm
  implements View.OnClickListener
{
  akfm(akfk paramakfk) {}
  
  public void onClick(View paramView)
  {
    int i = this.this$0.yi.size();
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.this$0.a;
    if (i >= NearbyPeopleProfileActivity.dmr) {
      QQToast.a(this.this$0.a, 0, this.this$0.a.getResources().getString(2131696219), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      akfk.c(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfm
 * JD-Core Version:    0.7.0.1
 */