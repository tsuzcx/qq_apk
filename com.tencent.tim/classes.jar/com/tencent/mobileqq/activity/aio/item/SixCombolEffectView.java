package com.tencent.mobileqq.activity.aio.item;

import acfp;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import ankt;
import aqhu;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import riw;
import wja;
import wki;
import xbu.a;
import xnl;
import xnm;
import xnn;
import xno;
import xnp;
import xnq;
import xnr;
import xns;
import xnt;
import xnu;
import xnv;
import xnw;
import xnx;
import xny;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static int bVC = 0;
  public static boolean mIsPlaying;
  private Handler V;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$b;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c;
  private String aUG = "chat_item_for_qq666";
  private ValueAnimator ab;
  private ValueAnimator ac;
  private ValueAnimator ad;
  private int bVD;
  private int bVE = ankt.dip2px(60.0F);
  int bVF = ankt.dip2px(30.0F);
  int bVG = ankt.dip2px(30.0F);
  int bVH = ankt.dip2px(13.0F);
  int bVI = ankt.dip2px(50.0F);
  private boolean bgK;
  private boolean bhW;
  private MessageForPoke c;
  private ChatXListView jdField_d_of_type_ComTencentMobileqqBubbleChatXListView;
  private wki jdField_d_of_type_Wki;
  Bitmap eh;
  Bitmap ei;
  Bitmap ej;
  private int jD;
  private Context mContext;
  private boolean mIsSend;
  private Matrix mMatrix;
  BitmapFactory.Options mOptions = new BitmapFactory.Options();
  private int mScreenHeight;
  private int mScreenWidth;
  private ArrayList<c> qE;
  public float qq;
  public float qr;
  float qs = ankt.dip2px(120.0F);
  float qt = ankt.dip2px(120.0F);
  float qu;
  float qv = ankt.dip2px(100.0F);
  private long startMs;
  
  public SixCombolEffectView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @TargetApi(11)
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    c localc = new c();
    localc.bVJ = paramInt1;
    localc.started = false;
    localc.mStartTime = paramInt2;
    localc.mStartY = paramInt3;
    localc.bTg = paramInt4;
    localc.bVK = paramInt5;
    localc.bgX = false;
    localc.a = new a();
    localc.ae = ValueAnimator.ofFloat(new float[] { 0.2F, this.qu - 0.15F });
    localc.ae.setDuration((int)(paramInt5 * 1.2D));
    localc.ae.addListener(new xny(this, localc));
    localc.ae.addUpdateListener(new xnm(this, localc));
    localc.af = ValueAnimator.ofFloat(new float[] { this.qu - 0.15F, this.qu });
    localc.af.setDuration(paramInt6);
    localc.af.addUpdateListener(new xnn(this, localc));
    localc.ag = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localc.ag.setDuration(((paramInt6 - paramInt5) * 2.1D));
    localc.ag.setInterpolator(new DecelerateInterpolator());
    localc.ag.addListener(new xno(this));
    localc.ag.addUpdateListener(new xnp(this, localc));
    localc.ah = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localc.ah.setDuration(paramInt6 - paramInt5);
    localc.ah.setInterpolator(new LinearInterpolator());
    localc.ah.addUpdateListener(new xnq(this, localc));
    return localc;
  }
  
  private xbu.a a()
  {
    View localView;
    if ((this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_d_of_type_Wki != null))
    {
      int i = wja.a(this.c.uniseq, this.jdField_d_of_type_Wki);
      localView = wja.a(this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView, i + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (xbu.a)wja.a(localView);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f = this.qt / paramBitmap.getHeight();
    localMatrix.postScale(f, f);
    localMatrix.postTranslate(paramFloat1, paramFloat2);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f = this.qt / paramBitmap.getHeight();
    localMatrix.postScale(f, f);
    localMatrix.postTranslate(-this.qs / 2.0F, -this.qt / 2.0F);
    localMatrix.postRotate(paramFloat1);
    localMatrix.postTranslate(paramFloat2, paramFloat3);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    paramc.mStartX = paramInt1;
    paramc.bTf = paramInt2;
    paramc.bgX = false;
    paramc.a.a(new PointF[] { new PointF(paramInt1, paramc.mStartY), new PointF(paramInt2, paramc.mStartY - paramInt3), new PointF(paramInt2, paramc.bTg) });
  }
  
  private void clear()
  {
    this.bhW = true;
    this.V.removeMessages(2);
    this.ad.end();
    this.ab.end();
    this.ac.end();
    this.bhW = false;
    Iterator localIterator = this.qE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.ah.end();
      localc.ae.end();
      localc.ag.end();
      localc.af.end();
      localc.mScale = 0.0F;
      localc.qw = 0.0F;
      localc.started = false;
    }
    if (this.bgK) {
      HapticManager.a().X(this.jD);
    }
    this.jD = 0;
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    if ((this.mContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)this.mContext).getChatFragment().a();
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.b;
      this.jdField_d_of_type_Wki = paramContext.a;
    }
    setOnTouchListener(new xnl(this));
    this.mOptions.inSampleSize = 1;
    this.mOptions.inMutable = true;
    if (PokeBigResHandler.bKF) {}
    try
    {
      this.eh = aqhu.d(PokeBigResHandler.brt + "/666_caidan/666send_caidan_hand.png", this.mOptions);
    }
    catch (OutOfMemoryError paramContext)
    {
      try
      {
        for (;;)
        {
          this.ej = aqhu.d(PokeBigResHandler.brt + "/666_caidan/666send_caidan_hand6.png", this.mOptions);
          this.ei = F(this.eh);
          this.ab = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
          this.ab.setDuration(300L);
          this.ab.addUpdateListener(new xnr(this));
          this.ab.addListener(new xns(this));
          this.ad = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
          this.ad.setInterpolator(new DecelerateInterpolator());
          this.ad.setRepeatCount(7);
          this.ad.addUpdateListener(new xnt(this));
          this.ad.addListener(new xnu(this));
          this.ac = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
          this.ac.setDuration(300L);
          this.ac.addUpdateListener(new xnv(this));
          this.ac.addListener(new xnw(this));
          dp(getContext());
          return;
          paramContext = paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("Six Hand", 2, paramContext.toString());
          }
          this.eh = null;
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Six Six", 2, paramContext.toString());
          }
          this.ej = null;
        }
      }
    }
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
  
  public MessageForPoke a()
  {
    return this.c;
  }
  
  public void a(xbu.a parama, boolean paramBoolean)
  {
    if (mIsPlaying) {}
    do
    {
      return;
      this.bgK = paramBoolean;
      clear();
      this.c = ((MessageForPoke)parama.mMessage);
      this.c.mFrameState.hi = true;
      this.mIsSend = this.c.isSend();
      mIsPlaying = true;
      this.V.sendEmptyMessage(3);
    } while (!this.bgK);
    this.jD = HapticManager.a().h(this.aUG, 2);
  }
  
  public void cef()
  {
    int i;
    c localc;
    if (this.mIsSend)
    {
      i = (int)(this.mScreenWidth - ankt.dip2px(50.0F) - this.qs / 2.0F);
      localIterator = this.qE.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        if (localc.bVJ == 0) {
          a(localc, i, i / 3 * 2, 0);
        } else if (localc.bVJ == 1) {
          a(localc, i, i / 3, 0);
        } else {
          a(localc, i, ankt.dip2px(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.qE.iterator();
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      i = (int)(ankt.dip2px(50.0F) + this.qs / 2.0F);
      int j = (int)(this.mScreenWidth - ankt.dip2px(50.0F) - this.qs / 2.0F);
      if (localc.bVJ == 0) {
        a(localc, i, i, 0);
      } else if (localc.bVJ == 1) {
        a(localc, i, j / 3 + i, 0);
      } else {
        a(localc, i, (int)(this.mScreenWidth - this.qv - ankt.dip2px(10.0F)), 50);
      }
    }
    this.V.sendEmptyMessage(1);
  }
  
  public void ceg()
  {
    setVisibility(8);
    xbu.a locala = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$b != null) && (locala != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$b.a(locala);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$b = null;
    }
    if (this.c != null) {
      this.c.mFrameState.hi = false;
    }
    mIsPlaying = false;
    bVC = 0;
    clear();
  }
  
  public void destory()
  {
    this.mContext = null;
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_d_of_type_Wki = null;
    ceg();
  }
  
  void dp(Context paramContext)
  {
    this.V = new Handler(Looper.getMainLooper(), this);
    this.mMatrix = new Matrix();
    int i = riw.getWindowScreenWidth(paramContext);
    int j = getResources().getDisplayMetrics().heightPixels;
    this.mScreenWidth = i;
    this.mScreenHeight = j;
    this.qu = (this.qv / this.ej.getWidth());
    this.qE = new ArrayList();
    this.qE.add(a(0, 800, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 700, 2000));
    this.qE.add(a(0, 1600, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 600, 1400));
    this.qE.add(a(0, 1800, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 600, 1800));
    this.qE.add(a(1, 0, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1500));
    this.qE.add(a(1, 600, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1400));
    this.qE.add(a(1, 1200, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1500));
    this.qE.add(a(1, 2000, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1800));
    this.qE.add(a(2, 300, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1500));
    this.qE.add(a(2, 1000, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1500));
    this.qE.add(a(2, 1400, j - ankt.dip2px(70.0F), (int)(j * 0.6F), 500, 1900));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c = ((c)this.qE.get(6));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.ag.addListener(new xnx(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      setVisibility(0);
      requestLayout();
      bVC = 0;
      this.ab.start();
      return false;
      this.startMs = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.qE.iterator();
      while (paramMessage.hasNext()) {
        ((c)paramMessage.next()).started = false;
      }
      this.V.sendEmptyMessage(2);
      return false;
      this.V.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.startMs;
      int i = 0;
      while (i < this.qE.size())
      {
        paramMessage = (c)this.qE.get(i);
        if ((l1 - l2 >= paramMessage.mStartTime) && (!paramMessage.started))
        {
          paramMessage.started = true;
          paramMessage.ae.start();
          paramMessage.ag.start();
        }
        i += 1;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.started);
    paramMessage = this.V.obtainMessage();
    paramMessage.what = 2;
    this.V.sendMessageDelayed(paramMessage, 25L);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null) {}
    Object localObject2;
    do
    {
      return;
      localObject1 = a();
      if (localObject1 == null)
      {
        ceg();
        return;
      }
      localObject2 = new int[2];
      ((xbu.a)localObject1).wE.getLocationOnScreen((int[])localObject2);
      i = localObject2[0];
      this.bVD = ((int)(localObject2[1] + this.qt - this.bVI));
    } while ((this.ej == null) || (this.eh == null));
    Object localObject1 = this.qE.iterator();
    float f;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      if (((c)localObject2).started)
      {
        this.mMatrix.reset();
        PointF localPointF;
        if (((c)localObject2).qw <= 1.0F)
        {
          localPointF = ((c)localObject2).a.evaluate(((c)localObject2).qw, null, null);
          this.mMatrix.postTranslate(localPointF.x, localPointF.y - (this.mScreenHeight - this.bVD) + this.bVH);
        }
        for (;;)
        {
          this.mMatrix.preScale(((c)localObject2).mScale, ((c)localObject2).mScale);
          paramCanvas.drawBitmap(this.ej, this.mMatrix, null);
          break;
          f = ((c)localObject2).qw;
          i = (int)(this.mScreenHeight * 0.6D * (1.0F - (f - 1.0F)));
          localPointF = ((c)localObject2).a.evaluate(((c)localObject2).qw, null, null);
          this.mMatrix.postTranslate(localPointF.x, i - (this.mScreenHeight - this.bVD) + this.bVH);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.started) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.qw > 1.0F) {
        break label489;
      }
    }
    label489:
    double d1;
    for (int i = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.a.evaluate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.qw, null, null).y - (this.mScreenHeight - this.bVD) + this.bVH);; i = (int)((1.0F - (f - 1.0F)) * (d1 * 0.6D)) - (this.mScreenHeight - this.bVD) + this.bVH)
    {
      if (i + this.ej.getHeight() * this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.mScale < 0.0F) {
        ceg();
      }
      switch (bVC)
      {
      default: 
        return;
      case 1: 
        if (!this.mIsSend) {
          break label538;
        }
        a(paramCanvas, null, this.eh, 90.0F - this.qq * 90.0F, getWidth() - this.qs / 2.0F - this.bVE, this.bVD - this.qt / 2.0F);
        return;
        f = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$c.qw;
        d1 = this.mScreenHeight;
      }
    }
    label538:
    a(paramCanvas, null, this.ei, -90.0F + this.qq * 90.0F, this.qs / 2.0F + this.bVE, this.bVD - this.qt / 2.0F);
    return;
    if (this.mIsSend)
    {
      a(paramCanvas, null, this.eh, getWidth() - this.qs + (this.qr - 0.5F) * 100.0F - this.bVE, this.bVD - this.qt);
      return;
    }
    a(paramCanvas, null, this.ei, -(this.qr - 0.5F) * 100.0F + this.bVE, this.bVD - this.qt);
    return;
    if (this.mIsSend)
    {
      a(paramCanvas, null, this.eh, 90.0F - this.qq * 90.0F, getWidth() - this.qs / 2.0F - this.bVE - this.bVH, this.bVD - this.qt / 2.0F + this.bVH);
      return;
    }
    a(paramCanvas, null, this.ei, -90.0F + this.qq * 90.0F, this.qs / 2.0F + this.bVE + this.bVH, this.bVD - this.qt / 2.0F + this.bVH);
  }
  
  public void setListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView$b = paramb;
  }
  
  public class a
    implements TypeEvaluator<PointF>
  {
    private PointF[] b;
    
    public a() {}
    
    public void a(PointF... paramVarArgs)
    {
      if (paramVarArgs.length != 3) {
        throw new IllegalArgumentException(acfp.m(2131714621));
      }
      this.b = paramVarArgs;
    }
    
    public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      paramPointF1 = this.b[0];
      paramPointF2 = this.b[1];
      PointF localPointF = this.b[2];
      if (paramFloat <= 1.0F)
      {
        float f1 = 1.0F - paramFloat;
        float f2 = (float)(paramPointF1.x * Math.pow(f1, 2.0D) + 2.0F * paramPointF2.x * paramFloat * f1 + localPointF.x * Math.pow(paramFloat, 2.0D));
        double d1 = paramPointF1.y;
        double d2 = Math.pow(f1, 2.0D);
        return new PointF(f2, (float)(2.0F * paramPointF2.y * paramFloat * f1 + d1 * d2 + localPointF.y * Math.pow(paramFloat, 2.0D)));
      }
      return this.b[2];
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(xbu.a parama);
  }
  
  public class c
  {
    public SixCombolEffectView.a a;
    public ValueAnimator ae;
    public ValueAnimator af;
    public ValueAnimator ag;
    public ValueAnimator ah;
    public int bTf;
    public int bTg;
    public int bVJ;
    public int bVK;
    public boolean bgX;
    public float mScale;
    public int mStartTime;
    public int mStartX;
    public int mStartY;
    public float qw;
    public boolean started;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */