package com.tencent.mobileqq.apollo.view;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.tencent.mobileqq.widget.MessageProgressView;
import wja;

public class ApolloMessageProgressView
  extends MessageProgressView
{
  public ApolloMessageProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void drawText(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(wja.dp2px(15.0F, getResources()));
    localPaint.setColor(-1);
    localPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(acfp.m(2131702610), this.Bn, getHeight() - wja.dp2px(25.0F, getResources()), localPaint);
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.egH == 1)
    {
      updateSize();
      this.Bo -= wja.dp2px(7.0F, getResources());
      this.egI = -822083584;
      bq(paramCanvas);
      br(paramCanvas);
      aQ(paramCanvas);
      if (getProgress() < 100) {
        drawText(paramCanvas);
      }
      bs(paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloMessageProgressView
 * JD-Core Version:    0.7.0.1
 */