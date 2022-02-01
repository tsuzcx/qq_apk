package com.tencent.mobileqq.facetoface;

import agbd;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
import wja;

public class SnowView
  extends View
{
  private static final Random random = new Random();
  private agbd[] a = new agbd[this.cWo];
  int cWo = 40;
  int cWp = 10;
  private Point k;
  private final Paint mPaint = new Paint();
  
  public SnowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(agbd paramagbd)
  {
    paramagbd.wu = (random.nextFloat() - 0.45F);
    paramagbd.wt += paramagbd.wu;
    if ((paramagbd.wt > 10.0F) && (paramagbd.wu > 0.0F))
    {
      paramagbd.wu = 0.0F;
      paramagbd.wt = 10.0F;
    }
    if ((paramagbd.wt < 2.0F) && (paramagbd.wu < 0.0F)) {
      paramagbd.wu = 0.0F;
    }
    paramagbd.wr += paramagbd.wt + random.nextFloat() * 10.0F;
    paramagbd.ws += (random.nextFloat() - 0.5F) * 0.5F;
    if (Math.abs(paramagbd.ws) > 3.0F) {
      paramagbd.ws = (0.96F * paramagbd.ws);
    }
    paramagbd.wq += paramagbd.ws;
    if (paramagbd.wq > this.k.x) {
      paramagbd.wq = 5.0F;
    }
    if (paramagbd.wq < 5.0F) {
      paramagbd.wq = this.k.x;
    }
    if (paramagbd.wr > this.k.y) {
      a(paramagbd);
    }
  }
  
  public void a(agbd paramagbd)
  {
    paramagbd.wq = (random.nextInt(this.k.x) + 5.0F);
    paramagbd.wr = 0.0F;
    paramagbd.wt = (2.0F + random.nextFloat() * 5.0F);
    paramagbd.alpha = random.nextInt(255);
    paramagbd.wv = (random.nextFloat() - 0.5F);
  }
  
  public void deJ()
  {
    int i = 0;
    while (i < this.cWo)
    {
      this.a[i] = new agbd(random.nextInt(this.k.x), random.nextInt(this.k.y), random.nextInt(this.cWp), random.nextInt(this.cWp), 0, 0.0F);
      i += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < this.cWo)
    {
      b(this.a[i]);
      if (i % 2 == 0) {
        this.mPaint.setAlpha(127);
      }
      for (;;)
      {
        paramCanvas.drawCircle(this.a[i].wq, this.a[i].wr, wja.dp2px(1.0F, getResources()), this.mPaint);
        i += 1;
        break;
        this.mPaint.setAlpha(51);
      }
    }
  }
  
  public void setSnowView(Point paramPoint)
  {
    this.k = paramPoint;
    deJ();
    this.mPaint.setColor(-1);
    this.mPaint.setDither(true);
    this.mPaint.setAntiAlias(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.SnowView
 * JD-Core Version:    0.7.0.1
 */