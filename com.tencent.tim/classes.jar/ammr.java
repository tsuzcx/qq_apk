import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.a;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.b;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ammr
  implements View.OnClickListener
{
  public ammr(AssociateSearchWordsFragment.b paramb, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.b.getActivity();
    if ((this.a.b.getActivity() instanceof AssociateSearchWordsFragment.a))
    {
      localObject = (AssociateSearchWordsFragment.a)localObject;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      amub.a(null, new ReportModelDC02528().module("all_search").action("clk_frame_up").ver1(this.caT).ver2("kandian").ver3(UniteSearchActivity.caO).ver4(this.a.b.wz).ver5(this.val$position / 2 + 1 + "").ver6(UniteSearchActivity.caN).session_id(UniteSearchActivity.mSessionId));
    }
    for (;;)
    {
      if (localObject != null) {
        ((AssociateSearchWordsFragment.a)localObject).PM(this.caT);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AssociateSearchWordsFragment.a(this.a.b) != null) {
        localObject = AssociateSearchWordsFragment.a(this.a.b);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ammr
 * JD-Core Version:    0.7.0.1
 */