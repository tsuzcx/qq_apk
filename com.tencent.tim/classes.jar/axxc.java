import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.NestedScrollingParentLayout;

public class axxc
  extends RecyclerView.OnScrollListener
{
  private boolean bel;
  
  public axxc(NestedScrollingParentLayout paramNestedScrollingParentLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (NestedScrollingParentLayout.a(this.b) != NestedScrollingParentLayout.b(this.b)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 0) || (!this.bel));
      this.bel = false;
      paramRecyclerView = NestedScrollingParentLayout.b(this.b).getLayoutManager();
      paramRecyclerView = NestedScrollingParentLayout.a(this.b).a(paramRecyclerView);
      NestedScrollingParentLayout.a(this.b, NestedScrollingParentLayout.b(this.b).getChildAdapterPosition(paramRecyclerView));
    } while (NestedScrollingParentLayout.a(this.b) < 0);
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "mVideoItemListener onScrollStateChanged onScrolled dx " + paramInt);
    }
    paramRecyclerView = NestedScrollingParentLayout.b(this.b).a(NestedScrollingParentLayout.c(this.b).getLayoutManager());
    paramRecyclerView.setTargetPosition(NestedScrollingParentLayout.a(this.b));
    NestedScrollingParentLayout.c(this.b).getLayoutManager().startSmoothScroll(paramRecyclerView);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "mVideoItemListener onScrolled dx +=" + paramInt1);
    }
    if (NestedScrollingParentLayout.a(this.b) != NestedScrollingParentLayout.b(this.b)) {}
    while ((NestedScrollingParentLayout.a(this.b) >= 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    paramInt1 = (int)(paramInt1 / NestedScrollingParentLayout.a(this.b));
    NestedScrollingParentLayout.c(this.b).scrollBy(paramInt1, paramInt2);
    this.bel = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxc
 * JD-Core Version:    0.7.0.1
 */