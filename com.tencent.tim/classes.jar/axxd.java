import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.NestedScrollingParentLayout;

public class axxd
  extends RecyclerView.OnScrollListener
{
  private boolean bel;
  
  public axxd(NestedScrollingParentLayout paramNestedScrollingParentLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (NestedScrollingParentLayout.a(this.b) != NestedScrollingParentLayout.c(this.b)) {}
    while ((paramInt != 0) || (!this.bel)) {
      return;
    }
    this.bel = false;
    paramRecyclerView = NestedScrollingParentLayout.c(this.b).getLayoutManager();
    paramRecyclerView = NestedScrollingParentLayout.b(this.b).a(paramRecyclerView);
    NestedScrollingParentLayout.b(this.b, NestedScrollingParentLayout.c(this.b).getChildAdapterPosition(paramRecyclerView));
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "onScrollStateChanged onScrolled dx " + paramInt);
    }
    paramRecyclerView = NestedScrollingParentLayout.a(this.b).a(NestedScrollingParentLayout.b(this.b).getLayoutManager());
    paramRecyclerView.setTargetPosition(NestedScrollingParentLayout.b(this.b));
    NestedScrollingParentLayout.b(this.b).getLayoutManager().startSmoothScroll(paramRecyclerView);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NestedScrollingParentLayout", 2, "onScrolled dx +=" + paramInt1);
    }
    if (NestedScrollingParentLayout.a(this.b) != NestedScrollingParentLayout.c(this.b)) {}
    while ((NestedScrollingParentLayout.b(this.b) >= 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    this.bel = true;
    paramInt1 = (int)(paramInt1 * NestedScrollingParentLayout.a(this.b));
    NestedScrollingParentLayout.b(this.b).scrollBy(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxd
 * JD-Core Version:    0.7.0.1
 */