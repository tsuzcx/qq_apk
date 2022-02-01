package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import aqnm;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jzk;
import kkq;
import kku.a;
import knd;
import mqq.os.MqqHandler;
import mtg.b;
import ods;
import org.json.JSONObject;
import wja;

public class ReadInJoyAdGestureView
  extends RelativeLayout
{
  static Handler mHandler = new Handler();
  boolean DR = false;
  boolean LJ = false;
  boolean NI = false;
  LongPressRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView$LongPressRunnable = new LongPressRunnable();
  private kkq jdField_a_of_type_Kkq;
  private int aKF = -1;
  String abo;
  String abp;
  private boolean agL;
  boolean agM = false;
  boolean agN = false;
  boolean agO = true;
  Paint aw = null;
  Paint ax = null;
  Paint ay = null;
  Runnable cz = new ReadInJoyAdGestureView.1(this);
  private VideoAdInfo d;
  float iP = -1.0F;
  float iQ = -1.0F;
  float iR = -1.0F;
  float iS = -1.0F;
  float iT = -1.0F;
  float iU = -1.0F;
  float iV = -1.0F;
  float iW = -1.0F;
  float iX;
  float iY;
  float iZ = -15.0F;
  private boolean isReleased = true;
  private Bitmap mBitmap;
  Paint mBitmapPaint = null;
  private WeakReference<Context> mContext;
  private Path mPath;
  float startX = 0.0F;
  float startY = 0.0F;
  
  public ReadInJoyAdGestureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyAdGestureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    init();
  }
  
  public ReadInJoyAdGestureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private long a(kkq paramkkq)
  {
    if ((paramkkq != null) && (paramkkq.sk > 0L)) {
      return paramkkq.sk;
    }
    return 500L;
  }
  
  private void a(kkq paramkkq, MotionEvent paramMotionEvent)
  {
    if ((paramkkq == null) || (paramMotionEvent == null)) {}
    do
    {
      return;
      this.agL = false;
      this.startX = paramMotionEvent.getX();
      this.startY = paramMotionEvent.getY();
      switch (this.aKF)
      {
      default: 
        return;
      case 1: 
        this.mPath.reset();
        this.mPath.moveTo(this.startX, this.startY);
        return;
      case 2: 
        this.isReleased = false;
        this.agM = true;
        this.iX = this.startX;
        this.iY = this.startY;
        postDelayed(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView$LongPressRunnable, a(paramkkq));
        invalidate();
        return;
      }
    } while ((this.startX < this.iT) || (this.startX > this.iT + this.iR) || (this.startY < this.iU) || (this.startY > this.iU + this.iS));
    this.NI = true;
  }
  
  private int[] a(float paramFloat1, float paramFloat2)
  {
    int i = -1;
    int[] arrayOfInt = new int[2];
    int[] tmp9_7 = arrayOfInt;
    tmp9_7[0] = -1;
    int[] tmp13_9 = tmp9_7;
    tmp13_9[1] = -1;
    tmp13_9;
    if (this.mBitmap == null) {
      return arrayOfInt;
    }
    int j;
    if ((paramFloat1 - this.iR / 2.0F > 0.0F) && (this.iR / 2.0F + paramFloat1 < getWidth()) && (paramFloat2 - this.iS / 2.0F > 0.0F) && (this.iS / 2.0F + paramFloat2 < getHeight()))
    {
      j = (int)paramFloat1;
      i = (int)paramFloat2;
    }
    for (;;)
    {
      arrayOfInt[0] = j;
      arrayOfInt[1] = i;
      return arrayOfInt;
      if ((this.iR / 2.0F + paramFloat1 >= getWidth()) && (paramFloat2 - this.iS / 2.0F > 0.0F) && (this.iS / 2.0F + paramFloat2 < getHeight()))
      {
        j = (int)(getWidth() - this.iR / 2.0F);
        i = (int)paramFloat2;
      }
      else if ((paramFloat1 - this.iR / 2.0F < 0.0F) && (paramFloat2 - this.iS / 2.0F > 0.0F) && (this.iS / 2.0F + paramFloat2 < getHeight()))
      {
        j = (int)(this.iR / 2.0F);
        i = (int)paramFloat2;
      }
      else if ((this.iS / 2.0F + paramFloat2 >= getHeight()) && (paramFloat1 - this.iR / 2.0F > 0.0F) && (this.iR / 2.0F + paramFloat1 < getWidth()))
      {
        j = (int)paramFloat1;
        i = (int)(getHeight() - this.iS / 2.0F);
      }
      else if ((paramFloat2 - this.iS / 2.0F <= 0.0F) && (paramFloat1 - this.iR / 2.0F > 0.0F) && (this.iR / 2.0F + paramFloat1 < getWidth()))
      {
        j = (int)paramFloat1;
        i = (int)(this.iS / 2.0F);
      }
      else if ((paramFloat1 - this.iR / 2.0F <= 0.0F) && (paramFloat2 - this.iS / 2.0F <= 0.0F))
      {
        j = (int)(this.iR / 2.0F);
        i = (int)this.iS / 2;
      }
      else if ((paramFloat1 - this.iR / 2.0F <= 0.0F) && (this.iS / 2.0F + paramFloat2 >= getHeight()))
      {
        j = (int)this.iR / 2;
        i = (int)(getHeight() - this.iS / 2.0F);
      }
      else if ((this.iR / 2.0F + paramFloat1 >= getWidth()) && (paramFloat2 - this.iS / 2.0F <= 0.0F))
      {
        j = (int)(getWidth() - this.iR / 2.0F);
        i = (int)(this.iS / 2.0F);
      }
      else if ((this.iR / 2.0F + paramFloat1 >= getWidth()) && (this.iS / 2.0F + paramFloat2 >= getHeight()))
      {
        j = (int)(getWidth() - this.iR / 2.0F);
        i = (int)(getHeight() - this.iS / 2.0F);
      }
      else
      {
        j = -1;
      }
    }
  }
  
  private void aFq()
  {
    try
    {
      switch (this.aKF)
      {
      case 1: 
        if ((this.mContext != null) && (this.mContext.get() != null)) {
          this.aw.setStrokeWidth(wja.dp2px(9.0F, ((Context)this.mContext.get()).getResources()));
        }
        if ((TextUtils.isEmpty(this.abp)) || (this.aw == null)) {
          return;
        }
        this.aw.setColor(Color.parseColor(this.abp));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if ((!TextUtils.isEmpty(this.abo)) && (this.ax != null) && (this.ay != null))
    {
      this.ax.setColor(Color.parseColor(this.abp));
      this.ay.setColor(Color.parseColor(this.abp));
      return;
    }
  }
  
  private void b(kkq paramkkq, MotionEvent paramMotionEvent)
  {
    if ((paramkkq == null) || (paramMotionEvent == null)) {}
    do
    {
      float f1;
      float f2;
      do
      {
        float f3;
        float f4;
        do
        {
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          f3 = this.startX;
          f4 = this.startY;
          f5 = Math.abs(f1 - f3);
          f6 = Math.abs(f2 - f4);
          if (((this.aKF == 1) && ((f5 >= paramkkq.aJr) || (f6 >= paramkkq.aJr))) || ((this.aKF == 2) && ((f5 >= 40.0F) || (f6 >= 40.0F))) || ((this.aKF == 3) && ((f5 >= 40.0F) || (f6 >= 40.0F)))) {
            this.agL = true;
          }
          switch (this.aKF)
          {
          default: 
            return;
          }
        } while (!this.agL);
        float f5 = (f1 + f3) / 2.0F;
        float f6 = (f2 + f4) / 2.0F;
        this.mPath.quadTo(f3, f4, f5, f6);
        invalidate();
        this.startX = f1;
        this.startY = f2;
        return;
        invalidate();
        return;
      } while (!this.NI);
      paramkkq = a(f1, f2);
      this.iV = paramkkq[0];
      this.iW = paramkkq[1];
    } while ((this.iV == -1.0F) || (this.iW == -1.0F));
    invalidate();
  }
  
  private void c(kkq paramkkq, MotionEvent paramMotionEvent)
  {
    if ((paramkkq == null) || (paramMotionEvent == null)) {}
    do
    {
      do
      {
        return;
        invalidate();
        switch (this.aKF)
        {
        default: 
          return;
        case 1: 
          this.mPath.reset();
        }
      } while (!this.agL);
      action();
      this.agL = false;
      return;
      this.isReleased = true;
      this.agM = false;
      return;
    } while ((!this.NI) || (!this.agL));
    action();
    this.NI = false;
    this.iV = -1.0F;
    this.iW = -1.0F;
    this.iT = -1.0F;
    this.iU = -1.0F;
  }
  
  private void x(float paramFloat1, float paramFloat2)
  {
    if (BaseApplicationImpl.getContext() == null) {
      return;
    }
    int i = aqnm.getScreenWidth();
    int j = aqnm.getScreenHeight();
    if ((j == 0) || (i == 0)) {
      QLog.e("ReadInJoyAdGestureView", 2, "initStartPostionXY get Screen width and high error screenHigh:" + j + " screenWidth:" + i);
    }
    float f3 = (float)(i * 1.0D / j);
    float f2 = i;
    float f1 = j;
    if (f3 >= 0.5625F) {
      f2 = j * 0.5625F;
    }
    for (;;)
    {
      this.iT = (f2 * paramFloat1 + i / 2);
      this.iU = (f1 * paramFloat2 + j / 2 - wja.dp2px(58.0F, BaseApplicationImpl.getContext().getResources()));
      return;
      f1 = i / 0.5625F;
    }
  }
  
  public boolean Af()
  {
    return this.agN;
  }
  
  public void a(kkq paramkkq)
  {
    if ((paramkkq == null) || (this.mContext == null) || (this.mContext.get() == null)) {
      return;
    }
    this.aKF = paramkkq.aJq;
    this.iP = ((float)paramkkq.aR);
    this.iQ = ((float)paramkkq.aS);
    this.iR = wja.dp2px((float)paramkkq.aQ, ((Context)this.mContext.get()).getResources());
    this.iS = wja.dp2px((float)paramkkq.aP, ((Context)this.mContext.get()).getResources());
    x(this.iP, this.iQ);
    this.iV = a(this.iT + this.iR / 2.0F, this.iU + this.iS / 2.0F)[0];
    this.iW = a(this.iT + this.iR / 2.0F, this.iU + this.iS / 2.0F)[1];
    this.abo = paramkkq.aac;
    this.abp = paramkkq.aad;
    paramkkq = paramkkq.aab;
    aFq();
    ThreadManager.getSubThreadHandler().post(new ReadInJoyAdGestureView.2(this, paramkkq));
  }
  
  public void action()
  {
    if ((this.mContext != null) && (this.mContext.get() != null) && (this.d != null))
    {
      this.agN = ods.b((Context)this.mContext.get(), jzk.a(this.d), null, 3, false, null);
      jzk.a(new kku.a().a((Context)this.mContext.get()).a(jzk.aEJ).b(jzk.aFA).a(jzk.a(this.d)).e(knd.c(1, this.aKF)).a());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void init()
  {
    this.aw = new Paint();
    this.aw.setColor(-1);
    this.aw.setAntiAlias(true);
    this.aw.setStyle(Paint.Style.STROKE);
    this.aw.setStrokeWidth(18.0F);
    this.mPath = new Path();
    this.mBitmapPaint = new Paint(1);
    this.mBitmapPaint.setFilterBitmap(true);
    this.mBitmapPaint.setDither(true);
    this.ax = new Paint();
    this.ax.setColor(-1);
    this.ax.setAntiAlias(true);
    this.ax.setStyle(Paint.Style.FILL);
    this.ax.setAlpha(153);
    this.ay = new Paint();
    this.ay.setColor(-1);
    this.ay.setAntiAlias(true);
    this.ay.setStyle(Paint.Style.STROKE);
    this.ay.setAlpha(51);
    this.ay.setStrokeWidth(24.0F);
  }
  
  public void mz(boolean paramBoolean)
  {
    if ((!this.DR) && (paramBoolean) && (mHandler != null))
    {
      mHandler.removeCallbacksAndMessages(null);
      mHandler.post(this.cz);
    }
    if ((!paramBoolean) && (mHandler != null)) {
      mHandler.removeCallbacksAndMessages(null);
    }
    this.DR = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.aKF)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.mPath == null) || (this.aw == null) || (this.agN));
        paramCanvas.drawPath(this.mPath, this.aw);
        return;
      } while ((this.isReleased) || (this.agL) || (this.agN) || (!this.agM));
      paramCanvas.drawCircle(this.iX, this.iY, 60.0F, this.ax);
      paramCanvas.drawArc(new RectF(this.iX - 72.0F, this.iY - 72.0F, this.iX + 72.0F, this.iY + 72.0F), 0.0F, 360.0F, false, this.ay);
      return;
    } while ((this.mBitmap == null) || (this.agN));
    if ((this.NI) && (this.agL))
    {
      paramCanvas.drawBitmap(this.mBitmap, new Rect(0, 0, (int)this.iR, (int)this.iS), new Rect((int)(this.iV - this.iR / 2.0F), (int)(this.iW - this.iS / 2.0F), (int)(this.iV + this.iR / 2.0F), (int)(this.iW + this.iS / 2.0F)), this.mBitmapPaint);
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.iZ, this.iT + this.iR / 2.0F, this.iU + this.iS / 2.0F);
    paramCanvas.drawBitmap(this.mBitmap, this.iT, this.iU, this.mBitmapPaint);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      a(this.jdField_a_of_type_Kkq, paramMotionEvent);
      continue;
      b(this.jdField_a_of_type_Kkq, paramMotionEvent);
      continue;
      c(this.jdField_a_of_type_Kkq, paramMotionEvent);
    }
  }
  
  public void resetState()
  {
    invalidate();
    this.agL = false;
    this.agN = false;
    this.LJ = false;
    this.mContext = null;
    switch (this.aKF)
    {
    }
    do
    {
      return;
      this.mPath.reset();
      return;
      this.agM = false;
      removeCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView$LongPressRunnable);
      return;
      this.NI = false;
      x(this.iP, this.iQ);
    } while (mHandler == null);
    mHandler.removeCallbacksAndMessages(null);
  }
  
  public void setGestureAdInfo(mtg.b paramb, Context paramContext)
  {
    if (this.mContext == null) {
      this.mContext = new WeakReference(paramContext);
    }
    if ((!this.LJ) && (paramb != null) && (paramb.a != null) && (paramb.a.d != null) && (paramb.a.d.b != null)) {
      try
      {
        this.d = paramb.a.d.b;
        if (this.d == null) {
          return;
        }
        paramb = new JSONObject(this.d.mAdExtInfo);
        if (paramb != null)
        {
          this.jdField_a_of_type_Kkq = kkq.a(paramb.optJSONObject("GesturesAd_info"));
          a(this.jdField_a_of_type_Kkq);
        }
        this.LJ = true;
        invalidate();
        return;
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
      }
    }
  }
  
  public class LongPressRunnable
    implements Runnable
  {
    public LongPressRunnable() {}
    
    public void run()
    {
      if ((ReadInJoyAdGestureView.a(ReadInJoyAdGestureView.this)) || (ReadInJoyAdGestureView.b(ReadInJoyAdGestureView.this))) {
        return;
      }
      ReadInJoyAdGestureView.this.action();
      ReadInJoyAdGestureView.this.agM = false;
      ReadInJoyAdGestureView.this.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView
 * JD-Core Version:    0.7.0.1
 */