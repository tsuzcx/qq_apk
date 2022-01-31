package com.tencent.mobileqq.activity.recent.cur;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import clv;
import clw;
import clx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DragFrameLayout
  extends FrameLayout
  implements IDragView.OnChangeModeListener
{
  public static final float a = 1.1F;
  public static final int a = -1;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838249, 2130838250, 2130838251, 2130838252, 2130838253 };
  private static final float jdField_b_of_type_Float = 0.3F;
  public static final int b = 0;
  private static final float c = 0.7F;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private clv jdField_a_of_type_Clv;
  private clw jdField_a_of_type_Clw;
  private clx jdField_a_of_type_Clx;
  private DragFrameLayout.IDragViewProvider jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private float d;
  private final int h;
  private final int i;
  private final int j;
  private int k = -1;
  private int l;
  private int m;
  private int n;
  
  public DragFrameLayout(Context paramContext)
  {
    super(paramContext);
    super.setWillNotDraw(false);
    this.i = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.j = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.h = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setWillNotDraw(false);
    this.i = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.j = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.h = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  public DragFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setWillNotDraw(false);
    this.i = ((int)(3.0F * getResources().getDisplayMetrics().density));
    this.j = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.h = ((int)(48.0F * getResources().getDisplayMetrics().density));
  }
  
  private static Bitmap a(View paramView)
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
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    if ((localView != null) && ((localView instanceof DragFrameLayout))) {
      return (DragFrameLayout)localView;
    }
    paramActivity = new DragFrameLayout(paramActivity.getApplication());
    localViewGroup.addView(paramActivity);
    localViewGroup.removeView(localView);
    paramActivity.addView(localView);
    return paramActivity;
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "drawAtOrigion:" + paramFloat1 + ", " + paramFloat2);
    }
    float f1 = paramFloat1 + this.d;
    float f2 = paramFloat1 / 2.0F;
    float f3 = this.d;
    float f4 = paramFloat1 / 2.0F;
    float f5 = this.d;
    float f6 = paramFloat1 / 2.0F;
    float f7 = this.d;
    float f8 = paramFloat1 / 2.0F;
    float f9 = this.d;
    paramCanvas.drawCircle(paramFloat2, paramFloat1, paramFloat1, this.jdField_a_of_type_AndroidGraphicsPaint);
    Path localPath = new Path();
    localPath.moveTo(paramFloat2 + paramFloat1, paramFloat1);
    localPath.cubicTo(paramFloat2 + f6, paramFloat1 + 0.3F * f7, paramFloat2 + f8, paramFloat1 + 0.7F * f9, paramFloat2 + paramFloat2, 0.5F + f1);
    localPath.lineTo(paramFloat2 - paramFloat2, 0.5F + f1);
    localPath.cubicTo(paramFloat2 - f4, paramFloat1 + 0.7F * f5, paramFloat2 - f2, paramFloat1 + 0.3F * f3, paramFloat2 - paramFloat1, paramFloat1);
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k == -1) {
      this.l = 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((DragFrameLayout.OnDragModeChangedListener)localIterator.next()).a(paramBoolean, this.m, this);
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.k != -1)
    {
      if (this.jdField_a_of_type_Clx != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Clx);
        this.jdField_a_of_type_Clx = null;
      }
      if (this.jdField_a_of_type_Clw != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Clw);
        this.jdField_a_of_type_Clw = null;
      }
      if (this.jdField_a_of_type_Clv != null)
      {
        getHandler().removeCallbacks(this.jdField_a_of_type_Clv);
        this.jdField_a_of_type_Clv = null;
      }
      this.k = -1;
      a(false);
      this.b = null;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "onModeChanged:" + paramView);
    }
    this.l = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramView);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.l = this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, 1);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "getOrginalCachePixel:" + this.l);
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(1.1F, 1.1F);
      this.b = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), (Matrix)localObject, true);
      getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
      int i2 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left -= i1;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top -= i2;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).right -= i1;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).bottom -= i2;
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.width();
      i2 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).left = ((int)(((Rect)localObject).left - (i1 * 1.1F - i1) / 2.0F));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      float f1 = ((Rect)localObject).right;
      ((Rect)localObject).right = ((int)((i1 * 1.1F - i1) / 2.0F + f1));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom + (i2 * 1.1F - i2) / 2.0F));
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - (i2 * 1.1F - i2) / 2.0F));
      this.n = ((int)(Math.min(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height()) * 0.8D));
      if (this.n > this.j) {
        this.n = this.j;
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.k = 0;
      this.m = paramInt;
      paramView.setVisibility(4);
      invalidate();
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "init:" + this.jdField_a_of_type_AndroidGraphicsRect);
      }
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramOnDragModeChangedListener != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnDragModeChangedListener);
    }
  }
  
  public void a(DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener, boolean paramBoolean)
  {
    if ((paramOnDragModeChangedListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramOnDragModeChangedListener)))
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_JavaUtilList.add(paramOnDragModeChangedListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramOnDragModeChangedListener);
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.k == -1) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
          if (this.l != 0) {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.l);
          }
          while (this.k == 0)
          {
            paramCanvas.drawBitmap(this.b, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
            return;
            if (this.m == 1) {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-4797728);
            } else {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
            }
          }
          if (this.k == 1)
          {
            paramCanvas.save();
            f3 = this.n / 1.5F;
            f2 = this.n * (0.8F - 0.45F * this.d / this.h);
            f1 = f2;
            if (f2 > this.j) {
              f1 = this.j;
            }
            f2 = f1;
            if (f1 < this.i) {
              f2 = this.i;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Drag", 2, "MODE_DRAG:" + f2 + " for " + this.d + ", " + this.h);
            }
            paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
            paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
            paramCanvas.translate(-f3, -f2);
            a(paramCanvas, f2, f3);
            paramCanvas.restore();
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
            paramCanvas.drawBitmap(this.b, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
            return;
          }
          if (this.k != 3) {
            break;
          }
        } while (this.jdField_a_of_type_Clx == null);
        localObject = this.jdField_a_of_type_Clx.a();
        this.jdField_a_of_type_AndroidGraphicsPointF.set((PointF)localObject);
        this.d = ((float)Math.sqrt((this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY())));
        paramCanvas.save();
        float f3 = this.n / 1.5F;
        float f2 = (1.0F - this.d / this.h) * f3;
        float f1 = f2;
        if (f2 > this.j / 2) {
          f1 = this.j / 2;
        }
        f2 = f1;
        if (f1 < this.i) {
          f2 = this.i;
        }
        paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY());
        paramCanvas.rotate((float)(Math.atan2(this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * 57.295779513082323D) - 90.0F);
        paramCanvas.translate(-f3, -f2);
        paramCanvas.restore();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
        paramCanvas.drawBitmap(this.b, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        postDelayed(this.jdField_a_of_type_Clx, 60L);
        return;
        if (this.k == 2)
        {
          paramCanvas.drawBitmap(this.b, this.jdField_a_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
        }
        if (this.k != 4) {
          break;
        }
      } while (this.jdField_a_of_type_Clw == null);
      localObject = this.jdField_a_of_type_Clw.a();
      if (localObject != null) {
        paramCanvas.drawBitmap((Bitmap)localObject, null, new RectF(this.jdField_a_of_type_AndroidGraphicsPointF.x - ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y - ((Bitmap)localObject).getHeight() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.x + ((Bitmap)localObject).getWidth() / 2.0F, this.jdField_a_of_type_AndroidGraphicsPointF.y + ((Bitmap)localObject).getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      postDelayed(this.jdField_a_of_type_Clw, 50L);
      return;
    } while ((this.k != 5) || (this.jdField_a_of_type_Clv == null));
    Object localObject = this.jdField_a_of_type_Clv.a();
    Bitmap localBitmap = this.jdField_a_of_type_Clv.a();
    if ((localBitmap != null) && (((PointF)localObject).x > 0.0F) && (((PointF)localObject).y > 0.0F)) {
      paramCanvas.drawBitmap(localBitmap, null, new RectF(((PointF)localObject).x - localBitmap.getWidth() / 2.0F, ((PointF)localObject).y - localBitmap.getHeight() / 2.0F, ((PointF)localObject).x + localBitmap.getWidth() / 2.0F, ((PointF)localObject).y + localBitmap.getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    postDelayed(this.jdField_a_of_type_Clv, 40L);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.k == -1)
    {
      if ((paramMotionEvent.getAction() == 0) && (QLog.isColorLevel())) {
        QLog.d("Drag", 2, "Host.dispatchTouchEvent: Down At<" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ">");
      }
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      do
      {
        int i1;
        do
        {
          do
          {
            do
            {
              return bool1;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i1 = paramMotionEvent.getAction();
              if ((i1 != 3) && (i1 != 1)) {
                break;
              }
              if (this.k == 0)
              {
                this.b = null;
                this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                this.jdField_a_of_type_AndroidViewView = null;
                this.k = -1;
                invalidate();
                a(false);
                return true;
              }
              if (this.k == 1)
              {
                this.k = 3;
                this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
                paramMotionEvent = new RectF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY(), this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y);
                this.jdField_a_of_type_Clx = new clx(this, new PointF(this.jdField_a_of_type_AndroidGraphicsRect.centerX(), this.jdField_a_of_type_AndroidGraphicsRect.centerY()), paramMotionEvent);
                invalidate();
                return true;
              }
              bool1 = bool2;
            } while (this.k == 3);
            if (this.k == 2)
            {
              if ((float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY())) < (this.n + this.h) / 2)
              {
                this.b = null;
                this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                this.jdField_a_of_type_AndroidViewView = null;
                this.k = -1;
                a(false);
              }
              for (;;)
              {
                invalidate();
                return true;
                this.k = 4;
                this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
                this.jdField_a_of_type_Clw = new clw(this, this.jdField_a_of_type_AndroidGraphicsPointF);
              }
            }
            bool1 = bool2;
          } while (this.k != 4);
          return true;
          bool1 = bool2;
        } while (i1 != 2);
        if ((this.k == 0) || (this.k == 1))
        {
          float f3 = (float)Math.sqrt((f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) * (f1 - this.jdField_a_of_type_AndroidGraphicsRect.centerX()) + (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()) * (f2 - this.jdField_a_of_type_AndroidGraphicsRect.centerY()));
          if (f3 >= this.n + this.h)
          {
            this.d = f3;
            this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
            this.k = 2;
          }
          for (;;)
          {
            invalidate();
            return true;
            if (f3 >= 0.0F)
            {
              this.d = f3;
              this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
              this.k = 1;
            }
            else
            {
              this.k = 0;
            }
          }
        }
        bool1 = bool2;
      } while (this.k == 3);
      bool1 = bool2;
    } while (this.k != 2);
    this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
    invalidate();
    return true;
  }
  
  public void setDragViewProvider(DragFrameLayout.IDragViewProvider paramIDragViewProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout$IDragViewProvider = paramIDragViewProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragFrameLayout
 * JD-Core Version:    0.7.0.1
 */