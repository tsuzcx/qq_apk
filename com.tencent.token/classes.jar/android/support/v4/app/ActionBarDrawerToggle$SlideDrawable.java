package android.support.v4.app;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.Window;

class ActionBarDrawerToggle$SlideDrawable
  extends InsetDrawable
  implements Drawable.Callback
{
  private final boolean mHasMirroring;
  private float mOffset;
  private float mPosition;
  private final Rect mTmpRect;
  
  ActionBarDrawerToggle$SlideDrawable(ActionBarDrawerToggle paramActionBarDrawerToggle, Drawable paramDrawable)
  {
    super(paramDrawable, 0);
    if (Build.VERSION.SDK_INT > 18) {
      bool = true;
    }
    this.mHasMirroring = bool;
    this.mTmpRect = new Rect();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    int j = 1;
    copyBounds(this.mTmpRect);
    paramCanvas.save();
    if (ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = -1;
      }
      int k = this.mTmpRect.width();
      float f1 = -this.mOffset;
      float f2 = k;
      float f3 = this.mPosition;
      paramCanvas.translate(j * (f1 * f2 * f3), 0.0F);
      if ((i != 0) && (!this.mHasMirroring))
      {
        paramCanvas.translate(k, 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      super.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }
  
  public float getPosition()
  {
    return this.mPosition;
  }
  
  public void setOffset(float paramFloat)
  {
    this.mOffset = paramFloat;
    invalidateSelf();
  }
  
  public void setPosition(float paramFloat)
  {
    this.mPosition = paramFloat;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle.SlideDrawable
 * JD-Core Version:    0.7.0.1
 */