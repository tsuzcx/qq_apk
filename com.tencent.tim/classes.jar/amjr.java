import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class amjr
  implements View.OnClickListener
{
  amjr(amjp paramamjp) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    int i = amjp.a(this.this$0, this.this$0.FD, l);
    if (i == -1) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SearchHistory localSearchHistory = (SearchHistory)((amjz)this.this$0.FD.get(i)).R();
      if (localSearchHistory != null)
      {
        amxk.b("home_page", "del_history", new String[] { "" + i });
        ThreadManager.postImmediately(new HistorySearchEntryModel.2.1(this, localSearchHistory, l), null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjr
 * JD-Core Version:    0.7.0.1
 */