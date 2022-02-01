import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.widget.pull2refresh.XRecyclerView;

public class ukk
  implements bjxz
{
  public ukk(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a()
  {
    uya.b("WSRecommendFragment", "endOfRefresh");
    this.a.a.d();
  }
  
  public void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    uya.b("WSRecommendFragment", "startLoadMore");
    ((uuy)this.a.b()).a(false, false, "");
  }
  
  public void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    uya.b("WSRecommendFragment", "startTopRefresh");
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
      ((uuy)this.a.b()).a(true, false, "");
    } while (WSRecommendFragment.c(this.a));
    ((uuy)this.a.b()).a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukk
 * JD-Core Version:    0.7.0.1
 */