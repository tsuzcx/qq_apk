package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  private static final int MIN_DELAY = 500;
  private static final int MIN_SHOW_TIME = 500;
  private final Runnable mDelayedHide = new ContentLoadingProgressBar.1(this);
  private final Runnable mDelayedShow = new ContentLoadingProgressBar.2(this);
  boolean mDismissed = false;
  boolean mPostedHide = false;
  boolean mPostedShow = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void removeCallbacks()
  {
    removeCallbacks(this.mDelayedHide);
    removeCallbacks(this.mDelayedShow);
  }
  
  /* Error */
  public void hide()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 39	androidx/core/widget/ContentLoadingProgressBar:mDismissed	Z
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 51	androidx/core/widget/ContentLoadingProgressBar:mDelayedShow	Ljava/lang/Runnable;
    //   12: invokevirtual 56	androidx/core/widget/ContentLoadingProgressBar:removeCallbacks	(Ljava/lang/Runnable;)Z
    //   15: pop
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 37	androidx/core/widget/ContentLoadingProgressBar:mPostedShow	Z
    //   21: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   24: aload_0
    //   25: getfield 33	androidx/core/widget/ContentLoadingProgressBar:mStartTime	J
    //   28: lsub
    //   29: lstore_1
    //   30: lload_1
    //   31: ldc2_w 64
    //   34: lcmp
    //   35: ifge +14 -> 49
    //   38: aload_0
    //   39: getfield 33	androidx/core/widget/ContentLoadingProgressBar:mStartTime	J
    //   42: ldc2_w 30
    //   45: lcmp
    //   46: ifne +12 -> 58
    //   49: aload_0
    //   50: bipush 8
    //   52: invokevirtual 69	androidx/core/widget/ContentLoadingProgressBar:setVisibility	(I)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: getfield 35	androidx/core/widget/ContentLoadingProgressBar:mPostedHide	Z
    //   62: ifne -7 -> 55
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 46	androidx/core/widget/ContentLoadingProgressBar:mDelayedHide	Ljava/lang/Runnable;
    //   70: ldc2_w 64
    //   73: lload_1
    //   74: lsub
    //   75: invokevirtual 73	androidx/core/widget/ContentLoadingProgressBar:postDelayed	(Ljava/lang/Runnable;J)Z
    //   78: pop
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 35	androidx/core/widget/ContentLoadingProgressBar:mPostedHide	Z
    //   84: goto -29 -> 55
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	ContentLoadingProgressBar
    //   29	45	1	l	long
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	87	finally
    //   38	49	87	finally
    //   49	55	87	finally
    //   58	84	87	finally
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }
  
  public void show()
  {
    try
    {
      this.mStartTime = -1L;
      this.mDismissed = false;
      removeCallbacks(this.mDelayedHide);
      this.mPostedHide = false;
      if (!this.mPostedShow)
      {
        postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */