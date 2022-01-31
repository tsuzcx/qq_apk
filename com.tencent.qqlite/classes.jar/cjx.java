import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.widget.ADView;
import java.util.LinkedList;
import java.util.List;

public class cjx
  implements View.OnClickListener
{
  public cjx(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a(this.a).getSharedPreferences("QQLite", 0).edit().putBoolean("push_banner_display" + BannerManager.a(this.a).app.getAccount(), false).commit();
    paramView = BannerManager.a(this.a)[12];
    ADView localADView;
    if ((paramView != null) && (paramView.a != null))
    {
      localADView = (ADView)paramView.a.findViewById(2131297449);
      if (localADView == null) {
        break label224;
      }
    }
    label224:
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
        ThreadManager.a().post(new cjy(this, j, localLinkedList));
        if (localADView != null) {
          localADView.a();
        }
      }
      this.a.a(12, 0);
      this.a.a(null);
      this.a.b = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjx
 * JD-Core Version:    0.7.0.1
 */