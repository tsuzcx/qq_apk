import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.Map;

public class kgq
  extends nny
{
  private nhi b;
  private List<TabChannelCoverInfo> list;
  protected lce mObserver;
  private ViewGroup mRootView;
  
  public void E(Map<Integer, mgu> paramMap)
  {
    if (this.b != null) {
      this.b.J(paramMap);
    }
  }
  
  protected void aCG() {}
  
  public void e(ListView paramListView)
  {
    paramListView.addHeaderView(this.mRootView);
  }
  
  public void onDestroy()
  {
    this.list.clear();
    lcc.a().c(this.mObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgq
 * JD-Core Version:    0.7.0.1
 */