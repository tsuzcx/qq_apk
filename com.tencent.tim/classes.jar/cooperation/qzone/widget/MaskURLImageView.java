package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class MaskURLImageView
  extends URLImageView
{
  private boolean MS;
  private float fx;
  private float fy;
  private float fz;
  private int num;
  Paint paint;
  private float textSize;
  
  static
  {
    if (!MaskURLImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public MaskURLImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void M(Canvas paramCanvas)
  {
    if (this.MS) {
      drawPlayIcon(paramCanvas);
    }
    while (this.num <= 0) {
      return;
    }
    paramCanvas.drawColor(1711276032);
    int i = (int)(this.paint.measureText(String.valueOf(this.num)) + this.fy + this.fx);
    int j = (getWidth() - i) / 2;
    int k = (int)((getHeight() - this.fx) / 2.0F);
    int m = (int)(j + this.fx);
    int n = (int)(k + this.fx);
    Object localObject = this.paint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f2 = ((Paint.FontMetrics)localObject).top;
    f1 = (getHeight() - (f1 - f2)) / 2.0F;
    f2 = ((Paint.FontMetrics)localObject).top;
    localObject = getResources().getDrawable(2130848569);
    assert (localObject != null);
    ((Drawable)localObject).setBounds(j, k, m, n);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.drawText(String.valueOf(this.num), i + j, f1 - f2, this.paint);
  }
  
  private void drawPlayIcon(Canvas paramCanvas)
  {
    int i = (int)((getWidth() - this.fz) / 2.0F);
    int j = (int)((getHeight() - this.fz) / 2.0F);
    Drawable localDrawable = getResources().getDrawable(2130849182);
    if (localDrawable != null)
    {
      localDrawable.setBounds(i, j, (int)(i + this.fz), (int)(j + this.fz));
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void init()
  {
    this.paint = new Paint();
    this.paint.setColor(-1);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.textSize = TypedValue.applyDimension(2, 18.0F, localDisplayMetrics);
    this.fy = TypedValue.applyDimension(1, 4.0F, localDisplayMetrics);
    this.fx = TypedValue.applyDimension(1, 12.0F, localDisplayMetrics);
    this.fz = TypedValue.applyDimension(1, 28.0F, localDisplayMetrics);
    this.paint.setTextSize(this.textSize);
    this.paint.setAntiAlias(true);
    this.paint.setTextAlign(Paint.Align.RIGHT);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    M(paramCanvas);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setHasMore(int paramInt)
  {
    this.num = paramInt;
    invalidate();
  }
  
  public void setNeedSowPlayIcon(boolean paramBoolean)
  {
    this.MS = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.MaskURLImageView
 * JD-Core Version:    0.7.0.1
 */