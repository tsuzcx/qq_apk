package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

@Deprecated
public class Space
  extends View
{
  @Deprecated
  public Space(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @Deprecated
  public Space(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (getVisibility() == 0) {
      setVisibility(4);
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i != -2147483648)
    {
      paramInt2 = paramInt1;
      if (i != 0)
      {
        if (i != 1073741824) {
          return paramInt1;
        }
        return j;
      }
    }
    else
    {
      paramInt2 = Math.min(paramInt1, j);
    }
    return paramInt2;
  }
  
  @Deprecated
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  @Deprecated
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(getSuggestedMinimumWidth(), paramInt1), a(getSuggestedMinimumHeight(), paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.Space
 * JD-Core Version:    0.7.0.1
 */