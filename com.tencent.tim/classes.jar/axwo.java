import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView.a;

public abstract class axwo
  extends SpeedFlexibleRecyclerView.a
{
  SpeedFlexibleRecyclerView c;
  private Scroller l;
  private final RecyclerView.OnScrollListener mScrollListener = new axwp(this);
  
  private boolean a(@NonNull RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    LinearSmoothScroller localLinearSmoothScroller = a(paramLayoutManager);
    if (localLinearSmoothScroller == null) {}
    do
    {
      return false;
      paramInt1 = a(paramLayoutManager, paramInt1, paramInt2);
    } while (paramInt1 == -1);
    localLinearSmoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(localLinearSmoothScroller);
    return true;
  }
  
  private void destroyCallbacks()
  {
    this.c.removeOnScrollListener(this.mScrollListener);
    this.c.setOnFlingListener(null);
  }
  
  private void setupCallbacks()
    throws IllegalStateException
  {
    if (this.c.a() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.c.addOnScrollListener(this.mScrollListener);
    this.c.setOnFlingListener(this);
  }
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  @Nullable
  public LinearSmoothScroller a(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new axwq(this, this.c.getContext());
  }
  
  @Nullable
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public void a(@Nullable SpeedFlexibleRecyclerView paramSpeedFlexibleRecyclerView)
    throws IllegalStateException
  {
    if (this.c == paramSpeedFlexibleRecyclerView) {}
    do
    {
      return;
      if (this.c != null) {
        destroyCallbacks();
      }
      this.c = paramSpeedFlexibleRecyclerView;
    } while (this.c == null);
    setupCallbacks();
    this.l = new Scroller(this.c.getContext(), new DecelerateInterpolator());
    eOZ();
  }
  
  @Nullable
  public abstract int[] a(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView);
  
  public void eOZ()
  {
    if (this.c == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.c.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.LayoutManager)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.LayoutManager)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.c.smoothScrollBy(localObject[0], localObject[1]);
  }
  
  public int[] f(int paramInt1, int paramInt2)
  {
    this.l.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.l.getFinalX(), this.l.getFinalY() };
  }
  
  public boolean s(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.c.getLayoutManager();
    if (localLayoutManager == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (this.c.getAdapter() == null);
      i = this.c.getMinFlingVelocity();
    } while (((Math.abs(paramInt2) <= i) && (Math.abs(paramInt1) <= i)) || (!a(localLayoutManager, paramInt1, paramInt2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwo
 * JD-Core Version:    0.7.0.1
 */