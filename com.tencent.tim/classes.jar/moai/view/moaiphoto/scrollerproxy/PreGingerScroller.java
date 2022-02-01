package moai.view.moaiphoto.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

public class PreGingerScroller
  extends ScrollerProxy
{
  private final Scroller mScroller;
  
  public PreGingerScroller(Context paramContext)
  {
    this.mScroller = new Scroller(paramContext);
  }
  
  public boolean computeScrollOffset()
  {
    return this.mScroller.computeScrollOffset();
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void forceFinished(boolean paramBoolean)
  {
    this.mScroller.forceFinished(paramBoolean);
  }
  
  public int getCurrX()
  {
    return this.mScroller.getCurrX();
  }
  
  public int getCurrY()
  {
    return this.mScroller.getCurrY();
  }
  
  public boolean isFinished()
  {
    return this.mScroller.isFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.scrollerproxy.PreGingerScroller
 * JD-Core Version:    0.7.0.1
 */