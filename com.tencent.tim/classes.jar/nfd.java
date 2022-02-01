import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class nfd
  implements AbsListView.e
{
  public nfd(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.a(new nff(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.this$0.a(new nfe(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nfd
 * JD-Core Version:    0.7.0.1
 */