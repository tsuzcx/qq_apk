package com.tencent.mobileqq.activity;

import acfp;
import achs;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Calendar;
import wja;

public class TimeLineView
  extends FrameLayout
{
  private AutoFitScrollView a;
  public int bLr;
  private BitSet d;
  private Calendar h;
  private Calendar i;
  private Context mContext;
  private int mDisplayWidth;
  
  public TimeLineView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public BitSet a()
  {
    return this.d;
  }
  
  public Calendar a()
  {
    return (Calendar)this.h.clone();
  }
  
  public void a(AutoFitScrollView paramAutoFitScrollView)
  {
    this.a = paramAutoFitScrollView;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int m = wja.a(8.0F, this.mContext.getResources());
    int n = wja.a(2.0F, this.mContext.getResources());
    int i1 = wja.a(15.0F, this.mContext.getResources());
    int i2 = wja.a(7.5F, this.mContext.getResources());
    int k = (this.mDisplayWidth >> 1) - (n >> 1);
    Paint localPaint1 = new Paint();
    Paint localPaint2 = new Paint();
    localPaint2.setTextSize(this.mContext.getResources().getDisplayMetrics().density * 12.0F);
    localPaint2.setColor(-8355712);
    localPaint2.setDither(true);
    Calendar localCalendar = (Calendar)this.h.clone();
    int j = 0;
    if (!this.d.get(0)) {
      return;
    }
    label151:
    int i3;
    int i4;
    Rect localRect;
    String str;
    if ((localCalendar.before(this.i)) || (localCalendar.equals(this.i)))
    {
      i3 = localCalendar.get(2) + 1;
      i4 = localCalendar.get(5);
      localRect = new Rect();
      if ((1 != i4) && (i4 != 15)) {
        break label419;
      }
      localRect.left = k;
      localRect.top = (getHeight() - i1);
      localRect.right = (localRect.left + n);
      localRect.bottom = getHeight();
      if (i4 != 1) {
        break label389;
      }
      str = i3 + acfp.m(2131715342);
      label287:
      float f = localPaint2.measureText(str);
      i3 = wja.a(3.0F, this.mContext.getResources());
      paramCanvas.drawText(str, n / 2 + k - f / 2.0F, (getHeight() >> 1) - i3, localPaint2);
      label339:
      k += m + n;
      if (!this.d.get(j)) {
        break label463;
      }
      localPaint1.setColor(-15158035);
    }
    for (;;)
    {
      paramCanvas.drawRect(localRect, localPaint1);
      localCalendar.add(5, 1);
      j += 1;
      break label151;
      break;
      label389:
      str = i3 + "-" + i4;
      break label287;
      label419:
      localRect.left = k;
      localRect.top = (getHeight() - i2);
      localRect.right = (localRect.left + n);
      localRect.bottom = getHeight();
      break label339;
      label463:
      localPaint1.setColor(-3355444);
    }
  }
  
  void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDisplayWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramContext = Calendar.getInstance();
    this.i = paramContext;
    this.h = paramContext;
    this.d = new BitSet();
  }
  
  public void setDate(QQAppInterface paramQQAppInterface, Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeLineView", 2, "setDate date is null");
      }
      return;
    }
    this.h = ((Calendar)paramCalendar1.clone());
    this.i = ((Calendar)paramCalendar2.clone());
    StringBuilder localStringBuilder = new StringBuilder("setDate date: ");
    if (QLog.isColorLevel())
    {
      int j = this.h.get(1);
      int k = this.h.get(2);
      int m = this.h.get(5);
      localStringBuilder.append(j).append("-").append(k + 1).append("-").append(m).append(" ~ ");
      j = this.i.get(1);
      k = this.i.get(2);
      m = this.i.get(5);
      localStringBuilder.append(j).append("-").append(k + 1).append("-").append(m);
      localStringBuilder.append(", isLoc: ").append(paramBoolean);
    }
    paramQQAppInterface = (achs)paramQQAppInterface.getManager(92);
    if (!paramBoolean) {}
    for (this.d = paramQQAppInterface.c(this.h, this.i);; this.d = paramQQAppInterface.a(paramCalendar1, paramCalendar2))
    {
      long l = paramCalendar1.getTimeInMillis();
      this.bLr = ((int)((paramCalendar2.getTimeInMillis() - l) / 86400000L));
      this.a.setFitWidth(this.bLr * vD() + this.mDisplayWidth, vD());
      this.a.bGy();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", mDataSize: ").append(this.bLr).append(", max scrollView Width: ").append(this.a.bEd).append(", item width: ").append(vD());
        localStringBuilder.append(",displayWidth: ").append(this.mDisplayWidth);
        QLog.d("TimeLineView", 2, localStringBuilder.toString());
      }
      requestLayout();
      invalidate();
      return;
    }
  }
  
  public int vD()
  {
    return wja.a(10.0F, this.mContext.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TimeLineView
 * JD-Core Version:    0.7.0.1
 */