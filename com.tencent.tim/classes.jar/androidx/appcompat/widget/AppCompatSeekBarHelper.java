package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import b.a;

class AppCompatSeekBarHelper
  extends AppCompatProgressBarHelper
{
  private boolean mHasTickMarkTint = false;
  private boolean mHasTickMarkTintMode = false;
  private Drawable mTickMark;
  private ColorStateList mTickMarkTintList = null;
  private PorterDuff.Mode mTickMarkTintMode = null;
  private final SeekBar mView;
  
  AppCompatSeekBarHelper(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.mView = paramSeekBar;
  }
  
  private void applyTickMarkTint()
  {
    if ((this.mTickMark != null) && ((this.mHasTickMarkTint) || (this.mHasTickMarkTintMode)))
    {
      this.mTickMark = DrawableCompat.wrap(this.mTickMark.mutate());
      if (this.mHasTickMarkTint) {
        DrawableCompat.setTintList(this.mTickMark, this.mTickMarkTintList);
      }
      if (this.mHasTickMarkTintMode) {
        DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
      }
      if (this.mTickMark.isStateful()) {
        this.mTickMark.setState(this.mView.getDrawableState());
      }
    }
  }
  
  void drawTickMarks(Canvas paramCanvas)
  {
    int j = 1;
    if (this.mTickMark != null)
    {
      int k = this.mView.getMax();
      if (k > 1)
      {
        int i = this.mTickMark.getIntrinsicWidth();
        int m = this.mTickMark.getIntrinsicHeight();
        if (i >= 0) {
          i /= 2;
        }
        for (;;)
        {
          if (m >= 0) {
            j = m / 2;
          }
          this.mTickMark.setBounds(-i, -j, i, j);
          float f = (this.mView.getWidth() - this.mView.getPaddingLeft() - this.mView.getPaddingRight()) / k;
          j = paramCanvas.save();
          paramCanvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
          i = 0;
          while (i <= k)
          {
            this.mTickMark.draw(paramCanvas);
            paramCanvas.translate(f, 0.0F);
            i += 1;
          }
          i = 1;
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  void drawableStateChanged()
  {
    Drawable localDrawable = this.mTickMark;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(this.mView.getDrawableState()))) {
      this.mView.invalidateDrawable(localDrawable);
    }
  }
  
  @Nullable
  Drawable getTickMark()
  {
    return this.mTickMark;
  }
  
  @Nullable
  ColorStateList getTickMarkTintList()
  {
    return this.mTickMarkTintList;
  }
  
  @Nullable
  PorterDuff.Mode getTickMarkTintMode()
  {
    return this.mTickMarkTintMode;
  }
  
  void jumpDrawablesToCurrentState()
  {
    if (this.mTickMark != null) {
      this.mTickMark.jumpToCurrentState();
    }
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, b.a.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(b.a.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      this.mView.setThumb(localDrawable);
    }
    setTickMark(paramAttributeSet.getDrawable(b.a.AppCompatSeekBar_tickMark));
    if (paramAttributeSet.hasValue(b.a.AppCompatSeekBar_tickMarkTintMode))
    {
      this.mTickMarkTintMode = DrawableUtils.parseTintMode(paramAttributeSet.getInt(b.a.AppCompatSeekBar_tickMarkTintMode, -1), this.mTickMarkTintMode);
      this.mHasTickMarkTintMode = true;
    }
    if (paramAttributeSet.hasValue(b.a.AppCompatSeekBar_tickMarkTint))
    {
      this.mTickMarkTintList = paramAttributeSet.getColorStateList(b.a.AppCompatSeekBar_tickMarkTint);
      this.mHasTickMarkTint = true;
    }
    paramAttributeSet.recycle();
    applyTickMarkTint();
  }
  
  void setTickMark(@Nullable Drawable paramDrawable)
  {
    if (this.mTickMark != null) {
      this.mTickMark.setCallback(null);
    }
    this.mTickMark = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this.mView);
      DrawableCompat.setLayoutDirection(paramDrawable, ViewCompat.getLayoutDirection(this.mView));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.mView.getDrawableState());
      }
      applyTickMarkTint();
    }
    this.mView.invalidate();
  }
  
  void setTickMarkTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.mTickMarkTintList = paramColorStateList;
    this.mHasTickMarkTint = true;
    applyTickMarkTint();
  }
  
  void setTickMarkTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mTickMarkTintMode = paramMode;
    this.mHasTickMarkTintMode = true;
    applyTickMarkTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSeekBarHelper
 * JD-Core Version:    0.7.0.1
 */