import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment.11.1;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ahno
  implements View.OnClickListener
{
  public ahno(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    double d2 = 0.0D;
    int i = paramView.getId();
    if (i == 2131366480)
    {
      localObject1 = akks.dm();
      localObject1 = new akkq(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (ArrayList)localObject1);
      ((akkq)localObject1).a(this.this$0.a);
      ((akkq)localObject1).e(aqcx.dip2px(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), aqcx.dip2px(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.this$0.Do.getHeight(), 0.2F);
      new anov(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").report();
      ajrk.a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
    }
    while (i != 2131374939)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    ajvd localajvd = this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject1 = localajvd.a(10);
    akjs localakjs = new akjs();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get()).intValue();
      }
      catch (Exception localException1)
      {
        try
        {
          localakjs.b((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          QLog.d("nearby.redpoint", 1, "click red info, isOfficialNotify=" + localakjs.cst + " redContentType = " + localakjs.content_type + " redTopicId = " + localakjs.bTC);
          localObject1 = localajvd.b();
          if ((localObject1 == null) || (((akju)localObject1).dmY != i)) {
            break label630;
          }
          Intent localIntent = new Intent(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          if (i != 1) {
            break label561;
          }
          if (localakjs.content_type != 2) {
            break label532;
          }
          localObject1 = "https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=" + akjr.xE();
          localIntent.putExtra("url", (String)localObject1);
          QLog.d("nearby.redpoint", 1, "click OfficialNotify, url" + (String)localObject1);
          this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          akjq.a().a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_click");
          localajvd.Ru(38);
          this.this$0.mHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
          ajrk.a(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
          anot.a(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)ajrb.c(this.this$0.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            continue;
            double d1 = 0.0D;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      localException1.printStackTrace();
      continue;
      label532:
      localObject2 = "https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=" + localakjs.bTC;
      continue;
      label561:
      localObject2 = aczc.a("nearby_recommend");
      if ((localObject2 != null) && (((SosoInterface.SosoLbsInfo)localObject2).a != null))
      {
        d2 = ((SosoInterface.SosoLbsInfo)localObject2).a.cd;
        d1 = ((SosoInterface.SosoLbsInfo)localObject2).a.ce;
        localObject2 = "https://nearby.qq.com/h5/helper/index.html?_wv=3&_bid=4234&latitude=$LATITUDE$&longitude=$LONGITUDE$".replace("$LATITUDE$", String.valueOf(d2)).replace("$LONGITUDE$", String.valueOf(d1));
        continue;
        label630:
        localObject2 = new Intent(this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
        this.this$0.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject2);
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahno
 * JD-Core Version:    0.7.0.1
 */