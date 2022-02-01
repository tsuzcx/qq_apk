package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import aqis;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.Arrays;

public class MessageProgressView
  extends View
{
  public float AO = Math.abs(this.bx - this.jdField_cx_of_type_Float);
  public float BA = 23.0F;
  private float BB;
  private float BC;
  public float Bn;
  public float Bo;
  public float Bp;
  private float Bq;
  private float Br;
  private float Bs;
  private float Bt;
  private float Bu;
  private float Bv;
  private float Bw;
  private float Bx;
  private float By;
  private float Bz = -1.0F;
  public final String TAG = "MessageProgressView";
  private int TEXT_COLOR = -1;
  private int TEXT_SIZE;
  public float TRIANGLE_WIDTH;
  private Path V;
  private Path W;
  public Path X;
  public a a;
  private float[] aC;
  private RectF aX;
  private RectF aY;
  private RectF aZ;
  AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;
  private Paint as;
  public long avA = 400L;
  public long avB = 767L;
  public long avC = 667L;
  public long avz = 534L;
  private float ax = 14.0F;
  private float ay = 8.0F;
  private RectF ba;
  private float bx;
  private float by = 5.0F;
  public String cAo;
  private boolean cZv = true;
  private float jdField_cx_of_type_Float = 10.0F;
  private Paint jdField_cx_of_type_AndroidGraphicsPaint;
  private float cy = 16.0F;
  public int egH = -1;
  public int egI = 2130706432;
  public int egJ = 0;
  public Drawable gh;
  public Drawable gi;
  private float kX;
  private Paint mBackgroundPaint;
  Rect mImageRect;
  private boolean mIsSend;
  public long mOffsetTime = -1L;
  public int mProgress;
  public Resources mRes;
  private Paint mTextPaint;
  private Paint mTrianglePaint;
  private float mx = 4.0F;
  private float my = 10.0F;
  private float nx = 1.0F;
  private float ny = 14.0F;
  
  public MessageProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MessageProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(Canvas paramCanvas, Path paramPath1, Path paramPath2)
  {
    if (this.mProgress < 100)
    {
      this.mBackgroundPaint.setColor(this.egI);
      paramCanvas.drawPath(this.V, this.mBackgroundPaint);
      return;
    }
    float f1 = (float)Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight());
    float f2 = (float)this.mOffsetTime / (float)this.avz * f1;
    this.Bq = f(0.0F, f1, f2);
    this.W.reset();
    this.W.addCircle(this.Bn, this.Bo, f2, Path.Direction.CW);
    this.W.close();
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.clipPath(this.W, Region.Op.DIFFERENCE);
    paramCanvas.drawPath(this.V, this.mBackgroundPaint);
    paramCanvas.restoreToCount(i);
  }
  
  private void bn(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if (!this.cZv)
    {
      this.aX.set(0.0F, 0.0F, i, j);
      this.V.reset();
      this.V.addRoundRect(this.aX, this.aC, Path.Direction.CW);
      this.V.close();
      a(paramCanvas, this.V, this.W);
      return;
    }
    Resources localResources = this.mRes;
    label113:
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.mIsSend)
    {
      this.aX.set(0.0F, 0.0F, i - this.TRIANGLE_WIDTH, j);
      this.V.reset();
      f1 = dp2px(this.by, localResources);
      if (!this.mIsSend) {
        break label350;
      }
      this.V.addRoundRect(this.aX, this.aC, Path.Direction.CW);
      f2 = i - dp2px(this.ax, localResources);
      f3 = dp2px(this.ay, localResources);
      this.V.moveTo(f2, f3);
      f2 = i;
      f3 = this.bx;
      f4 = i - dp2px(this.mx, localResources);
      float f5 = dp2px(this.my, localResources);
      this.V.quadTo(f4, f5, f2 - f3, f1);
      f1 = i - dp2px(this.jdField_cx_of_type_Float, localResources);
      f2 = dp2px(this.cy, localResources);
      f3 = i - dp2px(this.nx, localResources);
      f4 = dp2px(this.ny, localResources);
      this.V.quadTo(f3, f4, f1, f2);
    }
    for (;;)
    {
      this.V.close();
      break;
      this.aX.set(this.TRIANGLE_WIDTH, 0.0F, i, j);
      break label113;
      label350:
      this.V.addRoundRect(this.aX, this.aC, Path.Direction.CCW);
      f2 = dp2px(this.ax, localResources);
      f3 = dp2px(this.ay, localResources);
      this.V.moveTo(f2, f3);
      f2 = this.bx;
      f3 = dp2px(this.mx, localResources);
      f4 = dp2px(this.my, localResources);
      this.V.quadTo(f3, f4, f2, f1);
      f1 = dp2px(this.jdField_cx_of_type_Float, localResources);
      f2 = dp2px(this.cy, localResources);
      f3 = dp2px(this.nx, localResources);
      f4 = dp2px(this.ny, localResources);
      this.V.quadTo(f3, f4, f1, f2);
    }
  }
  
  private int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat3 < paramFloat1) || (paramFloat3 > paramFloat2)) {}
    for (;;)
    {
      return paramFloat3;
      paramFloat2 -= paramFloat1;
      try
      {
        float f = new BigDecimal((paramFloat3 - paramFloat1) / paramFloat2).setScale(3, 4).floatValue();
        f = this.accelerateDecelerateInterpolator.getInterpolation(f);
        if ((f >= 0.0F) && (f <= 1.0F)) {
          return paramFloat2 * f + paramFloat1;
        }
      }
      catch (Exception localException) {}
    }
    return paramFloat3;
  }
  
  public void Wt(String paramString)
  {
    aqis.a().UK(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MessageProgressView", 2, " stopAnim  key=" + paramString);
    }
  }
  
  protected void aQ(Canvas paramCanvas)
  {
    if (this.mProgress < 0) {}
    while (this.mProgress >= 100) {
      return;
    }
    this.aY.set(this.Bn - this.Br, this.Bo - this.Br, this.Bn + this.Br, this.Bo + this.Br);
    this.mTextPaint.setTextSize(this.TEXT_SIZE);
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    float f1 = localFontMetrics.top;
    float f2 = localFontMetrics.bottom;
    int i = (int)(this.aY.centerY() - f1 / 2.0F - f2 / 2.0F);
    paramCanvas.drawText(this.mProgress + "%", this.aY.centerX(), i, this.mTextPaint);
  }
  
  protected void b(Canvas paramCanvas, String paramString)
  {
    this.aY.set(this.Bn - this.Br, this.Bo - this.Br, this.Bn + this.Br, this.Bo + this.Br);
    this.mTextPaint.setTextSize(dp2px(10.0F, getResources()));
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    float f1 = localFontMetrics.top;
    float f2 = localFontMetrics.bottom;
    int i = (int)(this.aY.centerY() - f1 / 2.0F - f2 / 2.0F);
    paramCanvas.drawText(paramString, this.aY.centerX(), i, this.mTextPaint);
  }
  
  public void bind(String paramString)
  {
    paramString = aqis.a().a(paramString);
    if (paramString != null) {
      paramString.a(this);
    }
  }
  
  protected void bq(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i <= 0) || (j <= 0)) {
      super.draw(paramCanvas);
    }
    while (this.mProgress < 0) {
      return;
    }
    bn(paramCanvas);
  }
  
  protected void br(Canvas paramCanvas)
  {
    if (this.mProgress < 0) {}
    while (this.mProgress >= 100) {
      return;
    }
    this.By = ((float)this.mOffsetTime / (float)this.avC * (this.Bu - this.Bv) + this.Bv);
    this.Bx = ((float)this.mOffsetTime / (float)this.avC * (this.Bs - this.Bt) + this.Bt);
    float f1 = f(this.Bv, this.Bu, this.By);
    float f2 = f(this.Bt, this.Bs, this.Bx);
    float f3 = this.Br;
    this.Bw = (f2 / 2.0F + f3);
    this.jdField_cx_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    this.jdField_cx_of_type_AndroidGraphicsPaint.setMaskFilter(new BlurMaskFilter(f1, BlurMaskFilter.Blur.SOLID));
    paramCanvas.drawCircle(this.Bn, this.Bo, this.Bw, this.jdField_cx_of_type_AndroidGraphicsPaint);
  }
  
  protected void bs(Canvas paramCanvas)
  {
    if ((this.mProgress == 100) && (this.egJ == 1) && (this.mOffsetTime >= this.avA) && (this.mOffsetTime < this.avB))
    {
      this.kX = (((float)this.mOffsetTime - (float)this.avA) / (float)(this.avB - this.avA) * 360.0F);
      this.as.setStrokeWidth(this.Bs);
      this.aZ.set(this.Bn - this.Br, this.Bo - this.Br, this.Bn + this.Br, this.Bo + this.Br);
      paramCanvas.drawArc(this.aZ, -90.0F, -this.kX, false, this.as);
    }
  }
  
  public void bt(Canvas paramCanvas)
  {
    if (this.mProgress == 100)
    {
      if (this.egJ == 1)
      {
        float f1 = this.Br * 2.0F / 3.0F;
        float f2 = (float)Math.sqrt(5.0F * f1 * f1 / 4.0F);
        this.X.reset();
        this.X.moveTo(this.Bn - f1 / 2.0F + 5.0F, this.Bo - f2 / 2.0F);
        Path localPath = this.X;
        float f3 = this.Bn;
        float f4 = f1 / 2.0F;
        float f5 = this.Bo;
        localPath.lineTo(f3 - f4 + 5.0F, f2 / 2.0F + f5);
        localPath = this.X;
        f2 = this.Bn;
        localPath.lineTo(f1 / 2.0F + f2 + 5.0F, this.Bo);
        this.X.close();
        if ((this.mOffsetTime >= this.avA) && (this.mOffsetTime < this.avB))
        {
          this.BB = ((1.0F - ((float)this.mOffsetTime - (float)this.avA) / (float)(this.avB - this.avA)) * this.BA);
          this.BC = (((float)this.mOffsetTime - (float)this.avA) / (float)(this.avB - this.avA) * 1.0F);
          paramCanvas.save();
          paramCanvas.rotate(this.BB, this.Bn, this.Bo);
          paramCanvas.scale(this.BC, this.BC, this.Bn, this.Bo);
          paramCanvas.drawPath(this.X, this.mTrianglePaint);
          paramCanvas.restore();
        }
      }
      if (this.mOffsetTime >= this.avB)
      {
        if (this.egJ != 1) {
          break label321;
        }
        setDrawStatus(2);
      }
    }
    label321:
    while (this.egJ != 2) {
      return;
    }
    setDrawStatus(3);
    setImageDrawable(this.gh);
  }
  
  public void bu(Canvas paramCanvas)
  {
    this.as.setStrokeWidth(this.Bs);
    this.aZ.set(this.Bn - this.Br, this.Bo - this.Br, this.Bn + this.Br, this.Bo + this.Br);
    paramCanvas.drawArc(this.aZ, 0.0F, 360.0F, false, this.as);
    float f1 = this.Br * 2.0F / 3.0F;
    float f2 = (float)Math.sqrt(5.0F * f1 * f1 / 4.0F);
    this.X.reset();
    this.X.moveTo(this.Bn - f1 / 2.0F + 5.0F, this.Bo - f2 / 2.0F);
    Path localPath = this.X;
    float f3 = this.Bn;
    float f4 = f1 / 2.0F;
    float f5 = this.Bo;
    localPath.lineTo(f3 - f4 + 5.0F, f2 / 2.0F + f5);
    localPath = this.X;
    f2 = this.Bn;
    localPath.lineTo(f1 / 2.0F + f2 + 5.0F, this.Bo);
    this.X.close();
    paramCanvas.drawPath(this.X, this.mTrianglePaint);
  }
  
  public void bv(Canvas paramCanvas)
  {
    int i;
    float f;
    if (this.gi != null)
    {
      i = this.gi.getIntrinsicWidth();
      this.mImageRect.set(0, 0, i, i);
      if (!this.cZv) {
        break label114;
      }
      if (!this.mIsSend) {
        break label94;
      }
      f = (getWidth() - i) / 2.0F - this.TRIANGLE_WIDTH / 2.0F;
    }
    for (;;)
    {
      this.mImageRect.offset((int)f, (getHeight() - i) / 2);
      this.gi.setBounds(this.mImageRect);
      this.gi.draw(paramCanvas);
      return;
      label94:
      f = (getWidth() - i) / 2.0F + this.TRIANGLE_WIDTH / 2.0F;
      continue;
      label114:
      f = (getWidth() - i) / 2.0F;
    }
  }
  
  protected void f(Canvas paramCanvas, float paramFloat)
  {
    if (this.mProgress < 0) {
      super.draw(paramCanvas);
    }
    while (this.mProgress >= 100) {
      return;
    }
    float f1 = (this.Bt + this.Bs) / 2.0F;
    float f2 = this.Br + f1;
    this.jdField_cx_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    this.ba.set(this.Bn - f2, this.Bo - f2, this.Bn + f2, f2 + this.Bo);
    paramCanvas.drawArc(this.ba, -90.0F, paramFloat * 360.0F, false, this.jdField_cx_of_type_AndroidGraphicsPaint);
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  @TargetApi(11)
  public void init()
  {
    this.mRes = getResources();
    this.accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    this.Br = dp2px(22.0F, getResources());
    this.Bt = dp2px(2.5F, getResources());
    this.Bs = dp2px(5.0F, getResources());
    this.Bu = dp2px(5.0F, getResources());
    this.Bv = dp2px(2.5F, getResources());
    this.TEXT_SIZE = dp2px(16.0F, getResources());
    this.jdField_cx_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_cx_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_cx_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_cx_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.ba = new RectF();
    this.mTextPaint = new Paint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextSize(this.TEXT_SIZE);
    this.mTextPaint.setColor(this.TEXT_COLOR);
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.as = new Paint();
    this.as.setStyle(Paint.Style.STROKE);
    this.as.setColor(-1);
    this.as.setAntiAlias(true);
    this.mTrianglePaint = new Paint();
    this.mTrianglePaint.setStyle(Paint.Style.FILL);
    this.mTrianglePaint.setColor(-1);
    this.mTrianglePaint.setAntiAlias(true);
    this.X = new Path();
    this.mBackgroundPaint = new Paint();
    this.mBackgroundPaint.setAntiAlias(true);
    this.mBackgroundPaint.setFilterBitmap(true);
    this.mBackgroundPaint.setStyle(Paint.Style.FILL);
    this.V = new Path();
    this.aX = new RectF();
    this.W = new Path();
    this.aC = new float[8];
    this.mImageRect = new Rect();
    this.aY = new RectF();
    this.aZ = new RectF();
    this.TRIANGLE_WIDTH = dp2px(this.AO, getResources());
    this.Bp = dp2px(70.0F, getResources());
    setLayerType(1, null);
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.egH == 1)
    {
      updateSize();
      bq(paramCanvas);
      br(paramCanvas);
      if (this.cAo != null)
      {
        b(paramCanvas, this.cAo);
        bs(paramCanvas);
        bt(paramCanvas);
      }
    }
    do
    {
      return;
      aQ(paramCanvas);
      break;
      if (this.egH == 2)
      {
        updateSize();
        bu(paramCanvas);
        return;
      }
    } while (this.egH != 3);
    updateSize();
    bv(paramCanvas);
  }
  
  public boolean sd(String paramString)
  {
    return aqis.a().a(paramString) != null;
  }
  
  public void setAnimProgress(int paramInt, String paramString)
  {
    this.cAo = null;
    this.mProgress = paramInt;
    RefreshProgressRunnable localRefreshProgressRunnable;
    if (this.egH == 1)
    {
      localRefreshProgressRunnable = aqis.a().a(paramString);
      if (localRefreshProgressRunnable != null) {
        break label96;
      }
      localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString);
      aqis.a().a(paramString, localRefreshProgressRunnable);
      ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("MessageProgressView", 2, " setAnimProgress new AnimRunnable key=" + paramString + " progress=" + paramInt);
      }
    }
    return;
    label96:
    localRefreshProgressRunnable.a(this);
  }
  
  public void setAnimProgress(String paramString1, String paramString2)
  {
    this.cAo = paramString1;
    this.mProgress = 0;
    RefreshProgressRunnable localRefreshProgressRunnable;
    if (this.egH == 1)
    {
      localRefreshProgressRunnable = aqis.a().a(paramString2);
      if (localRefreshProgressRunnable != null) {
        break label96;
      }
      localRefreshProgressRunnable = new RefreshProgressRunnable(this, paramString2);
      aqis.a().a(paramString2, localRefreshProgressRunnable);
      ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("MessageProgressView", 2, " setAnimProgress new AnimRunnable key=" + paramString2 + " progress=" + paramString1);
      }
    }
    return;
    label96:
    localRefreshProgressRunnable.a(this);
  }
  
  public void setAnimRunnableListener(a parama)
  {
    this.a = parama;
  }
  
  public void setBreathingCircleRadius(float paramFloat)
  {
    this.Bz = dp2px(paramFloat, getResources());
  }
  
  public void setCornerDirection(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
  }
  
  public void setCustomSize(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.Br = dp2px(15.0F, getResources());
    this.Bt = dp2px(2.0F, getResources());
    this.Bs = dp2px(4.0F, getResources());
    this.Bu = dp2px(5.0F, getResources());
    this.Bv = dp2px(2.5F, getResources());
    this.TEXT_SIZE = dp2px(13.0F, getResources());
  }
  
  public void setDisplayInTextView(int paramInt1, int paramInt2)
  {
    this.TEXT_SIZE = paramInt1;
    this.TEXT_COLOR = paramInt2;
  }
  
  public void setDrawFinishDefault(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.egJ = 1;
      return;
    }
    this.egJ = 0;
  }
  
  public void setDrawFinishDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.egJ = 2;
      this.gh = paramDrawable;
      return;
    }
    this.egJ = 0;
  }
  
  public void setDrawFinishResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.gh = getResources().getDrawable(paramInt);
      if (this.gh != null) {
        this.egJ = 2;
      }
    }
    else
    {
      return;
    }
    this.egJ = 0;
  }
  
  public void setDrawStatus(int paramInt)
  {
    this.egH = paramInt;
    if (paramInt != 1) {
      invalidate();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.gi = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.gi = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setProgressBackgroudColor(int paramInt)
  {
    this.egI = paramInt;
  }
  
  public void setRadius(float paramFloat, boolean paramBoolean)
  {
    float f = paramFloat;
    if (paramBoolean) {
      f = dp2px(paramFloat, this.mRes);
    }
    if (this.aC != null) {
      Arrays.fill(this.aC, f);
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
    this.jdField_cx_of_type_Float = paramArrayOfFloat[6];
    this.cy = paramArrayOfFloat[7];
    this.nx = paramArrayOfFloat[8];
    this.ny = paramArrayOfFloat[9];
    this.AO = Math.abs(this.bx - this.jdField_cx_of_type_Float);
    this.TRIANGLE_WIDTH = dp2px(this.AO, getResources());
  }
  
  public void setShowCorner(boolean paramBoolean)
  {
    this.cZv = paramBoolean;
  }
  
  protected void updateSize()
  {
    if (this.cZv) {
      if (this.mIsSend) {
        this.Bn = (getWidth() / 2.0F - this.TRIANGLE_WIDTH / 2.0F);
      }
    }
    for (;;)
    {
      this.Bo = (getHeight() / 2);
      if (Math.min(getWidth(), getHeight()) < this.Bp)
      {
        this.Br = dp2px(10.0F, getResources());
        this.Bt = dp2px(1.25F, getResources());
        this.Bs = dp2px(2.5F, getResources());
        this.Bu = dp2px(4.0F, getResources());
        this.Bv = dp2px(2.0F, getResources());
        this.TEXT_SIZE = dp2px(9.0F, getResources());
        if (this.Bz > 0.0F) {
          this.Br = this.Bz;
        }
      }
      return;
      this.Bn = (getWidth() / 2.0F + this.TRIANGLE_WIDTH / 2.0F);
      continue;
      this.Bn = (getWidth() / 2);
    }
  }
  
  public static class RefreshProgressRunnable
    implements Runnable
  {
    private volatile long avD = -1L;
    private volatile long beginTime = -1L;
    public MessageProgressView e;
    private volatile boolean isStopped;
    public String key = "";
    
    public RefreshProgressRunnable(MessageProgressView paramMessageProgressView, String paramString)
    {
      this.key = paramString;
      this.e = paramMessageProgressView;
    }
    
    public void a(MessageProgressView paramMessageProgressView)
    {
      this.e = paramMessageProgressView;
    }
    
    public void run()
    {
      if (this.isStopped)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageProgressView", 2, " stopAnim in isStopped key=" + this.key);
        }
        this.e.Wt(this.key);
        this.e = null;
      }
      for (;;)
      {
        return;
        if (this.beginTime == -1L) {
          this.beginTime = SystemClock.uptimeMillis();
        }
        while ((!this.isStopped) && (this.e != null))
        {
          ViewCompat.postOnAnimation(this.e, this);
          return;
          long l = SystemClock.uptimeMillis() - this.beginTime;
          if (l >= 0L)
          {
            if ((this.e != null) && (this.e.mProgress < 100))
            {
              if (l / this.e.avC % 2L == 0L) {}
              for (this.e.mOffsetTime = (l % this.e.avC);; this.e.mOffsetTime = (this.e.avC - l % this.e.avC))
              {
                this.e.invalidate();
                break;
              }
            }
            if ((this.e != null) && (this.e.mProgress == 100) && (this.avD == -1L)) {
              this.avD = SystemClock.uptimeMillis();
            }
            l = SystemClock.uptimeMillis() - this.avD;
            if ((this.e != null) && (l >= this.e.avB))
            {
              this.e.mOffsetTime = this.e.avB;
              this.e.invalidate();
              this.e.Wt(this.key);
              if (QLog.isColorLevel()) {
                QLog.e("MessageProgressView", 2, " stopAnim in run key=" + this.key);
              }
              if (this.e.a != null) {
                this.e.a.rs(this.key);
              }
            }
            else if (this.e != null)
            {
              this.e.mOffsetTime = (l % this.e.avB);
              this.e.invalidate();
            }
          }
          else
          {
            this.beginTime = SystemClock.uptimeMillis();
          }
        }
      }
    }
    
    public void stop()
    {
      this.isStopped = true;
      this.beginTime = -1L;
      this.avD = -1L;
    }
  }
  
  public static abstract interface a
  {
    public abstract void rs(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MessageProgressView
 * JD-Core Version:    0.7.0.1
 */