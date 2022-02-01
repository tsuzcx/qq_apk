import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akex
  implements View.OnClickListener
{
  akex(akef paramakef) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.csb)
    {
      akef.b(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    Object localObject = sxx.getViewRect(paramView);
    int i = 0;
    label41:
    if (i < this.this$0.a.yi.size()) {
      if (localPicInfo.photoId != ((PicInfo)this.this$0.a.yi.get(i)).photoId) {}
    }
    for (;;)
    {
      this.this$0.a.a(i, (Rect)localObject);
      anot.a(this.this$0.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.this$0.a.mMode == 3) {}
      for (localObject = "2";; localObject = "1")
      {
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, (String)localObject, "", "", "");
        if (!ajqp.ba(this.this$0.a.e.bJa, this.this$0.a.mMode)) {
          break;
        }
        this.this$0.a.app.a().MM(localPicInfo.bSZ);
        break;
        i += 1;
        break label41;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akex
 * JD-Core Version:    0.7.0.1
 */