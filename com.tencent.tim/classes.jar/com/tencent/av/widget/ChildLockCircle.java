package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import iwu;
import jma;

public class ChildLockCircle
  extends View
  implements Handler.Callback, Animation.AnimationListener
{
  private Animation Q;
  private Animation R;
  private String Ta;
  private String Tb;
  private String Tc;
  private String Td;
  private boolean Vm = true;
  private AnimatedThread a;
  private int aBt;
  private Bitmap bI;
  private Bitmap bJ;
  private Bitmap bK;
  private CountDownTimer c;
  private int height;
  private final int mMaxProgress = 100;
  private final Paint mPaint = new Paint();
  private int mProgress;
  private String mText;
  public Handler mUiHandler;
  private final long qi = 300L;
  private final int strokeWidth = 8;
  private final RectF w = new RectF();
  private int width;
  private final RectF x = new RectF();
  
  public ChildLockCircle(Context paramContext)
  {
    super(paramContext);
    init(null, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet, paramInt);
  }
  
  private void axP()
  {
    sendMessage(1);
  }
  
  private void axQ()
  {
    sendMessage(2);
  }
  
  private void axR()
  {
    try
    {
      if (!((AVActivity)getContext()).b().b().Ql)
      {
        anot.a(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
        return;
      }
      anot.a(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      igd.aL("ChildLockCircle", localException.getMessage());
    }
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373959);
    setBackgroundResource(2130842928);
    paramAttributeSet = getResources();
    this.Ta = paramAttributeSet.getString(2131697618);
    this.Tb = paramAttributeSet.getString(2131697619);
    this.Tc = paramAttributeSet.getString(2131697616);
    this.Td = paramAttributeSet.getString(2131697617);
    try
    {
      this.bI = BitmapFactory.decodeResource(paramAttributeSet, 2130842919);
      this.bJ = BitmapFactory.decodeResource(paramAttributeSet, 2130842913);
      this.w.left = 12.0F;
      this.w.top = 12.0F;
      this.mPaint.setFlags(1);
      this.mPaint.setColor(-1);
      this.mUiHandler = new Handler(Looper.getMainLooper(), this);
      return;
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  private void startAnimation()
  {
    stopAnimation();
    this.a = new AnimatedThread();
    this.a.isAnimating = true;
    this.a.start();
  }
  
  private void stopAnimation()
  {
    if (this.a != null)
    {
      this.a.isAnimating = false;
      this.a = null;
    }
    if (this.c != null)
    {
      this.c.cancel();
      this.c = null;
    }
  }
  
  public void asv()
  {
    if (this.aBt == 1) {
      this.aBt = -1;
    }
    stopAnimation();
  }
  
  public Bitmap b(Resources paramResources, int paramInt)
  {
    int j = 2130842919;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return BitmapFactory.decodeResource(paramResources, i);
      i = 2130842913;
      continue;
      i = 2130842920;
      continue;
      i = 2130842921;
      continue;
      i = 2130842922;
      continue;
      i = 2130842923;
      continue;
      i = 2130842924;
      continue;
      i = 2130842925;
      continue;
      i = 2130842926;
      continue;
      i = 2130842927;
      continue;
      i = 2130842914;
      continue;
      i = 2130842915;
      continue;
      i = 2130842916;
      continue;
      i = 2130842917;
      continue;
      i = 2130842918;
    }
  }
  
  public void bH(Context paramContext)
  {
    VideoController localVideoController = ((AVActivity)getContext()).b();
    if (localVideoController != null)
    {
      localVideoController.b().amU = 1;
      if (this.c == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer start");
        }
        this.c = new jma(this, 750L, 50L, paramContext);
        this.c.start();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 3: 
      do
      {
        return false;
        postInvalidate();
        return false;
        if (this.R == null) {
          this.R = AnimationUtils.loadAnimation(getContext(), 2130772221);
        }
        if (this.R != null)
        {
          this.aBt = 3;
          this.R.setAnimationListener(this);
          startAnimation(this.R);
          return false;
        }
        onAnimationEnd(this.R);
        return false;
      } while (!xT());
      bH(getContext());
      return false;
    }
    try
    {
      Object localObject = (AVActivity)getContext();
      paramMessage = ((AVActivity)localObject).b();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).mControlUI;
      if (!paramMessage.b().Ql)
      {
        paramMessage.b().Qm = true;
        ((DoubleVideoCtrlUI)localObject).jC(true);
        paramMessage.b().amU = 2;
        if (QLog.isColorLevel()) {
          QLog.e("ChildLockCircle", 2, "[childLock] action lock");
        }
        anot.a(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return false;
      }
      paramMessage.b().Qm = false;
      ((DoubleVideoCtrlUI)localObject).asx();
      if (QLog.isColorLevel()) {
        QLog.e("ChildLockCircle", 2, "[childLock] action unlock");
      }
      anot.a(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return false;
    }
    catch (Exception paramMessage) {}
    return false;
  }
  
  public void lm(boolean paramBoolean)
  {
    iwu.l((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    updateText();
    if (this.Q == null) {
      this.Q = AnimationUtils.loadAnimation(getContext(), 2130772220);
    }
    if (paramBoolean)
    {
      this.aBt = 1;
      this.Q.setAnimationListener(this);
      startAnimation(this.Q);
      return;
    }
    setVisibility(0);
    this.aBt = 2;
    startAnimation();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.R))
    {
      setVisibility(8);
      if (QLog.isDevelopLevel()) {
        QLog.w("ChildLockCircle", 1, "timtest onAnimationEnd animation.equals(fadeoutAnimation)");
      }
      paramAnimation = (AVActivity)getContext();
      iwu.m((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.aBt = 0;
      new Handler().post(new ChildLockCircle.2(this));
    }
    while (!paramAnimation.equals(this.Q)) {
      try
      {
        if ((this.bI != null) && (!this.bI.isRecycled())) {
          this.bI.isRecycled();
        }
        if ((this.bJ != null) && (!this.bJ.isRecycled())) {
          this.bJ.isRecycled();
        }
        this.bI = null;
        this.bJ = null;
        this.bK = null;
        return;
      }
      catch (OutOfMemoryError paramAnimation)
      {
        paramAnimation.printStackTrace();
        return;
      }
    }
    setVisibility(0);
    if (this.aBt == 1)
    {
      this.aBt = 2;
      startAnimation();
      return;
    }
    axR();
    axP();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setStrokeWidth(8.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAlpha(255);
    paramCanvas.drawArc(this.w, -90.0F, 360.0F * (this.mProgress / 100.0F), false, this.mPaint);
    if ((this.bK != null) && (!this.bK.isRecycled())) {
      paramCanvas.drawBitmap(this.bK, null, this.x, this.mPaint);
    }
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(this.mText, (this.width - this.mPaint.measureText(this.mText, 0, this.mText.length())) / 2.0F, this.height * 6 / 7, this.mPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.w.left = (paramInt1 * 18 / 65);
    this.w.top = (paramInt2 * 19 / 120);
    this.w.right = (paramInt1 * 47 / 65);
    this.w.bottom = (paramInt2 * 77 / 120);
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildLockCircle", 1, "[childLock] action : w = " + paramInt1 + "  h = " + paramInt2 + " width = " + this.width);
    }
    this.x.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.mPaint.setTextSize(paramInt1 / 8);
  }
  
  public void sendMessage(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void setIsLock(boolean paramBoolean)
  {
    this.Vm = paramBoolean;
    if (this.Vm)
    {
      this.mProgress = 0;
      this.mText = this.Ta;
      this.bK = this.bJ;
      return;
    }
    this.mProgress = 100;
    this.mText = this.Tc;
    this.bK = this.bI;
  }
  
  public void updateText()
  {
    if (!((AVActivity)getContext()).b().b().Ql)
    {
      setIsLock(true);
      return;
    }
    setIsLock(false);
  }
  
  public boolean xT()
  {
    return this.Vm;
  }
  
  class AnimatedThread
    extends Thread
  {
    boolean isAnimating = false;
    private boolean mIsSuccess;
    
    AnimatedThread() {}
    
    public void run()
    {
      this.mIsSuccess = false;
      float f2 = 0.0F;
      if (ChildLockCircle.a(ChildLockCircle.this))
      {
        ChildLockCircle.a(ChildLockCircle.this, 0);
        ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.a(ChildLockCircle.this));
        ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.a(ChildLockCircle.this));
      }
      for (;;)
      {
        ChildLockCircle.this.sendMessage(0);
        float f1 = f2;
        if (!ChildLockCircle.a(ChildLockCircle.this)) {}
        try
        {
          Thread.sleep(300L);
          f1 = f2;
          label84:
          if (this.isAnimating)
          {
            if (ChildLockCircle.a(ChildLockCircle.this))
            {
              ChildLockCircle.a(ChildLockCircle.this, (int)((float)(ChildLockCircle.a(ChildLockCircle.this) + 100L * 15L / 1000L) + f1));
              if (ChildLockCircle.a(ChildLockCircle.this) >= 100)
              {
                ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.c(ChildLockCircle.this));
                this.mIsSuccess = true;
              }
              f1 = (float)(f1 + 0.08D);
              if ((!this.mIsSuccess) || (!ChildLockCircle.a(ChildLockCircle.this))) {
                ChildLockCircle.this.postInvalidate();
              }
              if ((!this.mIsSuccess) || (ChildLockCircle.a(ChildLockCircle.this))) {
                break label384;
              }
              ChildLockCircle.a(ChildLockCircle.this);
            }
          }
          else
          {
            label221:
            if (!this.mIsSuccess) {
              break label451;
            }
            if (!ChildLockCircle.a(ChildLockCircle.this)) {
              break label425;
            }
          }
        }
        catch (InterruptedException localInterruptedException5)
        {
          try
          {
            label165:
            Thread.sleep(900L);
            for (;;)
            {
              for (;;)
              {
                ChildLockCircle.c(ChildLockCircle.this);
                return;
                ChildLockCircle.a(ChildLockCircle.this, 100);
                ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.b(ChildLockCircle.this));
                ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.b(ChildLockCircle.this));
                break;
                ChildLockCircle.a(ChildLockCircle.this, (int)((float)(ChildLockCircle.a(ChildLockCircle.this) - 100L * 15L / 1000L) - f1));
                if (ChildLockCircle.a(ChildLockCircle.this) > 0) {
                  break label165;
                }
                ChildLockCircle.a(ChildLockCircle.this, 0);
                ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.d(ChildLockCircle.this));
                ChildLockCircle.a(ChildLockCircle.this, ChildLockCircle.a(ChildLockCircle.this));
                this.mIsSuccess = true;
                break label165;
                label384:
                if ((this.mIsSuccess) && (ChildLockCircle.a(ChildLockCircle.this)))
                {
                  ChildLockCircle.this.sendMessage(3);
                  break label221;
                }
                try
                {
                  Thread.sleep(15L);
                }
                catch (InterruptedException localInterruptedException1) {}
              }
              break label84;
              try
              {
                label425:
                Thread.sleep(300L);
              }
              catch (InterruptedException localInterruptedException2) {}
            }
            label438:
            ChildLockCircle.this.postInvalidate();
          }
          catch (InterruptedException localInterruptedException5)
          {
            try
            {
              for (;;)
              {
                Thread.sleep(15L);
                label451:
                if (ChildLockCircle.a(ChildLockCircle.this))
                {
                  ChildLockCircle.a(ChildLockCircle.this, (int)(ChildLockCircle.a(ChildLockCircle.this) - 9L * 15L / 5L * 100L / 1000L));
                  if (ChildLockCircle.a(ChildLockCircle.this) <= 0) {
                    ChildLockCircle.a(ChildLockCircle.this, 0);
                  }
                }
                else
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      ChildLockCircle.this.postInvalidate();
                      ChildLockCircle.b(ChildLockCircle.this);
                      try
                      {
                        Thread.sleep(2L * 15L);
                      }
                      catch (InterruptedException localInterruptedException3) {}
                    }
                    break;
                    ChildLockCircle.a(ChildLockCircle.this, (int)(ChildLockCircle.a(ChildLockCircle.this) + 9L * 15L / 5L * 100L / 1000L));
                    if (ChildLockCircle.a(ChildLockCircle.this) < 100) {
                      break label438;
                    }
                  }
                  localInterruptedException4 = localInterruptedException4;
                  f1 = f2;
                }
              }
              localInterruptedException5 = localInterruptedException5;
            }
            catch (InterruptedException localInterruptedException6)
            {
              break label451;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle
 * JD-Core Version:    0.7.0.1
 */