package com.tencent.av.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import iiv;

public class ChildLockSign
  extends View
  implements Handler.Callback, View.OnClickListener
{
  private String TAG = "ChildLockSign";
  private ChangeSignThread a;
  private Bitmap bI;
  private Bitmap bJ;
  private Bitmap bK;
  private boolean isLocked = true;
  private final Paint mPaint = new Paint();
  public Handler mUiHandler;
  private int min;
  private final int strokeWidth = 8;
  private final RectF x = new RectF();
  
  public ChildLockSign(Context paramContext)
  {
    super(paramContext);
    init(null, 0);
    setOnClickListener(this);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet, 0);
  }
  
  public ChildLockSign(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet, paramInt);
  }
  
  private void axS()
  {
    this.a = new ChangeSignThread();
    this.a.start();
  }
  
  private void init(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131373962);
    paramAttributeSet = getResources();
    this.isLocked = true;
    try
    {
      this.bI = BitmapFactory.decodeResource(paramAttributeSet, 2130842929);
      this.bJ = BitmapFactory.decodeResource(paramAttributeSet, 2130842930);
      if (this.isLocked) {}
      for (this.bK = this.bI;; this.bK = this.bJ)
      {
        this.mPaint.setFlags(1);
        this.mPaint.setColor(-1);
        this.mUiHandler = new Handler(Looper.getMainLooper(), this);
        return;
      }
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    setVisibility(8);
    try
    {
      Object localObject = (AVActivity)getContext();
      paramMessage = ((AVActivity)localObject).b();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).mControlUI;
      if (!paramMessage.b().Ql)
      {
        paramMessage.b().Qm = true;
        ((DoubleVideoCtrlUI)localObject).jC(true);
        anot.a(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        setEnabled(true);
        return false;
        paramMessage.b().Qm = false;
        ((DoubleVideoCtrlUI)localObject).asx();
        anot.a(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.isLocked)
    {
      setEnabled(false);
      axS();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setStrokeWidth(8.0F);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAlpha(255);
    if ((this.bK != null) && (!this.bK.isRecycled())) {
      paramCanvas.drawBitmap(this.bK, null, this.x, this.mPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.min = Math.min(paramInt1, paramInt2);
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 1, "ChildLock : w = " + paramInt1 + "  h = " + paramInt2 + " min = " + this.min + "  " + this.min / 6 + "  " + this.min / 6 + "  " + this.min * 5 / 6 + "  " + this.min * 5 / 6);
    }
    this.x.set(this.min / 6, this.min / 6, this.min * 5 / 6, this.min * 5 / 6);
  }
  
  public void sendMessage(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  public void setLocked(boolean paramBoolean)
  {
    this.isLocked = paramBoolean;
    if (this.isLocked)
    {
      this.bK = this.bI;
      return;
    }
    this.bK = this.bJ;
  }
  
  class ChangeSignThread
    extends Thread
  {
    ChangeSignThread() {}
    
    public void run()
    {
      ChildLockSign.a(ChildLockSign.this, ChildLockSign.a(ChildLockSign.this));
      ChildLockSign.a(ChildLockSign.this, false);
      ChildLockSign.this.postInvalidate();
      try
      {
        Thread.sleep(500L);
        label37:
        ChildLockSign.this.sendMessage(1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label37;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockSign
 * JD-Core Version:    0.7.0.1
 */