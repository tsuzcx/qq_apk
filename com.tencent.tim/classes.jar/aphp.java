import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aphp
  implements View.OnClickListener
{
  public aphp(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a.jI(4) >= 6) {
      QQToast.a(this.this$0.getActivity(), String.format(acfp.m(2131710269), new Object[] { Integer.valueOf(6) }), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((InputMethodManager)this.this$0.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.this$0.eB.getWindowToken(), 0);
      this.this$0.a.aLz();
      SearchReciteArticleFragment.ci(this.this$0.getActivity(), this.this$0.mTroopUin);
      aqfr.b("Grp_edu", "Grp_recite", "Assign_Clk", 0, 0, new String[] { this.this$0.mTroopUin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphp
 * JD-Core Version:    0.7.0.1
 */