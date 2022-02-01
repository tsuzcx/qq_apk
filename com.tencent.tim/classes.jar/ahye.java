import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.a;

public class ahye
  extends RecyclerView.OnScrollListener
  implements aiad.a
{
  private aiad a = new aiad(200, this);
  private EmotionPanelListView.a b;
  private int mLastState = 0;
  
  public ahye(EmotionPanelListView.a parama)
  {
    this.b = parama;
  }
  
  public void Ib(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b != null))
    {
      this.b.cZu();
      this.a.KQ(false);
    }
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.a.KQ(true);
    }
    for (;;)
    {
      return false;
      if ((i == 1) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.b != null)) {
        this.b.cZv();
      }
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      AbstractGifImage.resumeAll();
    }
    for (;;)
    {
      if ((paramInt == 0) && (this.mLastState == 2) && (((GridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0) && (this.b != null)) {
        this.b.cZv();
      }
      this.mLastState = paramInt;
      return;
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      this.a.onMove(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahye
 * JD-Core Version:    0.7.0.1
 */