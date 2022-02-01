import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahse
  implements View.OnClickListener
{
  ahse(ahsd paramahsd, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.b.jumpUrl)) {
      if (this.b.jumpUrl.startsWith("mqqapi://miniapp/")) {
        MiniAppLauncher.startMiniApp(this.a.mContext, this.b.jumpUrl, 2016, null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.a.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.b.jumpUrl);
      this.a.mContext.startActivity(localIntent);
      continue;
      if (!TextUtils.isEmpty(this.b.groupId)) {
        ahtz.bA(this.a.mContext, this.b.groupId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahse
 * JD-Core Version:    0.7.0.1
 */