import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yig
  implements View.OnClickListener
{
  yig(yif paramyif, int paramInt) {}
  
  public void onClick(View paramView)
  {
    yif.a(this.this$0, 2);
    yif.a(this.this$0).ciA();
    anot.a(yif.a(this.this$0), "P_CliOper", "Safe_AntiFraud", yif.a(this.this$0).aTl, "banner", "userclick", this.alR, 0, "", "", "", "");
    Object localObject1 = (Bundle)aqfz.a().a("SecWarningCfg", "BannerURL", 146, this.alR);
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getString("BannerURL");; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "https://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
      }
      if (this.alR == 1) {}
      for (localObject1 = ((String)localObject2).replace("$SUBAPP$", "notice");; localObject1 = ((String)localObject2).replace("$SUBAPP$", "tips"))
      {
        localObject1 = ((String)localObject1).replace("$SYSTEM$", "android").replace("$EVILUIN$", yif.a(this.this$0).aTl).replace("$USERUIN$", yif.a(this.this$0).getAccount());
        localObject2 = BaseActivity.sTopActivity;
        Intent localIntent = new Intent((Context)localObject2, QQBrowserDelegationActivity.class);
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("url", (String)localObject1);
        ((Context)localObject2).startActivity(localIntent);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */