import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchActivity.SearchAsociatedWordAdapter;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.lebasearch.SearchResultAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class nh
  implements SearchProtocol.SearchObserver
{
  public nh(SearchActivity paramSearchActivity) {}
  
  public void a(int paramInt, SearchProtocol.WordItem paramWordItem) {}
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList.add(0, SearchActivity.a(this.a).getText().toString());
      if (SearchActivity.b(this.a).a() != null) {
        break label79;
      }
      paramArrayList = new SearchActivity.SearchAsociatedWordAdapter(this.a, paramArrayList);
      SearchActivity.b(this.a).setAdapter(paramArrayList);
    }
    for (;;)
    {
      SearchActivity.a(this.a, 3);
      return;
      label79:
      if ((SearchActivity.b(this.a).a() instanceof HeaderViewListAdapter)) {
        ((SearchActivity.SearchAsociatedWordAdapter)((HeaderViewListAdapter)SearchActivity.b(this.a).a()).getWrappedAdapter()).a(paramArrayList);
      } else {
        ((SearchActivity.SearchAsociatedWordAdapter)SearchActivity.b(this.a).a()).a(paramArrayList);
      }
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "hot words size: " + paramList.size());
      }
      SearchActivity.b(this.a, paramList);
      paramList = this.a;
      if (SearchActivity.a(this.a) != 1) {
        break label73;
      }
    }
    for (;;)
    {
      SearchActivity.b(paramList, bool);
      return;
      label73:
      bool = false;
    }
  }
  
  public void a(int paramInt, JSONArray paramJSONArray)
  {
    SearchActivity.a(this.a, false);
    if ((paramInt == 0) && (paramJSONArray != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "results: " + paramJSONArray.toString());
      }
      if (paramJSONArray.length() != 0)
      {
        SearchActivity.a(this.a).setVisibility(8);
        SearchActivity.a(this.a).setVisibility(0);
        if (SearchActivity.a(this.a).a() == null)
        {
          paramJSONArray = new SearchResultAdapter(this.a, SearchActivity.a(this.a), paramJSONArray);
          SearchActivity.a(this.a).setAdapter(paramJSONArray);
        }
      }
    }
    for (;;)
    {
      SearchActivity.a(this.a, 2);
      return;
      if ((SearchActivity.a(this.a).a() instanceof HeaderViewListAdapter))
      {
        ((SearchResultAdapter)((HeaderViewListAdapter)SearchActivity.a(this.a).a()).getWrappedAdapter()).a(paramJSONArray);
      }
      else
      {
        ((SearchResultAdapter)SearchActivity.b(this.a).a()).a(paramJSONArray);
        continue;
        SearchActivity.a(this.a).setVisibility(8);
        SearchActivity.a(this.a).setVisibility(0);
        continue;
        SearchActivity.a(this.a).setVisibility(8);
        SearchActivity.a(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nh
 * JD-Core Version:    0.7.0.1
 */