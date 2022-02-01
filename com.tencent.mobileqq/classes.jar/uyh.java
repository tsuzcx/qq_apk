import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class uyh
  implements bljk
{
  public uyh(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    vmp.b("WSRecommendFragment", "endOfRefresh");
    this.a.a.d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    vmp.b("WSRecommendFragment", "startLoadMore");
    ((vjl)this.a.b()).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    vmp.b("WSRecommendFragment", "startTopRefresh");
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
      ((vjl)this.a.b()).a(true, false, "");
    } while (WSRecommendFragment.c(this.a));
    ((vjl)this.a.b()).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyh
 * JD-Core Version:    0.7.0.1
 */