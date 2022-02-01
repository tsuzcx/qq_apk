package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.token.gp.a;
import com.tencent.token.il;

public class AppCompatSeekBar
  extends SeekBar
{
  private final il a = new il(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gp.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    il localil = this.a;
    Drawable localDrawable = localil.c;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localil.b.getDrawableState()))) {
      localil.b.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    il localil = this.a;
    if (localil.c != null) {
      localil.c.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        il localil = this.a;
        if (localil.c != null)
        {
          int k = localil.b.getMax();
          int j = 1;
          if (k > 1)
          {
            i = localil.c.getIntrinsicWidth();
            int m = localil.c.getIntrinsicHeight();
            if (i < 0) {
              break label203;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localil.c.setBounds(-i, -j, i, j);
            float f = (localil.b.getWidth() - localil.b.getPaddingLeft() - localil.b.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localil.b.getPaddingLeft(), localil.b.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localil.c.draw(paramCanvas);
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