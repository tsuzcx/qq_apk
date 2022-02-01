import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zip
  implements View.OnClickListener
{
  public zip(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(aqrf.cww, acfp.m(2131703616));
    localBundle.putString(aqrf.cwx, "CJCLUBT");
    localBundle.putString(aqrf.cwv, "1450000516");
    localBundle.putInt(aqrf.cwt, 3);
    localBundle.putString(aqrf.cwz, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(aqrf.VIPTYPE, "svip");
    localBundle.putString(aqrf.cws, this.this$0.app.getCurrentAccountUin());
    aqrf.b(this.this$0.app, this.this$0.getActivity(), localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zip
 * JD-Core Version:    0.7.0.1
 */