import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.OnClickListener;

public class afid
  extends RecyclerView.LayoutManager
{
  private View.OnClickListener mListener;
  
  public afid(View.OnClickListener paramOnClickListener)
  {
    this.mListener = paramOnClickListener;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int i = getItemCount();
    int m;
    int j;
    int k;
    if (i > 3)
    {
      i = 3;
      if (i >= 0)
      {
        paramState = paramRecycler.getViewForPosition(i);
        addView(paramState);
        measureChildWithMargins(paramState, 0, 0);
        m = getWidth() - getDecoratedMeasuredWidth(paramState);
        j = getHeight() - getDecoratedMeasuredHeight(paramState);
        k = m / 2;
        m /= 2;
        layoutDecoratedWithMargins(paramState, k, j, getDecoratedMeasuredWidth(paramState) + m, getDecoratedMeasuredHeight(paramState) + j);
        if (i == 3)
        {
          paramState.setScaleX(1.0F - (i - 1) * 0.1F);
          paramState.setScaleY(1.0F - (i - 1) * 0.1F);
          paramState.setTranslationY((i - 1) * paramState.getMeasuredHeight() / -10);
          paramState.setAlpha(0.8F);
        }
        for (;;)
        {
          i -= 1;
          break;
          if (i > 0)
          {
            paramState.setScaleX(1.0F - i * 0.1F);
            paramState.setScaleY(1.0F - i * 0.1F);
            paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
            paramState.setAlpha(0.6F);
          }
          else if (this.mListener != null)
          {
            paramState.setOnClickListener(this.mListener);
          }
        }
      }
    }
    else
    {
      i -= 1;
      if (i >= 0)
      {
        paramState = paramRecycler.getViewForPosition(i);
        addView(paramState);
        measureChildWithMargins(paramState, 0, 0);
        m = getWidth() - getDecoratedMeasuredWidth(paramState);
        j = getHeight() - getDecoratedMeasuredHeight(paramState);
        k = m / 2;
        m /= 2;
        layoutDecoratedWithMargins(paramState, k, j, getDecoratedMeasuredWidth(paramState) + m, getDecoratedMeasuredHeight(paramState) + j);
        if (i > 0)
        {
          paramState.setScaleX(1.0F - i * 0.1F);
          paramState.setScaleY(1.0F - i * 0.1F);
          paramState.setTranslationY(paramState.getMeasuredHeight() * i / -10);
        }
        for (;;)
        {
          i -= 1;
          break;
          if (this.mListener != null) {
            paramState.setOnClickListener(this.mListener);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afid
 * JD-Core Version:    0.7.0.1
 */