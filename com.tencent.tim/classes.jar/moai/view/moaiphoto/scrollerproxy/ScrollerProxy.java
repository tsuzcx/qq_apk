package moai.view.moaiphoto.scrollerproxy;

import android.content.Context;
import android.os.Build.VERSION;

public abstract class ScrollerProxy
{
  public static ScrollerProxy getScroller(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return new PreGingerScroller(paramContext);
    }
    if (Build.VERSION.SDK_INT < 14) {
      return new GingerScroller(paramContext);
    }
    return new IcsScroller(paramContext);
  }
  
  public abstract boolean computeScrollOffset();
  
  public abstract void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public abstract void forceFinished(boolean paramBoolean);
  
  public abstract int getCurrX();
  
  public abstract int getCurrY();
  
  public abstract boolean isFinished();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.scrollerproxy.ScrollerProxy
 * JD-Core Version:    0.7.0.1
 */