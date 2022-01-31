import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class xif
  implements View.OnClickListener
{
  public xif(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    try
    {
      DialogUtil.b(BannerManager.a(this.a), 0, null, "确认关闭游戏？", 2131433015, 2131433016, new xig(this), new xih(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xif
 * JD-Core Version:    0.7.0.1
 */