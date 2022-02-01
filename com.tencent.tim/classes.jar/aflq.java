import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aflq
  implements View.OnClickListener
{
  aflq(aflm paramaflm, IPSiteModel.Game paramGame, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, this.a.jumpUrl, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "IP", "aio_gameclk", "", 0, 0, 0, this.bDW, this.bDX, "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflq
 * JD-Core Version:    0.7.0.1
 */