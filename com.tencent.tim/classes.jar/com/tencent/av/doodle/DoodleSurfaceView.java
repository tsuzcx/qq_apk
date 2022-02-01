package com.tencent.av.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import iiv;
import imo;
import imp;
import imp.a;
import imq;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class DoodleSurfaceView
  extends MySurfaceView
  implements Handler.Callback, imp.a
{
  private Paint ap;
  private long lY = -1L;
  private Bitmap mBitmap;
  private Paint mBitmapPaint;
  private Canvas mCanvas = new Canvas();
  private imp mDoodleLogic;
  public Handler mUiHandler;
  
  public DoodleSurfaceView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DoodleSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DoodleSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void a(Canvas paramCanvas, imo paramimo, boolean paramBoolean)
  {
    if (paramimo != null) {
      paramimo.a(paramCanvas, this, paramBoolean);
    }
  }
  
  private void a(imp paramimp)
  {
    this.mDoodleLogic = paramimp;
    this.mDoodleLogic.mScreenHeight = getHeight();
    this.mDoodleLogic.mScreenWidth = getWidth();
  }
  
  private void d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      try
      {
        if (((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (this.mBitmap.getWidth() == paramInt1) && (this.mBitmap.getHeight() == paramInt2)) || (paramInt1 == 0) || (paramInt2 == 0)) {
          return;
        }
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          this.mBitmap.recycle();
        }
        try
        {
          this.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          if (this.mBitmap == null) {
            return;
          }
          synchronized (this.mCanvas)
          {
            this.mCanvas.setBitmap(this.mBitmap);
            return;
          }
          QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + localThrowable);
        }
        catch (Throwable localThrowable)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + localException);
    }
    else if (this.mBitmap != null)
    {
      if (!this.mBitmap.isRecycled()) {
        this.mBitmap.recycle();
      }
      this.mBitmap = null;
    }
  }
  
  @TargetApi(11)
  private void init(Context paramContext)
  {
    setId(2131373974);
    setClickable(false);
    this.mBitmapPaint = new Paint();
    this.ap = new Paint();
    this.ap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    a(imp.a());
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void q(float paramFloat1, float paramFloat2)
  {
    this.mDoodleLogic.a(0, paramFloat1, paramFloat2);
  }
  
  private void s(float paramFloat1, float paramFloat2)
  {
    this.mDoodleLogic.c(0, paramFloat1, paramFloat2);
  }
  
  private void t(float paramFloat1, float paramFloat2)
  {
    this.mDoodleLogic.b(0, paramFloat1, paramFloat2);
  }
  
  protected void Q(Canvas paramCanvas)
  {
    this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      paramCanvas.drawPaint(this.ap);
      Object localObject = this.mDoodleLogic.jdField_a_of_type_ComTencentAvVideoController.b();
      if ((!this.mDoodleLogic.jdField_a_of_type_ComTencentAvVideoController.sB()) && ((localObject == null) || (((iiv)localObject).amI != 2))) {
        break label245;
      }
      localObject = this.mDoodleLogic.m.iterator();
      while (((Iterator)localObject).hasNext())
      {
        imo localimo = (imo)((Iterator)localObject).next();
        if ((this.lY == -1L) || (localimo.lV - this.lY < 0L)) {
          a(paramCanvas, localimo, false);
        }
      }
      if (this.mBitmap == null) {
        break label205;
      }
    }
    finally
    {
      this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.mDoodleLogic.m.isEmpty()) && (this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[0] == null) && (this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[1] == null)) {
        it(false);
      }
    }
    if (!this.mBitmap.isRecycled()) {
      paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, this.mBitmapPaint);
    }
    label205:
    if (this.mDoodleLogic.SA)
    {
      a(paramCanvas, this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[1], true);
      a(paramCanvas, this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[0], true);
    }
    for (;;)
    {
      label245:
      this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      if ((this.mDoodleLogic.m.isEmpty()) && (this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[0] == null) && (this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[1] == null)) {
        it(false);
      }
      return;
      a(paramCanvas, this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[0], true);
      a(paramCanvas, this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[1], true);
    }
  }
  
  protected void ch(long paramLong)
  {
    this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    Object localObject3;
    try
    {
      if ((this.mDoodleLogic.jdField_g_of_type_ArrayOfBoolean[1] != 0) || (this.mDoodleLogic.jdField_g_of_type_ArrayOfBoolean[0] != 0))
      {
        Iterator localIterator = this.mDoodleLogic.m.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (imo)localIterator.next();
          if (this.mCurTime - ((imo)localObject3).lV <= 1200L) {
            ((imo)localObject3).lV = this.mCurTime;
          }
        }
      }
      if (this.mDoodleLogic.m.size() <= 0) {
        break label228;
      }
    }
    finally
    {
      this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    for (;;)
    {
      ??? = (imo)this.mDoodleLogic.m.peek();
      if ((??? == null) || (this.mCurTime - ((imo)???).lV <= 2000L)) {
        break;
      }
      this.mDoodleLogic.m.poll();
      QLog.w("DoodleSurfaceView", 1, "onUpdateDoodle, poll[" + ??? + "], size[" + this.mDoodleLogic.m.size() + "]");
    }
    label228:
    ??? = this.mDoodleLogic.m.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject3 = (imo)((Iterator)???).next();
      if (this.mCurTime - ((imo)localObject3).lV <= 1200L) {
        break;
      }
      ((imo)localObject3).ch(paramLong);
    }
    if ((this.lY != -1L) && (this.mCurTime - this.lY > 1200L) && (this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      long l1;
      synchronized (this.mCanvas)
      {
        this.mCanvas.drawPaint(this.ap);
        l1 = -1L;
        localObject3 = this.mDoodleLogic.m.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          imo localimo = (imo)((Iterator)localObject3).next();
          long l2 = l1;
          if (l1 == -1L)
          {
            l2 = l1;
            if (this.mCurTime - localimo.lV <= 1200L) {
              l2 = localimo.lV;
            }
          }
          l1 = l2;
          if (l2 != -1L)
          {
            l1 = l2;
            if (localimo.lV - l2 >= 0L)
            {
              a(this.mCanvas, localimo, false);
              l1 = l2;
            }
          }
        }
      }
      this.lY = l1;
    }
    this.mDoodleLogic.ch(paramLong);
    this.mDoodleLogic.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleSurfaceView", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (ViewGroup)getParent();
      if (paramMessage != null) {
        paramMessage.removeView(this);
      }
    }
  }
  
  public void invalidate()
  {
    it(true);
  }
  
  protected void is(boolean paramBoolean)
  {
    d(paramBoolean, getWidth(), getHeight());
    if ((!paramBoolean) && (!isClickable()))
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      this.mUiHandler.sendMessage(localMessage);
    }
  }
  
  public void kY(int paramInt)
  {
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {}
    synchronized (this.mCanvas)
    {
      a(this.mCanvas, this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[paramInt], false);
      if (this.lY == -1L) {
        this.lY = this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[paramInt].lV;
      }
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    try
    {
      d(ud(), paramInt1, paramInt2);
      if (this.mDoodleLogic != null)
      {
        this.mDoodleLogic.mScreenHeight = paramInt2;
        this.mDoodleLogic.mScreenWidth = paramInt1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DoodleSurfaceView", 2, "WL_DEBUG onSizeChanged e = " + localThrowable);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = isClickable();
    if (bool)
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
    }
    while (this.mDoodleLogic.jdField_a_of_type_ArrayOfImo[0] == null)
    {
      float f1;
      float f2;
      do
      {
        return bool;
        localObject = (View)getParent();
      } while (!bool);
      q(f1, f2);
      paramMotionEvent = getContext();
      if ((paramMotionEvent instanceof AVActivity))
      {
        localObject = ((View)localObject).findViewById(2131373963);
        if (localObject != null)
        {
          paramMotionEvent = ((AVActivity)paramMotionEvent).mControlUI;
          ((View)localObject).startAnimation(paramMotionEvent.a(false));
          paramMotionEvent.auV();
        }
      }
      invalidate();
      return bool;
      t(f1, f2);
      invalidate();
      return bool;
      s(f1, f2);
      Object localObject = getContext();
      if ((localObject instanceof AVActivity))
      {
        paramMotionEvent = ((View)getParent()).findViewById(2131373963);
        if (paramMotionEvent != null)
        {
          localObject = ((AVActivity)localObject).mControlUI;
          if (localObject != null)
          {
            paramMotionEvent.startAnimation(((VideoControlUI)localObject).a(true));
            ((VideoControlUI)localObject).auV();
          }
        }
      }
      invalidate();
      return bool;
    }
    s(paramMotionEvent.getX(), paramMotionEvent.getY());
    invalidate();
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.mDoodleLogic != null))
    {
      this.mDoodleLogic.mScreenHeight = getHeight();
      this.mDoodleLogic.mScreenWidth = getWidth();
    }
  }
  
  public void setColor(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mDoodleLogic.jdField_a_of_type_Imq.onColorChanged(this.mDoodleLogic.mColor);
    this.mDoodleLogic.mColor = paramInt1;
    this.mDoodleLogic.apU = paramInt2;
    this.mDoodleLogic.gh = paramFloat;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mDoodleLogic.a() != this) {
      this.mDoodleLogic.a(this);
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.mDoodleLogic.a() == this) {
      this.mDoodleLogic.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleSurfaceView
 * JD-Core Version:    0.7.0.1
 */