import android.view.View;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class nk
  implements AdapterView.OnItemClickListener
{
  public nk(SearchActivity paramSearchActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getTag() != null)
    {
      paramAdapterView = (String)paramView.getTag();
      this.a.a(paramAdapterView);
      SearchProtocol.a(this.a.app, this.a, SearchActivity.a(this.a), paramAdapterView, SearchActivity.a(this.a));
      SearchActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nk
 * JD-Core Version:    0.7.0.1
 */