package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

class VectorDrawableCompat$VPathRenderer
{
  private static final Matrix IDENTITY_MATRIX = new Matrix();
  float mBaseHeight = 0.0F;
  float mBaseWidth = 0.0F;
  private int mChangingConfigurations;
  private Paint mFillPaint;
  private final Matrix mFinalPathMatrix = new Matrix();
  private final Path mPath;
  private PathMeasure mPathMeasure;
  private final Path mRenderPath;
  int mRootAlpha = 255;
  final VectorDrawableCompat.VGroup mRootGroup;
  String mRootName = null;
  private Paint mStrokePaint;
  final ArrayMap mVGTargetsMap = new ArrayMap();
  float mViewportHeight = 0.0F;
  float mViewportWidth = 0.0F;
  
  public VectorDrawableCompat$VPathRenderer()
  {
    this.mRootGroup = new VectorDrawableCompat.VGroup();
    this.mPath = new Path();
    this.mRenderPath = new Path();
  }
  
  public VectorDrawableCompat$VPathRenderer(VPathRenderer paramVPathRenderer)
  {
    this.mRootGroup = new VectorDrawableCompat.VGroup(paramVPathRenderer.mRootGroup, this.mVGTargetsMap);
    this.mPath = new Path(paramVPathRenderer.mPath);
    this.mRenderPath = new Path(paramVPathRenderer.mRenderPath);
    this.mBaseWidth = paramVPathRenderer.mBaseWidth;
    this.mBaseHeight = paramVPathRenderer.mBaseHeight;
    this.mViewportWidth = paramVPathRenderer.mViewportWidth;
    this.mViewportHeight = paramVPathRenderer.mViewportHeight;
    this.mChangingConfigurations = paramVPathRenderer.mChangingConfigurations;
    this.mRootAlpha = paramVPathRenderer.mRootAlpha;
    this.mRootName = paramVPathRenderer.mRootName;
    if (paramVPathRenderer.mRootName != null) {
      this.mVGTargetsMap.put(paramVPathRenderer.mRootName, this);
    }
  }
  
