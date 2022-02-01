package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import anyb;
import anyb.a;
import anyc;
import anyg;
import anyi;
import anyj;
import anyo;
import anyo.a;
import anyq;
import anyq.a;
import anyr;
import anyu;
import apxi;
import apxj;
import apxk;
import apxl;
import aqho;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftToAllSurfaceView
  extends SpriteGLView
{
  private anyq jdField_a_of_type_Anyq;
  private a jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a;
  private anyq jdField_b_of_type_Anyq;
  private anyr jdField_b_of_type_Anyr;
  private int mOffsetY;
  private float mScale;
  private String mVideoPath;
  private anyu n;
  private anyu o;
  
  public TroopGiftToAllSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, anyq.a parama, a parama1)
  {
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    float f1;
    int j;
    if ((!parama1.cmE) && (paramBitmap1 != null))
    {
      localBitmap = paramBitmap1.copy(Bitmap.Config.ARGB_8888, true);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setColor(parama1.titleColor);
      localPaint.setTextSize(34.0F);
      paramBitmap1 = new Matrix();
      f1 = 140.0F / paramBitmap2.getWidth();
      paramBitmap1.postScale(f1, f1);
      paramBitmap1.postTranslate((localBitmap.getWidth() - f1 * paramBitmap2.getWidth()) / 2.0F, 154.0F);
      localCanvas.drawBitmap(paramBitmap2, paramBitmap1, localPaint);
      if ((!TextUtils.isEmpty(parama1.bPY)) && (!TextUtils.isEmpty(parama1.nickName)))
      {
        float f2 = localPaint.measureText(parama1.bPY);
        f1 = 0.0F;
        j = 0;
        paramBitmap1 = parama1.bPY;
        int i = 0;
        while (i < parama1.nickName.length())
        {
          float f3 = localPaint.measureText("" + parama1.nickName.charAt(i));
          if (f1 + f3 + f2 > 475.0F) {
            break;
          }
          f1 += f3;
          j += 1;
          i += 1;
        }
        if (j <= 0) {
          break label577;
        }
        if (j != parama1.nickName.length()) {
          break label524;
        }
        paramBitmap1 = parama1.nickName + paramBitmap1;
      }
    }
    label524:
    label577:
    for (;;)
    {
      f1 = localPaint.measureText(paramBitmap1);
      localCanvas.drawText(paramBitmap1, localBitmap.getWidth() / 2 - f1 / 2.0F, 359.20001F, localPaint);
      this.n = new anyu(this, localBitmap);
      this.n.x = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewWidth / 2);
      this.n.y = this.mOffsetY;
      this.n.scale = 0.0F;
      b(this.n);
      if (paramBitmap3 != null)
      {
        this.jdField_b_of_type_Anyq = new anyq(this, paramBitmap3, false);
        this.jdField_b_of_type_Anyq.setPosition(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewWidth / 2, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewHeight * this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.dgn / 100);
      }
      try
      {
        this.jdField_a_of_type_Anyq = new anyq(this, BitmapFactory.decodeResource(getResources(), 2130848048), true);
        this.jdField_a_of_type_Anyq.setPosition(parama1.viewWidth - aqho.convertDpToPixel(getContext(), 40.0F), aqho.convertDpToPixel(getContext(), 120.0F));
        this.jdField_a_of_type_Anyq.a(parama);
        this.jdField_a_of_type_Anyq.scale = 0.75F;
        b(this.jdField_a_of_type_Anyq);
        return;
        paramBitmap1 = parama1.nickName.substring(0, j) + "..." + paramBitmap1;
      }
      catch (OutOfMemoryError paramBitmap1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString, anyq.a parama, a parama1)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a = parama1;
    this.mOffsetY = (parama1.viewHeight * parama1.dgl / 100);
    this.mScale = (getResources().getDisplayMetrics().density / 2.0F);
    this.mVideoPath = paramString;
    paramString = new VideoSprite(this, getContext(), true);
    paramString.isFullScreen = true;
    paramString.x = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewWidth / 2);
    paramString.y = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewHeight / 2);
    this.o = paramString;
    a(paramBitmap1, paramBitmap2, paramBitmap3, parama, parama1);
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String[] paramArrayOfString, anyq.a parama, a parama1)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a = parama1;
    this.mOffsetY = (parama1.viewHeight * parama1.dgl / 100);
    this.mScale = (getResources().getDisplayMetrics().density / 2.0F);
    paramArrayOfString = new anyo(this, paramArrayOfString);
    this.o = paramArrayOfString;
    this.o.x = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewWidth / 2);
    this.o.y = (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView$a.viewHeight / 2);
    this.o.scale = parama1.AA;
    paramArrayOfString.setFps(parama1.fps);
    paramArrayOfString.GK(true);
    a(paramBitmap1, paramBitmap2, paramBitmap3, parama, parama1);
  }
  
  public void aL(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    al(new TroopGiftToAllSurfaceView.5(this, paramString, paramInt1, paramInt2));
  }
  
  public void b(anyb.a parama)
  {
    if (this.o != null) {
      this.o.a(new anyb[] { new anyg(500, 255, 0, 1) });
    }
    anyg localanyg = new anyg(500, 255, 0, 1);
    localanyg.a(parama);
    if (this.n != null) {
      this.n.a(new anyb[] { localanyg });
    }
    if (this.jdField_b_of_type_Anyq != null)
    {
      this.jdField_b_of_type_Anyq.a(null);
      this.jdField_b_of_type_Anyq.a(new anyb[] { new anyg(500, 255, 0, 1) });
    }
    if (this.jdField_b_of_type_Anyr != null) {
      this.jdField_b_of_type_Anyr.a(new anyb[] { new anyg(500, 255, 0, 1) });
    }
    if (this.jdField_a_of_type_Anyq != null) {
      this.jdField_a_of_type_Anyq.a(new anyb[] { new anyg(500, 255, 0, 1) });
    }
  }
  
  public void b(anyq.a parama)
  {
    if (this.jdField_b_of_type_Anyq != null)
    {
      this.jdField_b_of_type_Anyq.a(parama);
      this.jdField_b_of_type_Anyq.scale = 0.0F;
      b(this.jdField_b_of_type_Anyq);
      parama = new anyj(new anyb[] { new anyi(500, 0.0F, this.mScale * 1.1F), new anyi(200, this.mScale * 1.1F, this.mScale * 0.88F), new anyi(200, this.mScale * 0.88F, this.mScale) });
      parama.a(new apxk(this));
      this.jdField_b_of_type_Anyq.a(new anyb[] { parama });
    }
  }
  
  public void c(anyo.a parama)
  {
    if (this.n != null)
    {
      anyj localanyj = new anyj(new anyb[] { new anyi(500, 0.0F, this.mScale * 1.1F), new anyi(200, this.mScale * 1.1F, this.mScale * 0.95F), new anyi(200, this.mScale * 0.95F, this.mScale * 1.05F), new anyi(200, this.mScale * 1.05F, this.mScale * 1.0F) });
      this.n.a(new anyb[] { localanyj });
    }
    if ((this.o != null) && ((this.o instanceof anyo)))
    {
      ((anyo)this.o).e = new apxi(this, parama);
      ((anyo)this.o).a(getContext(), this);
    }
    for (;;)
    {
      parama = new anyc(500);
      parama.a(new apxj(this));
      if (this.n != null) {
        this.n.a(new anyb[] { parama });
      }
      return;
      if ((this.o != null) && ((this.o instanceof VideoSprite))) {
        ((VideoSprite)this.o).a(parama);
      }
    }
  }
  
  public void ecC()
  {
    if (this.jdField_b_of_type_Anyq != null)
    {
      anyg localanyg = new anyg(500, 255, 0);
      localanyg.a(new apxl(this));
      this.jdField_b_of_type_Anyq.a(new anyb[] { localanyg });
    }
  }
  
  public static class a
  {
    public float AA;
    public String bPY;
    public boolean cmE;
    public int dgj;
    public int dgl;
    public int dgm;
    public int dgn;
    public int fps;
    public String nickName;
    public int titleColor;
    public int viewHeight;
    public int viewWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView
 * JD-Core Version:    0.7.0.1
 */