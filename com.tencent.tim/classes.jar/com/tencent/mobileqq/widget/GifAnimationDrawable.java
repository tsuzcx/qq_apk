package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;
import aqgs;
import awtg;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GifAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static Set<SoftReference<Bitmap>> dk = Collections.synchronizedSet(new HashSet());
  private final String TAG = "FastAnimationDrawable@" + Integer.toHexString(hashCode());
  private b jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b;
  private c jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$c;
  private long akp;
  protected boolean bgP;
  private Paint cv = new Paint(1);
  private long delay = 34L;
  private ArrayList<a> mAnimationCallbacks = new ArrayList();
  protected Context mContext;
  protected boolean mIsLoading;
  protected volatile boolean mIsRunning;
  private int mNextFrameIndex = -1;
  private ArrayList<String> mPhotoList;
  private Set<SoftReference<Bitmap>> mReusableBitmaps;
  protected boolean mStarted;
  
  public GifAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    this.mContext = paramContext;
    this.mIsRunning = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$c = new c(this);
    this.delay = paramLong;
    this.mReusableBitmaps = dk;
    this.mPhotoList = paramArrayList;
  }
  
  private void a(b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "frameReady() called next=" + paramb);
    }
    this.mIsLoading = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b != null) && (aqgs.getBitmapFromCache("android.resource://main_tab_animation_" + (String)this.mPhotoList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.index)) == null)) {
      this.mReusableBitmaps.add(new SoftReference(this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.drawable.getBitmap()));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b = paramb;
    if (!isRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "frameReady() isRunning = false");
      }
      return;
    }
    invalidateSelf();
    b(paramb);
    if ((this.mNextFrameIndex == this.mPhotoList.size() - 1) && (this.bgP))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$c.postDelayed(new GifAnimationDrawable.1(this), this.delay);
      return;
    }
    loadNextFrame();
  }
  
  private void b(b paramb)
  {
    Iterator localIterator = this.mAnimationCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).Ys(paramb.index);
    }
  }
  
  private void ehX()
  {
    Log.i(this.TAG, "dispatchAnimationStart: ");
    Iterator localIterator = this.mAnimationCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onAnimationStart(this);
    }
  }
  
  private void ehY()
  {
    Log.i(this.TAG, "dispatchAnimationEnd: ");
    Iterator localIterator = this.mAnimationCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onAnimationEnd(this);
    }
  }
  
  private void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "reset");
    }
    this.mIsRunning = true;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    long l1 = 0L;
    long l2 = SystemClock.uptimeMillis();
    long l3 = this.akp;
    if (this.akp == 0L) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "draw() called diff=[" + l1 + "]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b != null)
      {
        if (this.mStarted)
        {
          this.mStarted = false;
          ehX();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.drawable.setBounds(getBounds());
        if (QLog.isColorLevel())
        {
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.drawable.getBitmap();
          if (localBitmap != null) {
            QLog.d(this.TAG, 2, "draw() called with: w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.drawable.setFilterBitmap(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetGifAnimationDrawable$b.drawable.draw(paramCanvas);
          this.cv.setColor(-16711936);
          this.cv.setStyle(Paint.Style.STROKE);
          this.cv.setStrokeWidth(1.0F);
        }
      }
      for (;;)
      {
        this.akp = SystemClock.uptimeMillis();
        return;
        QLog.e(this.TAG, 2, "draw() called with: null bitmap");
        break;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "draw() called null bitmap");
        }
      }
      l1 = l2 - l3;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return getBounds().height();
  }
  
  public int getIntrinsicWidth()
  {
    return getBounds().width();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected void loadNextFrame()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "loadNextFrame() called");
    }
    if ((!isRunning()) || (this.mIsLoading)) {
      return;
    }
    this.mIsLoading = true;
    this.mNextFrameIndex += 1;
    this.mNextFrameIndex %= this.mPhotoList.size();
    long l2 = SystemClock.uptimeMillis();
    long l1 = l2;
    if (!this.mStarted) {
      l1 = l2 + this.delay;
    }
    ThreadManagerV2.postImmediately(new Decoder(new b(this.mNextFrameIndex, l1, null)), null, false);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setOneShot(boolean paramBoolean)
  {
    this.bgP = paramBoolean;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setVisible changed:" + bool + " visible:" + paramBoolean1 + " restart:" + paramBoolean2);
    }
    if (paramBoolean1) {
      if (bool)
      {
        start();
        if (!paramBoolean2) {
          break label83;
        }
        reset();
      }
    }
    label83:
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (!this.mIsRunning)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "start");
      }
      this.mIsRunning = true;
      this.mStarted = true;
      loadNextFrame();
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "stop() called");
    }
    if (isRunning()) {
      this.mIsRunning = false;
    }
  }
  
  public class Decoder
    implements Runnable
  {
    private final GifAnimationDrawable.b b;
    
    public Decoder(GifAnimationDrawable.b paramb)
    {
      this.b = paramb;
    }
    
    @TargetApi(12)
    private BitmapDrawable b(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(GifAnimationDrawable.a(GifAnimationDrawable.this), 2, "decodeBitmap() called with: path = [" + paramString + "]");
      }
      return new BitmapDrawable(awtg.d(paramString, 320, 320, true));
    }
    
    public void run()
    {
      if (!GifAnimationDrawable.this.isRunning()) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(GifAnimationDrawable.a(GifAnimationDrawable.this), 2, "Decoder index:" + this.b.index);
        }
        Object localObject = "android.resource://main_tab_animation_" + (String)GifAnimationDrawable.a(GifAnimationDrawable.this).get(this.b.index);
        Bitmap localBitmap = aqgs.getBitmapFromCache((String)localObject);
        if (localBitmap != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(GifAnimationDrawable.a(GifAnimationDrawable.this), 2, "Decoder hit cache :" + this.b.index);
          }
          this.b.drawable = new BitmapDrawable(localBitmap);
        }
        while (GifAnimationDrawable.this.isRunning())
        {
          localObject = GifAnimationDrawable.a(GifAnimationDrawable.this).obtainMessage(0, this.b);
          GifAnimationDrawable.a(GifAnimationDrawable.this).sendMessageAtTime((Message)localObject, this.b.avy);
          return;
          long l1 = System.currentTimeMillis();
          this.b.drawable = b((String)GifAnimationDrawable.a(GifAnimationDrawable.this).get(this.b.index));
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(GifAnimationDrawable.a(GifAnimationDrawable.this), 2, "Decoder decodeBitmap index:" + this.b.index + " cost:" + (l2 - l1) + " delay:" + GifAnimationDrawable.a(GifAnimationDrawable.this));
          }
          aqgs.e((String)localObject, this.b.drawable.getBitmap());
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ys(int paramInt);
    
    public abstract void onAnimationEnd(Drawable paramDrawable);
    
    public abstract void onAnimationStart(Drawable paramDrawable);
  }
  
  static class b
  {
    long avy;
    BitmapDrawable drawable;
    int index;
    
    public b(int paramInt, long paramLong, BitmapDrawable paramBitmapDrawable)
    {
      this.index = paramInt;
      this.avy = paramLong;
      this.drawable = paramBitmapDrawable;
    }
    
    public String toString()
    {
      return "Frame{index=" + this.index + ", targetTime=" + this.avy + ", drawable=" + this.drawable + '}';
    }
  }
  
  public static class c
    extends Handler
  {
    private final WeakReference<GifAnimationDrawable> mDrawableRef;
    
    public c(GifAnimationDrawable paramGifAnimationDrawable)
    {
      super();
      this.mDrawableRef = new WeakReference(paramGifAnimationDrawable);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      GifAnimationDrawable localGifAnimationDrawable;
      do
      {
        return;
        localGifAnimationDrawable = (GifAnimationDrawable)this.mDrawableRef.get();
      } while (localGifAnimationDrawable == null);
      GifAnimationDrawable.a(localGifAnimationDrawable, (GifAnimationDrawable.b)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GifAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */