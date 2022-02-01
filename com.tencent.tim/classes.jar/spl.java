import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class spl
{
  private RecyclerView.LayoutManager layoutManager;
  
  public spl(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    this.layoutManager = paramLayoutManager;
  }
  
  public View a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getViewForPosition(paramInt);
    this.layoutManager.addView(paramRecycler);
    this.layoutManager.measureChildWithMargins(paramRecycler, 0, 0);
    return paramRecycler;
  }
  
  public void a(View paramView, RecyclerView.Recycler paramRecycler)
  {
    paramRecycler.recycleView(paramView);
  }
  
  public void attachView(View paramView)
  {
    this.layoutManager.attachView(paramView);
  }
  
  public void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
  {
    this.layoutManager.detachAndScrapAttachedViews(paramRecycler);
  }
  
  public void detachAndScrapView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    this.layoutManager.detachAndScrapView(paramView, paramRecycler);
  }
  
  public void detachView(View paramView)
  {
    this.layoutManager.detachView(paramView);
  }
  
  public View getChildAt(int paramInt)
  {
    return this.layoutManager.getChildAt(paramInt);
  }
  
  public int getChildCount()
  {
    return this.layoutManager.getChildCount();
  }
  
  public int getHeight()
  {
    return this.layoutManager.getHeight();
  }
  
  public int getItemCount()
  {
    return this.layoutManager.getItemCount();
  }
  
  public int getPosition(View paramView)
  {
    return this.layoutManager.getPosition(paramView);
  }
  
  public int getWidth()
  {
    return this.layoutManager.getWidth();
  }
  
  public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    this.layoutManager.layoutDecorated(paramView, localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  public int m(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = this.layoutManager.getDecoratedMeasuredWidth(paramView);
    int j = localMarginLayoutParams.leftMargin;
    return localMarginLayoutParams.rightMargin + (i + j);
  }
  
  public int n(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = this.layoutManager.getDecoratedMeasuredHeight(paramView);
    int j = localMarginLayoutParams.topMargin;
    return localMarginLayoutParams.bottomMargin + (i + j);
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    this.layoutManager.offsetChildrenHorizontal(paramInt);
  }
  
  public void removeAllViews()
  {
    this.layoutManager.removeAllViews();
  }
  
  public void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
  {
    this.layoutManager.removeAndRecycleAllViews(paramRecycler);
  }
  
  public void requestLayout()
  {
    this.layoutManager.requestLayout();
  }
  
  public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    this.layoutManager.startSmoothScroll(paramSmoothScroller);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spl
 * JD-Core Version:    0.7.0.1
 */