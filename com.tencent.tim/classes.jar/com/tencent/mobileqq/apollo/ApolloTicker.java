package com.tencent.mobileqq.apollo;

import abhh;
import abki;
import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloTicker
{
  public static final String TAG = "sava_ApolloTicker";
  public int mInterval = 3;
  public boolean mTickerUseGlobalTimer;
  public boolean mTimerAlive;
  public long ticker;
  private Map<Long, abki> tickerMap = new HashMap();
  
  public ApolloTicker()
  {
    QLog.d("sava_ApolloTicker", 1, "tickerObj new");
  }
  
  private Timer getTimer()
  {
    Object localObject = ApolloUtil.a();
    if ((this.mTickerUseGlobalTimer) && (localObject != null) && (((abhh)localObject).z != null))
    {
      localObject = ((abhh)localObject).z;
      this.mTimerAlive = true;
      QLog.i("sava_ApolloTicker", 1, "get global Timer ");
      return localObject;
    }
    return new Timer();
  }
  
  public void createTicker(long paramLong)
  {
    QLog.d("sava_ApolloTicker", 1, "ApolloTicker  thread=" + Thread.currentThread().getId() + "ticker = " + paramLong);
    Object localObject = ApolloRender.getRenderViewByThreadId();
    this.ticker = paramLong;
    try
    {
      Timer localTimer = getTimer();
      localObject = new NativeDrawTask((View)localObject, paramLong, 2L);
      abki localabki = new abki();
      localabki.mTimer = localTimer;
      localabki.mInterval = 1;
      localabki.a = ((NativeDrawTask)localObject);
      localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, 16L);
      this.tickerMap.put(Long.valueOf(paramLong), localabki);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 1, "createTicker ", localThrowable);
    }
  }
  
  public void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sava_ApolloTicker", 2, "disposeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
    }
    abki localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
    if (localabki == null)
    {
      QLog.e("sava_ApolloTicker", 1, "[disposeTicker], null error. ticker:" + paramLong);
      return;
    }
    Timer localTimer = localabki.mTimer;
    if (!this.mTimerAlive) {
      if (localTimer != null)
      {
        localTimer.cancel();
        localTimer.purge();
      }
    }
    for (;;)
    {
      localabki.mTimer = null;
      localabki = (abki)this.tickerMap.remove(Long.valueOf(paramLong));
      return;
      if (localabki.a != null) {
        localabki.a.cancel();
      }
    }
  }
  
  public float getDuration(long paramLong)
  {
    abki localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
    if (localabki != null) {
      return localabki.mInterval / 60.0F;
    }
    return 0.0F;
  }
  
  public int getInterval(long paramLong)
  {
    abki localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
    if (localabki != null) {
      return localabki.mInterval;
    }
    return 1;
  }
  
  public native void nativeCallbackTicker(long paramLong, double paramDouble1, double paramDouble2);
  
  public void pauseTicker(long paramLong)
  {
    abki localabki;
    try
    {
      localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
      if (localabki == null)
      {
        QLog.e("sava_ApolloTicker", 1, "[pauseTicker], null error. ticker:" + paramLong);
        return;
      }
      String str = "";
      if (localabki.a != null) {
        str = localabki.a.qT();
      }
      QLog.d("sava_ApolloTicker", 1, new Object[] { "pauseTicker ticker = ", Long.valueOf(paramLong), ",thread=", Long.valueOf(Thread.currentThread().getId()), ",intervalFps:", str });
      if (localabki.mTimer == null) {
        return;
      }
      if (!this.mTimerAlive)
      {
        localabki.mTimer.cancel();
        localabki.mTimer.purge();
        localabki.mTimer = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
      return;
    }
    if (localabki.a != null) {
      localabki.a.cancel();
    }
  }
  
  public void resumeTicker(long paramLong)
  {
    for (;;)
    {
      try
      {
        abki localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
        if (localabki == null)
        {
          QLog.e("sava_ApolloTicker", 1, "[resumeTicker], null error. ticker:" + paramLong);
          return;
        }
        View localView = ApolloRender.getRenderViewByThreadId();
        int i = localabki.mInterval;
        if ((localView == null) || (localabki.mTimer != null)) {
          break;
        }
        if (localabki.mTimer != null)
        {
          if (!this.mTimerAlive)
          {
            localabki.mTimer.cancel();
            localabki.mTimer.purge();
            localabki.mTimer = null;
          }
        }
        else
        {
          QLog.d("sava_ApolloTicker", 1, "resumeTicker ticker = " + paramLong + ",thread=" + Thread.currentThread().getId());
          NativeDrawTask localNativeDrawTask = new NativeDrawTask(localView, paramLong, i);
          Timer localTimer = getTimer();
          localTimer.scheduleAtFixedRate(localNativeDrawTask, 0L, i * 16);
          localabki.mTimer = localTimer;
          localabki.a = localNativeDrawTask;
          if ((localView == null) || (!(localView instanceof ApolloTextureView))) {
            break;
          }
          ((ApolloTextureView)localView).getRender().isRunning = true;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("sava_ApolloTicker", 2, "pause ticker error=" + localThrowable.toString());
        return;
      }
      if (localThrowable.a != null) {
        localThrowable.a.cancel();
      }
    }
  }
  
  public void setInterval(long paramLong, int paramInt)
  {
    if (paramInt == 1) {}
    abki localabki;
    do
    {
      return;
      this.mInterval = paramInt;
      localabki = (abki)this.tickerMap.get(Long.valueOf(paramLong));
      if (localabki == null)
      {
        QLog.e("sava_ApolloTicker", 1, "setInterval tickerInfo null");
        return;
      }
      localObject = ApolloRender.getRenderViewByThreadId();
    } while (localObject == null);
    QLog.d("sava_ApolloTicker", 1, "ScheduledExecutorService setInterval call = " + paramInt + " thread=" + Thread.currentThread().getId());
    Timer localTimer = localabki.mTimer;
    if ((!this.mTimerAlive) && (localTimer != null))
    {
      localTimer.cancel();
      localTimer.purge();
    }
    if (localabki.a != null) {
      localabki.a.cancel();
    }
    Object localObject = new NativeDrawTask((View)localObject, paramLong, paramInt);
    localTimer = getTimer();
    localTimer.scheduleAtFixedRate((TimerTask)localObject, 0L, paramInt * 16);
    localabki.mTimer = localTimer;
    localabki.a = ((NativeDrawTask)localObject);
    localabki.mInterval = paramInt;
  }
  
  public void setRenderView(View paramView)
  {
    Iterator localIterator = this.tickerMap.values().iterator();
    while (localIterator.hasNext())
    {
      abki localabki = (abki)localIterator.next();
      if ((localabki != null) && (localabki.a != null)) {
        localabki.a.setRenderView(paramView);
      }
    }
    QLog.i("sava_ApolloTicker", 1, "setRenderView size:" + this.tickerMap.size());
  }
  
  public class NativeDrawTask
    extends TimerTask
  {
    private StringBuilder M;
    private final long Nx;
    private long Ny;
    private long Nz;
    private int cpc;
    private WeakReference<View> mApolloViewRef;
    private final long mInterval;
    private long ya;
    
    NativeDrawTask(View paramView, long paramLong1, long paramLong2)
    {
      this.mApolloViewRef = new WeakReference(paramView);
      this.Nx = paramLong1;
      this.mInterval = paramLong2;
      this.cpc = -1;
      paramLong1 = System.currentTimeMillis();
      this.ya = paramLong1;
      this.Ny = paramLong1;
      this.M = new StringBuilder();
    }
    
    public String qT()
    {
      long l = 0L;
      if (this.cpc > 0) {
        l = (this.Nz - this.ya) / this.cpc;
      }
      this.M.append("[mspf:").append(l).append("]");
      String str = this.M.toString();
      this.M.delete(0, this.M.length());
      return str;
    }
    
    public void run()
    {
      if (this.mApolloViewRef == null) {}
      Object localObject;
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
                return;
                localObject = (View)this.mApolloViewRef.get();
              } while (localObject == null);
              if (!(localObject instanceof ApolloSurfaceView)) {
                break;
              }
              localObject = (ApolloSurfaceView)localObject;
            } while ((((ApolloSurfaceView)localObject).mIsDestroy == null) || (((ApolloSurfaceView)localObject).mIsDestroy.get()));
            if (((ApolloSurfaceView)localObject).mRenderMode == 0)
            {
              ((ApolloSurfaceView)localObject).requestRender();
              return;
            }
          } while (((ApolloSurfaceView)localObject).mRenderMode != 1);
          ApolloTicker.this.pauseTicker(ApolloTicker.this.ticker);
          return;
        } while (!(localObject instanceof ApolloTextureView));
        localObject = (ApolloTextureView)localObject;
      } while ((((ApolloTextureView)localObject).mIsDestroy == null) || (((ApolloTextureView)localObject).mIsDestroy.get()));
      System.currentTimeMillis();
      ((ApolloTextureView)localObject).requestRender();
      System.currentTimeMillis();
      this.cpc += 1;
      this.Nz = System.currentTimeMillis();
      this.Ny = this.Nz;
    }
    
    public void setRenderView(View paramView)
    {
      this.mApolloViewRef = new WeakReference(paramView);
    }
  }
  
  class SurfaceViewCallback
    implements Runnable
  {
    private final long Nx;
    public final ApolloSurfaceView c;
    private final long mInterval;
    
    public void run()
    {
      if (this.c == null) {}
      while ((this.c.mIsDestroy == null) || (this.c.mIsDestroy.get()) || (this.c.mRenderMode != 0)) {
        return;
      }
      long l = System.currentTimeMillis();
      try
      {
        this.this$0.nativeCallbackTicker(this.Nx, l, 0.01666666666666667D * this.mInterval);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("sava_ApolloTicker", 1, "[onDrawFrame]");
      }
    }
  }
  
  class TextureViewCallback
    implements Runnable
  {
    private final long Nx;
    public final ApolloTextureView b;
    private final long mInterval;
    
    public void run()
    {
      if ((this.b == null) || (this.b.mIsDestroy == null) || (this.b.mIsDestroy.get())) {
        return;
      }
      long l = System.currentTimeMillis();
      try
      {
        this.this$0.nativeCallbackTicker(this.Nx, l, 0.01666666666666667D * this.mInterval);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("sava_ApolloTicker", 1, "[onDrawFrame]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker
 * JD-Core Version:    0.7.0.1
 */