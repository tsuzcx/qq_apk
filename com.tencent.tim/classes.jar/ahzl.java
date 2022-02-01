import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView.a;

public class ahzl
  extends RecyclerView.OnScrollListener
{
  public ahzl(HotPicRecyclerView paramHotPicRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      ahzp.drz();
      this.b.drv();
      if (paramInt != 2) {
        break label128;
      }
      this.b.b.KQ(true);
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.b.mLastState == 2))
      {
        ((StaggeredGridLayoutManager)this.b.getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.b.lD);
        if ((this.b.lD[0] == 0) && (this.b.a != null)) {
          this.b.a.cZv();
        }
      }
      this.b.mLastState = paramInt;
      return;
      this.b.drw();
      AbstractGifImage.pauseAll();
      ahzp.dry();
      break;
      label128:
      this.b.b.KQ(false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.b.b.onMove(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzl
 * JD-Core Version:    0.7.0.1
 */