import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wyo
  implements View.OnClickListener
{
  public wyo(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (abhh.aV(this.this$0.app.getApplication()))
    {
      ApolloUtil.a(paramView.getContext(), null, "aio", abxi.bju, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (!abhh.aW(this.this$0.app.getApplication())) {}
    for (String str = abxi.bjh;; str = abxi.bji + avcv.actionId)
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), str, -1L, localIntent, false, -1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */