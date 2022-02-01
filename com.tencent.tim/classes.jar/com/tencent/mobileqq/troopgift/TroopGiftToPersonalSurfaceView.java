package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import anyb;
import anyb.a;
import anyc;
import anyd;
import anye;
import anyg;
import anyi;
import anyj;
import anyo;
import anyo.a;
import anyu;
import anyv;
import apxn;
import apxp;
import aqcx;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class TroopGiftToPersonalSurfaceView
  extends SpriteGLView
{
  protected int JO;
  private anyu[] a;
  private int dXQ;
  protected int mViewHeight;
  private anyu o;
  private anyu p;
  private anyu q;
  
  public TroopGiftToPersonalSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap o(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = aqcx.dip2px(getContext(), 4.0F);
    try
    {
      Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      Object localObject = new Canvas(localBitmap2);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawCircle(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, paramBitmap.getWidth() / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject).drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap = new Paint();
      paramBitmap.setColor(-1);
      paramBitmap.setAntiAlias(true);
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localObject = new Matrix();
      ((Matrix)localObject).postScale((paramInt1 - i) / localBitmap2.getWidth(), (paramInt2 - i) / localBitmap2.getHeight());
      ((Matrix)localObject).postTranslate(i / 2, i / 2);
      localCanvas.drawBitmap(localBitmap2, (Matrix)localObject, paramBitmap);
      paramBitmap = new Paint();
      paramBitmap.setColor(-16777216);
      paramBitmap.setAlpha(43);
      paramBitmap.setStyle(Paint.Style.STROKE);
      paramBitmap.setAntiAlias(true);
      paramBitmap.setStrokeWidth(aqcx.dip2px(getContext(), 1.0F));
      localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1.getHeight() / 2, localBitmap1.getWidth() / 2, paramBitmap);
      localBitmap2.recycle();
      return localBitmap1;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a(int paramInt, anyb.a parama)
  {
    int i = this.p.getWidth();
    int j = (int)(i * 0.15F);
    this.p.a(new anyb[] { new anyj(new anyb[] { new anyc(paramInt), new anyi(200, 1.0F, 1.05F), new anyi(200, 1.05F, 0.0F) }), new anyj(new anyb[] { new anyc(paramInt), new anye(200, (int)this.p.x, (int)this.p.y, (int)this.p.x - j / 2, (int)this.p.y), new anye(200, (int)this.p.x, (int)this.p.y, (int)this.p.x + j / 2 + i, (int)this.p.y) }) });
    if (this.q.a() == null)
    {
      if (parama != null) {
        parama.aVH();
      }
      return;
    }
    anyi localanyi = new anyi(200, 1.05F, 0.0F);
    this.q.a(new anyb[] { new anyj(new anyb[] { new anyc(paramInt), new anyi(200, 1.0F, 1.05F), localanyi }), new anyj(new anyb[] { new anye(200, (int)this.q.x, (int)this.q.y, (int)this.q.x + j / 2, (int)this.q.y), new anye(200, (int)this.q.x, (int)this.q.y, (int)this.q.x - j / 2 - i, (int)this.q.y) }) });
    localanyi.a(parama);
  }
  
  public void c(anyo.a parama)
  {
    this.p.scale = 0.0F;
    this.q.scale = 0.0F;
    int i = this.p.getWidth();
    int j = i / 10;
    this.p.setPosition(this.JO / 2 - i, this.dXQ);
    this.q.setPosition(this.JO / 2 + i, this.dXQ);
    this.a[0].setPosition(this.JO / 2 - i, this.dXQ - j * 2);
    this.a[1].setPosition(this.JO / 2 - i, this.dXQ - j);
    this.a[2].setPosition(this.JO / 2 - i, this.dXQ);
    this.a[3].setPosition(this.JO / 2 - i * 6 / 5, this.dXQ + j);
    this.a[4].setPosition(this.JO / 2 - i * 6 / 5, this.dXQ + j * 2);
    this.a[5].setPosition(this.JO / 2 - i, j * 2 + this.dXQ);
    this.p.a(new anyb[] { new anyj(new anyb[] { new anyi(200, 0.0F, 1.05F), new anyi(150, 1.05F, 1.0F) }) });
    this.q.a(new anyb[] { new anyj(new anyb[] { new anyc(200), new anyi(200, 0.0F, 1.05F), new anyi(150, 1.05F, 1.0F) }) });
    float f = 9.0F / (this.q.x - this.p.x);
    anyj localanyj1 = new anyj(new anyb[] { new anyc(500), new anyd(600, (int)this.a[0].x, (int)this.a[0].y, (int)this.q.x, i / 20, f) });
    anyj localanyj2 = new anyj(new anyb[] { new anyc(700), new anyd(600, (int)this.a[1].x, (int)this.a[1].y, (int)this.q.x, i / 20, f) });
    anyj localanyj3 = new anyj(new anyb[] { new anyc(600), new anyd(600, (int)this.a[2].x, (int)this.a[2].y, (int)this.q.x, i / 20, f) });
    anyj localanyj4 = new anyj(new anyb[] { new anyc(900), new anyd(600, (int)this.a[3].x, (int)this.a[3].y, (int)this.q.x, i / 20, f * 0.6F) });
    anyj localanyj5 = new anyj(new anyb[] { new anyc(800), new anyd(600, (int)this.a[4].x, (int)this.a[4].y, (int)this.q.x, i / 20, f * 0.6F) });
    anyj localanyj6 = new anyj(new anyb[] { new anyc(1000), new anyd(600, (int)this.a[5].x, (int)this.a[5].y, (int)this.q.x, i / 20, f) });
    i = 0;
    while (i < this.a.length)
    {
      this.a[i].scale = 0.0F;
      this.a[i].opacity = 255;
      this.a[i].a(new anyb[] { new anyb[] { localanyj1, localanyj2, localanyj3, localanyj4, localanyj5, localanyj6 }[i], new anyj(new anyb[] { new anyc(1300), new anyg(300, 255, 0) }) });
      i += 1;
    }
    if ((this.o != null) && ((this.o instanceof anyo)))
    {
      ((anyo)this.o).e = new apxn(this, parama);
      ((anyo)this.o).a(getContext(), this);
    }
    while (isEmpty())
    {
      b(this.o);
      b(this.p);
      b(this.q);
      i = 0;
      while (i < this.a.length)
      {
        b(this.a[i]);
        i += 1;
      }
      if ((this.o != null) && ((this.o instanceof VideoSprite))) {
        ((VideoSprite)this.o).a(new apxp(this, parama));
      }
    }
  }
  
  public void setHeadPositionY(int paramInt1, int paramInt2, float paramFloat, int paramInt3, boolean paramBoolean)
  {
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    int j = paramInt1 / 6;
    int i;
    if (paramInt3 < j) {
      i = j;
    }
    for (;;)
    {
      this.dXQ = i;
      this.o.setPosition(paramInt1 / 2, paramInt2 / 2);
      this.o.scale = paramFloat;
      this.o.opacity = 255;
      return;
      i = paramInt3;
      if (paramInt3 + j > paramInt2) {
        i = paramInt2 - j;
      }
    }
  }
  
  public void setReceiveHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.q != null)) {
      this.q.a(this, o(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, int paramInt1, int paramInt2)
  {
    this.o = new VideoSprite(this, getContext(), true);
    ((VideoSprite)this.o).Go(paramString);
    this.o.x = (paramInt1 / 2);
    this.o.y = (paramInt2 / 2);
    b(this.o);
    this.p = new anyu();
    b(this.p);
    this.q = new anyu();
    b(this.q);
    this.p.scale = 0.0F;
    this.q.scale = 0.0F;
    this.a = new anyu[6];
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.a[paramInt1] = new anyu();
      this.a[paramInt1].scale = 0.0F;
      b(this.a[paramInt1]);
      paramInt1 += 1;
    }
    if (paramBitmap1 != null) {
      this.p.a(this, o(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.q.a(this, o(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
    paramBitmap1 = new anyv(this, paramBitmap3);
    paramInt1 = 0;
    while (paramInt1 < 6)
    {
      this.a[paramInt1].a(paramBitmap1);
      paramInt1 += 1;
    }
  }
  
  public void setResourceWithFps(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, int paramInt)
  {
    this.o = new anyo(this, paramArrayOfString);
    ((anyo)this.o).setFps(paramInt);
    b(this.o);
    this.p = new anyu();
    b(this.p);
    this.q = new anyu();
    b(this.q);
    this.p.scale = 0.0F;
    this.q.scale = 0.0F;
    this.a = new anyu[6];
    paramInt = 0;
    while (paramInt < 6)
    {
      this.a[paramInt] = new anyu();
      this.a[paramInt].scale = 0.0F;
      b(this.a[paramInt]);
      paramInt += 1;
    }
    if (paramBitmap1 != null) {
      this.p.a(this, o(paramBitmap1.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
    if (paramBitmap2 != null) {
      this.q.a(this, o(paramBitmap2.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
    paramBitmap1 = new anyv(this, paramBitmap3);
    paramInt = 0;
    while (paramInt < 6)
    {
      this.a[paramInt].a(paramBitmap1);
      paramInt += 1;
    }
  }
  
  public void setSendHeadBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.p != null)) {
      this.p.a(this, o(paramBitmap.copy(Bitmap.Config.ARGB_8888, false), aqcx.dip2px(getContext(), 70.0F), aqcx.dip2px(getContext(), 70.0F)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView
 * JD-Core Version:    0.7.0.1
 */