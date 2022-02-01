import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.a;

public class ofy
  implements XRecyclerView.a
{
  public ofy(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ooz.d("WSRecommendFragment", "startLoadMore");
    ((omy.a)this.this$0.b()).b(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    ooz.d("WSRecommendFragment", "startTopRefresh");
    if (WSRecommendFragment.a(this.this$0)) {
      WSRecommendFragment.a(this.this$0, false);
    }
    do
    {
      return;
      if (!WSRecommendFragment.b(this.this$0)) {
        WSRecommendFragment.b(this.this$0, true);
      }
      WSRecommendFragment.a(this.this$0, System.currentTimeMillis());
      ((omy.a)this.this$0.b()).b(true, false, "");
    } while (WSRecommendFragment.c(this.this$0));
    ((omy.a)this.this$0.b()).pL("");
  }
  
  public void aCB()
  {
    ooz.d("WSRecommendFragment", "endOfRefresh");
    this.this$0.b.exW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofy
 * JD-Core Version:    0.7.0.1
 */