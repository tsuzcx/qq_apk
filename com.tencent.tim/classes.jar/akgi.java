import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akgi
  implements View.OnClickListener
{
  akgi(akfk paramakfk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ausj localausj = ausj.b(this.this$0.a);
      if (this.val$pos != 0) {
        localausj.addButton(this.this$0.a.getResources().getString(2131696235));
      }
      localausj.addButton(acfp.m(2131708813));
      if (this.this$0.yi.size() > 1) {
        localausj.addButton(acfp.m(2131708896), 3);
      }
      localausj.addCancelButton(2131721058);
      localausj.a(new akgj(this, paramView, localPicInfo, localausj));
      localausj.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgi
 * JD-Core Version:    0.7.0.1
 */