package com.tencent.mobileqq.qzonevip.gift.particle;

import also;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

public abstract class ParticleTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  protected int JO;
  protected a a;
  private Rect ad = new Rect();
  public final Object ae = new Object();
  protected int dwR;
  protected Context mContext;
  protected volatile boolean mIsStop;
  protected Matrix mMatrix;
  protected Paint mPaint;
  protected Random mRandom;
  private Surface mSurface;
  protected int mViewHeight;
  protected Handler mWorkHandler;
  protected HandlerThread mWorkThread;
  public ArrayList<also> yQ;
  
  public ParticleTextureView(Context paramContext)
  {
    super(paramContext);
    eO(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    eO(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    eO(paramContext);
  }
  
  private void Th(int paramInt)
  {
    jp(paramInt, 0);
  }
  
  private void eO(Context paramContext)
  {
    this.mContext = paramContext;
    this.mRandom = new Random();
    this.mMatrix = new Matrix();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColor(-1);
    this.yQ = new ArrayList();
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  private void jp(int paramInt1, int paramInt2)
  {
    if (this.mWorkHandler == null)
    {
      QLog.i("ParticleTextureView", 1, "sendValidMessage: handle = null ");
      return;
    }
    if (this.mWorkHandler.hasMessages(paramInt1)) {
      this.mWorkHandler.removeMessages(paramInt1);
    }
    this.mWorkHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  protected int E(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return paramInt1 + this.mRandom.nextInt(paramInt2 - paramInt1);
  }
  
  protected abstract int Ib();
  
  protected abstract void a(Bitmap[] paramArrayOfBitmap);
  
  protected abstract Bitmap[] a();
  
  protected abstract boolean aut();
  
  protected void dJa()
  {
    long l = System.currentTimeMillis();
    also localalso2 = null;
    Canvas localCanvas = null;
    Object localObject6 = this.ae;
    Object localObject4 = localCanvas;
    also localalso1 = localalso2;
    try
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        try
        {
          if (this.mSurface != null) {
            this.mSurface.unlockCanvasAndPost(null);
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable1);
          }
        }
        finally {}
      }
      localObject4 = localCanvas;
      Object localObject2 = localalso2;
      localCanvas = this.mSurface.lockCanvas(this.ad);
      if (localCanvas != null)
      {
        localObject4 = localCanvas;
        localObject2 = localCanvas;
        if (this.mSurface.isValid())
        {
          localObject4 = localCanvas;
          localObject2 = localCanvas;
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          localObject2 = localCanvas;
          try
          {
            localObject4 = this.yQ.iterator();
            for (;;)
            {
              localObject2 = localCanvas;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject2 = localCanvas;
              localalso2 = (also)((Iterator)localObject4).next();
              if (localalso2 != null)
              {
                localObject2 = localCanvas;
                localalso2.draw(localCanvas, this.mPaint, this.mMatrix);
              }
            }
            try
            {
              if (this.mSurface != null) {
                this.mSurface.unlockCanvasAndPost(localCanvas);
              }
              QLog.i("ParticleTextureView", 1, "consume = " + (System.currentTimeMillis() - l));
              if ((this.mWorkHandler != null) && (this.yQ.size() != 0))
              {
                jp(3, Ib());
                return;
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable2);
              }
            }
          }
          catch (Throwable localThrowable6)
          {
            localObject4 = localCanvas;
            localObject2 = localCanvas;
            QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + localThrowable6);
          }
        }
      }
      Object localObject3;
      return;
    }
    catch (Throwable localThrowable5)
    {
      for (;;)
      {
        localObject3 = localObject4;
        QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + localThrowable5);
        try
        {
          if (this.mSurface != null) {
            this.mSurface.unlockCanvasAndPost((Canvas)localObject4);
          }
        }
        catch (Throwable localThrowable3)
        {
          QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable3);
        }
      }
    }
    finally
    {
      try
      {
        if (this.mSurface != null) {
          this.mSurface.unlockCanvasAndPost(localThrowable3);
        }
        throw localObject5;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + localThrowable4);
        }
      }
      if (this.a != null) {
        this.a.dJb();
      }
    }
  }
  
  protected float m(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return paramFloat1 + this.mRandom.nextFloat() * (paramFloat2 - paramFloat1);
  }
  
  public void onStart()
  {
    Th(1);
  }
  
  public void onStop()
  {
    this.mIsStop = true;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("ParticleTextureView", 1, "onSurfaceTextureAvailable: width = " + paramInt1 + " height = " + paramInt2);
    this.mSurface = new Surface(paramSurfaceTexture);
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    this.ad = new Rect(0, 0, paramInt1, paramInt2);
    this.mWorkThread = new HandlerThread("Particle-Texture-Thread" + UUID.randomUUID());
    this.mWorkThread.start();
    this.mWorkHandler = new b(this.mWorkThread.getLooper());
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurface = null;
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setParticleListener(a parama)
  {
    this.a = parama;
  }
  
  protected abstract void updateData();
  
  public static abstract interface a
  {
    public abstract void dJb();
  }
  
  class b
    extends Handler
  {
    private Bitmap[] bitmaps;
    
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        QLog.i("ParticleTextureView", 1, "handleMessage: MSG_INIT_DATA");
        this.bitmaps = ParticleTextureView.this.a();
        ParticleTextureView.a(ParticleTextureView.this, 2);
        return;
        ParticleTextureView.this.dwR = 0;
        QLog.i("ParticleTextureView", 1, "handleMessage: MSG_ADD_DATA");
        ParticleTextureView.this.a(this.bitmaps);
        ParticleTextureView.a(ParticleTextureView.this, 4);
        return;
        paramMessage = ParticleTextureView.this;
        paramMessage.dwR += 1;
        ParticleTextureView.this.updateData();
        if (ParticleTextureView.this.aut())
        {
          ParticleTextureView.a(ParticleTextureView.this, 2);
          return;
        }
        ParticleTextureView.a(ParticleTextureView.this, 4);
        return;
        QLog.i("ParticleTextureView", 1, "handleMessage: MSG_REFRESH_VIEW size = " + ParticleTextureView.this.yQ.size());
      } while ((ParticleTextureView.this.yQ.size() <= 0) && (ParticleTextureView.this.mIsStop));
      ParticleTextureView.this.dJa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
 * JD-Core Version:    0.7.0.1
 */