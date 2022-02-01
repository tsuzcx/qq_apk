import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class ngq
  implements AbsListView.e
{
  public ngq(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.a(new ngs(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.this$0.a(new ngr(this, "onScrollStateChanged", paramAbsListView, paramInt));
    if ((kxm.AI()) && (paramInt != 0)) {
      txn.a().startMonitorScene("proteus_family_feeds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngq
 * JD-Core Version:    0.7.0.1
 */