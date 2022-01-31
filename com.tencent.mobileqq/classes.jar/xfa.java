import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class xfa
  implements View.OnClickListener
{
  public xfa(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    try
    {
      DialogUtil.b(BannerManager.a(this.a), 0, null, "确认关闭游戏？", 2131432998, 2131432999, new xfb(this), new xfc(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfa
 * JD-Core Version:    0.7.0.1
 */