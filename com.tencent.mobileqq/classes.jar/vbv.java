import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class vbv
  extends vbl
{
  public static final int a;
  public float a;
  public Paint a;
  vbh a;
  public vbu a;
  public float b;
  public int b;
  public Paint b;
  public int c = aciy.a(6.0F, BaseApplicationImpl.getContext().getResources());
  
  static
  {
    jdField_a_of_type_Int = vjb.a[8];
  }
  
  public vbv(vbh paramvbh)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Vbh = paramvbh;
  }
  
  private void a(Paint paramPaint, vbu paramvbu)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramvbu.jdField_b_of_type_Int);
    paramPaint.setStrokeWidth(paramvbu.c);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, vbi paramvbi, Paint paramPaint)
  {
    if ((paramvbi instanceof vbu))
    {
      paramvbi = (vbu)paramvbi;
      a(paramPaint, paramvbi);
      paramCanvas.drawPath(paramvbi.a, paramPaint);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_Vbu = new vbu(new Path(), 101, this.jdField_a_of_type_AndroidGraphicsPaint.getColor(), this.c);
      if (this.jdField_a_of_type_Vbh != null) {
        this.jdField_a_of_type_Vbh.a(this.jdField_a_of_type_Vbu);
      }
      DoodleLayout.a("use_graffiti");
      this.jdField_a_of_type_Vbu.a.reset();
      this.jdField_a_of_type_Vbu.a.moveTo(f1, f2);
      this.jdField_a_of_type_Vbu.a.lineTo(f1 + 1.0F, f2 + 1.0F);
      continue;
      if ((this.jdField_a_of_type_Vbu != null) && (this.jdField_a_of_type_Vbu.a != null)) {
        this.jdField_a_of_type_Vbu.a.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, (this.jdField_a_of_type_Float + f1) / 2.0F, (this.jdField_b_of_type_Float + f2) / 2.0F);
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
  }
  
  public Paint b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_Vbu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbv
 * JD-Core Version:    0.7.0.1
 */