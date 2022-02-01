package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import lss;
import wja;

public class ReadInjoyProgressView$1
  extends NativeTextImp
{
  public ReadInjoyProgressView$1(lss paramlss, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      this.a.D.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.E.set(0.0F, 0.0F, getWidth() * lss.a(this.a) / 100.0F, getHeight());
      this.a.aB.setColor(Color.parseColor(lss.a(this.a)));
      paramCanvas.drawRoundRect(this.a.D, wja.dp2px(2.0F, getResources()), wja.dp2px(2.0F, getResources()), this.a.aB);
      this.a.aB.setColor(Color.parseColor(lss.b(this.a)));
      paramCanvas.drawRoundRect(this.a.E, wja.dp2px(2.0F, getResources()), wja.dp2px(2.0F, getResources()), this.a.aB);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyProgressView.1
 * JD-Core Version:    0.7.0.1
 */