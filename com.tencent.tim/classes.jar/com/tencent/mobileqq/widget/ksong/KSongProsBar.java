package com.tencent.mobileqq.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import arkm.a;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import wja;

public class KSongProsBar
  extends View
{
  private arkm.a a;
  private String cAH;
  private String cAI;
  private Paint cP = new Paint();
  private Paint cQ = new Paint();
  private Paint ck = new Paint();
  private int ejR;
  private int ejS;
  private int ejT;
  private int ejU;
  private int ejV = 3;
  private int ejW = 10;
  private int h;
  private RectF rect = new RectF();
  private int w;
  
  public KSongProsBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private String bZ(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("mm:ss").format(localDate);
  }
  
  private void d(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext.getResources();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeJoin(Paint.Join.ROUND);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStyle(Paint.Style.FILL);
    this.cQ = new Paint(paramContext);
    this.cQ.setColor(paramInt1);
    this.ck = new Paint(paramContext);
    this.ck.setColor(paramInt2);
    this.cP = new Paint(paramContext);
    this.cP.setColor(paramInt3);
    this.cP.setTextSize(w(10.0F));
  }
  
  /* Error */
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 141	atau$a:rA	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 145	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: iconst_1
    //   15: sipush -256
    //   18: invokevirtual 151	android/content/res/TypedArray:getColor	(II)I
    //   21: aload_2
    //   22: iconst_0
    //   23: iconst_m1
    //   24: invokevirtual 151	android/content/res/TypedArray:getColor	(II)I
    //   27: aload_2
    //   28: iconst_2
    //   29: sipush -256
    //   32: invokevirtual 151	android/content/res/TypedArray:getColor	(II)I
    //   35: invokespecial 153	com/tencent/mobileqq/widget/ksong/KSongProsBar:d	(Landroid/content/Context;III)V
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 53	com/tencent/mobileqq/widget/ksong/KSongProsBar:ejV	I
    //   43: putfield 155	com/tencent/mobileqq/widget/ksong/KSongProsBar:ejR	I
    //   46: aload_0
    //   47: aload_0
    //   48: ldc 156
    //   50: invokevirtual 129	com/tencent/mobileqq/widget/ksong/KSongProsBar:w	(F)I
    //   53: putfield 158	com/tencent/mobileqq/widget/ksong/KSongProsBar:ejS	I
    //   56: aload_2
    //   57: invokevirtual 161	android/content/res/TypedArray:recycle	()V
    //   60: return
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 161	android/content/res/TypedArray:recycle	()V
    //   66: return
    //   67: astore_1
    //   68: aload_2
    //   69: invokevirtual 161	android/content/res/TypedArray:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	KSongProsBar
    //   0	74	1	paramContext	Context
    //   0	74	2	paramAttributeSet	AttributeSet
    //   0	74	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	56	61	java/lang/Exception
    //   11	56	67	finally
  }
  
  public void a(arkm.a parama)
  {
    if (parama == null) {
      return;
    }
    this.a = parama;
    this.cAI = bZ(parama.total);
    this.cAH = bZ(0L);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.rect.set(0.0F, this.ejT, this.w, this.ejT + this.ejW);
    paramCanvas.drawRoundRect(this.rect, this.ejV, this.ejV, this.ck);
    this.rect.set(0.0F, this.ejT, this.ejR, this.ejT + this.ejW);
    paramCanvas.drawRoundRect(this.rect, this.ejV, this.ejV, this.cQ);
    if (!TextUtils.isEmpty(this.cAH)) {
      paramCanvas.drawText(this.cAH, 0.0F, this.ejT + this.ejS, this.cP);
    }
    if (!TextUtils.isEmpty(this.cAI)) {
      paramCanvas.drawText(this.cAI, this.w - this.ejU, this.ejT + this.ejS, this.cP);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.w = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    this.h = paramInt1;
    this.ejT = (paramInt1 / 3);
    QLog.i("KSongProsBar", 2, "w = " + this.w + " h = " + this.h);
    if ((this.w > 0) || (this.h > 0))
    {
      Rect localRect = new Rect();
      this.cP.getTextBounds("00:00", 0, "00:00".length(), localRect);
      this.ejU = localRect.width();
      postInvalidate();
    }
  }
  
  public void update(long paramLong)
  {
    if ((this.w <= 0) || (this.a == null))
    {
      QLog.i("KSongProsBar", 2, "error call, not initialized...");
      return;
    }
    this.cAH = bZ(paramLong);
    this.ejR = ((int)((float)paramLong / (float)this.a.total * this.w));
    postInvalidate();
  }
  
  protected final int w(float paramFloat)
  {
    return wja.dp2px(paramFloat, getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongProsBar
 * JD-Core Version:    0.7.0.1
 */