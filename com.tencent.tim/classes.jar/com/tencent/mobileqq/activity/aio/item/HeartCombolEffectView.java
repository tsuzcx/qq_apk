package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import aqhu;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import xdx;
import xdy;
import xdz;

public class HeartCombolEffectView
  extends View
  implements Handler.Callback
{
  private Handler V;
  private a a;
  private String aUG = "chat_item_for_qqbixin_strong";
  private boolean bgK;
  private Bitmap eb;
  private int jD;
  private Bitmap mBitmap;
  private boolean mIsSend = true;
  private Matrix mMatrix;
  private int mScreenHeight;
  private int mScreenWidth;
  private int offsetX;
  private int offsetY;
  private ArrayList<a> qE;
  private long startMs;
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.bgK = paramBoolean;
    init(paramContext);
  }
  
  @TargetApi(11)
  private a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, int paramInt6)
  {
    a locala = new a();
    locala.started = false;
    locala.mStartTime = paramInt1;
    locala.mStartX = paramInt2;
    locala.mStartY = paramInt3;
    locala.bTf = paramInt4;
    locala.bTg = paramInt5;
    locala.mStartScale = paramFloat;
    locala.bTh = paramInt6;
    locala.bgX = false;
    locala.h = new Scroller(getContext(), new DecelerateInterpolator());
    locala.h = new Scroller(getContext(), new DecelerateInterpolator());
    locala.i = new Scroller(getContext(), new AccelerateInterpolator());
    locala.aa = ValueAnimator.ofFloat(new float[] { locala.mStartScale, 0.0F });
    locala.aa.setDuration(1100 - locala.bTh);
    locala.aa.addUpdateListener(new xdz(this, locala));
    return locala;
  }
  
  public Bitmap F(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.startMs = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.qE.iterator();
      while (paramMessage.hasNext())
      {
        a locala = (a)paramMessage.next();
        locala.started = false;
        locala.h.abortAnimation();
        locala.i.abortAnimation();
        locala.mCurrentX = locala.mStartX;
        locala.mCurrentY = locala.mStartY;
        locala.mScale = locala.mStartScale;
      }
      if (this.bgK) {
        this.jD = HapticManager.a().h(this.aUG, 2);
      }
      this.V.sendEmptyMessage(2);
      continue;
      this.V.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.startMs;
      int i = 0;
      if (i < this.qE.size())
      {
        paramMessage = (a)this.qE.get(i);
        if (l1 - l2 >= paramMessage.mStartTime) {
          if (!paramMessage.started)
          {
            if (!this.mIsSend) {
              break label367;
            }
            j = paramMessage.mStartX;
          }
        }
        for (int k = paramMessage.bTf;; k = this.mScreenWidth - paramMessage.bTf)
        {
          paramMessage.h.startScroll(j, 0, k - j, 0, 1100);
          paramMessage.i.startScroll(0, paramMessage.mStartY, 0, paramMessage.bTg - paramMessage.mStartY, 1100);
          paramMessage.started = true;
          if (paramMessage.h.computeScrollOffset())
          {
            paramMessage.i.computeScrollOffset();
            if ((paramMessage.h.timePassed() > paramMessage.bTh) && (paramMessage.mScale == paramMessage.mStartScale)) {
              paramMessage.aa.start();
            }
            paramMessage.mCurrentX = paramMessage.h.getCurrX();
            paramMessage.mCurrentY = paramMessage.i.getCurrY();
          }
          i += 1;
          break;
          label367:
          j = this.mScreenWidth - paramMessage.mStartX;
        }
      }
      i = this.mScreenWidth;
      int j = this.a.bTf;
      float f = ((Float)this.a.aa.getAnimatedValue()).floatValue();
      if ((!this.a.started) || ((this.mIsSend) && (this.a.mCurrentX > this.a.bTf)) || ((!this.mIsSend) && (this.a.mCurrentX < i - j)) || ((this.a.bgX) && (f > 0.001D)))
      {
        postInvalidate();
        paramMessage = this.V.obtainMessage();
        paramMessage.what = 2;
        this.V.sendMessageDelayed(paramMessage, 25L);
      }
      else
      {
        if (this.bgK) {
          HapticManager.a().X(this.jD);
        }
        this.jD = 0;
      }
    }
  }
  
  void init(Context paramContext)
  {
    setOnTouchListener(new xdx(this));
    this.V = new Handler(Looper.getMainLooper(), this);
    this.mBitmap = aqhu.g(getResources(), 2130839277);
    if (this.mBitmap != null) {
      this.eb = F(this.mBitmap);
    }
    if (this.eb == null) {
      this.eb = this.mBitmap;
    }
    this.mMatrix = new Matrix();
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels - ImmersiveUtils.getStatusBarHeight(getContext()) * 2;
    this.qE = new ArrayList();
    this.qE.add(a(300, (int)(i * 1.2F), (int)(j * 0.37F), 0, (int)(j * 0.15F), 1.0F, 500));
    this.qE.add(a(780, (int)(i * 1.2F), (int)(j * 0.42F), 0, (int)(j * 0.25F), 0.95F, 500));
    this.qE.add(a(180, (int)(i * 1.2F), (int)(j * 0.46F), (int)(-i * 0.06D), (int)(j * 0.27F), 1.42F, 500));
    this.qE.add(a(450, (int)(i * 1.2F), (int)(j * 0.51F), 0, (int)(j * 0.45F), 0.92F, 500));
    this.qE.add(a(0, (int)(i * 1.2F), (int)(j * 0.56F), (int)(-i * 0.1D), (int)(j * 0.6F), 0.55F, 500));
    this.qE.add(a(620, (int)(i * 1.2F), (int)(j * 0.63F), (int)(-i * 0.04D), (int)(j * 0.75F), 1.3F, 500));
    this.qE.add(a(410, (int)(i * 1.2F), (int)(j * 0.71F), (int)(-i * 0.06D), (int)(j * 0.89F), 0.88F, 500));
    this.a = ((a)this.qE.get(1));
    this.a.aa.addListener(new xdy(this));
    this.mScreenWidth = i;
    this.mScreenHeight = j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mIsSend) && (this.mBitmap == null)) {}
    for (;;)
    {
      return;
      if ((this.mIsSend) || (this.eb != null))
      {
        Iterator localIterator = this.qE.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.started)
          {
            this.mMatrix.reset();
            this.offsetX = ((int)(this.mBitmap.getWidth() * locala.mScale / 2.0F));
            this.offsetY = ((int)(this.mBitmap.getHeight() * locala.mScale / 2.0F));
            this.mMatrix.postTranslate(locala.mCurrentX, locala.mCurrentY);
            this.mMatrix.preScale(locala.mScale, locala.mScale);
            if (this.mIsSend) {
              paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
            } else {
              paramCanvas.drawBitmap(this.eb, this.mMatrix, null);
            }
          }
        }
      }
    }
  }
  
  public void start(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
    setVisibility(0);
    this.V.sendEmptyMessage(1);
    if (this.bgK) {
      ThreadManager.postImmediately(new HeartCombolEffectView.4(this), null, true);
    }
  }
  
  public class a
  {
    public ValueAnimator aa;
    public int bTf;
    public int bTg;
    public int bTh;
    public boolean bgX;
    public Scroller h;
    public Scroller i;
    public int mCurrentX;
    public int mCurrentY;
    public float mScale;
    public float mStartScale;
    public int mStartTime;
    public int mStartX;
    public int mStartY;
    public boolean started;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView
 * JD-Core Version:    0.7.0.1
 */