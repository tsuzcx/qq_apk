import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class vnd
  extends RecyclerView.OnScrollListener
{
  vnd(vmw paramvmw) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 0) && (vmw.a(this.a) != null) && ((vmw.a(this.a).getLayoutManager() instanceof LinearLayoutManager))) {
      vmw.a(this.a, ((LinearLayoutManager)vmw.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition());
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((vmw.a(this.a) != null) && ((vmw.a(this.a).getLayoutManager() instanceof LinearLayoutManager)))
    {
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)vmw.a(this.a).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = vmw.a(this.a).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          vmw.d(this.a);
        }
        if ((paramInt1 == paramInt2 - 1) && (vmw.a(this.a).a().a())) {
          vmw.e(this.a);
        }
        vmw.b(this.a, paramInt1);
      }
      return;
    }
    paramInt1 = ((LinearLayoutManager)vmw.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    if (vmw.a(this.a) == 0) {
      vmw.e(this.a);
    }
    vmw.b(this.a, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnd
 * JD-Core Version:    0.7.0.1
 */