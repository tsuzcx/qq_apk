import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class axpf
{
  public static class a
    extends RecyclerView.ItemDecoration
  {
    int eGu = 0;
    int eGv = 0;
    int eGw = 0;
    int eGx = 0;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.eGu = paramInt1;
      this.eGv = paramInt2;
      this.eGw = paramInt3;
      this.eGx = paramInt4;
    }
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      paramRect.left = this.eGu;
      paramRect.right = this.eGv;
      paramRect.bottom = this.eGx;
      paramRect.top = this.eGw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpf
 * JD-Core Version:    0.7.0.1
 */