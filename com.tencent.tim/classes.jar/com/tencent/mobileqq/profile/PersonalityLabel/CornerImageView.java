package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.util.VersionUtils;

public class CornerImageView
  extends URLImageView
{
  public static ColorFilter d = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
  boolean cvO = false;
  private Path mPath;
  private RectF mTmpRectF = new RectF();
  private float[] radius = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  public CornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void bb(Canvas paramCanvas) {}
  
  protected void bc(Canvas paramCanvas) {}
  
  public void dEJ()
  {
    if (!VersionUtils.isKITKAT()) {
      setLayerType(1, null);
    }
  }
  
  protected void drawableStateChanged()
  {
    int k = 0;
    super.drawableStateChanged();
    if (!this.cvO) {}
    Object localObject;
    label83:
    do
    {
      return;
      localObject = getDrawableState();
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < localObject.length)
        {
          if (localObject[i] == 16842919) {
            j = 1;
          }
        }
        else
        {
          if (!(isPressed() | j)) {
            break label83;
          }
          localObject = getDrawable();
          if (localObject == null) {
            break;
          }
          ((Drawable)localObject).setColorFilter(d);
          ((Drawable)localObject).invalidateSelf();
          return;
        }
        i += 1;
      }
      localObject = getDrawable();
    } while (localObject == null);
    ((Drawable)localObject).setColorFilter(null);
    ((Drawable)localObject).invalidateSelf();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    int i = paramCanvas.save();
    try
    {
      Path localPath = this.mPath;
      RectF localRectF = this.mTmpRectF;
      localRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      localPath.reset();
      localPath.addRoundRect(localRectF, this.radius, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      bb(paramCanvas);
      super.onDraw(paramCanvas);
      bc(paramCanvas);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      super.onDraw(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void setPressMask(boolean paramBoolean)
  {
    this.cvO = paramBoolean;
  }
  
  public void setRadius(float paramFloat)
  {
    this.radius = new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat };
    dEJ();
  }
  
  public void setRadius(float[] paramArrayOfFloat)
  {
    this.radius = paramArrayOfFloat;
    dEJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView
 * JD-Core Version:    0.7.0.1
 */