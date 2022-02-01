import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yjs
  implements View.OnClickListener
{
  private long lastClickTime;
  
  yjs(yjr paramyjr) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.lastClickTime < 200L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.lastClickTime = l;
      this.b.a.ciA();
      Object localObject = new Intent(yjr.a(this.b), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("hide_left_button", false);
      ((Intent)localObject).putExtra("show_right_close_button", false);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      String str = aqqj.o(yjr.a(this.b), "call", "mvip.gongneng.anroid.individuation.web");
      VasWebviewUtil.openQQBrowserWithoutAD(yjr.a(this.b), str, 524288L, (Intent)localObject, false, -1);
      VipUtils.a(this.b.app, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
      localObject = this.b.app.getPreferences().edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_tip_" + this.b.mFriendUin, 4);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjs
 * JD-Core Version:    0.7.0.1
 */