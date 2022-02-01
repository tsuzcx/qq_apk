package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.token.go.a;
import com.tencent.token.ik;

public class AppCompatSeekBar
  extends SeekBar
{
  private final ik a = new ik(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, go.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ik localik = this.a;
    Drawable localDrawable = localik.c;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localik.b.getDrawableState()))) {
      localik.b.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    ik localik = this.a;
    if (localik.c != null) {
      localik.c.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        ik localik = this.a;
        if (localik.c != null)
        {
          int k = localik.b.getMax();
          int j = 1;
          if (k > 1)
          {
            i = localik.c.getIntrinsicWidth();
            int m = localik.c.getIntrinsicHeight();
            if (i < 0) {
              break label203;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localik.c.setBounds(-i, -j, i, j);
            float f = (localik.b.getWidth() - localik.b.getPaddingLeft() - localik.b.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localik.b.getPaddingLeft(), localik.b.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localik.c.draw(paramCanvas);
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