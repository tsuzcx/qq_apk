import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vnp
  implements View.OnClickListener
{
  public vnp(QQBroadcastActivity.a parama, aevp paramaevp, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.a.bCl;
    Object localObject1 = this.a.bCm;
    if ((((String)localObject2).equals("TMTWAPI")) || (((String)localObject2).equals("WAPI")))
    {
      localObject1 = aehp.h((String)localObject1, 0, null);
      localObject2 = new Intent(this.b.a, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("uin", this.b.a.app.getCurrentAccountUin());
      this.b.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    }
    for (;;)
    {
      this.v.edit().putBoolean(this.val$key, true).commit();
      this.b.a.handler.sendEmptyMessageDelayed(1010, 1000L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((String)localObject2).equals("TMTWAP")) || (((String)localObject2).equals("WAP")))
      {
        localObject2 = new Intent(this.b.a, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.b.a.app.getCurrentAccountUin());
        this.b.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
      }
      else if (((String)localObject2).equals("LOCAL"))
      {
        if ("CARD".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.a.bCn.split(",")[0];
          if (("".equals(localObject1)) || (this.b.a.app.getCurrentAccountUin().equals(localObject1))) {}
          for (localObject1 = new ProfileActivity.AllInOne(this.b.a.app.getCurrentAccountUin(), 0);; localObject1 = new ProfileActivity.AllInOne((String)localObject1, 19))
          {
            ProfileActivity.b(this.b.a, (ProfileActivity.AllInOne)localObject1);
            break;
          }
        }
        if ("CHAT".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = this.a.bCn.split(",")[0];
          if (!"".equals(localObject1)) {
            if (((acff)this.b.a.app.getManager(51)).isFriend((String)localObject1)) {
              this.b.E((String)localObject1, 0, aqgv.o(this.b.a.app, (String)localObject1));
            } else {
              this.b.E((String)localObject1, 1001, aqgv.o(this.b.a.app, (String)localObject1));
            }
          }
        }
        else if ("NEARBY".equalsIgnoreCase((String)localObject1))
        {
          this.b.a.startActivity(new Intent(this.b.a, NearbyActivity.class));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */