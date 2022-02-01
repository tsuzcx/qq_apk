import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.BannerManager.37.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class aaii
  implements View.OnClickListener
{
  aaii(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    aahb.a(this.this$0).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + aahb.a(this.this$0).app.getAccount(), false).commit();
    Object localObject = aahb.a(this.this$0)[21];
    ADView localADView;
    if ((localObject != null) && (((aagz)localObject).view != null))
    {
      localADView = (ADView)((aagz)localObject).view.findViewById(2131362278);
      if (localADView == null) {
        break label307;
      }
    }
    label307:
    for (localObject = localADView.a(0);; localObject = null)
    {
      if (localObject != null)
      {
        int j = ((ViewGroup)localObject).getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if (localView != null) {
            localLinkedList.add((anqr)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.getFileThreadHandler().post(new BannerManager.37.1(this, j, localLinkedList));
        if (localADView != null) {
          localADView.ehD();
        }
      }
      this.this$0.gm(21, 0);
      this.this$0.d(-1, null);
      this.this$0.bvG = false;
      anot.a(aahb.a(this.this$0).app, "dc00898", "", "", "0X80087C3", "0X80087C3", 0, 0, "", "", "", "");
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 12, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaii
 * JD-Core Version:    0.7.0.1
 */