package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.token.hg.a;
import com.tencent.token.jc;

public class AppCompatSeekBar
  extends SeekBar
{
  private final jc a = new jc(this);
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    jc localjc = this.a;
    Drawable localDrawable = localjc.c;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localjc.b.getDrawableState()))) {
      localjc.b.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    jc localjc = this.a;
    if (localjc.c != null) {
      localjc.c.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        jc localjc = this.a;
        if (localjc.c != null)
        {
          int k = localjc.b.getMax();
          int j = 1;
          if (k > 1)
          {
            i = localjc.c.getIntrinsicWidth();
            int m = localjc.c.getIntrinsicHeight();
            if (i < 0) {
              break label203;
            }
            i /= 2;
            if (m >= 0) {
              j = m / 2;
            }
            localjc.c.setBounds(-i, -j, i, j);
            float f = (localjc.b.getWidth() - localjc.b.getPaddingLeft() - localjc.b.getPaddingRight()) / k;
            j = paramCanvas.save();
            paramCanvas.translate(localjc.b.getPaddingLeft(), localjc.b.getHeight() / 2);
            i = 0;
            if (i <= k)
            {
              localjc.c.draw(paramCanvas);
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