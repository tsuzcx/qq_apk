import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.widget.ListView;

public class amne
  extends amlv<amqa, amzk>
{
  public amne(MessageSearchDetailFragment paramMessageSearchDetailFragment, ListView paramListView, aqdf paramaqdf, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramaqdf, paramSearchResultItem, paramString, paramQQAppInterface);
  }
  
  protected amsq a(int paramInt)
  {
    return new amtl(MessageSearchDetailFragment.a(this.a));
  }
  
  protected amxz a(int paramInt, ViewGroup paramViewGroup)
  {
    return new amzk(paramViewGroup, 2131563040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amne
 * JD-Core Version:    0.7.0.1
 */