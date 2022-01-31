package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;

class CircularProgressDrawable$Ring
{
  int mAlpha = 255;
  Path mArrow;
  int mArrowHeight;
  final Paint mArrowPaint = new Paint();
  float mArrowScale = 1.0F;
  int mArrowWidth;
  final Paint mCirclePaint = new Paint();
  int mColorIndex;
  int[] mColors;
  int mCurrentColor;
  float mEndTrim = 0.0F;
  final Paint mPaint = new Paint();
  float mRingCenterRadius;
  float mRotation = 0.0F;
  boolean mShowArrow;
  float mStartTrim = 0.0F;
  float mStartingEndTrim;
  float mStartingRotation;
  float mStartingStartTrim;
  float mStrokeWidth = 5.0F;
  final RectF mTempBounds = new RectF();
  
  CircularProgressDrawable$Ring()
  {
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mArrowPaint.setStyle(Paint.Style.FILL);
    this.mArrowPaint.setAntiAlias(true);
    this.mCirclePaint.setColor(0);
  }
  
  void draw(Canvas paramCanvas, Rect paramRect)
  {
    RectF localRectF = this.mTempBounds;
    float f1 = this.mRingCenterRadius + this.mStrokeWidth / 2.0F;
    if (this.mRingCenterRadius <= 0.0F) {
      f1 = Math.min(paramRect.width(), paramRect.height()) / 2.0F - Math.max(this.mArrowWidth * this.mArrowScale / 2.0F, this.mStrokeWidth / 2.0F);
    }
    localRectF.set(paramRect.centerX() - f1, paramRect.centerY() - f1, paramRect.centerX() + f1, f1 + paramRect.centerY());
    f1 = (this.mStartTrim + this.mRotation) * 360.0F;
    float f2 = (this.mEndTrim + this.mRotation) * 360.0F - f1;
    this.mPaint.setColor(this.mCurrentColor);
    this.mPaint.setAlpha(this.mAlpha);
    float f3 = this.mStrokeWidth / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, this.mCirclePaint);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, this.mPaint);
    drawTriangle(paramCanvas, f1, f2, localRectF);
  }
  
  void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, RectF paramRectF)
  {
    if (this.mShowArrow)
    {
      if (this.mArrow != null) {
        break label220;
      }
      this.mArrow = new Path();
      this.mArrow.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      float f1 = Math.min(paramRectF.width(), paramRectF.height()) / 2.0F;
      float f2 = this.mArrowWidth * this.mArrowScale / 2.0F;
      this.mArrow.moveTo(0.0F, 0.0F);
      this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0F);
      this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale / 2.0F, this.mArrowHeight * this.mArrowScale);
      this.mArrow.offset(f1 + paramRectF.centerX() - f2, paramRectF.centerY() + this.mStrokeWidth / 2.0F);
      this.mArrow.close();
      this.mArrowPaint.setColor(this.mCurrentColor);
      this.mArrowPaint.setAlpha(this.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(paramFloat1 + paramFloat2, paramRectF.centerX(), paramRectF.centerY());
      paramCanvas.drawPath(this.mArrow, this.mArrowPaint);
      paramCanvas.restore();
      return;
      label220:
      this.mArrow.reset();
    }
  }
  
  int getAlpha()
  {
    return this.mAlpha;
  }
  
  float getArrowHeight()
  {
    return this.mArrowHeight;
  }
  
  float getArrowScale()
  {
    return this.mArrowScale;
  }
  
  float getArrowWidth()
  {
    return this.mArrowWidth;
  }
  
  int getBackgroundColor()
  {
    return this.mCirclePaint.getColor();
  }
  
  float getCenterRadius()
  {
    return this.mRingCenterRadius;
  }
  
  int[] getColors()
  {
    return this.mColors;
  }
  
  float getEndTrim()
  {
    return this.mEndTrim;
  }
  
  int getNextColor()
  {
    return this.mColors[getNextColorIndex()];
  }
  
  int getNextColorIndex()
  {
    return (this.mColorIndex + 1) % this.mColors.length;
  }
  
  float getRotation()
  {
    return this.mRotation;
  }
  
  boolean getShowArrow()
  {
    return this.mShowArrow;
  }
  
  float getStartTrim()
  {
    return this.mStartTrim;
  }
  
  int getStartingColor()
  {
    return this.mColors[this.mColorIndex];
  }
  
  float getStartingEndTrim()
  {
    return this.mStartingEndTrim;
  }
  
  float getStartingRotation()
  {
    return this.mStartingRotation;
  }
  
  float getStartingStartTrim()
  {
    return this.mStartingStartTrim;
  }
  
  Paint.Cap getStrokeCap()
  {
    return this.mPaint.getStrokeCap();
  }
  
  float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }
  
  void goToNextColor()
  {
    setColorIndex(getNextColorIndex());
  }
  
  void resetOriginals()
  {
    this.mStartingStartTrim = 0.0F;
    this.mStartingEndTrim = 0.0F;
    this.mStartingRotation = 0.0F;
    setStartTrim(0.0F);
    setEndTrim(0.0F);
    setRotation(0.0F);
  }
  
  void setAlpha(int paramInt)
  {
    this.mAlpha = paramInt;
  }
  
  void setArrowDimensions(float paramFloat1, float paramFloat2)
  {
    this.mArrowWidth = ((int)paramFloat1);
    this.mArrowHeight = ((int)paramFloat2);
  }
  
  void setArrowScale(float paramFloat)
  {
    if (paramFloat != this.mArrowScale) {
      this.mArrowScale = paramFloat;
    }
  }
  
  void setBackgroundColor(int paramInt)
  {
    this.mCirclePaint.setColor(paramInt);
  }
  
  void setCenterRadius(float paramFloat)
  {
    this.mRingCenterRadius = paramFloat;
  }
  
  void setColor(int paramInt)
  {
    this.mCurrentColor = paramInt;
  }
  
  void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  void setColorIndex(int paramInt)
  {
    this.mColorIndex = paramInt;
    this.mCurrentColor = this.mColors[this.mColorIndex];
  }
  
  void setColors(@NonNull int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
    setColorIndex(0);
  }
  
  void setEndTrim(float paramFloat)
  {
    this.mEndTrim = paramFloat;
  }
  
  void setRotation(float paramFloat)
  {
    this.mRotation = paramFloat;
  }
  
  void setShowArrow(boolean paramBoolean)
  {
    if (this.mShowArrow != paramBoolean) {
      this.mShowArrow = paramBoolean;
    }
  }
  
  void setStartTrim(float paramFloat)
  {
    this.mStartTrim = paramFloat;
  }
  
  void setStrokeCap(Paint.Cap paramCap)
  {
    this.mPaint.setStrokeCap(paramCap);
  }
  
  void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    this.mPaint.setStrokeWidth(paramFloat);
  }
  
  void storeOriginals()
  {
    this.mStartingStartTrim = this.mStartTrim;
    this.mStartingEndTrim = this.mEndTrim;
    this.mStartingRotation = this.mRotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircularProgressDrawable.Ring
 * JD-Core Version:    0.7.0.1
 */