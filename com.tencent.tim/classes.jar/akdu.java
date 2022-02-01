import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class akdu
  implements View.OnClickListener
{
  akdu(akcx paramakcx) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo;
    Object localObject;
    int i;
    int j;
    if ((paramView.getTag() instanceof PicInfo))
    {
      localPicInfo = (PicInfo)paramView.getTag();
      localObject = sxx.getViewRect(paramView);
      i = 0;
      if (i >= this.this$0.a.yi.size()) {
        break label280;
      }
      if (akcx.a(this.this$0).nowUserType != 0) {
        break label233;
      }
      if (localPicInfo.photoId != ((PicInfo)this.this$0.a.yi.get(i)).photoId) {
        break label266;
      }
      j = i;
    }
    for (;;)
    {
      label87:
      this.this$0.a.a(j, (Rect)localObject);
      anot.a(this.this$0.a.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
      if (this.this$0.a.mMode == 3) {}
      for (localObject = "2";; localObject = "1")
      {
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_pic", 0, 0, (String)localObject, "", "", "");
        if (ajqp.ba(this.this$0.a.e.bJa, this.this$0.a.mMode)) {
          this.this$0.a.app.a().MM(localPicInfo.bSZ);
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label233:
        j = i;
        if (TextUtils.equals(localPicInfo.bSZ, ((PicInfo)this.this$0.a.yi.get(i)).bSZ)) {
          break label87;
        }
        label266:
        i += 1;
        break;
      }
      label280:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdu
 * JD-Core Version:    0.7.0.1
 */