package com.tencent.mobileqq.activity.recent.cur;

import aalh.a;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DragFrameLayout
  extends FrameLayout
  implements aalh.a
{
  private static final int[] jD = { 2130843239, 2130843240, 2130843241, 2130843242, 2130843243 };
  private PointF U = new PointF(-1.0F, -1.0F);
  private AllBornRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner;
  private BornRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner;
  private ShakeRunner jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner;
  private a jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$b;
  private Rect bt = new Rect();
  private int chA;
  private final int chv;
  private final int chw;
  private final int chx;
  private int chy;
  private int chz;
  private View ef;
  private Bitmap eo;
  private Bitmap ep;
  private int mMode = -1;
  private Paint mPaint = new Paint();
  private float rt;
  private final List<c> vs = new ArrayList();
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
    this.chw = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.chx = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.chv = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setWillNotDraw(false);
    this.chw = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.chx = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.chv = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setWillNotDraw(false);
    this.chw = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.chx = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.chv = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  private void Cs(boolean paramBoolean)
  {
    if (this.mMode == -1) {
      this.chy = 0;
    }
    Iterator localIterator = this.vs.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(paramBoolean, this.chz, this);
    }
  }
  
  private void Q(Canvas paramCanvas)
  {
    if (this.mMode == -1) {}
    do
    {
      do
      {
        do
        {
          return;
          this.mPaint.setAntiAlias(true);
          if (this.chy != 0) {
            this.mPaint.setColor(this.chy);
          }
          while (this.mMode == 0)
          {
            paramCanvas.drawBitmap(this.ep, this.bt.left, this.bt.top, this.mPaint);
            return;
            if (this.chz == 1) {
              this.mPaint.setColor(-4797728);
            } else {
              this.mPaint.setColor(-65536);
            }
          }
          if (this.mMode == 1)
          {
            paramCanvas.save();
            f3 = this.chA / 1.5F;
            f2 = this.chA * (0.8F - 0.45F * this.rt / this.chv);
            f1 = f2;
            if (f2 > this.chx) {
              f1 = this.chx;
            }
            f2 = f1;
            if (f1 < this.chw) {
              f2 = this.chw;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Drag", 2, "MODE_DRAG:" + f2 + " for " + this.rt + ", " + this.chv);
            }
            paramCanvas.translate(this.bt.centerX(), this.bt.centerY());
            paramCanvas.rotate((float)(Math.atan2(this.U.y - this.bt.centerY(), this.U.x - this.bt.centerX()) * 57.295779513082323D) - 90.0F);
            paramCanvas.translate(-f3, -f2);
            a(paramCanvas, f2, f3);
            paramCanvas.restore();
            this.mPaint.setColor(-16711936);
            paramCanvas.drawBitmap(this.ep, this.U.x - this.bt.width() / 2.0F, this.U.y - this.bt.height() / 2.0F, this.mPaint);
            return;
          }
          if ((this.mMode != 3) && (this.mMode != 6)) {
            break;
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner == null) || (this.ep == null));
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner.c();
        this.U.set((PointF)localObject);
        this.rt = ((float)Math.sqrt((this.U.x - this.bt.centerX()) * (this.U.x - this.bt.centerX()) + (this.U.y - this.bt.centerY()) * (this.U.y - this.bt.centerY())));
        paramCanvas.save();
        float f3 = this.chA / 1.5F;
        float f2 = (1.0F - this.rt / this.chv) * f3;
        float f1 = f2;
        if (f2 > this.chx / 2) {
          f1 = this.chx / 2;
        }
        f2 = f1;
        if (f1 < this.chw) {
          f2 = this.chw;
        }
        paramCanvas.translate(this.bt.centerX(), this.bt.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.U.y - this.bt.centerY(), this.U.x - this.bt.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.mPaint.setColor(-16711936);
        paramCanvas.drawBitmap(this.ep, this.U.x - this.bt.width() / 2.0F, this.U.y - this.bt.height() / 2.0F, this.mPaint);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner, 60L);
        return;
        if (this.mMode == 2)
        {
          paramCanvas.drawBitmap(this.ep, this.U.x - this.bt.width() / 2.0F, this.U.y - this.bt.height() / 2.0F, this.mPaint);
          return;
        }
        if (this.mMode != 4) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner == null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner.ap();
      if (localObject != null) {
        paramCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new RectF(this.U.x - ((Bitmap)localObject).getWidth() / 2.0F, this.U.y - ((Bitmap)localObject).getHeight() / 2.0F, this.U.x + ((Bitmap)localObject).getWidth() / 2.0F, this.U.y + ((Bitmap)localObject).getHeight() / 2.0F), this.mPaint);
      }
      postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner, 50L);
      return;
    } while ((this.mMode != 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner == null));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner.c();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner.ap();
    if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
      paramCanvas.drawBitmap(localBitmap, new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.mPaint);
    }
    postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner, 40L);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "drawAtOrigion:" + paramFloat1 + ", " + paramFloat2);
    }
    float f1 = paramFloat1 + this.rt;
    float f2 = paramFloat1 / 2.0F;
    float f3 = this.rt;
    float f4 = paramFloat1 / 2.0F;
    float f5 = this.rt;
    float f6 = paramFloat1 / 2.0F;
    float f7 = this.rt;
    float f8 = paramFloat1 / 2.0F;
    float f9 = this.rt;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.mPaint);
    Path localPath = new Path();
    localPath.moveTo(paramFloat2 + paramFloat1, paramFloat1);
    localPath.cubicTo(paramFloat2 + f6, paramFloat1 + 0.3F * f7, paramFloat2 + f8, paramFloat1 + 0.7F * f9, paramFloat2 + paramFloat2, 0.5F + f1);
    localPath.lineTo(paramFloat2 - paramFloat2, 0.5F + f1);
    localPath.cubicTo(paramFloat2 - f4, paramFloat1 + 0.7F * f5, paramFloat2 - f2, paramFloat1 + 0.3F * f3, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath(localPath, this.mPaint);
  }
  
  public static DragFrameLayout b(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if ((localView != null) && ((localView instanceof DragFrameLayout))) {
      return (DragFrameLayout)localView;
    }
    paramActivity = new DragFrameLayout(paramActivity.getApplication());
    localViewGroup.addView(paramActivity, 0);
    localViewGroup.removeView(localView);
    paramActivity.addView(localView);
    return paramActivity;
  }
  
  private static Bitmap d(View paramView)
  {
    Object localObject3 = null;
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = paramView.getDrawingCache();
    Object localObject1 = localObject3;
    if (localBitmap != null) {}
    try
    {
      localObject1 = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      paramView.setDrawingCacheEnabled(false);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void d(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$b.a(paramFloat1, paramFloat2, paramInt, this.ef);
    }
  }
  
  private void setMode(int paramInt)
  {
    this.mMode = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setMode:" + this.mMode);
    }
  }
  
  public void a(c paramc)
  {
    if ((paramc != null) && (this.vs.contains(paramc))) {
      this.vs.remove(paramc);
    }
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    if ((paramc != null) && (!this.vs.contains(paramc)))
    {
      if (!paramBoolean) {
        this.vs.add(paramc);
      }
    }
    else {
      return;
    }
    this.vs.add(0, paramc);
  }
  
  public void aa(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "onModeChanged:" + paramView);
    }
    this.chy = 0;
    this.eo = d(paramView);
    if (this.eo != null)
    {
      this.chy = this.eo.getPixel(this.eo.getWidth() / 2, 1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "getOrginalCachePixel:" + this.chy);
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.1F, 1.1F);
      this.ep = Bitmap.createBitmap(this.eo, 0, 0, this.eo.getWidth(), this.eo.getHeight(), (Matrix)localObject, true);
      getGlobalVisibleRect(this.bt);
      int i = this.bt.left;
      int j = this.bt.top;
      paramView.getGlobalVisibleRect(this.bt);
      localObject = this.bt;
      ((Rect)localObject).left -= i;
      localObject = this.bt;
      ((Rect)localObject).top -= j;
      localObject = this.bt;
      ((Rect)localObject).right -= i;
      localObject = this.bt;
      ((Rect)localObject).bottom -= j;
      i = this.bt.width();
      j = this.bt.height();
      localObject = this.bt;
      ((Rect)localObject).left = ((int)(((Rect)localObject).left - (i * 1.1F - i) / 2.0F));
      localObject = this.bt;
      float f = ((Rect)localObject).right;
      ((Rect)localObject).right = ((int)((i * 1.1F - i) / 2.0F + f));
      localObject = this.bt;
      ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom + (j * 1.1F - j) / 2.0F));
      localObject = this.bt;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - (j * 1.1F - j) / 2.0F));
      this.chA = ((int)(Math.min(this.bt.width(), this.bt.height()) * 0.8D));
      if (this.chA > this.chx) {
        this.chA = this.chx;
      }
      this.ef = paramView;
      setMode(0);
      this.chz = paramInt;
      paramView.setVisibility(4);
      invalidate();
      Cs(false);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "init:" + this.bt);
      }
    }
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    super.addChildrenForAccessibility(paramArrayList);
    int i = 0;
    View localView;
    if (i < paramArrayList.size())
    {
      localView = (View)paramArrayList.get(i);
      if (localView.getId() != 2131370213) {}
    }
    for (;;)
    {
      if (localView != null)
      {
        paramArrayList.remove(localView);
        paramArrayList.add(0, localView);
      }
      return;
      i += 1;
      break;
      localView = null;
    }
  }
  
  public View bI()
  {
    return this.ef;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      label5:
      Q(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    boolean bool1;
    if (this.mMode == -1)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.d("Drag", 2, "Host.dispatchTouchEvent: Down At<" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ">");
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (QLog.isColorLevel()) {
                  QLog.d("Drag", 2, "Host.dispatchTouchEvent: " + paramMotionEvent.getAction() + " At<" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ">");
                }
                if ((this.mMode != 6) && (this.chz == 4))
                {
                  setMode(6);
                  paramMotionEvent = new RectF(this.bt.centerX(), this.bt.centerY(), this.bt.centerX() - 6, this.bt.centerY());
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = new ShakeRunner(new PointF(this.bt.centerX(), this.bt.centerY()), paramMotionEvent);
                  invalidate();
                }
                if ((i != 3) && (i != 1)) {
                  break;
                }
                d(this.bt.centerX() - f1, this.bt.centerY() - f2, -1);
                if (this.mMode == 0)
                {
                  this.ep = null;
                  this.ef.setVisibility(0);
                  this.ef = null;
                  setMode(-1);
                  invalidate();
                  Cs(false);
                  return true;
                }
                if (this.mMode == 1)
                {
                  setMode(3);
                  this.U.set(f1, f2);
                  paramMotionEvent = new RectF(this.bt.centerX(), this.bt.centerY(), this.U.x, this.U.y);
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = new ShakeRunner(new PointF(this.bt.centerX(), this.bt.centerY()), paramMotionEvent);
                  invalidate();
                  return true;
                }
                bool1 = bool2;
              } while (this.mMode == 3);
              if (this.mMode == 2)
              {
                if ((float)Math.sqrt((f1 - this.bt.centerX()) * (f1 - this.bt.centerX()) + (f2 - this.bt.centerY()) * (f2 - this.bt.centerY())) < (this.chA + this.chv) / 2)
                {
                  this.ep = null;
                  this.ef.setVisibility(0);
                  this.ef = null;
                  setMode(-1);
                  Cs(false);
                }
                for (;;)
                {
                  invalidate();
                  return true;
                  setMode(4);
                  this.U.set(f1, f2);
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner = new BornRunner(this.U);
                }
              }
              bool1 = bool2;
            } while (this.mMode == 4);
            bool1 = bool2;
          } while (this.mMode != 6);
          return true;
          bool1 = bool2;
        } while (i != 2);
        if ((this.mMode == 0) || (this.mMode == 1))
        {
          float f3 = (float)Math.sqrt((f1 - this.bt.centerX()) * (f1 - this.bt.centerX()) + (f2 - this.bt.centerY()) * (f2 - this.bt.centerY()));
          if (f3 >= this.chA + this.chv)
          {
            this.rt = f3;
            this.U.set(f1, f2);
            setMode(2);
            d(this.bt.centerX() - f1, this.bt.centerY() - f2, 2);
          }
          for (;;)
          {
            invalidate();
            return true;
            if (f3 >= 0.0F)
            {
              this.rt = f3;
              this.U.set(f1, f2);
              setMode(1);
              d(this.bt.centerX() - f1, this.bt.centerY() - f2, 1);
            }
            else
            {
              setMode(0);
              d(0.0F, 0.0F, 0);
            }
          }
        }
        bool1 = bool2;
      } while (this.mMode == 3);
      if (this.mMode == 2)
      {
        this.U.set(f1, f2);
        d(this.bt.centerX() - f1, this.bt.centerY() - f2, 2);
        invalidate();
        return true;
      }
      bool1 = bool2;
    } while (this.mMode != 6);
    return true;
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  public void onPause()
  {
    if (this.mMode != -1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$ShakeRunner = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$BornRunner = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$AllBornRunner = null;
      }
      setMode(-1);
      Cs(false);
      this.ep = null;
      this.ef = null;
    }
  }
  
  public void setDragViewProvider(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$a = parama;
  }
  
  public void setOnDragListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$b = paramb;
  }
  
  class AllBornRunner
    implements Runnable
  {
    private int mIndex;
    private List<View> vt;
    
    public AllBornRunner()
    {
      Collection localCollection;
      this.vt = new ArrayList(localCollection);
      this.mIndex = -1;
    }
    
    public Bitmap ap()
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.mIndex >= 0)
      {
        localObject1 = localObject2;
        if (this.mIndex >= DragFrameLayout.p().length) {}
      }
      try
      {
        localObject1 = BitmapFactory.decodeResource(DragFrameLayout.this.getResources(), DragFrameLayout.p()[this.mIndex]);
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          localObject1 = localObject2;
        } while (!QLog.isColorLevel());
        QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + localOutOfMemoryError, localOutOfMemoryError);
      }
      return null;
    }
    
    public PointF c()
    {
      PointF localPointF = new PointF();
      if (this.vt.size() > 0)
      {
        View localView = (View)this.vt.get(0);
        Rect localRect = new Rect();
        DragFrameLayout.this.getGlobalVisibleRect(localRect);
        int i = localRect.left;
        int j = localRect.top;
        localView.getGlobalVisibleRect(localRect);
        localRect.left -= i;
        localRect.top -= j;
        localRect.right -= i;
        localRect.bottom -= j;
        localPointF.set(localRect.centerX(), localRect.centerY());
      }
      return localPointF;
    }
    
    public void run()
    {
      if (this.vt.size() == 0)
      {
        if (this == DragFrameLayout.a(DragFrameLayout.this)) {
          DragFrameLayout.a(DragFrameLayout.this, null);
        }
        DragFrameLayout.a(DragFrameLayout.this, -1);
        if (QLog.isColorLevel()) {
          QLog.d("Drag", 2, "DONE!");
        }
        DragFrameLayout.a(DragFrameLayout.this, true);
      }
      for (;;)
      {
        DragFrameLayout.this.invalidate();
        return;
        View localView = (View)this.vt.get(0);
        if (this.mIndex == DragFrameLayout.p().length)
        {
          this.vt.remove(0);
          this.mIndex = -1;
        }
        else
        {
          localView.setVisibility(4);
          this.mIndex += 1;
        }
      }
    }
  }
  
  class BornRunner
    implements Runnable
  {
    private PointF V = new PointF();
    private int mIndex;
    
    public BornRunner(PointF paramPointF)
    {
      this.V.set(paramPointF);
      this.mIndex = -1;
    }
    
    public Bitmap ap()
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.mIndex >= 0)
      {
        localObject1 = localObject2;
        if (this.mIndex >= DragFrameLayout.p().length) {}
      }
      try
      {
        localObject1 = BitmapFactory.decodeResource(DragFrameLayout.this.getResources(), DragFrameLayout.p()[this.mIndex]);
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        do
        {
          localObject1 = localObject2;
        } while (!QLog.isColorLevel());
        QLog.e("DragRelativeLayout", 2, "decodeBitmap failed" + localOutOfMemoryError, localOutOfMemoryError);
      }
      return null;
    }
    
    public void run()
    {
      if (this.mIndex == DragFrameLayout.p().length)
      {
        if (this == DragFrameLayout.a(DragFrameLayout.this)) {
          DragFrameLayout.a(DragFrameLayout.this, null);
        }
        DragFrameLayout.a(DragFrameLayout.this, null);
        if (DragFrameLayout.a(DragFrameLayout.this) == 2) {
          if (DragFrameLayout.a(DragFrameLayout.this) == null) {
            break label221;
          }
        }
      }
      label221:
      for (List localList = DragFrameLayout.a(DragFrameLayout.this).du();; localList = null)
      {
        if ((DragFrameLayout.a(DragFrameLayout.this) != null) && (localList != null) && (localList.size() > 0))
        {
          DragFrameLayout.a(DragFrameLayout.this, 5);
          DragFrameLayout.a(DragFrameLayout.this, new DragFrameLayout.AllBornRunner(DragFrameLayout.this, localList));
          DragFrameLayout.a(DragFrameLayout.this, null);
        }
        for (;;)
        {
          DragFrameLayout.this.invalidate();
          return;
          DragFrameLayout.a(DragFrameLayout.this, -1);
          if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "DONE!");
          }
          DragFrameLayout.a(DragFrameLayout.this, true);
          break;
          DragFrameLayout.a(DragFrameLayout.this, -1);
          if (QLog.isColorLevel()) {
            QLog.d("Drag", 2, "DONE!");
          }
          DragFrameLayout.a(DragFrameLayout.this, true);
          break;
          this.mIndex += 1;
        }
      }
    }
  }
  
  class ShakeRunner
    implements Runnable
  {
    private int ALL = 20;
    private PointF W;
    private PointF X;
    private RectF aq;
    private int chB = 9;
    private int chC;
    private boolean mIsCancel;
    private float ru;
    
    public ShakeRunner(PointF paramPointF, RectF paramRectF)
    {
      this.W = new PointF(paramPointF.x, paramPointF.y);
      this.X = new PointF(this.W.x, this.W.y);
      this.aq = paramRectF;
      this.ru = ((float)Math.sqrt(this.aq.width() * this.aq.width() + this.aq.height() * this.aq.height()));
      if (this.ru <= 0.01D)
      {
        this.chC = 0;
        return;
      }
      this.ALL = ((int)(this.ALL * this.ru / DragFrameLayout.b(DragFrameLayout.this)));
      this.chB = ((int)(this.chB * this.ru / DragFrameLayout.b(DragFrameLayout.this)));
      this.chC = (-this.ALL);
    }
    
    public PointF c()
    {
      return this.X;
    }
    
    public void run()
    {
      if (this.mIsCancel) {
        return;
      }
      if ((Math.abs(this.chC) < this.chB) || (this.chB == 0)) {
        if (DragFrameLayout.a(DragFrameLayout.this) == this)
        {
          DragFrameLayout.a(DragFrameLayout.this, null);
          DragFrameLayout.a(DragFrameLayout.this, -1);
          DragFrameLayout.a(DragFrameLayout.this, null);
          DragFrameLayout.a(DragFrameLayout.this).setVisibility(0);
          DragFrameLayout.a(DragFrameLayout.this, null);
          DragFrameLayout.a(DragFrameLayout.this, false);
        }
      }
      for (;;)
      {
        DragFrameLayout.this.invalidate();
        return;
        this.X.x = (this.W.x + this.chC * this.aq.width() / this.ru);
        this.X.y = (this.W.y + this.chC * this.aq.height() / this.ru);
        if (this.chC < 0) {
          this.chC = (-this.chC - this.chB);
        } else {
          this.chC = (-this.chC + this.chB);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract List<View> du();
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat1, float paramFloat2, int paramInt, View paramView);
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */