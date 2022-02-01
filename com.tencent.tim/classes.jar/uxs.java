import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class uxs
  implements View.OnClickListener
{
  public uxs(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("key_forward_business_id");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      boolean bool = ((Intent)localObject1).hasExtra("file_send_path");
      uya.a(this.this$0.app, this.this$0, (Intent)localObject1, (String)localObject2, bool);
    }
    for (;;)
    {
      this.this$0.a.getExtras().putString("uin", "-1010");
      this.this$0.a.dnX();
      anot.a(this.this$0.app, "CliOper", "", "", "friendchoose", "0X800A2D7", ForwardRecentActivity.a(this.this$0), 0, "", "", "", ForwardRecentActivity.a(this.this$0));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_receiver_type", 3L);
      if ("caller_aecamera".equals(this.this$0.aNa)) {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", (Bundle)localObject1, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j = ((Intent)localObject1).getIntExtra("req_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->addQZoneEntry--onClick--req_type = " + j);
      }
      Bundle localBundle = ((Intent)localObject1).getExtras();
      localObject2 = localBundle.getString("image_url_remote");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localBundle.getString("image_url");
      }
      localObject2 = new ArrayList();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(";");
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i]));
          i += 1;
        }
      }
      localBundle.putStringArrayList("image_url", (ArrayList)localObject2);
      localBundle.putString("share_action", "shareToQQ");
      localBundle.putString("jfrom", "login");
      localBundle.putBoolean("thirdPartShare", true);
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
      avqq.a(this.this$0.app, this.this$0, localBundle, null);
      localObject1 = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject1).actionType = "1";
      ((QZoneClickReport.a)localObject1).cMI = "0";
      ((QZoneClickReport.a)localObject1).tabletype = 4;
      ((QZoneClickReport.a)localObject1).sourceType = "5";
      ((QZoneClickReport.a)localObject1).sourceFrom = "thirdApp";
      ((QZoneClickReport.a)localObject1).sourceTo = "activefeed";
      QZoneClickReport.startReportImediately(this.this$0.app.getAccount(), (QZoneClickReport.a)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "5");
      ((HashMap)localObject1).put("source_from", "thirdApp");
      ((HashMap)localObject1).put("source_to", "activefeed");
      anpc.a(this.this$0.getApplicationContext()).collectPerformance(this.this$0.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      if (this.this$0.isSdkShare)
      {
        arts.a().a(this.this$0.app.getAccount(), "", this.this$0.appid, "1000", "33", "0", false, this.this$0.isSdkShare);
        if ((this.this$0.a instanceof ahki))
        {
          localObject1 = (ahki)this.this$0.a;
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("report_type", "102");
          ((Bundle)localObject2).putString("act_type", "81");
          ((Bundle)localObject2).putString("intext_1", "" + artv.b.kK(((ahki)localObject1).cZW));
          ((Bundle)localObject2).putString("intext_2", "" + artv.b.u(-1, acbn.blE));
          ((Bundle)localObject2).putString("intext_3", "0");
          arts.a().a((Bundle)localObject2, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare);
        }
      }
      if ((!this.this$0.isSdkShare) || (j != 5)) {
        this.this$0.finish();
      } else {
        ForwardRecentActivity.i(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxs
 * JD-Core Version:    0.7.0.1
 */