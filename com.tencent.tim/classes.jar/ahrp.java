import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahrp
  implements View.OnClickListener
{
  ahrp(ahrb.e parame, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.bLv.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.b.mContext, this.bLv, 2016, null);
    }
    for (;;)
    {
      tbb.a(abmt.getAppInterface(), "769", "205647", this.b.c.a().gameAppId, "76903", "1", "160", new String[] { "", "", "20" });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.b.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.bLv);
      this.b.mContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrp
 * JD-Core Version:    0.7.0.1
 */