  private static float cross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
  }
  
  private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    VectorDrawableCompat.VGroup.access$200(paramVGroup).set(paramMatrix);
    VectorDrawableCompat.VGroup.access$200(paramVGroup).preConcat(VectorDrawableCompat.VGroup.access$300(paramVGroup));
    paramCanvas.save();
    int i = 0;
    if (i < paramVGroup.mChildren.size())
    {
      paramMatrix = paramVGroup.mChildren.get(i);
      if ((paramMatrix instanceof VectorDrawableCompat.VGroup)) {
        drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, VectorDrawableCompat.VGroup.access$200(paramVGroup), paramCanvas, paramInt1, paramInt2, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramMatrix instanceof VectorDrawableCompat.VPath)) {
          drawPath(paramVGroup, (VectorDrawableCompat.VPath)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
    }
    paramCanvas.restore();
  }
  
  private void drawPath(VectorDrawableCompat.VGroup paramVGroup, VectorDrawableCompat.VPath paramVPath, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    float f2 = paramInt1 / this.mViewportWidth;
    float f3 = paramInt2 / this.mViewportHeight;
    float f1 = Math.min(f2, f3);
    paramVGroup = VectorDrawableCompat.VGroup.access$200(paramVGroup);
    this.mFinalPathMatrix.set(paramVGroup);
    this.mFinalPathMatrix.postScale(f2, f3);
    f2 = getMatrixScale(paramVGroup);
    if (f2 == 0.0F) {
      return;
    }
    paramVPath.toPath(this.mPath);
    paramVGroup = this.mPath;
    this.mRenderPath.reset();
    if (paramVPath.isClipPath())
    {
      this.mRenderPath.addPath(paramVGroup, this.mFinalPathMatrix);
      paramCanvas.clipPath(this.mRenderPath);
      return;
    }
    paramVPath = (VectorDrawableCompat.VFullPath)paramVPath;
    float f6;
    float f4;
    label267:
    Paint localPaint;
    Path localPath;
    if ((paramVPath.mTrimPathStart != 0.0F) || (paramVPath.mTrimPathEnd != 1.0F))
    {
      f6 = paramVPath.mTrimPathStart;
      float f7 = paramVPath.mTrimPathOffset;
      f4 = paramVPath.mTrimPathEnd;
      float f5 = paramVPath.mTrimPathOffset;
      if (this.mPathMeasure == null) {
        this.mPathMeasure = new PathMeasure();
      }
      this.mPathMeasure.setPath(this.mPath, false);
      f3 = this.mPathMeasure.getLength();
      f6 = (f6 + f7) % 1.0F * f3;
      f4 = (f4 + f5) % 1.0F * f3;
      paramVGroup.reset();
      if (f6 > f4)
      {
        this.mPathMeasure.getSegment(f6, f3, paramVGroup, true);
        this.mPathMeasure.getSegment(0.0F, f4, paramVGroup, true);
        paramVGroup.rLineTo(0.0F, 0.0F);
      }
    }
    else
    {
      this.mRenderPath.addPath(paramVGroup, this.mFinalPathMatrix);
      if (paramVPath.mFillColor != 0)
      {
        if (this.mFillPaint == null)
        {
          this.mFillPaint = new Paint();
          this.mFillPaint.setStyle(Paint.Style.FILL);
          this.mFillPaint.setAntiAlias(true);
        }
        localPaint = this.mFillPaint;
        localPaint.setColor(VectorDrawableCompat.applyAlpha(paramVPath.mFillColor, paramVPath.mFillAlpha));
        localPaint.setColorFilter(paramColorFilter);
        localPath = this.mRenderPath;
        if (paramVPath.mFillRule != 0) {
          break label540;
        }
      }
    }
    label540:
    for (paramVGroup = Path.FillType.WINDING;; paramVGroup = Path.FillType.EVEN_ODD)
    {
      localPath.setFillType(paramVGroup);
      paramCanvas.drawPath(this.mRenderPath, localPaint);
      if (paramVPath.mStrokeColor == 0) {
        break;
      }
      if (this.mStrokePaint == null)
      {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setAntiAlias(true);
      }
      paramVGroup = this.mStrokePaint;
      if (paramVPath.mStrokeLineJoin != null) {
        paramVGroup.setStrokeJoin(paramVPath.mStrokeLineJoin);
      }
      if (paramVPath.mStrokeLineCap != null) {
        paramVGroup.setStrokeCap(paramVPath.mStrokeLineCap);
      }
      paramVGroup.setStrokeMiter(paramVPath.mStrokeMiterlimit);
      paramVGroup.setColor(VectorDrawableCompat.applyAlpha(paramVPath.mStrokeColor, paramVPath.mStrokeAlpha));
      paramVGroup.setColorFilter(paramColorFilter);
      paramVGroup.setStrokeWidth(f2 * f1 * paramVPath.mStrokeWidth);
      paramCanvas.drawPath(this.mRenderPath, paramVGroup);
      return;
      this.mPathMeasure.getSegment(f6, f4, paramVGroup, true);
      break label267;
    }
  }
  
  private float getMatrixScale(Matrix paramMatrix)
  {
    float f1 = 0.0F;
    float[] arrayOfFloat = new float[4];
    float[] tmp9_7 = arrayOfFloat;
    tmp9_7[0] = 0.0F;
    float[] tmp13_9 = tmp9_7;
    tmp13_9[1] = 1.0F;
    float[] tmp17_13 = tmp13_9;
    tmp17_13[2] = 1.0F;
    float[] tmp21_17 = tmp17_13;
    tmp21_17[3] = 0.0F;
    tmp21_17;
    paramMatrix.mapVectors(arrayOfFloat);
    float f3 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
    float f4 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
    float f2 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
    f3 = Math.max(f3, f4);
    if (f3 > 0.0F) {
      f1 = Math.abs(f2) / f3;
    }
    return f1;
  }
  
  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
  {
    drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
  }
  
  public float getAlpha()
  {
    return getRootAlpha() / 255.0F;
  }
  
  public int getRootAlpha()
  {
    return this.mRootAlpha;
  }
  
  public void setAlpha(float paramFloat)
  {
    setRootAlpha((int)(255.0F * paramFloat));
  }
  
  public void setRootAlpha(int paramInt)
  {
    this.mRootAlpha = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VPathRenderer
 * JD-Core Version:    0.7.0.1
 */