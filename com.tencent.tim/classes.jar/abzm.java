import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment.ItemView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abzm
  implements View.OnClickListener
{
  public abzm(ApolloGameInfoFragment.ItemView paramItemView, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.val$openId)) && (this.val$openId != null))
    {
      String str = "https://lgame.qq.com/html/feedback/index?gameid=" + this.cub + "&_wv=2&openid=" + this.val$openId;
      Intent localIntent = new Intent(this.b.a.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(this.b.a.getActivity(), str, -1L, localIntent, false, -1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setGameIdAndOpenId] openId is null or is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzm
 * JD-Core Version:    0.7.0.1
 */