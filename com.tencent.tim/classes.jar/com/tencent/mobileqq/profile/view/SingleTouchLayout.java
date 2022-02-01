package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import wja;

public class SingleTouchLayout
  extends FrameLayout
{
  View Ge;
  public int JO;
  public float MAX_SCALE = 4.0F;
  public float MIN_SCALE = 0.3F;
  public b a;
  private PointF ad = new PointF();
  PointF ae = new PointF();
  PointF af = new PointF();
  long agx;
  boolean cwS = true;
  boolean cwT = false;
  boolean cwU = true;
  boolean cwV = false;
  public int dtA;
  private int dtB;
  private int dtC;
  int dtD = 8;
  int dtE = 2;
  int dtF = 0;
  public int dtG;
  public int dtH;
  Bitmap fU;
  Bitmap fV;
  Bitmap fW;
  Bitmap fX;
  int frameColor = -1;
  int frameWidth = 1;
  boolean isEditable = true;
  Rect mDstRect = new Rect();
  public int mIconHeight;
  public int mIconWidth;
  float mLastX;
  float mLastY;
  Matrix mMatrix = new Matrix();
  Paint mPaint;
  public int mParentWidth;
  Path mPath = new Path();
  private float mScale = 1.0F;
  float mShadowRadius;
  int mStatus = 0;
  public int mViewHeight;
  DisplayMetrics metrics;
  int offsetX;
  int offsetY;
  public Point q;
  public Point r;
  public Point s;
  public Point t;
  Point v = new Point();
  Point w = new Point();
  private float yC = 0.0F;
  float yD;
  
  public SingleTouchLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleTouchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleTouchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramAttributeSet);
    init();
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, float paramFloat)
  {
    Point localPoint = new Point();
    paramPoint2.x -= paramPoint1.x;
    paramPoint2.y -= paramPoint1.y;
    double d2 = 0.0D;
    paramPoint2 = new Point();
    double d3 = Math.sqrt(localPoint.x * localPoint.x + localPoint.y * localPoint.y);
    if ((localPoint.x == 0) && (localPoint.y == 0)) {
      return paramPoint1;
    }
    double d1;
    if ((localPoint.x >= 0) && (localPoint.y >= 0)) {
      d1 = Math.asin(localPoint.y / d3);
    }
    for (;;)
    {
      d1 = j(i(d1) + paramFloat);
      paramPoint2.x = ((int)Math.round(Math.cos(d1) * d3));
      paramPoint2.y = ((int)Math.round(Math.sin(d1) * d3));
      paramPoint2.x += paramPoint1.x;
      paramPoint2.y += paramPoint1.y;
      return paramPoint2;
      if ((localPoint.x < 0) && (localPoint.y >= 0))
      {
        d1 = Math.asin(Math.abs(localPoint.x) / d3) + 1.570796326794897D;
      }
      else if ((localPoint.x < 0) && (localPoint.y < 0))
      {
        d1 = Math.asin(Math.abs(localPoint.y) / d3) + 3.141592653589793D;
      }
      else
      {
        d1 = d2;
        if (localPoint.x >= 0)
        {
          d1 = d2;
          if (localPoint.y < 0) {
            d1 = Math.asin(localPoint.x / d3) + 4.71238898038469D;
          }
        }
      }
    }
  }
  
  public static double i(double paramDouble)
  {
    return 180.0D * paramDouble / 3.141592653589793D;
  }
  
  public static double j(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  @TargetApi(11)
  public boolean N(float paramFloat1, float paramFloat2)
  {
    if (this.Ge == null) {
      return true;
    }
    if ((this.dtG > 0) && (this.dtH > 0)) {
      this.cwV = true;
    }
    int i = (int)(this.dtG * paramFloat1);
    int j = (int)(this.dtH * paramFloat1);
    if (QLog.isColorLevel()) {
      QLog.d("SingleTouchLayout", 2, "transformDraw(): mActualViewWidth=" + i + ", mActualViewHeight=" + j);
    }
    Object localObject = a(-this.dtD, -this.dtD, this.dtD + i, j + this.dtD, paramFloat2);
    if ((be(((a)localObject).vw, ((a)localObject).vh)) || (!this.cwV) || (this.ad.x == 0.0F) || (this.ad.y == 0.0F) || (!this.isEditable))
    {
      this.q = ((a)localObject).x;
      this.r = ((a)localObject).y;
      this.s = ((a)localObject).z;
      this.t = ((a)localObject).A;
      this.v = ((a)localObject).B;
      this.w = ((a)localObject).C;
      this.JO = ((a)localObject).vw;
      this.mViewHeight = ((a)localObject).vh;
      this.offsetX = ((a)localObject).offsetX;
      this.offsetY = ((a)localObject).offsetY;
      localObject = (FrameLayout.LayoutParams)this.Ge.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = ((this.JO + this.mIconWidth - this.Ge.getWidth()) / 2);
      ((FrameLayout.LayoutParams)localObject).topMargin = ((this.mViewHeight + this.mIconHeight - this.Ge.getHeight()) / 2);
      this.Ge.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Ge.setScaleX(paramFloat1);
      this.Ge.setScaleY(paramFloat1);
      this.Ge.setRotation(paramFloat2 % 360.0F);
      if (QLog.isColorLevel()) {
        QLog.d("SingleTouchLayout", 2, "transformDraw(): mViewWidth=" + this.JO + ", mViewHeight=" + this.mViewHeight);
      }
      dtj();
      return true;
    }
    return false;
  }
  
  boolean O(float paramFloat1, float paramFloat2)
  {
    return c(new PointF(paramFloat1, paramFloat2), new PointF(this.w)) < Math.min(this.mIconWidth / 2, this.mIconHeight / 2);
  }
  
  public boolean S(View paramView)
  {
    if (this.Ge != paramView)
    {
      removeView(this.Ge);
      this.Ge = paramView;
      addView(this.Ge, new FrameLayout.LayoutParams(-2, -2));
      return true;
    }
    return false;
  }
  
  public int a(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(paramVarArgs.size() - 1)).intValue();
  }
  
  Point a(int paramInt, a parama)
  {
    switch (paramInt)
    {
    default: 
      return parama.x;
    case 0: 
      return parama.x;
    case 1: 
      return parama.y;
    case 2: 
      return parama.z;
    }
    return parama.A;
  }
  
  a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    Point localPoint1 = new Point(paramInt1, paramInt2);
    Point localPoint2 = new Point(paramInt3, paramInt2);
    Point localPoint3 = new Point(paramInt3, paramInt4);
    Point localPoint4 = new Point(paramInt1, paramInt4);
    Point localPoint5 = new Point((paramInt1 + paramInt3) / 2, (paramInt2 + paramInt4) / 2);
    a locala = new a();
    locala.x = a(localPoint5, localPoint1, paramFloat);
    locala.y = a(localPoint5, localPoint2, paramFloat);
    locala.z = a(localPoint5, localPoint3, paramFloat);
    locala.A = a(localPoint5, localPoint4, paramFloat);
    paramInt1 = a(new Integer[] { Integer.valueOf(locala.x.x), Integer.valueOf(locala.y.x), Integer.valueOf(locala.z.x), Integer.valueOf(locala.A.x) });
    paramInt2 = b(new Integer[] { Integer.valueOf(locala.x.x), Integer.valueOf(locala.y.x), Integer.valueOf(locala.z.x), Integer.valueOf(locala.A.x) });
    locala.vw = (paramInt1 - paramInt2);
    paramInt3 = a(new Integer[] { Integer.valueOf(locala.x.y), Integer.valueOf(locala.y.y), Integer.valueOf(locala.z.y), Integer.valueOf(locala.A.y) });
    paramInt4 = b(new Integer[] { Integer.valueOf(locala.x.y), Integer.valueOf(locala.y.y), Integer.valueOf(locala.z.y), Integer.valueOf(locala.A.y) });
    locala.vh = (paramInt3 - paramInt4);
    localPoint1 = new Point((paramInt1 + paramInt2) / 2, (paramInt3 + paramInt4) / 2);
    locala.offsetX = (locala.vw / 2 - localPoint1.x);
    locala.offsetY = (locala.vh / 2 - localPoint1.y);
    paramInt2 = this.mIconWidth / 2;
    paramInt1 = this.mIconHeight / 2;
    localPoint1 = locala.x;
    localPoint1.x += locala.offsetX + paramInt2;
    localPoint1 = locala.y;
    localPoint1.x += locala.offsetX + paramInt2;
    localPoint1 = locala.z;
    localPoint1.x += locala.offsetX + paramInt2;
    localPoint1 = locala.A;
    paramInt3 = localPoint1.x;
    localPoint1.x = (paramInt2 + locala.offsetX + paramInt3);
    localPoint1 = locala.x;
    localPoint1.y += locala.offsetY + paramInt1;
    localPoint1 = locala.y;
    localPoint1.y += locala.offsetY + paramInt1;
    localPoint1 = locala.z;
    localPoint1.y += locala.offsetY + paramInt1;
    localPoint1 = locala.A;
    paramInt2 = localPoint1.y;
    localPoint1.y = (paramInt1 + locala.offsetY + paramInt2);
    locala.B = a(this.dtE, locala);
    locala.C = a(this.dtF, locala);
    return locala;
  }
  
  public boolean atC()
  {
    return N(this.mScale, this.yC);
  }
  
  public int b(Integer... paramVarArgs)
  {
    paramVarArgs = Arrays.asList(paramVarArgs);
    Collections.sort(paramVarArgs);
    return ((Integer)paramVarArgs.get(0)).intValue();
  }
  
  boolean b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 < 10000.0F;
  }
  
  boolean be(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (this.cwT)
    {
      paramInt1 = this.mIconWidth + paramInt1;
      paramInt2 = this.mIconHeight + paramInt2;
      i = (int)(this.ad.x - paramInt1 / 2);
      j = (int)(this.ad.y - paramInt2 / 2);
      if (QLog.isColorLevel()) {
        QLog.d("SingleTouchLayout", 2, String.format("inBounds: l=%s, t=%s, w=%s, h=%s, cp.x=%s, cp.y=%s, width=%s, height=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(this.ad.x), Float.valueOf(this.ad.y), Integer.valueOf(this.mParentWidth), Integer.valueOf(this.mParentWidth) }));
      }
    }
    return (i >= 0) && (j >= 0) && (paramInt1 + i <= this.mParentWidth) && (j + paramInt2 <= this.dtA);
  }
  
  public float bp()
  {
    return this.yC;
  }
  
  public float bq()
  {
    return this.mScale;
  }
  
  double c(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public PointF d()
  {
    return this.ad;
  }
  
  void dFR()
  {
    this.mMatrix.setRotate(this.yC);
    if ((this.fV != null) && (this.fV != this.fU)) {
      this.fV.recycle();
    }
    this.fV = Bitmap.createBitmap(this.fU, 0, 0, this.fU.getWidth(), this.fU.getHeight(), this.mMatrix, false);
    if ((this.fX != null) && (this.fX != this.fW)) {
      this.fX.recycle();
    }
    this.fX = Bitmap.createBitmap(this.fW, 0, 0, this.fW.getWidth(), this.fW.getHeight(), this.mMatrix, false);
  }
  
  void dtj()
  {
    int i = this.JO + this.mIconWidth;
    int j = this.mViewHeight + this.mIconHeight;
    int k = (int)(this.ad.x - i / 2);
    int m = (int)(this.ad.y - j / 2);
    if ((this.dtB != k) || (this.dtC != m))
    {
      this.dtB = k;
      this.dtC = m;
    }
    layout(k, m, i + k, j + m);
  }
  
  void e(AttributeSet paramAttributeSet)
  {
    this.metrics = getContext().getResources().getDisplayMetrics();
    this.dtD = ((int)TypedValue.applyDimension(1, 8.0F, this.metrics));
    this.frameWidth = ((int)TypedValue.applyDimension(1, 1.0F, this.metrics));
    this.frameColor = -1;
    this.mScale = 1.0F;
    this.yC = 0.0F;
    this.dtE = 2;
    this.dtF = 0;
    this.isEditable = true;
  }
  
  int f(float paramFloat1, float paramFloat2)
  {
    if (c(new PointF(paramFloat1, paramFloat2), new PointF(this.v)) < Math.min(this.mIconWidth / 2, this.mIconHeight / 2)) {
      return 2;
    }
    return 1;
  }
  
  public boolean g(View paramView, int paramInt)
  {
    if (this.Ge != paramView)
    {
      removeView(this.Ge);
      this.Ge = paramView;
      addView(this.Ge, new FrameLayout.LayoutParams(paramInt, -2));
      return true;
    }
    return false;
  }
  
  public void hy(View paramView)
  {
    removeView(this.Ge);
    this.Ge = paramView;
    addView(this.Ge, new FrameLayout.LayoutParams(-2, -2));
  }
  
  void init()
  {
    setWillNotDraw(false);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(this.frameColor);
    this.mPaint.setStrokeWidth(this.frameWidth);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mShadowRadius = wja.dp2px(2.0F, getResources());
    this.yD = wja.dp2px(1.0F, getResources());
    this.mPaint.setShadowLayer(this.mShadowRadius, 0.0F, this.yD, -16777216);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = getResources().getDisplayMetrics().densityDpi;
    if (this.fU == null) {}
    try
    {
      this.fU = BitmapFactory.decodeResource(getResources(), 2130848284, localOptions);
      if (this.fW != null) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      try
      {
        this.fW = BitmapFactory.decodeResource(getResources(), 2130848285, localOptions);
        setIconSize(this.fU.getWidth(), this.fU.getHeight());
        atC();
        return;
        localOutOfMemoryError2 = localOutOfMemoryError2;
        QLog.e("SingleTouchLayout", 1, "controlDrawable decode failed");
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          QLog.e("SingleTouchLayout", 1, "deleteDrawable decode failed");
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = (ViewGroup)getParent();
    if ((this.ad.x == 0.0F) || (this.ad.y == 0.0F))
    {
      this.mParentWidth = ((ViewGroup)localObject).getWidth();
      this.dtA = ((ViewGroup)localObject).getHeight();
      this.ad.set(this.mParentWidth / 2, this.dtA / 2);
      atC();
      if (!this.cwV) {
        atC();
      }
      super.onDraw(paramCanvas);
      if ((this.isEditable) && (this.q != null) && (this.r != null) && (this.s != null) && (this.t != null) && (this.v != null) && (this.w != null))
      {
        this.mPath.reset();
        this.mPath.moveTo(this.q.x, this.q.y);
        this.mPath.lineTo(this.r.x, this.r.y);
        this.mPath.lineTo(this.s.x, this.s.y);
        this.mPath.lineTo(this.t.x, this.t.y);
        this.mPath.lineTo(this.q.x, this.q.y);
        this.mPath.lineTo(this.r.x, this.r.y);
        paramCanvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setFilterBitmap(true);
        this.mDstRect.set(this.v.x - this.mIconWidth / 2, this.v.y - this.mIconHeight / 2, this.v.x + this.mIconWidth / 2, this.v.y + this.mIconHeight / 2);
        if (this.fV != null) {
          break label534;
        }
        localObject = this.fU;
        label380:
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.mDstRect, this.mPaint);
        this.mDstRect.set(this.w.x - this.mIconWidth / 2, this.w.y - this.mIconHeight / 2, this.w.x + this.mIconWidth / 2, this.w.y + this.mIconHeight / 2);
        if (this.fX != null) {
          break label542;
        }
      }
    }
    label534:
    label542:
    for (localObject = this.fW;; localObject = this.fX)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, this.mDstRect, this.mPaint);
      this.mPaint.setFilterBitmap(false);
      dtj();
      return;
      if ((this.mParentWidth != 0) && (this.dtA != 0)) {
        break;
      }
      this.mParentWidth = ((ViewGroup)localObject).getWidth();
      this.dtA = ((ViewGroup)localObject).getHeight();
      atC();
      break;
      localObject = this.fV;
      break label380;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.isEditable) && (!this.cwS)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label312:
    label325:
    label356:
    do
    {
      do
      {
        for (;;)
        {
          return true;
          this.agx = System.currentTimeMillis();
          this.mLastX = paramMotionEvent.getRawX();
          this.mLastY = paramMotionEvent.getRawY();
          this.ae.set(paramMotionEvent.getX() + this.dtB, paramMotionEvent.getY() + this.dtC);
          this.mStatus = f(paramMotionEvent.getX(), paramMotionEvent.getY());
          Log.d("SingleTouchLayout", "ActionDown -- (" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ")");
        }
        Log.d("SingleTouchLayout", "ActionUp -- (" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ")");
        if ((this.a != null) && (this.isEditable))
        {
          if (this.mStatus == 2) {
            break label356;
          }
          if ((System.currentTimeMillis() - this.agx >= 100L) || (!b(this.mLastX, this.mLastY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
            break label325;
          }
          if (!O(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            break label312;
          }
          this.a.f(this);
        }
        for (;;)
        {
          this.mStatus = 0;
          break;
          this.a.e(this);
          continue;
          this.a.f(this, paramMotionEvent.getX() - this.mLastX, paramMotionEvent.getY() - this.mLastY);
          continue;
          this.a.i(this, this.mScale);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SingleTouchLayout", 4, "ActionMove: x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY());
        }
        this.af.set(paramMotionEvent.getX() + this.dtB, paramMotionEvent.getY() + this.dtC);
        if (this.mStatus != 2) {
          break;
        }
      } while (!this.isEditable);
      i = this.Ge.getWidth() / 2;
      j = this.Ge.getHeight() / 2;
      d1 = Math.sqrt(i * i + j * j);
      d2 = c(this.ad, this.af) / d1;
      if (d2 <= this.MIN_SCALE)
      {
        d1 = this.MIN_SCALE;
        f1 = 0.0F;
        if (this.cwU)
        {
          d2 = c(this.ad, this.ae);
          d3 = c(this.ae, this.af);
          d4 = c(this.ad, this.af);
          d3 = (d2 * d2 + d4 * d4 - d3 * d3) / (d2 * 2.0D * d4);
          d2 = d3;
          if (d3 >= 1.0D) {
            d2 = 1.0D;
          }
          f2 = (float)i(Math.acos(d2));
          paramMotionEvent = new PointF(this.ae.x - this.ad.x, this.ae.y - this.ad.y);
          localPointF = new PointF(this.af.x - this.ad.x, this.af.y - this.ad.y);
          f1 = f2;
          if (paramMotionEvent.x * localPointF.y - paramMotionEvent.y * localPointF.x < 0.0F) {
            f1 = -f2;
          }
        }
        if (N((float)d1, this.yC + f1))
        {
          this.yC += f1;
          this.mScale = ((float)d1);
          if (f1 != 0.0F) {
            dFR();
          }
          if (QLog.isColorLevel()) {
            QLog.d("SingleTouchLayout", 4, "ActionMove-Zoom: scale=" + this.mScale + ", deltaY=" + this.yC);
          }
        }
      }
      while (this.mStatus != 1) {
        for (;;)
        {
          int i;
          int j;
          double d2;
          double d3;
          double d4;
          PointF localPointF;
          this.ae.set(this.af);
          break;
          double d1 = d2;
          if (d2 >= this.MAX_SCALE) {
            d1 = this.MAX_SCALE;
          }
        }
      }
    } while (!this.cwS);
    float f1 = this.af.x - this.ae.x;
    float f2 = this.af.y - this.ae.y;
    if (this.cwT)
    {
      if ((getLeft() + f1 >= 0.0F) && (getRight() + f1 <= this.mParentWidth))
      {
        paramMotionEvent = this.ad;
        paramMotionEvent.x = (f1 + paramMotionEvent.x);
      }
      if ((getTop() + f2 >= 0.0F) && (getBottom() + f2 <= this.dtA)) {
        paramMotionEvent = this.ad;
      }
    }
    for (paramMotionEvent.y = (f2 + paramMotionEvent.y);; paramMotionEvent.y = (f2 + paramMotionEvent.y))
    {
      dtj();
      break;
      paramMotionEvent = this.ad;
      paramMotionEvent.x = (f1 + paramMotionEvent.x);
      paramMotionEvent = this.ad;
    }
  }
  
  public void setActualViewSize(int paramInt1, int paramInt2)
  {
    if (this.Ge != null)
    {
      this.dtG = paramInt1;
      this.dtH = paramInt2;
      atC();
    }
  }
  
  public void setBoundLimited(boolean paramBoolean)
  {
    this.cwT = paramBoolean;
  }
  
  public void setCenterPoint(float paramFloat1, float paramFloat2)
  {
    this.ad = new PointF(paramFloat1, paramFloat2);
    dtj();
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.isEditable = paramBoolean;
    invalidate();
  }
  
  public void setFrameWidth(int paramInt)
  {
    if (this.frameWidth == paramInt) {
      return;
    }
    this.frameWidth = ((int)TypedValue.applyDimension(1, paramInt, this.metrics));
    this.mPaint.setStrokeWidth(paramInt);
    invalidate();
  }
  
  public void setIconSize(int paramInt1, int paramInt2)
  {
    this.mIconWidth = paramInt1;
    this.mIconHeight = paramInt2;
    atC();
  }
  
  public void setImageDegree(float paramFloat)
  {
    if (this.yC != paramFloat)
    {
      this.yC = paramFloat;
      dFR();
      atC();
    }
  }
  
  public void setImageScale(float paramFloat)
  {
    if (this.mScale != paramFloat)
    {
      this.mScale = paramFloat;
      atC();
    }
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.cwS = paramBoolean;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.cwU = paramBoolean;
  }
  
  public void setScaleLimit(float paramFloat1, float paramFloat2)
  {
    this.MIN_SCALE = paramFloat1;
    this.MAX_SCALE = paramFloat2;
  }
  
  class a
  {
    Point A;
    Point B;
    Point C;
    int offsetX;
    int offsetY;
    int vh;
    int vw;
    Point x;
    Point y;
    Point z;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void e(View paramView);
    
    public abstract void f(View paramView);
    
    public abstract void f(View paramView, float paramFloat1, float paramFloat2);
    
    public abstract void i(View paramView, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SingleTouchLayout
 * JD-Core Version:    0.7.0.1
 */