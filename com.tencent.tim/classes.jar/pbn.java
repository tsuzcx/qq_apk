import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class pbn
  implements RecyclerView.OnItemTouchListener
{
  private int mInitialTouchX;
  private int mInitialTouchY;
  
  pbn(pbm parampbm) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int j;
    int k;
    do
    {
      return false;
      this.mInitialTouchX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mInitialTouchY = ((int)(paramMotionEvent.getY() + 0.5F));
      return false;
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.mInitialTouchX;
      k = i - this.mInitialTouchY;
      i = (int)((i - this.mInitialTouchY) * 0.6F);
    } while (pbm.a(this.b, paramMotionEvent));
    if ((Math.abs(j) > pbm.a(this.b)) && (Math.abs(j) >= Math.abs(i))) {}
    for (int i = 1; i != 0; i = 0)
    {
      pbm.a(this.b, j, k);
      return false;
    }
    pbm.b(this.b, j, k);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbn
 * JD-Core Version:    0.7.0.1
 */