import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akee
  implements View.OnClickListener
{
  akee(akcx paramakcx, String paramString) {}
  
  public void onClick(View paramView)
  {
    anov localanov = new anov(this.this$0.a.app).b("grp_lbs").c("data_card").d("live_clk").e(akcx.a(this.this$0).uin);
    Object localObject;
    if (akcx.a(this.this$0).gender == 0)
    {
      localObject = "1";
      localanov.a(new String[] { localObject }).report();
      if (!TextUtils.isEmpty(this.val$jumpUrl)) {
        break label129;
      }
      QLog.i("NearbyProfileDisplayPanel", 1, "jumpUrl is empty");
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
      label129:
      if (this.val$jumpUrl.startsWith("mqqapi:"))
      {
        localObject = aqik.c(this.this$0.a.app, this.this$0.mContext, this.val$jumpUrl);
        if (localObject != null) {
          ((aqhv)localObject).ace();
        } else {
          QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.val$jumpUrl);
        }
      }
      else
      {
        localObject = new Intent(this.this$0.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.val$jumpUrl);
        this.this$0.a.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akee
 * JD-Core Version:    0.7.0.1
 */