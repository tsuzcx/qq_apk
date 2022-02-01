package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.token.gs.a;
import com.tencent.token.io;

public class AppCompatSeekBar
  extends SeekBar
{
  private final io a = new io(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gs.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    io localio = this.a;
    Drawable localDrawable = localio.c;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localio.b.getDrawableState()))) {
      localio.b.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    io localio = this.a;
    if (localio.c != null) {
      localio.c.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        io localio = this.a;
        if (localio.c != null)
        {
          int k = localio.b.getMax();
          int j = 1;
          if (k > 1)
          {
            i = localio.c.getIntrinsicWidth();
            int m = localio.c.getIntrinsicHeight();
            if (i < 0) {
              break label203;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localio.c.setBounds(-i, -j, i, j);
            float f = (localio.b.getWidth() - localio.b.getPaddingLeft() - localio.b.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localio.b.getPaddingLeft(), localio.b.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localio.c.draw(paramCanvas);
              paramCanvas.translate(f, 0.0F);
              i += 1;
              continue;
            }
            paramCanvas.restoreToCount(j);
          }
        }
        return;
      }
      finally {}
      label203:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSeekBar
 * JD-Core Version:    0.7.0.1
 */