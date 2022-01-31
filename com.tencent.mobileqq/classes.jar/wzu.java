import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;

public class wzu
  extends xeh
{
  float jdField_a_of_type_Float;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  public TextPaint a;
  public xah a;
  protected float b;
  protected float c;
  protected float d;
  protected float e;
  protected float f;
  protected float g;
  protected float h;
  protected float i;
  
  public wzu(wzs paramwzs)
  {
    super(new PointF(), 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, true);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Xah = new xah();
    this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Xah.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Xah.b = paramwzs.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298879);
    this.jdField_a_of_type_Xah.c = 2;
    this.jdField_a_of_type_Xah.d = -1;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Xah.b);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Xah.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout("", this.jdField_a_of_type_AndroidTextTextPaint, paramwzs.g - wzs.jdField_a_of_type_Int * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.jdField_e_of_type_Int = xod.a(BaseApplicationImpl.getContext(), 7.5F);
  }
  
  public wzu(wzs paramwzs, @NonNull wzu paramwzu)
  {
    super(paramwzu, 1.0F);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramwzu.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_Xah = new xah();
    this.jdField_a_of_type_Xah.a(paramwzu.jdField_a_of_type_Xah);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramwzu.jdField_a_of_type_Xah.b);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramwzu.jdField_a_of_type_Xah.jdField_a_of_type_Int);
    this.jdField_a_of_type_Float = paramwzu.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramwzu.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString, paramwzu.jdField_a_of_type_AndroidTextTextPaint, paramwzs.g - wzs.jdField_a_of_type_Int * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.b = paramwzu.b;
    this.jdField_c_of_type_Float = paramwzu.jdField_c_of_type_Float;
    this.jdField_d_of_type_Float = paramwzu.jdField_d_of_type_Float;
    this.jdField_e_of_type_Float = paramwzu.jdField_e_of_type_Float;
    this.f = paramwzu.f;
    this.g = paramwzu.g;
    this.h = paramwzu.h;
    this.i = paramwzu.i;
    this.jdField_e_of_type_Int = xod.a(BaseApplicationImpl.getContext(), 7.5F);
  }
  
  private void e()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a();
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.setDuration(270L);
      localValueAnimator.addUpdateListener(new wzv(this));
      localValueAnimator.start();
    }
  }
  
  public xah a()
  {
    xah localxah = new xah();
    localxah.a(this.jdField_a_of_type_Xah);
    return localxah;
  }
  
  protected void a()
  {
    this.jdField_d_of_type_Float = this.l;
    this.jdField_e_of_type_Float = this.m;
    this.b = this.j;
    this.jdField_c_of_type_Float = this.k;
    this.f = (-this.jdField_a_of_type_AndroidGraphicsPointF.x + this.n / 2.0F + this.jdField_a_of_type_Float - this.jdField_d_of_type_Float);
    this.g = (this.jdField_a_of_type_Wzs.k + this.o / 2.0F - this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_e_of_type_Float);
    this.h = (1.0F - this.b);
    if (this.jdField_c_of_type_Float < 180.0F)
    {
      this.i = (0.0F - this.jdField_c_of_type_Float);
      return;
    }
    this.i = (360.0F - this.jdField_c_of_type_Float);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_Wzs.jdField_a_of_type_Xeg.a(this));
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
      float f1 = -((this.jdField_a_of_type_AndroidTextTextPaint.descent() + this.jdField_a_of_type_AndroidTextTextPaint.ascent()) / 2.0F);
      paramCanvas.drawText(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString, 0.0F, f1, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      xee.a(paramCanvas, this.jdField_a_of_type_Wzs.jdField_a_of_type_Xeg, this, 0, 2130844157, 2130844164);
      return;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    }
  }
  
  public void a(xah paramxah)
  {
    this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString = paramxah.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Xah.jdField_a_of_type_Int = paramxah.jdField_a_of_type_Int;
    this.jdField_a_of_type_Xah.d = paramxah.d;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramxah.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(255);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Wzs.g - wzs.jdField_a_of_type_Int * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 1) {
      this.n = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString);
    }
    for (this.o = (this.jdField_a_of_type_AndroidTextTextPaint.descent() - this.jdField_a_of_type_AndroidTextTextPaint.ascent());; this.o = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight())
    {
      this.jdField_a_of_type_Float = wzs.jdField_a_of_type_Int;
      return;
      this.n = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new wzw(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new wzx(this));
    }
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Xah.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Xah.d = -1;
    this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Xah.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_Xah.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Wzs.g, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.jdField_a_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_Wzs.jdField_a_of_type_AndroidGraphicsRect.width() / 2);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = (this.jdField_a_of_type_Wzs.jdField_a_of_type_AndroidGraphicsRect.height() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */