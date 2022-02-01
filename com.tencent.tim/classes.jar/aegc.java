import SummaryCard.CondFitUser;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity.a;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.List;

public class aegc
  implements accv.d
{
  public aegc(SearchResultActivity paramSearchResultActivity) {}
  
  public void b(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    if (paramInt == 3) {
      if (!paramBoolean1)
      {
        this.a.cai = 3;
        this.a.a.notifyDataSetChanged();
      }
    }
    while (paramInt != 2)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.a.yP.addAll(paramList);
      }
      paramList = this.a;
      if (paramBoolean2) {}
      for (paramInt = i;; paramInt = 0)
      {
        paramList.cai = paramInt;
        break;
      }
    }
    if (paramBoolean1)
    {
      aqfp.Sz(true);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.yP.clear();
        this.a.yP.addAll(paramList);
      }
      this.a.a.notifyDataSetChanged();
      aqfp.Sz(false);
      SearchResultActivity.a(this.a).tT(0);
      paramList = Message.obtain();
      paramList.what = 5;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
      return;
    }
    SearchResultActivity.a(this.a).tT(1);
    paramList = Message.obtain();
    paramList.what = 4;
    SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegc
 * JD-Core Version:    0.7.0.1
 */