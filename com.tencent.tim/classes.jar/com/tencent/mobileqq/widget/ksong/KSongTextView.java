package com.tencent.mobileqq.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import arkm.c;
import com.tencent.qphone.base.util.QLog;

public class KSongTextView
  extends TextView
{
  private float Cp;
  private float Cq = 0.0F;
  private Matrix J;
  private long avY = 50L;
  private long avZ;
  private arkm.c b;
  private LinearGradient f;
  private int text_color;
  private int type = 1;
  
  public KSongTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 49	atau$a:rA	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 55	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: iconst_1
    //   14: sipush -256
    //   17: invokevirtual 61	android/content/res/TypedArray:getColor	(II)I
    //   20: aload_1
    //   21: iconst_0
    //   22: iconst_m1
    //   23: invokevirtual 61	android/content/res/TypedArray:getColor	(II)I
    //   26: invokevirtual 65	com/tencent/mobileqq/widget/ksong/KSongTextView:kC	(II)V
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 69	com/tencent/mobileqq/widget/ksong/KSongTextView:getCurrentTextColor	()I
    //   34: putfield 71	com/tencent/mobileqq/widget/ksong/KSongTextView:text_color	I
    //   37: aload_1
    //   38: invokevirtual 75	android/content/res/TypedArray:recycle	()V
    //   41: return
    //   42: astore_2
    //   43: aload_1
    //   44: invokevirtual 75	android/content/res/TypedArray:recycle	()V
    //   47: return
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 75	android/content/res/TypedArray:recycle	()V
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	KSongTextView
    //   0	55	1	paramContext	Context
    //   0	55	2	paramAttributeSet	AttributeSet
    //   0	55	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	37	42	java/lang/Exception
    //   11	37	48	finally
  }
  
  public void a(long paramLong, arkm.c paramc)
  {
    QLog.i("KSongTextView", 2, "startDownTime = " + paramLong);
    if (4 == getVisibility()) {
      setVisibility(0);
    }
    this.type = 0;
    this.b = paramc;
    this.Cp = getPaint().measureText(getText().toString());
    paramLong /= this.avY;
    this.Cq = (this.Cp / (float)paramLong);
    this.avZ = System.currentTimeMillis();
    postInvalidate();
  }
  
  public void c(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = getPaint().measureText(getText().toString());
    this.Cp = (f1 * paramFloat);
    if (this.Cp > f1) {
      this.Cp = f1;
    }
    if (paramInt1 > 0) {
      setTextSize(2, paramInt1);
    }
    setTextColor(paramInt2);
    postInvalidate();
  }
  
  public void kC(int paramInt1, int paramInt2)
  {
    Object localObject1 = getPaint();
    Object localObject2 = Shader.TileMode.CLAMP;
    localObject2 = new LinearGradient(-1.0F, 0.0F, 0.0F, 0.0F, new int[] { paramInt1, paramInt2 }, null, (Shader.TileMode)localObject2);
    this.f = ((LinearGradient)localObject2);
    ((TextPaint)localObject1).setShader((Shader)localObject2);
    localObject1 = this.f;
    localObject2 = new Matrix();
    this.J = ((Matrix)localObject2);
    ((LinearGradient)localObject1).setLocalMatrix((Matrix)localObject2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.J == null) {
      return;
    }
    QLog.i("KSongTextView", 2, "type = " + this.type);
    if (this.type == 0)
    {
      this.Cp -= this.Cq;
      if (this.Cp <= 0.0F)
      {
        if (this.b != null) {
          this.b.complete();
        }
        setVisibility(4);
        return;
      }
      if (this.b != null) {
        this.b.update(System.currentTimeMillis() - this.avZ);
      }
      postInvalidateDelayed(this.avY);
    }
    this.J.setTranslate(this.Cp, 0.0F);
    this.f.setLocalMatrix(this.J);
  }
  
  public void reset()
  {
    c(0.0F, 14, this.text_color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongTextView
 * JD-Core Version:    0.7.0.1
 */