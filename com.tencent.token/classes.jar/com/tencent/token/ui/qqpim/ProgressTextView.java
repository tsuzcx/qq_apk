package com.tencent.token.ui.qqpim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint({"NewApi"})
public class ProgressTextView
  extends ImageView
{
  public LinearGradient a;
  public Paint b = new Paint(1);
  public float c;
  public String d = "";
  public String e;
  private int f = 2130968708;
  
  public ProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.c;
    float f2 = getWidth();
    int i = getResources().getColor(this.f);
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.a = new LinearGradient(0.0F, 0.0F, f1 * f2, 0.0F, new int[] { -1, i }, new float[] { 0.99F, 1.0F }, localTileMode);
    if (Build.VERSION.SDK_INT > 7) {
      this.b.setShader(this.a);
    } else {
      this.b.setColor(-16777216);
    }
    this.b.setTextSize(getResources().getDimensionPixelSize(2131034241));
    f1 = this.b.measureText(this.d);
    f1 = getWidth() - (int)f1 >> 1;
    paramCanvas.drawText(this.d, f1, getResources().getDimensionPixelSize(2131034241), this.b);
    try
    {
      paramCanvas.restore();
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  public void setColorId(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.e = paramString;
    this.d = paramString;
    invalidate();
  }
  
  public void setTextWhiteLength(float paramFloat)
  {
    this.c = paramFloat;
    if (this.c <= 0.05D) {
      this.c = 0.05F;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.ProgressTextView
 * JD-Core Version:    0.7.0.1
 */