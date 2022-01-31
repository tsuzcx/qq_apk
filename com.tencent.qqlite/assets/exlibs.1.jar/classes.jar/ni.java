import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class ni
  implements ActiveSearchTipsContainer.OnTipClickListener
{
  public ni(SearchActivity paramSearchActivity) {}
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      SearchActivity.a(this.a, 3);
      this.a.a(paramString);
      SearchProtocol.a(this.a.app, this.a, SearchActivity.a(this.a), paramString, SearchActivity.a(this.a));
      SearchActivity.a(this.a, true);
      Iterator localIterator = SearchActivity.b(this.a).iterator();
      while (localIterator.hasNext())
      {
        SearchProtocol.WordItem localWordItem = (SearchProtocol.WordItem)localIterator.next();
        if (paramString.equals(localWordItem.a))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004AB4", "0X8004AB4", 0, 0, localWordItem.b, null, null, null);
          SearchActivity.a(this.a, localWordItem.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ni
 * JD-Core Version:    0.7.0.1
 */