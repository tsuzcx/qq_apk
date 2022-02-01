package com.tencent.av.widget.stageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import jmd;
import jme;
import jmf;
import jmg;
import jmh;
import jmi;

public class StageEffectView
  extends ViewGroup
{
  private static final boolean aas;
  static final int[] cX;
  static final double[] e;
  private static final float ih;
  private static final float ii;
  private static final int[][] n;
  private b jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$b;
  private jmg jdField_a_of_type_Jmg;
  private final StageMemberView[] jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView = new StageMemberView[8];
  private int aBA;
  private int aBB;
  private int aBx;
  private int aBy;
  private int aBz = 0;
  private double aL;
  private boolean aat;
  public boolean aau = init(paramContext);
  private boolean aav = true;
  private final float[] am = new float[9];
  private final Integer[] b = new Integer[8];
  private Bitmap bN;
  private Bitmap bO;
  private final int[] cY = new int[1];
  private float ij;
  private View ix;
  private final ArrayList<d> jf = new ArrayList();
  private int mActivePointerId = -1;
  private final Runnable mAnimationRunnable = new StageEffectView.2(this);
  private Camera mCamera;
  private float mCenterX;
  private float mCenterY;
  private float mDownX;
  private Interpolator mInterpolator;
  private boolean mIsBeingDragged;
  private int mLastX;
  private float mScale = 1.0F;
  private int mScroll;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private final Comparator<Integer> q = new jmh(this);
  private long qj;
  private Comparator<StageMemberView> r = new jmi(this);
  private final Matrix s = new Matrix();
  private float x;
  private float x2;
  private float y;
  private float y2;
  private float z;
  
  static
  {
    boolean bool = true;
    ih = (float)Math.sin(-0.3141592653589793D);
    ii = (float)Math.cos(-0.3141592653589793D);
    cX = new int[] { 0, 17500, 2500, 15000, 5000, 12500, 7500, 10000 };
    e = new double[] { 0.0D, 0.6981317007977318D, 2.094395102393195D, 2.879793265790644D, 3.141592653589793D, 3.403392041388943D, 4.188790204786391D, 5.585053606381854D };
    int[] arrayOfInt1 = new int[0];
    int[] arrayOfInt2 = { 0 };
    int[] arrayOfInt3 = { 1, 0 };
    int[] arrayOfInt4 = { 1, 0, 2 };
    int[] arrayOfInt5 = { 3, 1, 0, 2, 4 };
    int[] arrayOfInt6 = { 5, 3, 1, 0, 2, 4 };
    int[] arrayOfInt7 = { 5, 3, 1, 0, 2, 4, 6, 7 };
    n = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 3, 1, 0, 2 }, arrayOfInt5, arrayOfInt6, { 5, 3, 1, 0, 2, 4, 6 }, arrayOfInt7 };
    if (Build.VERSION.SDK_INT >= 11) {}
    for (;;)
    {
      aas = bool;
      return;
      bool = false;
    }
  }
  
  public StageEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StageEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private double a(float paramFloat, boolean paramBoolean)
  {
    float f = 1.0F;
    paramFloat = (paramFloat - this.mCenterX) / this.mScale / 300.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        return Math.asin(paramFloat) * 0.6499999761581421D;
        if (paramFloat < -1.0F) {
          paramFloat = -1.0F;
        }
      }
      else
      {
        return 3.141592653589793D - Math.asin(paramFloat) * 1.350000023841858D;
      }
    }
  }
  
  private int a(String[] paramArrayOfString, int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      return paramInt;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    label17:
    Object localObject;
    int m;
    d locald;
    if (k < paramInt)
    {
      localObject = paramArrayOfString[k];
      if (localObject == null) {
        break label656;
      }
      m = 0;
      if (m < this.aBx)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m] == null) {}
        do
        {
          m += 1;
          break;
          locald = (d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m].getTag();
          locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d = null;
        } while (!((String)localObject).equals(locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mKey));
        removeViewInLayout(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m]);
        this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m] = null;
        m = j + 1;
        j = i + 1;
        i = m;
      }
    }
    for (;;)
    {
      label137:
      k += 1;
      m = j;
      j = i;
      i = m;
      break label17;
      m = 0;
      for (;;)
      {
        if (m < this.jf.size())
        {
          if (((String)localObject).equals(((d)this.jf.get(m)).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mKey))
          {
            this.jf.remove(m);
            m = i + 1;
            i = j;
            j = m;
            break label137;
          }
          m += 1;
          continue;
          paramInt = i;
          if (j <= 0) {
            break;
          }
          Arrays.sort(this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView, 0, this.aBx, this.r);
          int i3 = this.aBx - j;
          paramArrayOfString = n[i3];
          int i1 = 0;
          k = 0;
          paramInt = 0;
          while (i1 < this.aBx)
          {
            localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i1];
            if (localObject == null)
            {
              i1 += 1;
            }
            else
            {
              locald = (d)((StageMemberView)localObject).getTag();
              if ((locald.aBG == 0) && ((locald.aBG < 0) || (locald.aBG >= 10000))) {
                break label425;
              }
            }
          }
          int i2;
          if (k < i3)
          {
            i2 = 0;
            m = 0;
            i1 = paramInt;
            if (i2 < this.aBx) {
              if (k < i3) {
                break label488;
              }
            }
          }
          for (i1 = paramInt;; i1 = paramInt)
          {
            this.aBx -= j;
            paramInt = 0;
            for (;;)
            {
              if (paramInt < this.aBx)
              {
                this.b[paramInt] = Integer.valueOf(paramInt);
                paramInt += 1;
                continue;
                label425:
                m = paramInt;
                if (locald.aBG != cX[paramArrayOfString[k]])
                {
                  a((StageMemberView)localObject, locald, cX[paramArrayOfString[k]], -1, 0);
                  m = Math.max(paramInt, locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.duration);
                }
                k += 1;
                paramInt = m;
                break;
                label488:
                localObject = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[(this.aBx - 1 - i2)];
                if (localObject == null)
                {
                  i1 = m;
                  m = paramInt;
                  paramInt = i1;
                }
                for (;;)
                {
                  i2 += 1;
                  i1 = m;
                  m = paramInt;
                  paramInt = i1;
                  break;
                  locald = (d)((StageMemberView)localObject).getTag();
                  i1 = paramInt;
                  if (locald.aBG != cX[paramArrayOfString[(i3 - 1 - m)]])
                  {
                    a((StageMemberView)localObject, locald, cX[paramArrayOfString[(i3 - 1 - m)]], -1, 0);
                    i1 = Math.max(paramInt, locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.duration);
                  }
                  paramInt = m + 1;
                  k += 1;
                  m = i1;
                }
              }
            }
            axU();
            invalidate();
            paramInt = i;
            if (paramArrayOfInt == null) {
              break;
            }
            paramArrayOfInt[0] = i1;
            return i;
          }
        }
      }
      label656:
      m = i;
      i = j;
      j = m;
    }
  }
  
  private void a(int paramInt, d paramd)
  {
    paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d = null;
    paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a = null;
    if (paramInt < 0)
    {
      this.jf.add(paramd);
      return;
    }
    this.jf.add(paramInt, paramd);
  }
  
  private void a(d paramd, StageMemberView paramStageMemberView)
  {
    d locald = paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d;
    locald.a(paramd);
    paramStageMemberView.setTag(locald);
    paramStageMemberView.setBackgroundDrawable(locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mIcon);
    paramStageMemberView.ac(locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mText, false);
    if (this.jf.remove(locald)) {
      a(-1, paramd);
    }
  }
  
  @TargetApi(11)
  private void a(d paramd, StageMemberView paramStageMemberView, int paramInt)
  {
    paramInt = jme.mod(paramInt, 20000);
    int i = paramInt / 2500;
    if (i < e.length - 1) {}
    for (double d1 = e[(i + 1)] - e[i];; d1 = 6.283185307179586D - e[i])
    {
      double d2 = (paramInt - i * 2500) / 2500.0D;
      paramd.aBG = paramInt;
      d1 = d1 * d2 + e[i];
      this.x = ((float)(Math.sin(d1) * 300.0D));
      this.y = 0.0F;
      this.z = (-(float)(Math.cos(d1) * 300.0D));
      this.x2 = this.x;
      this.y2 = (this.y * ii - this.z * ih);
      this.ij = (this.y * ih + this.z * ii);
      this.mCamera.save();
      this.mCamera.translate(this.x2, this.y2, this.ij);
      this.mCamera.getMatrix(this.s);
      this.mCamera.restore();
      this.s.postScale(this.mScale, this.mScale);
      this.s.postTranslate(this.mCenterX, this.mCenterY);
      this.s.getValues(this.am);
      paramd.x = this.x2;
      paramd.y = this.y2;
      paramd.z = this.ij;
      paramd.t.set(this.s);
      paramd.io = this.am[0];
      if (this.z > 150.0F) {
        paramd.io *= (1.0F - (this.z - 150.0F) / 150.0F * 0.4F);
      }
      paramd.im = this.am[2];
      paramd.in = this.am[5];
      b((int)paramd.im, (int)paramd.in, paramStageMemberView);
      if (aas)
      {
        paramStageMemberView.setScaleX(paramd.io);
        paramStageMemberView.setScaleY(paramd.io);
      }
      if ((paramd.aBG == 0) && (this.aBy == 0))
      {
        paramd = new int[2];
        paramStageMemberView.getLocationInWindow(paramd);
        this.aBy = paramd[1];
      }
      return;
    }
  }
  
  private void a(StageMemberView paramStageMemberView, d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0) {
      paramStageMemberView.setVisibility(4);
    }
    paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a = new a(paramd.aBG, jme.mod(paramInt1, 20000), paramInt2, paramInt3, null);
  }
  
  private boolean a(d paramd, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    int i = this.aBx;
    StageMemberView localStageMemberView = new StageMemberView(getContext(), this.bN, this.bO);
    localStageMemberView.b = paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.a;
    localStageMemberView.setBackgroundDrawable(paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mIcon);
    localStageMemberView.layout(-54, -54, 54, 66);
    localStageMemberView.setTag(paramd);
    if (this.aat) {
      localStageMemberView.ac(paramd.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mText, false);
    }
    ln(true);
    super.addViewInLayout(localStageMemberView, getChildCount(), generateDefaultLayoutParams());
    this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i] = localStageMemberView;
    this.aBx += 1;
    if ((paramBoolean2) || (paramInt2 > 0) || (paramBoolean1))
    {
      a(paramd, localStageMemberView, cX[7]);
      paramInt1 = cX[i] + paramInt1;
      paramBoolean1 = bool;
      if (paramd.aBG != paramInt1) {
        a(localStageMemberView, paramd, paramInt1, -1, paramInt2);
      }
    }
    for (paramBoolean1 = true;; paramBoolean1 = bool)
    {
      this.b[i] = Integer.valueOf(i);
      axU();
      return paramBoolean1;
      a(paramd, localStageMemberView, cX[i]);
      invalidate();
    }
  }
  
  private void axU()
  {
    Arrays.sort(this.b, 0, this.aBx, this.q);
  }
  
  private void axV()
  {
    int j;
    int i;
    if (this.aBz != 0)
    {
      j = 1;
      if (this.aBx < 8) {
        break label81;
      }
      i = Math.round(this.mScroll / 2500.0F) * 2500 - this.mScroll;
    }
    for (;;)
    {
      this.qj = SystemClock.uptimeMillis();
      this.aBz |= 0x2;
      this.aBA = i;
      this.aBB = 0;
      if (j == 0) {
        axX();
      }
      return;
      j = 0;
      break;
      label81:
      int k = jme.a(this.mScroll, 0, 20000, false);
      i = k;
      if (k > 10000) {
        i = -(20000 - k);
      }
    }
  }
  
  @TargetApi(16)
  private void axX()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(this.mAnimationRunnable);
      return;
    }
    postDelayed(this.mAnimationRunnable, 16L);
  }
  
  private void axY()
    throws IllegalStateException
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("must call in ui thread");
    }
  }
  
  private static void b(int paramInt1, int paramInt2, View paramView)
  {
    int i = paramView.getWidth() / 2;
    int j = paramView.getLeft();
    int k = paramView.getHeight() / 2;
    int m = paramView.getTop();
    paramView.offsetLeftAndRight(paramInt1 - (i + j));
    paramView.offsetTopAndBottom(paramInt2 - (k + m));
  }
  
  @TargetApi(11)
  private void endAnimation()
  {
    removeCallbacks(this.mAnimationRunnable);
    this.aBz = 0;
  }
  
  private boolean init(Context paramContext)
  {
    this.mCamera = new Camera();
    this.mInterpolator = jmd.a();
    setChildrenDrawingOrderEnabled(true);
    setWillNotDraw(true);
    setClipChildren(false);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_Jmg = new jmg(paramContext);
    this.jdField_a_of_type_Jmg.setFriction(0.05F);
    int i = (int)(70.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    float f1 = Math.max(1.0F, 0.75F * paramContext.getResources().getDisplayMetrics().density);
    try
    {
      this.bN = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.bN);
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      paramContext.setDither(true);
      float f2 = i * 0.0625F + 2.0F;
      RectF localRectF1 = new RectF(f2, f2, i - f2, i - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(1.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setColor(-1593835521);
      localCanvas.drawOval(localRectF1, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-1);
      paramContext.setStrokeWidth(f1 * 2.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF1, paramContext);
      this.bO = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(this.bO);
      RectF localRectF2 = new RectF(f2, f2, i - f2, i - f2);
      paramContext.setMaskFilter(new BlurMaskFilter(f2 + 4.0F, BlurMaskFilter.Blur.OUTER));
      paramContext.setStyle(Paint.Style.FILL);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setColor(-1608790934);
      localCanvas.drawOval(localRectF2, paramContext);
      paramContext.setMaskFilter(null);
      paramContext.setColor(-15554453);
      paramContext.setStrokeWidth(f1 * 4.0F);
      paramContext.setStyle(Paint.Style.STROKE);
      localRectF1.inset(f1, f1);
      localCanvas.drawOval(localRectF2, paramContext);
      this.aat = true;
      if (!aas) {
        setStaticTransformationsEnabled(true);
      }
      return true;
    }
    catch (OutOfMemoryError paramContext) {}
    return false;
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void ln(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.aBx)
    {
      StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[this.b[(this.aBx - 1 - i)].intValue()];
      localStageMemberView.ac(((d)localStageMemberView.getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mText, true);
      i += 1;
    }
  }
  
  private void nT(int paramInt)
  {
    if (paramInt == 0) {}
    label555:
    for (;;)
    {
      return;
      int k = this.mScroll;
      int i = this.aBx;
      int j = this.jf.size() + i;
      int m = this.mScroll;
      if (j < 8) {}
      Object localObject1;
      Object localObject2;
      for (i = 8;; i = j)
      {
        this.mScroll = jme.mod(m + paramInt, i * 2500);
        k /= 2500;
        m = this.mScroll / 2500;
        i = 0;
        while (i < this.aBx)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i];
          localObject2 = (d)((StageMemberView)localObject1).getTag();
          float f = ((d)localObject2).im;
          f = ((d)localObject2).in;
          a((d)localObject2, (StageMemberView)localObject1, ((d)localObject2).aBG + paramInt);
          i += 1;
        }
      }
      if ((j > 8) && (k != m))
      {
        d locald;
        if (paramInt > 0)
        {
          j = (m + j - k) % j;
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.aBx) {
              break label349;
            }
            localObject1 = (d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
            if ((((d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt - 1 + 8) % 8)].getTag()).aBG < 10000) && (((d)localObject1).aBG >= 10000))
            {
              i = 0;
              while (i < j)
              {
                localObject1 = (d)this.jf.remove(0);
                localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((j - 1 - i + paramInt) % 8)];
                locald = (d)((StageMemberView)localObject2).getTag();
                ((d)localObject1).a(locald);
                ((StageMemberView)localObject2).setTag(localObject1);
                ((StageMemberView)localObject2).setBackgroundDrawable(((d)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mIcon);
                ((StageMemberView)localObject2).ac(((d)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mText, false);
                a(-1, locald);
                i += 1;
              }
              break;
            }
            paramInt += 1;
          }
        }
        else
        {
          label349:
          if (paramInt < 0)
          {
            j = jme.mod(k - m, j);
            paramInt = this.aBx - 1;
            for (;;)
            {
              if (paramInt < 0) {
                break label555;
              }
              localObject1 = (d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt].getTag();
              if ((((d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[((paramInt + 1 + 8) % 8)].getTag()).aBG > 10000) && (((d)localObject1).aBG < 10000))
              {
                i = 0;
                while (i < j)
                {
                  localObject1 = (d)this.jf.remove(this.jf.size() - 1);
                  k = jme.mod(paramInt - (j - 1 - i), 8);
                  localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[k];
                  locald = (d)((StageMemberView)localObject2).getTag();
                  ((d)localObject1).a(locald);
                  ((StageMemberView)localObject2).setTag(localObject1);
                  ((StageMemberView)localObject2).setBackgroundDrawable(((d)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mIcon);
                  ((StageMemberView)localObject2).ac(((d)localObject1).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c.mText, false);
                  a(0, locald);
                  i += 1;
                }
                break;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  @TargetApi(16)
  void axW()
  {
    long l = SystemClock.uptimeMillis();
    int j;
    StageMemberView localStageMemberView;
    d locald;
    int k;
    label86:
    label219:
    label232:
    float f1;
    int m;
    if ((this.aBz & 0x10) == 16)
    {
      j = 0;
      i = 0;
      if (i < this.aBx)
      {
        localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i];
        locald = (d)localStageMemberView.getTag();
        k = locald.aBG;
        if (locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a != null)
        {
          if (locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.cZ == null) {
            break label219;
          }
          j = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.cZ[0];
          if (l >= locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.beginTime) {
            break label232;
          }
        }
        for (;;)
        {
          if ((locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d != null) && (((locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a != null) && (!locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aax) && (k < 10000) && (locald.aBG >= 10000)) || ((locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a != null) && (locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aax) && (k > 10000) && (locald.aBG <= 10000)) || ((this.aBz == 16) && (locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a == null)))) {
            a(locald, localStageMemberView);
          }
          j = 1;
          i += 1;
          break;
          j = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.duration;
          break label86;
          if (l < locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.beginTime + j)
          {
            localStageMemberView.setVisibility(0);
            f1 = (float)(l - locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.beginTime) / j;
            if (locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aax) {}
            float f2;
            for (j = (int)(locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBC - this.mInterpolator.getInterpolation(f1) * locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBE);; j = (int)(this.mInterpolator.getInterpolation(f1) * locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBE + f2))
            {
              m = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBF;
              locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBF = j;
              a(locald, localStageMemberView, locald.aBG + (j - m));
              break;
              f2 = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBC;
            }
          }
          localStageMemberView.setVisibility(0);
          j = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBD;
          m = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBF;
          locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBF = locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a.aBD;
          a(locald, localStageMemberView, j - m + locald.aBG);
          locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a = null;
        }
      }
      i = j;
      if (j == 0) {
        this.aBz &= 0xFFFFFFEF;
      }
    }
    for (int i = j;; i = 0)
    {
      switch (this.aBz & 0xF)
      {
      default: 
        axU();
        if (i == 0) {
          break label946;
        }
        if (Build.VERSION.SDK_INT >= 16) {
          postOnAnimation(this.mAnimationRunnable);
        }
        break;
      }
      for (;;)
      {
        invalidate();
        return;
        f1 = (float)(l - this.qj) / (Math.abs(this.aBA) * 0.2F);
        if (f1 >= 1.0F)
        {
          j = this.aBA;
          k = this.aBB;
          this.aBB = this.aBA;
          k = j - k;
          j = i;
        }
        for (;;)
        {
          i = this.aBx;
          m = this.jf.size();
          this.mScroll = jme.mod(this.mScroll + k, (i + m) * 2500);
          m = 0;
          for (;;)
          {
            i = j;
            if (m >= this.aBx) {
              break;
            }
            localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[m];
            locald = (d)localStageMemberView.getTag();
            i = locald.aBG;
            a(locald, localStageMemberView, locald.aBG + k);
            if ((locald.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d != null) && ((j == 0) || ((this.aBB > 0) && (i < 10000) && (locald.aBG >= 10000)) || ((this.aBB < 0) && (i > 10000) && (locald.aBG <= 10000)))) {
              a(locald, localStageMemberView);
            }
            m += 1;
          }
          j = 1;
          i = (int)(this.mInterpolator.getInterpolation(f1) * this.aBA);
          k = this.aBB;
          this.aBB = i;
          k = i - k;
        }
        f1 = (float)(l - this.qj) / 500.0F;
        j = this.aBA;
        if (f1 < 1.0F)
        {
          j = (int)(this.mInterpolator.getInterpolation(f1) * this.aBA);
          i = 1;
        }
        nT(j - this.aBB);
        this.aBB = j;
        break;
        if (this.jdField_a_of_type_Jmg.computeScrollOffset()) {
          i = 1;
        }
        j = this.jdField_a_of_type_Jmg.getCurrX();
        nT(j - this.aBB);
        this.aBB = j;
        break;
        postDelayed(this.mAnimationRunnable, 16L);
      }
      label946:
      invalidate();
      endAnimation();
      return;
    }
  }
  
  public boolean b(String... paramVarArgs)
  {
    axY();
    if (this.aBz != 0) {}
    int k;
    for (int i = 1;; i = 0)
    {
      if ((this.mIsBeingDragged) || (this.aBz != 0)) {
        postDelayed(new StageEffectView.4(this, paramVarArgs), 500L);
      }
      int j = this.aBx;
      k = a(paramVarArgs, paramVarArgs.length, this.cY);
      ln(true);
      if (this.aBx >= j) {
        break label163;
      }
      if (this.jf.size() <= 0) {
        break;
      }
      int m = Math.min(this.jf.size(), 8 - this.aBx);
      j = 0;
      while (j < m)
      {
        a((d)this.jf.remove(0), 0, true, true, 0);
        j += 1;
      }
    }
    this.mScroll = 0;
    this.aBz = 16;
    if (i == 0) {
      axX();
    }
    label163:
    return k > 0;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.b[paramInt2].intValue();
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    d locald = (d)paramView.getTag();
    paramTransformation = paramTransformation.getMatrix();
    paramTransformation.postScale(locald.io, locald.io);
    paramTransformation.preTranslate(-paramView.getWidth() / 2.0F, -paramView.getHeight() / 2.0F);
    paramTransformation.postTranslate(paramView.getWidth() / 2.0F, paramView.getHeight() / 2.0F);
    return true;
  }
  
  public boolean isLayoutRequested()
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      float f1 = paramInt1 / 832.0F;
      float f2 = (paramInt2 - paramInt3 - paramInt4) / 444.0F;
      if (f2 >= f1)
      {
        this.mScale = f1;
        f2 = this.mScale;
        float f3 = getPaddingLeft();
        this.mCenterX = (paramInt1 / 2.0F + f3);
      }
      for (this.mCenterY = ((paramInt2 - f2 * 444.0F) / 2.0F + 96.770576F * f1);; this.mCenterY = (getPaddingTop() + 96.770576F * f2))
      {
        paramInt1 = 0;
        while (paramInt1 < this.aBx)
        {
          StageMemberView localStageMemberView = this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[paramInt1];
          Object localObject = (d)localStageMemberView.getTag();
          a((d)localObject, localStageMemberView, ((d)localObject).aBG);
          if ((((d)localObject).aBG == 0) && (this.aBy == 0))
          {
            localObject = new int[2];
            localStageMemberView.getLocationInWindow((int[])localObject);
            this.aBy = localObject[1];
          }
          paramInt1 += 1;
        }
        this.mScale = f2;
        f1 = getPaddingLeft();
        this.mCenterX = (paramInt1 / 2.0F + f1);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    setMeasuredDimension(getDefaultSize(i + 832 + j, paramInt1), getDefaultSize(k + 444 + m, paramInt2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      do
      {
        do
        {
          int i;
          do
          {
            return true;
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if (((this.mIsBeingDragged) || (this.aBz != 0)) && (this.aBx > 0))
            {
              localObject1 = getParent();
              if (localObject1 != null) {
                ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
              }
              if (this.ix != null)
              {
                this.ix.setPressed(false);
                this.ix = null;
              }
              i = 0;
              while (i < this.aBx)
              {
                ((d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i].getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d = null;
                i += 1;
              }
              this.mIsBeingDragged = true;
              this.aBz &= 0xFFFFFFF0;
            }
            for (;;)
            {
              ln(true);
              this.mDownX = f1;
              this.mLastX = ((int)this.mDownX);
              this.aav = true;
              this.aL = a(f1, this.aav);
              this.mActivePointerId = paramMotionEvent.getPointerId(0);
              return true;
              i = getChildCount() - 1;
              for (;;)
              {
                if (i < 0) {
                  break label398;
                }
                localObject1 = getChildAt(this.b[i].intValue());
                localObject2 = (d)((View)localObject1).getTag();
                f3 = ((d)localObject2).io * 54.0F;
                f4 = ((d)localObject2).in;
                f5 = ((d)localObject2).in;
                f6 = ((d)localObject2).im;
                f7 = ((d)localObject2).im;
                if ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3))
                {
                  ((View)localObject1).setPressed(true);
                  if (this.ix == localObject1) {
                    break;
                  }
                  if (this.ix != null) {
                    this.ix.setPressed(false);
                  }
                  this.ix = ((View)localObject1);
                  break;
                }
                i -= 1;
              }
            }
            i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          } while ((i == -1) || (i >= paramMotionEvent.getPointerCount()));
          f1 = paramMotionEvent.getX(i);
          f2 = this.mDownX;
          if ((!this.mIsBeingDragged) && (Math.abs(f1 - f2) > this.mTouchSlop) && (this.aBx > 0))
          {
            this.mIsBeingDragged = true;
            if (this.ix != null)
            {
              this.ix.setPressed(false);
              this.ix = null;
            }
            i = 0;
            while (i < this.aBx)
            {
              ((d)this.jdField_a_of_type_ArrayOfComTencentAvWidgetStageviewStageMemberView[i].getTag()).jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d = null;
              i += 1;
            }
            this.aBz &= 0xFFFFFFF0;
          }
          if (this.mIsBeingDragged)
          {
            double d = a(f1, this.aav);
            nT((int)((d - this.aL) * 45.0D / 40.0D / 6.283185307179586D * 20000.0D));
            axU();
            this.aL = d;
            this.mLastX = ((int)f1);
            invalidate();
            return true;
          }
        } while (this.ix == null);
        f2 = paramMotionEvent.getY();
        paramMotionEvent = (d)this.ix.getTag();
        f3 = paramMotionEvent.io * 54.0F;
        f4 = paramMotionEvent.in;
        f5 = paramMotionEvent.in;
        f6 = paramMotionEvent.im;
        f7 = paramMotionEvent.im;
      } while ((f1 >= f6 - f3) && (f1 < f7 + f3) && (f2 >= f4 - f3) && (f2 < f5 + f3));
      this.ix.setPressed(false);
      this.ix = null;
      return true;
    case 1: 
      label398:
      if ((this.ix != null) && (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$b != null))
      {
        playSoundEffect(0);
        paramMotionEvent = (d)this.ix.getTag();
        localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$b;
        localObject2 = this.ix;
        if (paramMotionEvent.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d != null)
        {
          paramMotionEvent = paramMotionEvent.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c;
          ((b)localObject1).a(this, (View)localObject2, paramMotionEvent);
        }
      }
      for (;;)
      {
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        invalidate();
        return true;
        paramMotionEvent = paramMotionEvent.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c;
        break;
        if (this.mIsBeingDragged)
        {
          paramMotionEvent = this.mVelocityTracker;
          paramMotionEvent.computeCurrentVelocity(1000, 2000.0F);
          f1 = paramMotionEvent.getXVelocity();
          if (Math.abs(f1) > 400.0F) {
            t(f1 * 0.0005D);
          } else {
            axV();
          }
        }
      }
    }
    if (this.ix != null)
    {
      this.ix.setPressed(false);
      this.ix = null;
    }
    if (this.mIsBeingDragged) {
      axV();
    }
    this.mIsBeingDragged = false;
    this.mActivePointerId = -1;
    recycleVelocityTracker();
    invalidate();
    return true;
  }
  
  public void setOnIconClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$b = paramb;
  }
  
  void t(double paramDouble)
  {
    if (this.aBz != 0) {}
    for (int i = 1;; i = 0)
    {
      this.aBz |= 0x3;
      this.jdField_a_of_type_Jmg.a(this.mScroll, 0, (int)(20000.0D * paramDouble), 0, -2147483648, 2147483647, 0, 0, 0, 0, 2500, 0);
      this.aBB = this.mScroll;
      if (i == 0) {
        axX();
      }
      return;
    }
  }
  
  static class a
  {
    final int aBC;
    final int aBD;
    int aBE;
    int aBF;
    final boolean aax;
    final long beginTime;
    int[] cZ;
    final int duration;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.aBC = jme.mod(paramInt1, 20000);
      this.aBD = paramInt2;
      this.beginTime = (SystemClock.uptimeMillis() + paramInt4);
      this.aBF = paramInt1;
      paramInt1 = jme.a(paramInt1, this.aBD, 20000, true);
      if (paramInt1 > 10000) {
        this.aBE = (20000 - paramInt1);
      }
      for (this.aax = false; paramInt3 == -1; this.aax = true)
      {
        this.duration = ((int)(0.1F * this.aBE));
        return;
        this.aBE = paramInt1;
      }
      this.duration = paramInt3;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(StageEffectView paramStageEffectView, View paramView, StageEffectView.c paramc);
  }
  
  public static class c
  {
    public jmf a;
    public Drawable mIcon;
    public final String mKey;
    public String mText;
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof c)) && (((c)paramObject).mKey.equals(this.mKey));
    }
  }
  
  public static class d
  {
    StageEffectView.a jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$a;
    StageEffectView.c jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$c;
    d jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$d;
    public int aBG;
    float im;
    float in;
    float io;
    final Matrix t = new Matrix();
    float x;
    float y;
    public float z;
    
    void a(d paramd)
    {
      this.aBG = paramd.aBG;
      this.x = paramd.x;
      this.y = paramd.y;
      this.z = paramd.z;
      this.im = paramd.im;
      this.in = paramd.in;
      this.io = paramd.im;
      this.t.set(paramd.t);
      this.a = paramd.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView
 * JD-Core Version:    0.7.0.1
 */