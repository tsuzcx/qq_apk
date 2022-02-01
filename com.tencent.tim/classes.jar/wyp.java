import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class wyp
  implements View.OnClickListener
{
  public wyp(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.Rk()) {}
    Object localObject2;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject2 = (ApolloItemBuilder.b)wja.a(paramView);
    } while ((localObject2 == null) || (((ApolloItemBuilder.b)localObject2).mMessage == null) || (((ApolloItemBuilder.b)localObject2).ar == null));
    int i = ((ApolloItemBuilder.b)localObject2).mActionId;
    if ((paramView instanceof TextView))
    {
      ApolloBaseInfo localApolloBaseInfo;
      Object localObject3;
      int j;
      if (abhh.aV(this.this$0.app.getApplication()))
      {
        ApolloUtil.a(paramView.getContext(), null, "aio", abxi.bju, null);
        localObject1 = "1";
        localApolloBaseInfo = ((abhh)this.this$0.app.getManager(153)).a(this.this$0.app.getCurrentUin());
        localObject3 = this.this$0.app;
        i = ApolloUtil.gi(((ApolloItemBuilder.b)localObject2).mMessage.istroop);
        j = ((ApolloItemBuilder.b)localObject2).mActionId;
        if (localApolloBaseInfo != null) {
          break label324;
        }
      }
      label324:
      for (localObject2 = "0";; localObject2 = localApolloBaseInfo.apolloStatus + "")
      {
        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "clk_icon", i, 0, new String[] { String.valueOf(j), localObject2, localObject1, abhh.a(this.this$0.app) + "" });
        break;
        if (!abhh.aW(this.this$0.app.getApplication())) {}
        for (localObject1 = abxi.bjh;; localObject1 = abxi.bji + i)
        {
          localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject3, false, -1);
          localObject1 = "0";
          break;
        }
      }
    }
    if (new File(ApolloItemBuilder.a.cD(i)).exists()) {
      ApolloItemBuilder.a(this.this$0.mContext, ((ApolloItemBuilder.b)localObject2).ar, (MessageForApollo)((ApolloItemBuilder.b)localObject2).mMessage, this.this$0.sessionInfo);
    }
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VipUtils.a(this.this$0.app, "cmshow", "Apollo", "clk_gif", ApolloUtil.gi(((ApolloItemBuilder.b)localObject2).mMessage.istroop), 0, new String[] { String.valueOf(i), localObject1, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
      break;
      localObject1 = ((ApolloItemBuilder.b)localObject2).ar.getDrawable();
      if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)))
      {
        localObject1 = (URLDrawable)localObject1;
        if ((((URLDrawable)localObject1).getStatus() == 3) || (((URLDrawable)localObject1).getStatus() == 2))
        {
          if (!aqiw.isNetworkAvailable(paramView.getContext())) {
            break;
          }
          this.this$0.a((ApolloItemBuilder.b)localObject2, paramView.getResources(), true);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyp
 * JD-Core Version:    0.7.0.1
 */