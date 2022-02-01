import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class akfi
  implements View.OnClickListener
{
  akfi(akef paramakef, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.this$0.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.bTn + "&type" + akef.a(this.this$0).gender);
    String str = acfp.m(2131708797);
    if (this.this$0.a.mMode != 2) {
      if (akef.a(this.this$0).gender == 0)
      {
        str = acfp.m(2131708866);
        ((Intent)localObject).putExtra("title", str + acfp.m(2131708917));
        this.this$0.a.startActivity((Intent)localObject);
        localObject = this.this$0.a.app;
        if (this.this$0.a.mMode != 2) {
          break label275;
        }
      }
    }
    label275:
    for (str = "1";; str = "2")
    {
      anot.a((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, str, "", "", "");
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = acfp.m(2131708900);
        break;
        if (this.this$0.a.app != null) {
          break label230;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
      }
      label230:
      ((ajpj)this.this$0.a.app.getManager(106)).go.put(this.this$0.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */