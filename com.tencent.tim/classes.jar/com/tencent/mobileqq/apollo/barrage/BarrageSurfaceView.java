package com.tencent.mobileqq.apollo.barrage;

import abjr;
import abjs;
import abjt;
import abjv;
import abjw;
import abjx;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import auru;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class BarrageSurfaceView
  extends SurfaceView
  implements abjw, Handler.Callback, SurfaceHolder.Callback
{
  private abjr jdField_a_of_type_Abjr;
  private abjs<Canvas> jdField_a_of_type_Abjs;
  private auru jdField_a_of_type_Auru;
  private int mHeight;
  private SurfaceHolder mSurfaceHolder;
  private int mWidth;
  private HandlerThread mWorkThread;
  
  public BarrageSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BarrageSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void cCv()
  {
    if (this.jdField_a_of_type_Auru == null) {
      return;
    }
    this.jdField_a_of_type_Auru.removeMessages(16);
    this.jdField_a_of_type_Auru.sendEmptyMessage(16);
  }
  
  private void init()
  {
    super.setZOrderOnTop(true);
    this.mSurfaceHolder = super.getHolder();
    this.mSurfaceHolder.addCallback(this);
    this.mSurfaceHolder.setFormat(-3);
  }
  
  public void DI(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Auru == null) {
      return;
    }
    this.jdField_a_of_type_Auru.obtainMessage(15).sendToTarget();
  }
  
  public abjr a()
  {
    if (this.jdField_a_of_type_Abjr == null) {
      this.jdField_a_of_type_Abjr = new abjt();
    }
    return this.jdField_a_of_type_Abjr;
  }
  
  public void af(List<abjv> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Auru == null) {}
    while (paramList == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_Auru.obtainMessage(13);
    localMessage.obj = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.jdField_a_of_type_Abjs == null);
          localObject = (List)paramMessage.obj;
          if (paramMessage.arg1 > 0) {
            this.jdField_a_of_type_Abjs.DH(false);
          }
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            paramMessage = ((List)localObject).iterator();
            while (paramMessage.hasNext()) {
              ((abjv)paramMessage.next()).cCu();
            }
          }
          this.jdField_a_of_type_Abjs.ac((List)localObject);
          cCv();
          return false;
        } while (this.jdField_a_of_type_Abjs == null);
        paramMessage = (abjv)paramMessage.obj;
        this.jdField_a_of_type_Abjs.a(paramMessage);
        cCv();
        return false;
      } while (this.jdField_a_of_type_Abjs == null);
      this.jdField_a_of_type_Abjs.DH(false);
      cCv();
      return false;
    } while (this.jdField_a_of_type_Abjs == null);
    long l = System.currentTimeMillis();
    localObject = null;
    paramMessage = null;
    boolean bool2 = true;
    SurfaceHolder localSurfaceHolder = this.mSurfaceHolder;
    bool1 = bool2;
    for (;;)
    {
      try
      {
        localCanvas = this.mSurfaceHolder.lockCanvas();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.save();
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        bool2 = this.jdField_a_of_type_Abjs.a(localCanvas, 1.0F);
        bool1 = bool2;
        paramMessage = localCanvas;
        localObject = localCanvas;
        localCanvas.restore();
        bool3 = bool2;
        if (localCanvas == null) {}
      }
      catch (Exception localException)
      {
        Canvas localCanvas;
        localObject = paramMessage;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject = paramMessage;
        QLog.e("BarrageSurfaceView", 2, localException.getMessage());
        boolean bool3 = bool1;
        if (paramMessage == null) {
          continue;
        }
        this.mSurfaceHolder.unlockCanvasAndPost(paramMessage);
        bool3 = bool1;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        this.mSurfaceHolder.unlockCanvasAndPost((Canvas)localObject);
      }
      try
      {
        this.mSurfaceHolder.unlockCanvasAndPost(localCanvas);
        bool3 = bool2;
        if ((bool3) && (this.jdField_a_of_type_Auru != null)) {
          this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(16, 20L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("BarrageSurfaceView", 2, "handle MSG_CODE_DRAW_BARRAGE use->" + (System.currentTimeMillis() - l));
        }
        return false;
      }
      finally {}
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_Abjr == null) {
      this.jdField_a_of_type_Abjr = new abjt();
    }
    if (this.jdField_a_of_type_Abjs == null) {
      this.jdField_a_of_type_Abjs = new abjx();
    }
    if (this.mWorkThread != null) {
      this.mWorkThread.quit();
    }
    this.mWorkThread = new HandlerThread("Barrage-Surface-Thread");
    this.mWorkThread.start();
    this.jdField_a_of_type_Auru = new auru(this.mWorkThread.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
  
  public int zA()
  {
    return this.mWidth;
  }
  
  public int zB()
  {
    return this.mHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageSurfaceView
 * JD-Core Version:    0.7.0.1
 */