import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class mln
  extends RecyclerView.ItemDecoration
{
  private final SparseArray<mln.a> al = new SparseArray();
  private final Paint mPaint = new Paint(1);
  
  public mln()
  {
    this.mPaint.setStyle(Paint.Style.FILL);
  }
  
  public static final mln.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static final mln.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mln.a locala = new mln.a();
    locala.aTE = paramInt5;
    paramInt5 = (paramInt3 - 1) * paramInt4 / paramInt3;
    int i = paramInt4 - paramInt5;
    locala.top = paramInt4;
    if (paramInt1 % paramInt3 == 0) {
      locala.right = paramInt5;
    }
    while (paramInt1 / paramInt3 == paramInt2 / paramInt3)
    {
      locala.bottom = paramInt4;
      return locala;
      if ((paramInt1 + 1) % paramInt3 == 0)
      {
        locala.left = paramInt5;
      }
      else
      {
        locala.left = i;
        locala.right = i;
      }
    }
    locala.bottom = 0;
    return locala;
  }
  
  @Nullable
  public abstract mln.a a(int paramInt, @NotNull RecyclerView paramRecyclerView);
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    paramView.setTag(Integer.valueOf(i));
    paramView = a(i, paramRecyclerView);
    if (paramView != null) {
      paramRect.set(paramView.left, paramView.top, paramView.right, paramView.bottom);
    }
    for (paramRect = paramView;; paramRect = new mln.a())
    {
      this.al.put(i, paramRect);
      return;
    }
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      int k = ((Integer)paramState.getTag()).intValue();
      mln.a locala = (mln.a)this.al.get(k);
      this.mPaint.setColor(locala.aTE);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      k = paramState.getBottom() + localLayoutParams.bottomMargin;
      int m = paramState.getLeft() - localLayoutParams.leftMargin;
      int n = paramState.getRight() + localLayoutParams.rightMargin;
      int i1 = paramState.getTop() - localLayoutParams.topMargin;
      paramCanvas.drawRect(m - locala.left, k, locala.right + n, locala.bottom + k, this.mPaint);
      paramCanvas.drawRect(m - locala.left, i1 - locala.top, locala.right + n, i1, this.mPaint);
      paramCanvas.drawRect(m - locala.left, i1, m, k, this.mPaint);
      paramCanvas.drawRect(n, i1, locala.right + n, k, this.mPaint);
      i += 1;
    }
  }
  
  public static final class a
  {
    int aTE = -16777216;
    int bottom;
    int left;
    int right;
    int top;
    
    public String toString()
    {
      return "Decoration{left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ", decorationColor=" + this.aTE + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mln
 * JD-Core Version:    0.7.0.1
 */