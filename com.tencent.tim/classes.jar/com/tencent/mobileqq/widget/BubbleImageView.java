package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

public class BubbleImageView
  extends ChatThumbView
{
  public static final float[] DEFAULT_EDGE_CORDS = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  protected static boolean aAv;
  public float AO = Math.abs(this.bx - this.cx);
  private int ID = (int)(Math.random() * 1000.0D);
  Path R;
  Path S;
  ComposeShader a;
  public boolean aAu;
  float[] aC;
  private Paint aQ;
  RectF aU;
  RectF aV;
  private float ax = 14.0F;
  private float ay = 8.0F;
  private float bx;
  private float by = 5.0F;
  private boolean cZv = true;
  private boolean cZw;
  private boolean cZx;
  protected boolean cZy;
  private float cx = 10.0F;
  private float cy = 16.0F;
  private int eeY = 1610612736;
  protected boolean flag;
  BitmapShader mBitmapShader;
  public int mDrawMode;
  public boolean mIsSend;
  Bitmap mMaskBitmap;
  Paint mMaskPaint;
  Paint mPaint;
  Path mPath;
  private float mRadius;
  RectF mRect;
  protected Resources mRes;
  Shader mShader;
  private Paint mShadowPaint;
  private float mx = 4.0F;
  private float my = 10.0F;
  private float nx = 1.0F;
  private float ny = 14.0F;
  Canvas p;
  private Path u;
  
  static
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("BV0720")) || (str.contains("M821")) || ((Build.VERSION.SDK_INT == 21) && ((str.contains("NX511J")) || (str.contains("MI 5")) || (str.contains("GT-I9508")) || (str.contains("X9077")) || (str.contains("COOLPAD 8675-A"))))) {}
    for (boolean bool = true;; bool = false)
    {
      aAv = bool;
      return;
    }
  }
  
  public BubbleImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BubbleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void bk(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    if (this.cZw)
    {
      if (this.mShadowPaint == null)
      {
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setShader(a());
      }
      paramCanvas.drawPaint(this.mShadowPaint);
    }
    if (this.cZx) {
      paramCanvas.drawColor(this.eeY);
    }
    bl(paramCanvas);
    if ((this.aQ != null) && (this.u != null)) {
      paramCanvas.drawPath(this.u, this.aQ);
    }
    paramCanvas.restoreToCount(i);
  }
  
  private void bm(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0))
    {
      super.draw(paramCanvas);
      return;
    }
    if ((this.mMaskBitmap != null) && ((this.mMaskBitmap.getWidth() != i) || (this.mMaskBitmap.getHeight() != j)))
    {
      this.mMaskBitmap = null;
      this.aU.setEmpty();
      this.R = null;
      this.aV.setEmpty();
      this.S = null;
      this.mShader = null;
    }
    if (this.mMaskBitmap == null) {}
    try
    {
      this.mMaskBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (this.p != null) {
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.mMaskBitmap == null)
      {
        super.draw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mMaskBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.mMaskBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
      if (this.p == null)
      {
        this.p = new Canvas(this.mMaskBitmap);
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.mBitmapShader == null) {
        this.mBitmapShader = new BitmapShader(this.mMaskBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
      if (!this.cZw) {
        break label328;
      }
    }
    if (this.a == null) {
      this.a = new ComposeShader(this.mBitmapShader, a(), PorterDuff.Mode.SRC_OVER);
    }
    label328:
    for (this.mShader = this.a;; this.mShader = this.mBitmapShader)
    {
      this.mMaskPaint.setShader(this.mShader);
      super.draw(this.p);
      if (this.cZx) {
        this.p.drawColor(this.eeY);
      }
      bn(paramCanvas);
      return;
    }
  }
  
  private void bn(Canvas paramCanvas)
  {
    Resources localResources = this.mRes;
    int i = getWidth();
    int j = getHeight();
    if (!this.cZv)
    {
      this.aU.set(0.0F, 0.0F, i, j);
      paramCanvas.drawRoundRect(this.aU, this.mRadius, this.mRadius, this.mMaskPaint);
    }
    label498:
    do
    {
      return;
      float f1;
      Path localPath;
      float f2;
      if (this.mIsSend)
      {
        if (this.aU.isEmpty())
        {
          f1 = dp2px(this.AO, localResources);
          this.aU.set(0.0F, 0.0F, i - f1, j);
        }
        if (this.R == null)
        {
          f1 = dp2px(this.by, localResources);
          localPath = new Path();
          localPath.moveTo(i - dp2px(this.ax, localResources), dp2px(this.ay, localResources));
          f2 = i;
          localPath.quadTo(i - dp2px(this.mx, localResources), dp2px(this.my, localResources), f2, f1);
          f1 = i - dp2px(this.cx, localResources);
          f2 = dp2px(this.cy, localResources);
          localPath.quadTo(i - dp2px(this.nx, localResources), dp2px(this.ny, localResources), f1, f2);
          localPath.close();
          this.R = localPath;
        }
      }
      for (;;)
      {
        if (!this.mIsSend) {
          break label498;
        }
        paramCanvas.drawRoundRect(this.aU, this.mRadius, this.mRadius, this.mMaskPaint);
        paramCanvas.drawPath(this.R, this.mMaskPaint);
        if (this.aQ == null) {
          break;
        }
        paramCanvas.drawPath(this.R, this.aQ);
        return;
        if (this.aV.isEmpty())
        {
          f1 = dp2px(this.AO, localResources);
          this.aV.set(f1, 0.0F, i, j);
        }
        if (this.S == null)
        {
          f1 = dp2px(this.by, localResources);
          localPath = new Path();
          localPath.moveTo(dp2px(this.ax, localResources), dp2px(this.ay, localResources));
          localPath.quadTo(dp2px(this.mx, localResources), dp2px(this.my, localResources), 0.0F, f1);
          f1 = dp2px(this.cx, localResources);
          f2 = dp2px(this.cy, localResources);
          localPath.quadTo(dp2px(this.nx, localResources), dp2px(this.ny, localResources), f1, f2);
          localPath.close();
          this.S = localPath;
        }
      }
      paramCanvas.drawRoundRect(this.aV, this.mRadius, this.mRadius, this.mMaskPaint);
      paramCanvas.drawPath(this.S, this.mMaskPaint);
    } while (this.aQ == null);
    paramCanvas.drawPath(this.S, this.aQ);
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void TC(boolean paramBoolean)
  {
    if (paramBoolean != this.cZw)
    {
      this.cZw = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void TD(boolean paramBoolean)
  {
    if (this.cZx != paramBoolean)
    {
      this.cZx = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void TE(boolean paramBoolean)
  {
    if (this.cZv != paramBoolean)
    {
      this.cZv = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void Yl(int paramInt)
  {
    setSharpCornerCor(DEFAULT_EDGE_CORDS);
    if ((this.aQ == null) || (this.u == null))
    {
      this.aQ = new Paint();
      this.aQ.setColor(paramInt);
      this.aQ.setAntiAlias(true);
      this.aQ.setStrokeWidth(Math.max(1, dp2px(0.5F, getResources())));
      this.aQ.setStyle(Paint.Style.STROKE);
      this.u = new Path();
    }
  }
  
  public Shader a()
  {
    return null;
  }
  
  protected void bl(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  protected void cei() {}
  
  public void draw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    if (this.cZy) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      l = System.currentTimeMillis() - l;
      boolean bool = false;
      if (VersionUtils.isHoneycomb()) {
        bool = paramCanvas.isHardwareAccelerated();
      }
      if ((QLog.isColorLevel()) && (l > 10L)) {
        QLog.w("BubbleImageView" + this.ID, 2, "draw(): isHardwaveAccelerated= " + bool + ", drawMode = " + this.mDrawMode + ", cost =" + l);
      }
      return;
      if (this.mDrawMode == 1) {
        bk(paramCanvas);
      } else if (this.mDrawMode == 2) {
        bm(paramCanvas);
      } else {
        super.draw(paramCanvas);
      }
    }
  }
  
  protected void init()
  {
    this.aAu = aAv;
    if (VersionUtils.isHoneycomb())
    {
      this.mDrawMode = 1;
      cei();
      this.mRes = getResources();
      if (this.mDrawMode != 1) {
        break label142;
      }
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setFilterBitmap(true);
      this.mPaint.setColor(-16777216);
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.mPath = new Path();
      this.mRect = new RectF();
      this.aC = new float[8];
    }
    label142:
    while (this.mDrawMode != 2)
    {
      return;
      this.mDrawMode = 2;
      break;
    }
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setFilterBitmap(true);
    this.aU = new RectF();
    this.aV = new RectF();
    this.mPath = new Path();
    this.mRect = new RectF();
    this.aC = new float[8];
  }
  
  public void invalidate()
  {
    super.invalidate();
  }
  
  @TargetApi(11)
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.aAu) {
      setLayerType(1, null);
    }
    while ((this.mDrawMode != 1) || (!VersionUtils.isHoneycomb())) {
      return;
    }
    setLayerType(2, null);
  }
  
  @TargetApi(11)
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mDrawMode == 1) && (VersionUtils.isHoneycomb())) {
      setLayerType(0, null);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.mDrawMode == 1)) {
      onResize(getWidth(), getHeight());
    }
  }
  
  public void onResize(float paramFloat1, float paramFloat2)
  {
    if (!this.cZv)
    {
      this.mRect.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      this.mPath.reset();
      this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      if (this.flag) {
        this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      }
      if (this.u != null)
      {
        this.u.reset();
        this.u.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      }
    }
    Resources localResources;
    float f1;
    float f10;
    Path localPath1;
    Path localPath2;
    float f9;
    float f8;
    float f7;
    float f6;
    float f5;
    float f4;
    float f3;
    float f2;
    Path localPath3;
    label408:
    do
    {
      return;
      localResources = this.mRes;
      f1 = dp2px(this.AO, localResources);
      if (!this.mIsSend) {
        break;
      }
      this.mRect.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.mPath.reset();
      f10 = dp2px(this.by, localResources);
      if (!this.mIsSend) {
        break label919;
      }
      if (!this.flag) {
        break label741;
      }
      localPath1 = new Path();
      localPath1.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      localPath1.setFillType(Path.FillType.EVEN_ODD);
      localPath2 = new Path();
      f9 = paramFloat1 - dp2px(this.ax, localResources);
      f8 = dp2px(this.ay, localResources);
      localPath2.moveTo(f9, f8);
      f7 = paramFloat1 - dp2px(this.bx, localResources);
      f6 = paramFloat1 - dp2px(this.mx, localResources);
      f5 = dp2px(this.my, localResources);
      localPath2.quadTo(f6, f5, f7, f10);
      f4 = paramFloat1 - dp2px(this.cx, localResources);
      f3 = dp2px(this.cy, localResources);
      f2 = paramFloat1 - dp2px(this.nx, localResources);
      f1 = dp2px(this.ny, localResources);
      localPath2.quadTo(f2, f1, f4, f3);
      localPath2.setFillType(Path.FillType.EVEN_ODD);
      localPath3 = new Path();
      if (Build.VERSION.SDK_INT >= 19) {
        localPath3.op(localPath1, localPath2, Path.Op.UNION);
      }
      localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
      this.mPath = localPath3;
      this.mPath.close();
    } while (this.u == null);
    this.u.reset();
    float f11 = 2.0F * this.mRadius;
    if (this.mIsSend)
    {
      paramFloat1 = (float)(Math.asin(dp2px(this.cy - this.ay, localResources) / this.aC[2]) * 180.0D / 3.141592653589793D);
      this.u.moveTo(f4, f3);
      this.u.lineTo(f4, paramFloat2 - this.mRadius);
      this.mRect.set(f4 - f11, paramFloat2 - f11, f4, paramFloat2);
      this.u.arcTo(this.mRect, 0.0F, 90.0F);
      this.u.lineTo(0.0F + this.mRadius, paramFloat2);
      this.mRect.set(0.0F, paramFloat2 - f11, f11, paramFloat2);
      this.u.arcTo(this.mRect, 90.0F, 90.0F);
      this.u.lineTo(0.0F, this.mRadius);
      this.mRect.set(0.0F, 0.0F, f11, f11);
      this.u.arcTo(this.mRect, 180.0F, 90.0F);
      this.u.lineTo(f4 - this.mRadius, 0.0F);
      this.mRect.set(f4 - f11, 0.0F, f4, f11);
      this.u.arcTo(this.mRect, 270.0F, 90.0F - paramFloat1);
      this.u.lineTo(f9, f8);
      this.u.quadTo(f6, f5, f7, f10);
      this.u.quadTo(f2, f1, f4, f3);
    }
    for (;;)
    {
      this.u.close();
      return;
      this.mRect.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label741:
      this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
      f9 = paramFloat1 - dp2px(this.ax, localResources);
      f8 = dp2px(this.ay, localResources);
      this.mPath.moveTo(f9, f8);
      f7 = paramFloat1 - dp2px(this.bx, localResources);
      f6 = paramFloat1 - dp2px(this.mx, localResources);
      f5 = dp2px(this.my, localResources);
      this.mPath.quadTo(f6, f5, f7, f10);
      f4 = paramFloat1 - dp2px(this.cx, localResources);
      f3 = dp2px(this.cy, localResources);
      f2 = paramFloat1 - dp2px(this.nx, localResources);
      f1 = dp2px(this.ny, localResources);
      this.mPath.quadTo(f2, f1, f4, f3);
      break label408;
      label919:
      if (this.flag)
      {
        localPath1 = new Path();
        localPath1.addRoundRect(this.mRect, this.aC, Path.Direction.CW);
        localPath1.setFillType(Path.FillType.EVEN_ODD);
        localPath2 = new Path();
        f9 = dp2px(this.ax, localResources);
        f8 = dp2px(this.ay, localResources);
        localPath2.moveTo(f9, f8);
        f7 = this.bx;
        f6 = dp2px(this.mx, localResources);
        f5 = dp2px(this.my, localResources);
        localPath2.quadTo(f6, f5, f7, f10);
        f4 = dp2px(this.cx, localResources);
        f3 = dp2px(this.cy, localResources);
        f2 = dp2px(this.nx, localResources);
        f1 = dp2px(this.ny, localResources);
        localPath2.quadTo(f2, f1, f4, f3);
        localPath3 = new Path();
        if (Build.VERSION.SDK_INT >= 19) {
          localPath3.op(localPath1, localPath2, Path.Op.UNION);
        }
        localPath3.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        this.mPath = localPath3;
        break label408;
      }
      this.mPath.addRoundRect(this.mRect, this.aC, Path.Direction.CCW);
      f9 = dp2px(this.ax, localResources);
      f8 = dp2px(this.ay, localResources);
      this.mPath.moveTo(f9, f8);
      f7 = this.bx;
      f6 = dp2px(this.mx, localResources);
      f5 = dp2px(this.my, localResources);
      this.mPath.quadTo(f6, f5, f7, f10);
      f4 = dp2px(this.cx, localResources);
      f3 = dp2px(this.cy, localResources);
      f2 = dp2px(this.nx, localResources);
      f1 = dp2px(this.ny, localResources);
      this.mPath.quadTo(f2, f1, f4, f3);
      break label408;
      float f12 = (float)(Math.asin(dp2px(this.cy - this.ay, localResources) / this.aC[0]) * 180.0D / 3.141592653589793D);
      this.u.moveTo(f9, f8);
      this.mRect.set(f4, 0.0F, f4 + f11, f11);
      this.u.arcTo(this.mRect, 180.0F + f12, 90.0F - f12);
      this.u.lineTo(paramFloat1 - this.mRadius, 0.0F);
      this.mRect.set(paramFloat1 - f11, 0.0F, paramFloat1, f11);
      this.u.arcTo(this.mRect, 270.0F, 90.0F);
      this.u.lineTo(paramFloat1, paramFloat2 - this.mRadius);
      this.mRect.set(paramFloat1 - f11, paramFloat2 - f11, paramFloat1, paramFloat2);
      this.u.arcTo(this.mRect, 0.0F, 90.0F);
      this.u.lineTo(this.mRadius + f4, paramFloat2);
      this.mRect.set(f4, paramFloat2 - f11, f11 + f4, paramFloat2);
      this.u.arcTo(this.mRect, 90.0F, 90.0F);
      this.u.lineTo(f4, this.mRadius);
      this.u.lineTo(f4, f3);
      this.u.quadTo(f2, f1, f7, f10);
      this.u.quadTo(f6, f5, f9, f8);
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.eeY = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null) {
      Arrays.fill(this.aC, this.mRadius);
    }
  }
  
  public void setRadiusBottom(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null)
    {
      Arrays.fill(this.aC, 0, 4, 0.0F);
      Arrays.fill(this.aC, 4, 8, this.mRadius);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.mRadius = dp2px(paramFloat, this.mRes);
    if (this.aC != null)
    {
      Arrays.fill(this.aC, 0, 4, this.mRadius);
      Arrays.fill(this.aC, 4, 8, 0.0F);
    }
  }
  
  public void setSend(boolean paramBoolean)
  {
    if (this.mIsSend != paramBoolean)
    {
      this.mIsSend = paramBoolean;
      if ((getWidth() != 0) && (getHeight() != 0)) {
        onResize(getWidth(), getHeight());
      }
    }
  }
  
  public void setSharpCornerCor(float[] paramArrayOfFloat)
  {
    this.ax = paramArrayOfFloat[0];
    this.ay = paramArrayOfFloat[1];
    this.bx = paramArrayOfFloat[2];
    this.by = paramArrayOfFloat[3];
    this.mx = paramArrayOfFloat[4];
    this.my = paramArrayOfFloat[5];
    this.cx = paramArrayOfFloat[6];
    this.cy = paramArrayOfFloat[7];
    this.nx = paramArrayOfFloat[8];
    this.ny = paramArrayOfFloat[9];
    this.AO = Math.abs(this.bx - this.cx);
  }
  
  public void setShowEdge(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Yl(Color.parseColor("#14000000"));
      return;
    }
    this.aQ = null;
    this.u = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleImageView
 * JD-Core Version:    0.7.0.1
 */