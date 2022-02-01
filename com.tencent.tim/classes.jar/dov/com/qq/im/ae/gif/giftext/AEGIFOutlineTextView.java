package dov.com.qq.im.ae.gif.giftext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import axck;

public class AEGIFOutlineTextView
  extends View
{
  private String cTO = "#00FFFFFF";
  private boolean ckl = true;
  private boolean dui;
  private int eEE;
  private TextPaint k = new TextPaint();
  private TextPaint m = new TextPaint();
  private float mShadowDx;
  private float mShadowDy;
  private float mShadowRadius;
  private Bitmap r;
  private Rect rect = new Rect();
  private String text = "";
  private Canvas v;
  
  public AEGIFOutlineTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEGIFOutlineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }
  
  private void a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    while ((localRect.width() + paramInt3 > paramInt1 * 1.0F) || (localRect.height() + paramInt3 > paramInt2 * 1.0F))
    {
      paramPaint.setTextSize(paramPaint.getTextSize() - 2.0F);
      paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public Bitmap aT()
  {
    return this.r;
  }
  
  public float ca()
  {
    return this.k.getStrokeWidth();
  }
  
  public float getTextSize()
  {
    return this.k.getTextSize();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    setFontStyle();
    this.m.setTextSize(this.k.getTextSize());
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setStrokeWidth(this.eEE);
    this.k.setAntiAlias(true);
    this.m.setAntiAlias(true);
    this.k.getTextBounds(this.text, 0, this.text.length(), this.rect);
    if (this.ckl) {
      this.k.setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, Color.parseColor(this.cTO));
    }
    float f1;
    int i;
    for (;;)
    {
      f1 = this.rect.height();
      i = this.text.indexOf("\r\n");
      if (i >= 0) {
        break label339;
      }
      if (!TextUtils.isEmpty(this.text)) {
        break;
      }
      return;
      this.k.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    a(this.text, this.m, getWidth(), getHeight(), this.eEE);
    this.k.setTextSize(this.m.getTextSize());
    float f2 = f1 / 2.0F + (Math.abs(this.k.ascent()) - this.k.descent()) / 2.0F;
    if (this.dui) {
      a(this.v, this.text, (getWidth() - this.m.measureText(this.text)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.m);
    }
    a(this.v, this.text, (getWidth() - this.k.measureText(this.text)) / 2.0F, (getHeight() - f1) / 2.0F + f2, this.k);
    for (;;)
    {
      paramCanvas.drawBitmap(this.r, 0.0F, 0.0F, this.k);
      return;
      label339:
      String str1 = this.text.substring(0, i);
      String str2 = this.text.substring("\r\n".length() + i);
      a(str1, this.m, getWidth(), getHeight() / 2, this.eEE);
      this.k.setTextSize(this.m.getTextSize());
      f2 = f1 / 2.0F + (Math.abs(this.k.ascent()) - this.k.descent()) / 2.0F;
      if (this.dui) {
        a(this.v, str1, (getWidth() - this.m.measureText(str1)) / 2.0F, getHeight() * 0.35F - f1 / 2.0F + f2, this.m);
      }
      a(this.v, str1, (getWidth() - this.k.measureText(str1)) / 2.0F, getHeight() * 0.35F - f1 / 2.0F + f2, this.k);
      if (this.dui) {
        a(this.v, str2, (getWidth() - this.m.measureText(str2)) / 2.0F, getHeight() * 0.75F - f1 / 2.0F + f2, this.m);
      }
      a(this.v, str2, (getWidth() - this.k.measureText(str2)) / 2.0F, getHeight() * 0.75F - f1 / 2.0F + f2, this.k);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      if ((this.r != null) && (!this.r.isRecycled())) {
        this.r.recycle();
      }
      this.r = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      this.v = new Canvas(this.r);
    }
  }
  
  public void setFontStyle()
  {
    Typeface localTypeface = axck.a().c("jianqiaohei.ttf");
    this.k.setTypeface(localTypeface);
    this.m.setTypeface(localTypeface);
  }
  
  public void setOutlineColor(String paramString)
  {
    this.m.setColor(Color.parseColor(paramString));
  }
  
  public void setOutlineWidth(int paramInt)
  {
    this.eEE = paramInt;
  }
  
  public void setShadow(boolean paramBoolean)
  {
    this.ckl = paramBoolean;
  }
  
  public void setShadowParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    this.mShadowRadius = paramFloat1;
    this.mShadowDx = paramFloat2;
    this.mShadowDy = paramFloat3;
    this.cTO = paramString;
  }
  
  public void setStroke(boolean paramBoolean)
  {
    this.dui = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString.trim();
    if (this.r != null)
    {
      this.r.eraseColor(0);
      invalidate();
    }
  }
  
  public void setTextColor(String paramString)
  {
    this.k.setColor(Color.parseColor(paramString));
  }
  
  public void setTextSize(float paramFloat)
  {
    this.k.setTextSize(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView
 * JD-Core Version:    0.7.0.1
 */