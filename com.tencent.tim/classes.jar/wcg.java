import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wcg
  implements View.OnClickListener
{
  public wcg(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(aqrf.cww, acfp.m(2131715964));
    localBundle.putString(aqrf.cwx, "CJCLUBT");
    localBundle.putString(aqrf.cwv, "1450000516");
    localBundle.putInt(aqrf.cwt, 3);
    localBundle.putString(aqrf.cwz, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(aqrf.VIPTYPE, "svip");
    localBundle.putString(aqrf.cws, this.this$0.app.getCurrentAccountUin());
    aqrf.b(this.this$0.app, this.this$0, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcg
 * JD-Core Version:    0.7.0.1
 */