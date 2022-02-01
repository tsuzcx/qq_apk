import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xpi
  implements View.OnClickListener
{
  xpi(xpg paramxpg, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.mContext, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40303);
    String str = aqqj.o(this.a.mContext, "call", "mvip.gongneng.anroid.individuation.web");
    str = str + "&funcallId=" + this.bVT;
    VasWebviewUtil.openQQBrowserWithoutAD(this.a.mContext, str, 524288L, localIntent, true, -1);
    int i = ((acle)this.a.app.getBusinessHandler(13)).AX();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      anot.a(this.a.app, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpi
 * JD-Core Version:    0.7.0.1
 */