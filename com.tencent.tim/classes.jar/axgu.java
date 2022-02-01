import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import dov.com.qq.im.ae.play.AEPlayShowPageView;

public class axgu
  extends RecyclerView.ItemDecoration
{
  public axgu(AEPlayShowPageView paramAEPlayShowPageView, axgn.a parama) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (AEPlayShowPageView.a(this.this$0) != 1)
    {
      paramRect.left = this.d.itemHorizontalPadding;
      paramRect.right = this.d.itemHorizontalPadding;
      paramRect.top = this.d.eEQ;
      paramRect.bottom = this.d.eEQ;
      return;
    }
    paramRect.bottom = this.d.eEQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgu
 * JD-Core Version:    0.7.0.1
 */