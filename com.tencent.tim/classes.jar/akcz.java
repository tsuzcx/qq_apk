import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akcz
  implements View.OnClickListener
{
  akcz(akcx paramakcx, String paramString) {}
  
  public void onClick(View paramView)
  {
    anov localanov = new anov(this.this$0.a.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(akcx.a(this.this$0).uin);
    Object localObject;
    if (akcx.a(this.this$0).gender == 0)
    {
      localObject = "1";
      localanov.a(new String[] { localObject }).report();
      if (!this.val$jumpUrl.startsWith("mqqapi:")) {
        break label188;
      }
      localObject = aqik.c(this.this$0.a.app, this.this$0.mContext, this.val$jumpUrl);
      if (localObject == null) {
        break label157;
      }
      ((aqhv)localObject).ace();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (akcx.a(this.this$0).gender == 1)
      {
        localObject = "2";
        break;
      }
      localObject = "0";
      break;
      label157:
      QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.val$jumpUrl);
      continue;
      label188:
      localObject = new Intent(this.this$0.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.val$jumpUrl);
      this.this$0.a.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcz
 * JD-Core Version:    0.7.0.1
 */