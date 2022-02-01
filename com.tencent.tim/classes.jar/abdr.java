import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abdr
  implements View.OnClickListener
{
  abdr(abdq paramabdq, zpo.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.b.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a.jumpUrl);
    localIntent.putExtra("isShowAd", false);
    this.b.mContext.startActivity(localIntent);
    if ((this.b.mContext instanceof AvatarPendantActivity)) {
      ((AvatarPendantActivity)this.b.mContext).Ll = -1L;
    }
    if (this.val$index == 1) {
      VasWebviewUtil.reportCommercialDrainage("", "faceaddon", "0X8008486", "", 1, 0, 0, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.b.mApp, "CliOper", "", "", "0X8006334", "0X8006334", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdr
 * JD-Core Version:    0.7.0.1
 */