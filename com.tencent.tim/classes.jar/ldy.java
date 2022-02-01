import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class ldy
  extends StaggeredGridLayoutManager
{
  public ldy(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public boolean canScrollVertically()
  {
    return (this.this$0.a.aso) && (super.canScrollVertically());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldy
 * JD-Core Version:    0.7.0.1
 */