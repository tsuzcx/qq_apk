import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahsc
  implements View.OnClickListener
{
  ahsc(ahsb paramahsb, FeedsItemData paramFeedsItemData) {}
  
  public void onClick(View paramView)
  {
    if (this.b.jumpUrl.startsWith("mqqapi://miniapp/")) {
      MiniAppLauncher.startMiniApp(this.a.itemView.getContext(), this.b.jumpUrl, 2016, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.a.itemView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.b.jumpUrl);
      this.a.itemView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsc
 * JD-Core Version:    0.7.0.1
 */