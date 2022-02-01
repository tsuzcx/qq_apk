import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class uds
  implements bksw
{
  public uds(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    upe.b("WSRecommendFragment", "endOfRefresh");
    this.a.a.d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    upe.b("WSRecommendFragment", "startLoadMore");
    ((umg)this.a.b()).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    upe.b("WSRecommendFragment", "startTopRefresh");
    if (WSRecommendFragment.a(this.a)) {
      WSRecommendFragment.a(this.a, false);
    }
    do
    {
      return;
      if (!WSRecommendFragment.b(this.a)) {
        WSRecommendFragment.b(this.a, true);
      }
      WSRecommendFragment.a(this.a, System.currentTimeMillis());
      ((umg)this.a.b()).a(true, false, "");
    } while (WSRecommendFragment.c(this.a));
    ((umg)this.a.b()).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uds
 * JD-Core Version:    0.7.0.1
 */