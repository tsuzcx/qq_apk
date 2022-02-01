import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class vkz
  extends RecyclerView.OnScrollListener
{
  vkz(vks paramvks) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (vks.a(this.a) != null) && ((vks.a(this.a).getLayoutManager() instanceof LinearLayoutManager))) {
      vks.a(this.a, ((LinearLayoutManager)vks.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition());
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((vks.a(this.a) != null) && ((vks.a(this.a).getLayoutManager() instanceof LinearLayoutManager)))
    {
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)vks.a(this.a).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = vks.a(this.a).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          vks.c(this.a);
        }
        if ((paramInt1 == paramInt2 - 1) && (vks.a(this.a).a().a())) {
          vks.d(this.a);
        }
        vks.b(this.a, paramInt1);
      }
      return;
    }
    paramInt1 = ((LinearLayoutManager)vks.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    if (vks.a(this.a) == 0) {
      vks.d(this.a);
    }
    vks.b(this.a, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */