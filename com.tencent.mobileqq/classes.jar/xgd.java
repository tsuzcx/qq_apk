import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.widget.ADView;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class xgd
  implements View.OnClickListener
{
  public xgd(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + BannerManager.a(this.a).app.getAccount(), false).commit();
    paramView = BannerManager.a(this.a)[17];
    ADView localADView;
    if ((paramView != null) && (paramView.a != null))
    {
      localADView = (ADView)paramView.a.findViewById(2131365666);
      if (localADView == null) {
        break label258;
      }
    }
    label258:
    for (paramView = localADView.a(0);; paramView = null)
    {
      if (paramView != null)
      {
        int j = paramView.getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = paramView.getChildAt(i);
          if (localView != null) {
            localLinkedList.add((PushBanner)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.getFileThreadHandler().post(new xge(this, j, localLinkedList));
        if (localADView != null) {
          localADView.h();
        }
      }
      this.a.a(17, 0);
      this.a.a(-1, null);
      this.a.e = false;
      ReportController.b(BannerManager.a(this.a).app, "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgd
 * JD-Core Version:    0.7.0.1
 */