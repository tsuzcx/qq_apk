import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arrm
  implements View.OnClickListener
{
  public arrm(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - OpenAuthorityFragment.d(this.this$0) > 1000L)
    {
      OpenAuthorityFragment.a(this.this$0).Kb.setClickable(false);
      Intent localIntent = new Intent();
      localIntent.putExtra("appid", OpenAuthorityFragment.a(this.this$0));
      localIntent.putExtra("key_proxy_appid", OpenAuthorityFragment.c(this.this$0));
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.b.startForResult(this.this$0.getActivity(), localIntent, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
      OpenAuthorityFragment.a(this.this$0).Kb.setClickable(true);
    }
    OpenAuthorityFragment.b(this.this$0, System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrm
 * JD-Core Version:    0.7.0.1
 */