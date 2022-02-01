package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class LoginPopupMaskView
  extends View
{
  private Path B;
  private int ccy;
  private int ccz;
  private Paint mMaskPaint = new Paint();
  private int radius = 26;
  
  public LoginPopupMaskView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      if ((this.B == null) || (i != this.ccy) || (j != this.ccz))
      {
        this.B = new Path();
        this.B.moveTo(i, j - this.radius);
        this.B.arcTo(new RectF(i - this.radius * 2, j - this.radius * 2, i, j), 0.0F, 90.0F);
        this.B.lineTo(this.radius, j);
        this.B.arcTo(new RectF(0.0F, j - this.radius * 2, this.radius * 2, j), 90.0F, 90.0F);
        this.B.close();
        this.ccy = i;
        this.ccz = j;
        float f = j;
        Object localObject = Shader.TileMode.CLAMP;
        localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 15922167, -2132417049, -2565928 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
        this.mMaskPaint.setShader((Shader)localObject);
      }
      paramCanvas.save();
      paramCanvas.clipPath(this.B);
      paramCanvas.drawRect(0.0F, 0.0F, i, j, this.mMaskPaint);
      paramCanvas.restore();
      return;
    }
    catch (Throwable paramCanvas)
    {
      QLog.e("LoginPopupMaskView", 1, "onDraw error2:" + paramCanvas.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginPopupMaskView
 * JD-Core Version:    0.7.0.1
 */